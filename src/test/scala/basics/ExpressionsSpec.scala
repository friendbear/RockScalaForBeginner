package basics

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest._
import matchers.should._

class ExpressionsSpec extends AnyFlatSpec with Matchers{

  "Expressions" should "mix" in {
    val s: String = Expressions.aCodeBlock
    s should be ("hello")
    Expressions.aCondition should be (true)
    Expressions.someOtherValue should be (42)
  }
}
