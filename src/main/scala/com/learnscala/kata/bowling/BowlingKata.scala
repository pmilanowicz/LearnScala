package com.learnscala.kata.bowling

import com.learnscala.kata.KataRunner

class BowlingKata extends KataRunner {

  override def run(): Unit = {
    val game = new Game
    println("Started bowling game")

    game.roll(10)
    game.roll(10)
    game.roll(10)
    game.roll(10)
    game.roll(10)
    game.roll(10)
    game.roll(10)
    game.roll(10)
    game.roll(10)

    game.roll(0)
    game.roll(0)

    println("Score: " +  game.score())
  }
}
