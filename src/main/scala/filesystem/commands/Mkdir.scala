package filesystem.commands

import filesystem.files.{DirEntry, Directory}
import filesysystem.State

class Mkdir(name: String) extends CreateEntry(name) {

  override def createSpecificEntry(state: State): DirEntry = {
    Directory.empty(state.wd.path, name)
  }
}
