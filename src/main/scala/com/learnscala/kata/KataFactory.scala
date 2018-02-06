package com.learnscala.kata

import com.learnscala.kata.bowling.BowlingKata

class KataFactory {

  private final val Bowling = "bowling"

  def create(objectName: String): KataRunner = {

    if (objectName.equals(this.Bowling)) {
      new BowlingKata
    } else {
      throw new Exception("Wrong kata class")
    }
  }
}
