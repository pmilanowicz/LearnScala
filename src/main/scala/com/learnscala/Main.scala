package com.learnscala

import com.learnscala.kata.KataFactory

object Main extends App {

  var factory = new KataFactory

  factory.create("bowling").run()
  factory.create("bowling_func").run()
  factory.create("chop").run()

}
