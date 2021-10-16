package basics

import org.scalatest.funsuite.AnyFunSuite

class CallByNameCallByValueSpec extends AnyFunSuite {

  test("CallByName should return Unit") {
    assert(CallByNameCallByValue.byName(System.nanoTime()) === ())
  }
  test("CallByValue should return Unit") {
    assert(CallByNameCallByValue.byValue(System.nanoTime()) === ())
  }
}
