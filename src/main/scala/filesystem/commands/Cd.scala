package filesystem.commands
import filesystem.files.{DirEntry, Directory}
import filesysystem.State

import scala.annotation.tailrec

class Cd(dir: String) extends Command {

  override def apply(state: State): State = {
    /*
      cd /something/somethingElse/.../
      cd a/b/c/ == relative to the current working directory

      cd ..
      cd .
      cd a/./.././a/
     */

    // 1. find root
    val root = state.root
    val wd = state.wd

    // 2. find the absolute path of the directory I want to cd to
    val absolutePath =
      if (dir.startsWith(Directory.SEPARATOR)) dir
      else if(wd.isRoot) wd.path + Directory.SEPARATOR + dir
      else wd.path + Directory.SEPARATOR + dir

    // 3. find the directory to cd to, given the path
    val destinationDirectory = doFindEntry(root, absolutePath)

    // 4. change the state given the new directory
    if (destinationDirectory == null || !destinationDirectory.isDirectory)
      state.setMessage(dir + ": no such directory")
    else
      State(root, destinationDirectory.asDirectory)

  }
  def doFindEntry(root: Directory, path: String): DirEntry = {
    @tailrec
    def findEntryHelper(currentDirectory: Directory, path: List[String]): DirEntry = {
      if (path.isEmpty || path.head.isEmpty) currentDirectory
      else if (path.tail.isEmpty) currentDirectory.findEntry(path.head)
      else {
        val nextDir = currentDirectory.findEntry(path.head)
        if (nextDir == null || !nextDir.isDirectory) null
        else findEntryHelper(nextDir.asDirectory, path.tail)
      }
    }

    /*

      /a/b => ["a", "b"]

      path.isEmpty?
        cRT(["b"], result = List :+ "a" = ["a"]
          path.isEmpty?
            cRG([], result = ["a"] :+ "b" = ["a", "b"])
              path.isEmpty?
      /a/b/.. => ["a", "b', ".."]
      path.isEmpty?
        cRT(["b", "..", ["a"]
        ?
          cRT(["..", ["a", "b"]
          ?
            cRT([], ["b"])

     */
    @tailrec
    def collapseRelativeTokens(path: List[String], acc: List[String]): List[String] ={
      if (path.isEmpty) acc
      else if("."equals(path.head)) collapseRelativeTokens(path.tail, acc)
      else if("..".equals(path.head)) {
        if (acc.isEmpty) null
        else collapseRelativeTokens(path.tail, acc.tail.init)
      } else collapseRelativeTokens(path.tail, acc :+ path.head)
    }
    // 1. tokens
    val tokens: List[String] = path.substring(1).split(Directory.SEPARATOR).toList


    //  1.3 eliminate/collapse relative tokens
    val newTokens = collapseRelativeTokens(tokens, List())

    /*
      ["a", "."] = > ["a"]
      ["a', "b", ".", "." => ["a", "b"]

      /a/.. => []
      /a/b/.. => ["a"]
     */
    // 2. navigate to the correct entry
    if (newTokens == null) null
    else findEntryHelper(root, newTokens)
  }
}
