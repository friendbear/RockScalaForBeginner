package basics

import basics.DefaultArgs._
import org.scalatest.{FlatSpec, Matchers}

class DefaultArgsTest extends FlatSpec with Matchers{

  "trFact" should "return Int" in {
    val test1 = trFact(1, 0)
    test1 should be 1
  }
  "savePicture all default args" should "return String" in {
    savePicture() should be  "jpg 1920 1080"
  }
  "savePicture jpg => png" should "return String" in {
    savePicture("png") should be = "png 1920 1080"
  }
}
