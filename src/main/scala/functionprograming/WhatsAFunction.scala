package functionprograming

trait MyFunction[A, B] {
  def apply(element:A): B
}

object WhatsAFunction extends App {

  
  val doubler = new Function[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }
  
  println(doubler(2))

  // function types = Function[A, B]
  val stringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("3") + 4)

  val adder: (Int, Int) => Int = new Function2[Int, Int, Int] {
    def apply(a: Int, b: Int): Int = a + b
  }

  // Function types Function2[A, B, R] == (A, B) => B

  // ALL SCALA FUNCTIONS ARE OBJECTS

  /*
   * 1. a function which takes 2 strings and concatenates them
   * 2. transform the MyPredicate and MyTransformer into function types
   * 3 define a function which takes an int and returns another function which takes an int
   *   - what's the type of 
   */

  def concatenator: (String, String) => String = new Function2[String, String, String] {
    override def apply(a: String, b: String): String = a + b
  }
  println(concatenator("Hello", "Scala"))

}



