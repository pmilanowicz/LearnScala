package com.learnscala.kata.anagrams

import org.scalatest.{FunSuite, Matchers}

import scala.io.{BufferedSource, Source}

class AnagramsSpec extends FunSuite with Matchers {

  val anagrams = new Anagrams()

  val bufferedFile: BufferedSource = Source.fromFile("assets/anagrams/british-english")
  bufferedFile.getLines().foreach(line => {
    anagrams.add(line)
  })

  bufferedFile.close()

  test("should print maximum number of anagrams") {
    val maxNumberOfAnagrams = anagrams.anagrams().groupBy(_._2.length).maxBy(groupedByNumberOfAnagrams => groupedByNumberOfAnagrams._1)

    println("Maximum anagrams number:")
    maxNumberOfAnagrams._2.foreach(x => println(x._2.mkString(", ")))
  }

  test("should print longest words anagrams") {
    val longestAnagrams = anagrams.anagrams().groupBy(_._1.length).maxBy(groupedByLength => groupedByLength._1)

    println("Longest anagrams:")
    longestAnagrams ._2.foreach(x => println(x._2.mkString(", ")))
  }
}
