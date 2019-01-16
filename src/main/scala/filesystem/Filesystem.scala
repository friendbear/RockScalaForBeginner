package filesysystem

import java.util.Scanner

import filesystem.commands.Command
import filesystem.files.Directory

object Filesystem extends App {

  val root = Directory.ROOT
  var state = State(root, root)

  val scanner = new Scanner(System.in)

  while (true) {
    state.show
    val input = scanner.nextLine()
    state = Command.from(input).apply(state)
  }
}
