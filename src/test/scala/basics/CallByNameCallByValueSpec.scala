package basics

import org.scalatest.{FlatSpec, Matchers}

class CallByNameCallByValueSpec extends FlatSpec with Matchers{

  "CallByName" should "return Unit" in {
    CallByNameCallByValue.byName(System.nanoTime()) should be ()
  }
  "CallByValue" should "return Unit" in {
    CallByNameCallByValue.byValue(System.nanoTime()) should be ()
  }
}
