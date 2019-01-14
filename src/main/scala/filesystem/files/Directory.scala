package filesystem.files

class Directory(override val parentPath: String, override val name: String, contents: List[DirEntry])
  extends DirEntry(parentPath, name) {

  override def asDirectory: Directory = ???

  def hasEntry(name: String): Boolean = ???

  def getAllFoldersInPath: List[String] =
    path.substring(1).split(Directory.SEPARATOR).toList
    // /a/b/c/d => List(a, b, c, d)

  def findDescendant(path: List[String]): DirEntry = ???

  def addEntry(newEntry: DirEntry): Directory = ???
  def findEntry(entryName: String): DirEntry = ???

  def replaceEntry(entryName: String, newEntry:DirEntry): Directory = ???


}

object Directory {

  val SEPARATOR = "/"
  val ROOT_PATH = "/"


  def ROOT: Directory = Directory.empty("", "")
  def empty(parentPath: String, name: String) =
    new Directory(parentPath , name, List())
}
