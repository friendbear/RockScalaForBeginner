package basics

import org.scalatest.{FlatSpec, Matchers}

class ExpressionsSpec extends FlatSpec with Matchers{

  "Expressions" should "mix" in {
    val s: String = Expressions.aCodeBlock
    s should be ("hello")
    Expressions.aCondition should be (true)
    Expressions.someOtherValue should be (42)
  }
}
