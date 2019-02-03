package exercises

import org.scalatest.{FlatSpec, Matchers}
class MaybeSpec extends FlatSpec with Matchers{

  behavior of "RecursionSpec"

  it should "Recursion" in {
    val just3 = Just[Int](3)
    just3.map(_ * 2) should equal(Just(6))
    just3.flatMap(x => Just(x % 2 == 0)) should equal(Just(false))
    just3.filter(_ % 2 == 0) should equal (MaybeNot)
  }

}
