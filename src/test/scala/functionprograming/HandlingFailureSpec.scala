package functionprograming

import functionprograming.HandlingFailure.HttpService
import org.scalatest.{FlatSpec, Matchers}

import scala.util.{Failure, Success}

class HandlingFailureSpec extends FlatSpec with Matchers {

  behavior of "HandlingFailure"

  it should "Connection" in {

    val connection = HttpService.getSafeConnection("localhost", "80")
    val possibleHTML = connection.flatMap(c => c.getSafe("/"))
    val result = possibleHTML match {
      case Success(s) => s
      case Failure(s) => "error"
    }
    result should (equal ("<html>...</html>") or equal ("error"))
  }
  it should "Connection2" in {
    HttpService.getSafeConnection("host", "8080")
      .flatMap(c => c.getSafe("/"))
      .foreach(HandlingFailure.renderHTML)
  }
  it should "Connection3" in {
    for {
      connection <- HttpService.getSafeConnection("host", "8080")
      html <- connection.getSafe("/home")
    } HandlingFailure.renderHTML(html)
  }
}
