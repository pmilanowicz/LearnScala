package com.learnscala.kata.chop

import org.scalatest.{BeforeAndAfterEach, FunSuite, Matchers}

class ChopSpec extends FunSuite with Matchers with BeforeAndAfterEach {

  var chopRecursive: ChopRecursive = _
  var chop: Chop = _

  override protected def beforeEach(): Unit = {
    chopRecursive = new ChopRecursive
    chop = new Chop
  }

  test("should return proper indexes in recursive chop") {
    assert_equal(-1, chopRecursive.chop(3, List()))
    assert_equal(-1, chopRecursive.chop(3, List(1)))
    assert_equal(0,  chopRecursive.chop(1, List(1)))

    assert_equal(0,  chopRecursive.chop(1, List(1, 3, 5)))
    assert_equal(1,  chopRecursive.chop(3, List(1, 3, 5)))
    assert_equal(2,  chopRecursive.chop(5, List(1, 3, 5)))
    assert_equal(-1, chopRecursive.chop(0, List(1, 3, 5)))
    assert_equal(-1, chopRecursive.chop(2, List(1, 3, 5)))
    assert_equal(-1, chopRecursive.chop(4, List(1, 3, 5)))
    assert_equal(-1, chopRecursive.chop(6, List(1, 3, 5)))

    assert_equal(0,  chopRecursive.chop(1, List(1, 3, 5, 7)))
    assert_equal(1,  chopRecursive.chop(3, List(1, 3, 5, 7)))
    assert_equal(2,  chopRecursive.chop(5, List(1, 3, 5, 7)))
    assert_equal(3,  chopRecursive.chop(7, List(1, 3, 5, 7)))
    assert_equal(-1, chopRecursive.chop(0, List(1, 3, 5, 7)))
    assert_equal(-1, chopRecursive.chop(2, List(1, 3, 5, 7)))
    assert_equal(-1, chopRecursive.chop(4, List(1, 3, 5, 7)))
    assert_equal(-1, chopRecursive.chop(6, List(1, 3, 5, 7)))
    assert_equal(-1, chopRecursive.chop(8, List(1, 3, 5, 7)))
  }


  test("should return proper indexes in chop") {
    assert_equal(-1, chop.chop(3, List()))
    assert_equal(-1, chop.chop(3, List(1)))
    assert_equal(0,  chopRecursive.chop(1, List(1)))

    assert_equal(0,  chop.chop(1, List(1, 3, 5)))
    assert_equal(1,  chop.chop(3, List(1, 3, 5)))
    assert_equal(2,  chop.chop(5, List(1, 3, 5)))
    assert_equal(-1, chop.chop(0, List(1, 3, 5)))
    assert_equal(-1, chop.chop(2, List(1, 3, 5)))
    assert_equal(-1, chop.chop(4, List(1, 3, 5)))
    assert_equal(-1, chop.chop(6, List(1, 3, 5)))

    assert_equal(0,  chop.chop(1, List(1, 3, 5, 7)))
    assert_equal(1,  chop.chop(3, List(1, 3, 5, 7)))
    assert_equal(2,  chop.chop(5, List(1, 3, 5, 7)))
    assert_equal(3,  chop.chop(7, List(1, 3, 5, 7)))
    assert_equal(-1, chop.chop(0, List(1, 3, 5, 7)))
    assert_equal(-1, chop.chop(2, List(1, 3, 5, 7)))
    assert_equal(-1, chop.chop(4, List(1, 3, 5, 7)))
    assert_equal(-1, chop.chop(6, List(1, 3, 5, 7)))
    assert_equal(-1, chop.chop(8, List(1, 3, 5, 7)))
  }

  def assert_equal(expected: Int, actual: Int): Unit = {
    actual should equal(expected)
  }


}
