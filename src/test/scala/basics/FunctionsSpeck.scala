package basics

import org.scalatest.{FlatSpec, Matchers}
class FunctionsSpeck extends FlatSpec with Matchers{

  "Functions" should "mix" in {
    Functions.aRepeatedFunction("hoge", 3) should be ("hogehogehoge")
    Functions.isPrime(4) should be (true)
  }
}