

abstract class MyList[+T] {

  /*
   * head = first element of the list
   * tail = remainder of the list
   * isEmpty = is this list empty
   * add(int) => new list with this element added
   * toString => a string representation of the list
   */
  def head[T]: T
  def tail[T]: MyList[T]
  def isEmpty: Boolean
  def add[T](element: T): MyList[T]
  def printElements: String
  override def toString: String = "[" + printElements + "]"
}

object Empty extends MyList {
  def head[T]: T = throw new NoSuchElementException
  def tail[T]: MyList[T] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[T](element: T): MyList[T] = new Cons(element, Empty)
  def printElements: String = ""
}

class Cons[T](head: T, tail: MyList[T]) extends MyList {
  def head[T]: T = head
  def tail[T]: MyList[T] = tail
  def isEmpty: Boolean = false
  def add[T](element: T): MyList[T] = new Cons(element, this)
  def printElements: String =
    if(tail.isEmpty) "" + head
    else head + " " + tail.printElements
}

object ListTest extends App {

  val list = new Cons(1, Empty)
  val list2 = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.head)
  println(list2.tail.head)
  println(list2.add(4).head)
  println(list2.isEmpty)

  println(list2.toString)

}

