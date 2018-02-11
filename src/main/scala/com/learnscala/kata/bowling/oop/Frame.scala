package com.learnscala.kata.bowling.oop

class Frame(val previous: Option[Frame]) {

  var rolls: List[Int] = List[Int]()
  var bonus: Int = 0

  def spare: Boolean = rolls.lengthCompare(2) == 0 && rolls.sum == 10

  def strike: Boolean = rolls.lengthCompare(1) == 0 && rolls.sum == 10

  def completed: Boolean = strike || rolls.lengthCompare(2) == 0

  def roll(pins: Int): Unit = {
    rolls = rolls ::: List(pins)
  }

  def score: Int = rolls.sum + bonus
}
