package basics

import basics.CallByNameCallByValue.{byName, byValue}
import org.scalatest.{FlatSpec, Matchers}

class CallByNameCallByValueTest extends FlatSpec with Matchers{

  "CallByName" should "return Unit" in {
    byName(System.nanoTime()) should be ()
  }
  "CallByValue" should "return Unit" in {
    byValue(System.nanoTime()) should be ()
  }
}
