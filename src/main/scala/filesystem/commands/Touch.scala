package filesystem.commands
import filesystem.files.{DirEntry, File}
import filesysystem.State

class Touch(name: String) extends CreateEntry(name) {

  override def createSpecificEntry(state: State): DirEntry = {
    File.empty(state.wd.path, name)
  }
}
