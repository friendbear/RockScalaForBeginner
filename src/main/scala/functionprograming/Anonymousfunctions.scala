package functionprograming


/**
  * Functional Programming in Scala
  *
  * - Anonymous Functions
  *
  */
object Anonymousfunctions extends App {

  val doublerF = new Function[Int, Int] {
    override def apply(v1: Int): Int = v1 * 2
  }

  // anonymous function (LAMBDA)
  val doubler1: Int => Int = (x: Int) => x * 2
  val doubler2: Int => Int = x => x * 2
  val doubler = (x: Int) => x * 2

  // multiple params in a lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // no params
  val justDoSomething: () => Int = () => 3

  val justDoSomethingByName: () => Int = () => 3
  println(justDoSomething) // function itself
  println(justDoSomething()) // call
  println(justDoSomethingByName)

  // curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // MOAR syntactic sugar
  val niceIncrementer: Int => Int = _ + 1
  val niceAdder: (Int, Int) => Int  = _ + _ // equivalent to (a, b) => a + b

  /*
    1. MyList: replace all FunctionX calls with lambdas
    2. Rewrite the "special" adder as an anonymous function
   */

  val superAdd = (x: Int) => (y: Int) => x + y
  println(superAdd(3)(4))
}
