package com.learnscala.kata.bowling.oop

class BonusFrame(previous: Some[Frame]) extends Frame(previous) {

  override def completed: Boolean = {
    rolls.lengthCompare(1) == 0 && !previous.exists(_.strike) || rolls.lengthCompare(2) == 0
  }

  override def score: Int = 0

  override def spare: Boolean = false

  override def strike: Boolean = false
}

