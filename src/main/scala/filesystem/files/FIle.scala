package filesystem.files

import filesystem.FilesystemException

class File(override val parentPath: String, override val name: String, contents: String )
extends DirEntry(parentPath, name) {

  override def asDirectory: Directory =
    throw new FilesystemException("A file cannot be converted to a directory!")

  override def asFile: File = this
  override def getType: String = "File"

  override def isDirectory: Boolean = false
  override def isFile: Boolean = true
  def setContents(contents: String): File =
    new File(parentPath, name, contents)
  def appendContends(newContents: String): File =
    setContents(contents + "\n" + newContents)
}

object File {
  def empty(parentPath: String, name: String): File =
    new File(parentPath, name, "")
}
