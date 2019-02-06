package filesystem.commands
import filesysystem.State

class Pwd extends Command {

  override def apply(state: State): State = {
    state.setMessage(state.wd.path)
  }
}
