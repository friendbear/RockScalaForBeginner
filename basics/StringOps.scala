
object StringOps extends App {

  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2))
  println(str.substring(7, 11))

  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)

  val aNumberString = "45"
  val aNumber = aNumberString.toInt

  println('a' +: aNumberString :+ 'z')
  println(str.reverse)
  println(str.take(2))

  // Scala-specific: String interpolators.
  //
  // //S-Interpolators
  val name = "David"
  val age = 12

  val greeting = s"Hello, my name is $name and I am $age years old"
  val antohergreeting = s"Hello, my name is $name and I am $age I will be turning ${age + 1} yeears old."
  println(anotherGreeting)

  // F-interpolators
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f burgers per minute"

  println(myth)

  // raw-interpolator
  println(raw"This is a \n newline")

}