package oop


/*
 * head = first element of the list
 * tail = remainder of the list
 * isEmpty = is this list empty
 * add(int) => new list with this element added
 * toString => a string representation of the list
 */

/*
  1. Expand MyList
    - foreach method A => Unit
      [1,2,3].foreach(x => println(x))

    - sort function ((A, A) => Int) => MyList
      [1,2,3].sort((x, y) => y - x) => [3,2,1]

    - zipWith (list, (A, A) => B) => MyList[B]
      [1,2,3].zipWith([4,5,6], x * y) => [1 * 4.2 * 2 * 5, 3 * 6] = [4,10,18]

    - fold(start)(function) => a value
      [1,2,3].fold(0)(x + y) = 6

  2. toCurry(f: (Int, Int) => Int) => (Int => Int => Int)
     fromCurry(f: (Int => Int => Int)) => (Int, Int) => Int

  3. compose(f,g) => x => f(g(x))
     andThen(f,g) => x => g(f(x))
 */
abstract class MyList[+A] {

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"

  // higher-order functions
  def map[B](transformer: A => B): MyList[B]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]

  // concatenation
  def ++[B >: A](list: MyList[B]): MyList[B]

  // hofs
  def foreach(f: A => Unit): Unit
  def sort(compare: (A, A) => Int): MyList[A]
}

/**
  * Emptyはcase object
  */
case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B]= new Cons(element, Empty)
  def printElements: String = ""

  def map[B](transformer: Nothing => B): MyList[B] = Empty
  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty
  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  def foreach(f: Nothing => Unit): Unit = ()
  def sort(compare: (Nothing, Nothing) => Int): MyList[Nothing] = Empty
}

/**
  * Consはcase class
  */
case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)
  def printElements: String =
    if(t.isEmpty) "" + h
    else h + " " + t.printElements

  /*
    [1,2,3].filter(n % 2 == 0) =
      [2.3].filter(n % 2 == 0) =
      = new Cons(2, [3].filter(n % 2 == 0))
      = new Cons(2, Empty.filter(n % 2 == 0))
      = new Cons(2, Empty)
      =
   */
  def filter(predicate: A => Boolean): MyList[A] =
    if (predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  /*
    [1, 2, 3].map(n * 2)
      = new Cons(2, [2,3].map(n * 2))
      = new Cons(2, new Cons(4, [3].map(n * 2)))
      = new Cons(2, new Cons(4, new Cons(6, Empty.map(n * 2))))
      = new Cons(2, new Cons(4, new Cons(6, Empty)))

   */
  def map[B](transformer: A => B): MyList[B] =
    new Cons(transformer(h), t.map(transformer))

  /*
    [1,2].flatMap(n => [n, n+1])
    = [1,2] ++ [2,3] ++ Empty.flatMap(n => [n, n+1])
    = [1,2] ++ [2,3] ++ Empty
    = [1,2,2,3]
   */
  def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)

  /*
    [1, 2] ++ [3,4,5]
    = new Cons(1, [2] ++ [3,4,5])
    = new Cons(1, new Cons(2, Empty ++ [3,4,5])
    = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5)))))
   */
  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)


  def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  def sort(compare: (A, A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] =
      if (sortedList.isEmpty) new Cons(x, Empty)
      else if (compare(x, sortedList.head) <= 0) new Cons(x, sortedList)
      else new Cons(sortedList.head, insert(x, sortedList.tail))

    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }
}

/**
trait MyPredicate[-T] {
  def test(elem: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(elem: A): B
}*/

object ListTest extends App {

  val list = new Cons(1, Empty)
  val list2 = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.head)
  println(list2.tail.head)
  println(list2.add(4).head)
  println(list2.isEmpty)

  println(list2.toString)


  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val cloneListOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherListOfIntegers: MyList[Int] = new Cons(4, new Cons(5, Empty))
  println(listOfIntegers.toString)
  val listOfString: MyList[String] = new Cons("Hello", new Cons("world", new Cons("Scala", Empty)))
  println(listOfString.toString)

  println(listOfIntegers.map(x => x * 2)).toString

/*  println(listOfIntegers.filter(new Function[Int, Boolean] {
    override def apply(elem: Int): Boolean = elem % 2 == 0
  }).toString) */
  println(listOfIntegers.filter(_ % 2 == 0))

  println((listOfIntegers ++ anotherListOfIntegers).toString)

/*  println(listOfIntegers.flatMap(new Function1[Int, MyList[Int]] {
    override def apply(elem: Int): MyList[Int] = new Cons(elem, new Cons(elem + 1, Empty))
  }).toString) */
  println(listOfIntegers.flatMap(t => new Cons(t, new Cons(t +1, Empty))).toString)

  // CCs によりSensible equals, hashCode, toString
  println(cloneListOfIntegers == listOfIntegers)

  listOfIntegers.foreach(println _)

  println(listOfIntegers.sort((x, y) => y - x))
}

