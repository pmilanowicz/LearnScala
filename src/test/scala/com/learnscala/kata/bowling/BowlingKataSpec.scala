package com.learnscala.kata.bowling

import org.scalatest.{BeforeAndAfterEach, FunSuite, Matchers}


class BowlingKataSpec extends FunSuite with Matchers with BeforeAndAfterEach {

  var game: Game = _

  override def beforeEach(): Unit = {
    game = new Game
  }


  test("score should be 0 at the beginning") {
    game.score() should equal(0)
  }

  test("score should be 10 after rolls 2 and 8") {
    game.roll(2)
    game.roll(8)

    game.score() should equal(10)
  }

  test("should add bonus after first strike and return 30 as score") {
    game.roll(10)
    game.roll(5)
    game.roll(5)

    game.score() should equal(30)
  }


  test("should correct score perfect game at 300 points") {

    (1 to 12).foreach(_ => game.roll(10))

    game.score() should equal(300)
  }
}
