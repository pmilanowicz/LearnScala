package com.learnscala.kata.bowling

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

class BonusFrame(previous: Some[Frame]) extends Frame(previous) {

  override def completed: Boolean = {
    rolls.lengthCompare(1) == 0 && !previous.exists(_.strike) || rolls.lengthCompare(2) == 0
  }

  override def score: Int = 0

  override def spare: Boolean = false

  override def strike: Boolean = false
}
