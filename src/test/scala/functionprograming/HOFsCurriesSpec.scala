package functionprograming

import org.scalatest.{FlatSpec, Matchers}
import functionprograming.HOFsCurries._

class HOFsCurriesSpec extends FlatSpec with Matchers {

  behavior of "HOFsCurriesTest"

  it should "nTime" in {
    val plusOne = (x: Int) => x + 1
    nTimes(plusOne, 10, 0) should equal(10)
  }

  it should "nTimeBetter" in {
    val n: (Int => Int) = nTimesBetter((x: Int) => x + 1, 10)
    n(0) should equal (10)
  }

  it should "curriedFormatter" in {
    curriedFormatter("%s")(10) should equal ("10")
  }

  it should "toCurry" in {
    val cur: Int => Int => Int = toCurry((x: Int, y: Int) => x + y)
    cur(1)(2) should equal (3)
  }

  it should "compose and Then" in {
    val add2 = (x: Int) => x + 2
    val times3 = (x: Int) => x * 3

    compose(add2, times3)(4) should equal (14)
    andThen(add2, times3)(4) should equal (18)
  }
}
