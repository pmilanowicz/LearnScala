package com.learnscala.kata.bowling.oop

class Game {

  var frames: List[Frame] = List(new Frame(None))

  private def currentFrame = frames.head

  def roll(pins: Int): Unit = {

    if (currentFrame.completed) addFrame(currentFrame)

    currentFrame.roll(pins)
    addBonuses(pins)
  }

  private def addBonuses(pins: Int): Unit = {

    val bonusForPrevious = previousFrameBonus(pins)
    val bonusFor2Previous = previous2FrameBonus(pins)

    currentFrame.previous.map(_.bonus += bonusForPrevious)
    currentFrame.previous.flatMap(_.previous).map(_.bonus += bonusFor2Previous)
  }

  private def previousFrameBonus(pins: Int): Int = {

    if (currentFrame.previous.exists(_.strike) ||
      (currentFrame.previous.exists(_.spare) && currentFrame.rolls.lengthCompare(1) == 0)
    ) pins else 0
  }

  private def previous2FrameBonus(pins: Int): Int = {

    if (
      currentFrame.previous.exists(_.strike) &&
        currentFrame.rolls.lengthCompare(1) == 0 &&
        currentFrame.previous.flatMap(_.previous).exists(_.strike)
    ) pins else 0

  }

  private def addFrame(previous: Frame): Unit = {

    if (frames.lengthCompare(10) < 0) {
      frames = new Frame(Some(previous)) :: frames
    } else if (frames.lengthCompare(10) == 0 && (previous.strike || previous.spare)) {
      frames = new BonusFrame(Some(previous)) :: frames
    } else {
      throw new Exception("No more frames allowed")
    }
  }


  def score(): Int = {
    frames.map(_.score).sum
  }
}
