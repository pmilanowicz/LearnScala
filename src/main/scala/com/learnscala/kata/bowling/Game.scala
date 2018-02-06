package com.learnscala.kata.bowling

class Game {

  var frames: List[Frame] = List(new Frame(None))

  private def currentFrame = frames.head

  def roll(pins: Int): Unit = {

    if (currentFrame.completed) addFrame(currentFrame)

    currentFrame.roll(pins)
    addBonuses(pins)
  }

  private def addBonuses(pins: Int): Unit = {
    val bonuses = currentFrame.bonuses(pins)

    currentFrame.previous.map(_.bonus += bonuses(0))
    currentFrame.previous.flatMap(_.previous).map(_.bonus += bonuses(1))
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