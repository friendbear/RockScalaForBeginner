package patternmatch

import oop.{Cons, Empty, MyList}
import org.scalatest.{FlatSpec, Matchers}

class AllThePatternsSpec extends FlatSpec with Matchers {

  behavior of "AllThePatternsTest"
  lazy val x: Any = "Scala"
  lazy val aList: MyList[Int] = Cons(1, Cons(2, Empty))
  lazy val nestedTuple = (1, (2, 3))
  lazy val aStandardList = List(1,2,3,42)
  lazy val aTuple = (1, 2)
  lazy val unknown: Any = 2
  lazy val numbers = List(1, 2, 3)

  it should "unknownMatch" in {
    AllThePatterns.unknownMatch(unknown).isEmpty should be (false)
  }

  it should "numbersMatch" in {
    AllThePatterns.numbersMatch(numbers).isEmpty should be (false)

  }

  it should "matchNestedTupleMatch" in {
    AllThePatterns.matchNestedTupleMatch(nestedTuple).isEmpty should be (false)
  }

  it should "standardListMatch" in {
    AllThePatterns.standardListMatch(aStandardList).isEmpty should be (false)
  }

  it should "nameBindingMatch" in {
    AllThePatterns.nameBindingMatch(aList).isEmpty should be (false)
  }

  it should "secondElementSpecial" in {
    AllThePatterns.secondElementSpecial(aList).isEmpty should be (false)
  }

  it should "matchATupleMatch" in {
    AllThePatterns.matchATupleMatch(aTuple).isEmpty should be (false)
  }

}
