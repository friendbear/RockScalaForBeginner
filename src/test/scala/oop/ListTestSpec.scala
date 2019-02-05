package oop

import org.scalatest.{FlatSpec, Matchers}

class ListTestSpec extends FlatSpec with Matchers {

  behavior of "MyList Class"

  lazy val list = new Cons(1, Empty)
  lazy val list2 = new Cons(1, new Cons(2, new Cons(3, Empty)))
  lazy val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  lazy val cloneListOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  lazy val anotherListOfIntegers: MyList[Int] = new Cons(4, new Cons(5, Empty))
  lazy val listOfStrings: MyList[String] = new Cons("Hello", new Cons("world", new Cons("Scala", Empty)))

  it should "map filter flatMap" in {

    listOfIntegers.map(x => x * 2).toString should equal ("2 4 6")
    listOfIntegers.filter(_ % 2 == 0)
    /*  println(listOfIntegers.flatMap(new Function1[Int, MyList[Int]] {
        override def apply(elem: Int): MyList[Int] = new Cons(elem, new Cons(elem + 1, Empty))
      }).toString) */
    listOfIntegers.flatMap(t => new Cons(t, new Cons(t +1, Empty))).toString should equal("1 2 2 3 3 4")
  }

  /*  println(listOfIntegers.filter(new Function[Int, Boolean] {
      override def apply(elem: Int): Boolean = elem % 2 == 0
    }).toString) */
  it should "++ ==" in {

    (listOfIntegers ++ anotherListOfIntegers).toString should be ("1 2 3 4 5")
    // CCs によりSensible equals, hashCode, toString
    cloneListOfIntegers == listOfIntegers === true
  }

  it should "sort fold zipWith" in {

    // sort
    listOfIntegers.sort((x, y) => y - x).toString should be ("5 4 3 2 1")

    // zipWith
    anotherListOfIntegers.zipWith[String, String](listOfStrings, _ + "-" + _).head should be ("1-Hello")

    // fold
    listOfIntegers.fold(0)(_ + _) should be (6)

  }
  /*
   1. MyList supports for comprehensions?
     - map(f: A => B) => MyList[B]
       filter(p: A => Boolean)
       flatMap(f: A=> MyList[B])
  */
  // for comprehensions
  val combinations = for {
    n <- listOfIntegers
    string <- listOfStrings
  } yield n + "-" + string
  println(combinations)

}
