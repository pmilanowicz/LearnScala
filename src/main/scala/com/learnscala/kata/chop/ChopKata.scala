package com.learnscala.kata.chop

import com.learnscala.kata.KataRunner

class ChopKata extends KataRunner {

  override def run(): Unit = {

    val (array, searched) = (List(1, 2, 5, 7, 8, 10, 13, 17), 8)

    val chop = new Chop

    println("Chop result: " + chop.chop(searched, array))
  }
}
