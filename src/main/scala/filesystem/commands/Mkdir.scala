package filesystem.commands

import filesystem.files.{DirEntry, Directory}
import filesysystem.State

class Mkdir(name: String) extends Command {

  override def apply(state: State): State = {
    val wd = state.wd
    if (wd.hasEntry(name)) {
      state.setMessage("Entry " + name + " already exists!")
    } else if (name.contains(Directory.SEPARATOR)) {
      // mkdir something/somethingElse
      state.setMessage(name + " must not contain separators!")
    } else if (checkIllegal(name)) {
      state.setMessage(name + ": illegal entry name!")
    } else {
      doMkdir(state, name)
    }
  }

  def checkIllegal(name: String): Boolean = {
    name.contains(".")
  }

  def doMkdir(state: State, name: String): State = {
    def updateStructure(currentDirectory: Directory, path: List[String], newEntry: DirEntry):Directory = {
      if (path.isEmpty) currentDirectory.addEntry(newEntry)
      else {

        val oldEntry = currentDirectory.findEntry(path.head)
        currentDirectory.replaceEntry(oldEntry.name, updateStructure(currentDirectory, path.tail, newEntry))
        /*
            /a/b
              /c
              /d
              (new entry)
            currentDIrectory = /a
            path = ["b"]
         */

      }
      /*
        someDir
          /a/b
            /c
            /d
            (new) /e

       new /a
         new /b (parent /a)
            /c
            /d
            /e


       */
    }

    val wd = state.wd
    val fullPath = wd.path

    // 1. all the directores in the full path
    val allDirsInPath = wd.getAllFoldersInPath

    // 2. create new directory entry in the wd
    val newDir = Directory.empty(wd.path, name)

    // 3. update the whole directory structure starting from the root
    val newRoot = updateStructure(state.root, allDirsInPath, newDir)

    // 4. find new working directory INSTANCE given wd's full path, in the NEW directory structure
    val newWd = newRoot.findDescendant(allDirsInPath)

    //State(newRoot, newWd)
    ???
  }
}