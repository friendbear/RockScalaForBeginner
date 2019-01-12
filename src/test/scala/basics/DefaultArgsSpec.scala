package basics

import basics.DefaultArgs._
import org.scalatest.{FlatSpec, Matchers}

class DefaultArgsSpec extends FlatSpec with Matchers{

  "trFact" should "return Int" in {
    val test1 = trFact(2)
    test1 should be(2)
  }
  "savePicture all default args" should "return String" in {
    savePicture() should be ("jpg 1920 1080")
    savePicture("png") should be ("png 1920 1080")
  }
}
