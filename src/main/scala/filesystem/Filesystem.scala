
package filesystem

/**
  * Coding practice: A Small File System
  *
  */

/**
object Filesystem extends App {

  val firstRoot = Directory.ROOT
  val state = State(firstRoot, firstRoot)

  val scanner = new Scanner(System.in)

  while(true) {
    state.show
    state = Command.from(scanner.nextLine()).apply(state)
  }
}
  */
