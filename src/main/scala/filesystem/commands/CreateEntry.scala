package filesystem.commands

import filesystem.files.{DirEntry, Directory}
import filesysystem.State

abstract class CreateEntry(name: String) extends Command {

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
      doCreateEntry(state, name)
    }
  }

  def checkIllegal(name: String): Boolean = {
    name.contains(".")
  }

  def doCreateEntry(state: State, name: String): State = {

    def updateStructure(currentDirectory: Directory, path: List[String], newEntry: DirEntry):Directory = {
      if (path.isEmpty) currentDirectory.addEntry(newEntry)
      else {

        val oldEntry = currentDirectory.findEntry(path.head).asDirectory
        currentDirectory.replaceEntry(oldEntry.name, updateStructure(oldEntry, path.tail, newEntry))
        /*
            /a/b
              /c
              /d
              (new entry)
            currentDirectory = /a
            path = ["b"]
         */

        /*
          /a/b
            (contents)
            (new entry) /e

          newRoot = updateStructure(root, ["a", "b"], /e)
          => path.isEmpty?
          => oldEntry = /a
          root.replaceEntry("a", updateStructure(/a, ["b"], /e) = /a.replaceEntry("b"/ updateStructure(/b,
            => path.isEmpty?
            => oldEntry = /b
            /a.replaceEntry("b", updateStructure(/b, [], /e) = /b.add(/e)
              => path.isEmpty? => /b.add(/e)
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
    val newEntry: DirEntry = createSpecificEntry(state)

    // 3. update the whole directory structure starting from the root
    val newRoot = updateStructure(state.root, allDirsInPath, newEntry)

    // 4. find new working directory INSTANCE given wd's full path, in the NEW directory structure
    val newWd = newRoot.findDescendant(allDirsInPath)

    State(newRoot, newWd)

  }
  def createSpecificEntry(state: State): DirEntry

}
