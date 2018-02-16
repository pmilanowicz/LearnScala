package com.learnscala.kata.bloom

import org.scalatest.{BeforeAndAfterEach, FunSuite, Matchers}

import scala.io.Source

class BloomFilterSpec extends FunSuite with Matchers with BeforeAndAfterEach {

  var bloomFilter: BloomFilter = _

  override protected def beforeEach(): Unit = {
    bloomFilter = new BloomFilter
  }

  test("should return false for not added any string") {

    bloomFilter.added("some") should equal(false)
  }

  test("should return true for added strings") {

    val bufferedFile = Source.fromFile("assets/bloom/dict.txt")
    val words = bufferedFile.getLines().toList

    bufferedFile.close()

    words.foreach(bloomFilter.add)
    words.foreach(bloomFilter.added(_) should equal(true))
  }

  test("should return false for not added strings") {

    val arrayOfStrings: Array[String] = Array("someString", "second string")

    arrayOfStrings.foreach(bloomFilter.add)

    bloomFilter.added("not added") should equal(false)
  }
}
