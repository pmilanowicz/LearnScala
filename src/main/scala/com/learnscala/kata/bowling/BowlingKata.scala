package com.learnscala.kata.bowling

import com.learnscala.kata.KataRunner

class BowlingKata extends KataRunner {

  override def run(): Unit = {

    val game = new Game

    println("Started bowling game")

    game.roll(8) // 1st frame
    game.roll(2) // 1st frame

    game.roll(3) // 2nd frame
    game.roll(6) // 2nd frame

    game.roll(9) // 3rd frame
    game.roll(1) // 3rd frame

    game.roll(10) // 4th frame

    game.roll(10) // 5th frame

    game.roll(0) // 6th frame
    game.roll(0) // 6th frame

    game.roll(1) // 7th frame
    game.roll(8) // 7th frame

    game.roll(10) // 8th frame

    game.roll(7) // 9th frame
    game.roll(2) // 9th frame

    game.roll(9) // 10th frame
    game.roll(0) // 10th frame

    val score = game.score()
    score match {
      case 300 => println("Perfect game! " + score + " points")
      case _ => println("Score: " + score + " points")
    }
  }
}
