package functionprograming

import scala.util.Random


/**
  * Functional Programming in Scala
  *
  * - Sequences
  *
  */
object Sequences extends App{

  // Ssq
  val aSequence = Seq(1, 3, 2, 4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(7, 5, 6))
  println(aSequence.sorted)

  // Ranges
  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println)

  // lists
  val aList = List(1, 2, 3)
  val prepended = 42 +: aList :+ 80
  println(prepended)

  val apples5 = List.fill(5)("apple")
  println(apples5)
  println(aList.mkString("-|-"))


  // arrays
  val numbers = Array(1, 2, 3, 4)
  val treeElements = Array.ofDim[Int](3)
  treeElements.foreach(println)

  // mutation
  numbers(2) = 0 // syntax sugar for numbers.update(2, 0)

  println(numbers.mkString(" "))

  // arrays and seq
  val numbersSeq: Seq[Int] = numbers // implicit conversion
  println(numbersSeq) // => WrappedArray

  // Vector good performance large size
  val vector: Vector[Int] = Vector(1, 2, 3)

  // vectors vs list
  val maxRuns = 1000
  val maxCapacity = 100000

  // Vector vs List WriteTime Random access and update
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime
      collection.updated(r.nextInt(maxCapacity), r.nextInt)
      System.nanoTime() - currentTime
    }
    // average
    times.sum * 1.0 / maxRuns
  }
  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  // keeps reference to tail
  // updating an element in the middle takes long
  println(getWriteTime(numbersList))
  // depth of the tree is small
  // needs to replace an entire 32-element chunk
  println(getWriteTime(numbersList))

}
