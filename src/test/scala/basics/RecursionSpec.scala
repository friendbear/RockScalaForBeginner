package basics

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest._
import matchers.should._
import basics.Recursion._

class RecursionSpec extends AnyFlatSpec with Matchers {

  behavior of "RecursionSpec"

  it should "fibonacci" in {
    fibonacci(8) should equal(13)
  }

  it should "factorial" in {
    factorial(10) should equal (3628800)
  }

  it should "anotherFactorial" in {
    anotherFactorial(10) should equal (3628800)
  }

  it should "isPrime" in {
    isPrime(2) should equal (true)
  }

  it should "concatenateTailrec" in {
    concatenateTailrec("a", 10, "") should equal("aaaaaaaaaa")
  }
}
