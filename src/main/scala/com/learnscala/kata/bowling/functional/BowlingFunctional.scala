package com.learnscala.kata.bowling.functional

class BowlingFunctional {

  var rolls: List[Int] = List()

  def roll(pins: Int): Unit = {
    rolls = rolls :+ pins
  }

  def score(): Int = {
    scoreRecursive(0, 1, rolls)
  }

  def scoreRecursive(score: Int, frame: Int, rollsList: List[Int]): Int = {
    if (frame > 10 || rollsList.isEmpty) {
      score
    } else if (rollsList.head == 10) { // strike
      scoreRecursive(score + 10 + rollsList.tail.take(2).sum, frame + 1, rollsList.tail)
    } else if (rollsList.head + rollsList.tail.take(1).sum == 10) { // spare
      scoreRecursive(score + 10 + rollsList.slice(2, 3).sum, frame + 1, rollsList.takeRight(rollsList.length - 2))
    } else { // normal frame
      scoreRecursive(score + rollsList.take(2).sum, frame + 1, rollsList.takeRight(rollsList.length - 2))
    }
  }
}
