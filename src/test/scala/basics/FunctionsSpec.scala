package basics

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest._
import matchers.should._

class FunctionsSpeck extends AnyFlatSpec with Matchers{

  "Functions" should "mix" in {
    Functions.aRepeatedFunction("hoge", 3) should be ("hogehogehoge")
  }
}