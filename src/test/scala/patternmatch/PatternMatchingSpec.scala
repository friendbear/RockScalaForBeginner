package patternmatch

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest._
import matchers.should._

import patternmatch.PatternMatching.{Number, Prod, Sum, show}

class PatternMatchingSpec extends AnyFlatSpec with Matchers {

  behavior of "PatternMatching"

  it should "Expr test" in {

    show(Sum(Number(2), Number(3))) should be ("2 + 3")
    show(Sum(Sum(Number(2), Number(3)), Number(4))) should equal("2 + 3 + 4")
    show(Prod(Sum(Number(2), Number(1)), Number(3))) should equal("(2 + 1) * 3")
    show(Sum(Prod(Number(2), Number(1)), Number(3))) should equal("2 * 1 + 3")

  }

}
