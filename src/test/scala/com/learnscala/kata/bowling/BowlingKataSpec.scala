package com.learnscala.kata.bowling

import com.learnscala.kata.bowling.functional.BowlingRecursive
import com.learnscala.kata.bowling.oop.Bowling
import org.scalatest.{BeforeAndAfterEach, FunSuite, Matchers}

class BowlingKataSpec extends FunSuite with Matchers with BeforeAndAfterEach {

  var bowling: Bowling = _
  var bowlingRecursive: BowlingRecursive = _

  override def beforeEach(): Unit = {
    bowling = new Bowling
    bowlingRecursive = new BowlingRecursive
  }

  test("should score be 0 at the beginning") {
    bowlingRecursive.score() should equal(0)
    bowling.score() should equal(0)
  }

  test("should score be 10 after rolls 2 and 8") {
    bowlingRecursive.roll(2)
    bowlingRecursive.roll(8)

    bowlingRecursive.score() should equal(10)

    bowling.roll(2)
    bowling.roll(8)

    bowling.score() should equal(10)
  }

  test("should score be 15 after rolls 1 and 9 (spare) and next roll 5") {
    bowlingRecursive.roll(1)
    bowlingRecursive.roll(9)
    bowlingRecursive.roll(5)

    bowlingRecursive.score() should equal(20)

    bowling.roll(1)
    bowling.roll(9)
    bowling.roll(5)

    bowling.score() should equal(20)
  }

  test("should add bonus after first strike and return 30 as score") {
    bowlingRecursive.roll(10)
    bowlingRecursive.roll(5)
    bowlingRecursive.roll(5)

    bowlingRecursive.score() should equal(30)

    bowling.roll(10)
    bowling.roll(5)
    bowling.roll(5)

    bowling.score() should equal(30)
  }


  test("should correct score perfect game at 300 points") {

    (1 to 12).foreach(_ => {bowlingRecursive.roll(10); bowling.roll(10)})

    bowlingRecursive.score() should equal(300)
    bowling.score() should equal(300)
  }
}
