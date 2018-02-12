package com.learnscala.kata.munging

import org.scalatest.{FunSuite, Matchers}

class MungingSpec extends FunSuite with Matchers {

  val dataMunging = new DataMunging

  test("should return day 14 as a smallest spread") {

    dataMunging.smallestWeatherTemperatureSpread() should equal(14)
  }

  test("should team with smallest points spread be Leicester") {

    dataMunging.smallestFootballGoalsSpread() should equal("Leicester")
  }

}