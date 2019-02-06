package filesystem.files

import filesystem.FilesystemException

abstract class DirEntry(val parentPath: String, val name: String) {

  def path: String = parentPath + Directory.SEPARATOR + name

  def asDirectory: Directory
  def asFile: File = throw new FilesystemException("")
  def getType: String
}
