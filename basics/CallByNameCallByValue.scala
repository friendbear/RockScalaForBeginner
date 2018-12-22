
object CallByNameCallByValue extends App {

    def byValue(n: Long) = {
      println(s"byValue System nano sec is $n")
      println(s"byValue System nano sec is $n")
    }

    def byName(n: => Long) = {
      println("byName System nano sec is " + n)
      println("byName System nano sec is " + n)
    }

    byValue(System.nanoTime())
    byName(System.nanoTime())

}
