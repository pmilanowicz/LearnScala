package com.learnscala.kata

import com.learnscala.kata.bowling.functional.BowlingKataFunctional
import com.learnscala.kata.bowling.oop.BowlingKataOop
import com.learnscala.kata.chop.ChopKata

class KataFactory {

  private final val Bowling = "bowling"
  private final val BowlingFunc = "bowling_func"
  private final val Chop = "chop"

  def create(objectName: String): KataRunner = {

    if (objectName.equals(this.Bowling)) {
      new BowlingKataOop
    }
    else if (objectName.equals(this.BowlingFunc)) {
      new BowlingKataFunctional
    }
    else if (objectName.equals(this.Chop)) {
      new ChopKata
    } else {
      throw new Exception("Wrong kata class")
    }
  }
}
