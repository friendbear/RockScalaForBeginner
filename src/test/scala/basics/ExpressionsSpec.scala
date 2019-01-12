package basics

import basics.Expressions._
import org.scalatest.{FlatSpec, Matchers}

class ExpressonsSpec extends FlatSpec with Matchers{

  "Expressions" should "mix" in {
    val aCode = aCodeBlock
    aCode should be ("hello")
  }
}
