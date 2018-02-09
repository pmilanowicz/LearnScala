package com.learnscala.kata.bowling.functional

import com.learnscala.kata.KataRunner

class BowlingKataFunctional extends KataRunner {

  override def run(): Unit = {

    val game = new BowlingFunctional

    game.roll(10) // 1st frame

    game.roll(10) // 2nd frame

    game.roll(10) // 3rd frame

    game.roll(10) // 4th frame

    game.roll(10) // 5th frame

    game.roll(10) // 6th frame

    game.roll(10) // 7th frame

    game.roll(10) // 8th frame

    game.roll(10) // 9th frame

    game.roll(10) // 10th frame

    game.roll(10) // 11th roll (bonus)
    game.roll(10) // 12th roll (bonus)

    val score = game.score()
    score match {
      case 300 => println("Perfect game! " + score + " points")
      case _ => println("Score: " + score + " points")
    }
  }
}
