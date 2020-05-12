package filesystem.commands
import filesysystem.State

class Cat(filename: String) extends Command {

  override def apply(state: State): State = ??? /*{
    val wd = state.wd
    val dirEntry = wd.findEntry(filename)
    if (dirEntry == null || !dirEntry.isFile)
      state.setMessage(filename + ": no match file")
    else
      state.setMessage(dirEntry.asFile.)
  }*/
}
