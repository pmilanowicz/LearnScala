package com.learnscala.kata.bowling

import com.learnscala.kata.bowling.functional.BowlingFunctional
import com.learnscala.kata.bowling.oop.Game
import org.scalatest.{BeforeAndAfterEach, FunSuite, Matchers}

class BowlingKataSpec extends FunSuite with Matchers with BeforeAndAfterEach {

  var gameOop: Game = _
  var gameFunc: BowlingFunctional = _

  override def beforeEach(): Unit = {
    gameOop = new Game
    gameFunc = new BowlingFunctional
  }

  test("should score be 0 at the beginning") {
    gameFunc.score() should equal(0)
    gameOop.score() should equal(0)
  }

  test("should score be 10 after rolls 2 and 8") {
    gameFunc.roll(2)
    gameFunc.roll(8)

    gameFunc.score() should equal(10)

    gameOop.roll(2)
    gameOop.roll(8)

    gameOop.score() should equal(10)
  }

  test("should score be 15 after rolls 1 and 9 (spare) and next roll 5") {
    gameFunc.roll(1)
    gameFunc.roll(9)
    gameFunc.roll(5)

    gameFunc.score() should equal(20)

    gameOop.roll(1)
    gameOop.roll(9)
    gameOop.roll(5)

    gameOop.score() should equal(20)
  }

  test("should add bonus after first strike and return 30 as score") {
    gameFunc.roll(10)
    gameFunc.roll(5)
    gameFunc.roll(5)

    gameFunc.score() should equal(30)

    gameOop.roll(10)
    gameOop.roll(5)
    gameOop.roll(5)

    gameOop.score() should equal(30)
  }


  test("should correct score perfect game at 300 points") {

    (1 to 12).foreach(_ => {gameFunc.roll(10); gameOop.roll(10)})

    gameFunc.score() should equal(300)
    gameOop.score() should equal(300)
  }
}
