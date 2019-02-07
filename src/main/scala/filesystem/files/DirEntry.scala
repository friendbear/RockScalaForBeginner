package filesystem.files

import filesystem.FilesystemException

abstract class DirEntry(val parentPath: String, val name: String) {

  def path: String = {
    val separatorIfNecessary =
      if (Directory.ROOT_PATH.equals(parentPath)) ""
      else Directory.SEPARATOR
    parentPath +separatorIfNecessary + name
  }

  def asDirectory: Directory
  def asFile: File = throw new FilesystemException("")
  def getType: String

  def isRoot = parentPath != Directory.ROOT_PATH
  def isDirectory: Boolean
  def isFile: Boolean
}
