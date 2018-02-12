package com.learnscala.kata.munging

import scala.io.Source

class DataMunging {

  private final val weatherFilename: String = "assets/munging/weather.dat"
  private final val footballFilename: String = "assets/munging/football.dat"

  def smallestWeatherTemperatureSpread(): Int = {
    val meaningfulWeatherRows = fileAsRows(weatherFilename, (ln: List[List[String]]) => ln.slice(2, 30))

    minimumSpread(meaningfulWeatherRows, (ln: List[String]) => (ln(1), ln(2).toInt - ln(3).toInt)).toInt
  }

  def smallestFootballGoalsSpread(): String = {
    val meaningfulFootballRows = fileAsRows(footballFilename, (l: List[List[String]]) => l.slice(1, 18) ::: l.slice(19, 22))

    minimumSpread(meaningfulFootballRows, (ln: List[String]) => (ln(2), ln(7).toInt - ln(8).toInt))
  }

  def fileAsRows(filename: String, filterRows: (List[List[String]]) => List[List[String]]): List[List[String]] = {
    val bufferedFile = Source.fromFile(filename)
    val fileLines = bufferedFile.getLines().toList.map(_.split("\\W+").toList) //

    bufferedFile.close()

    filterRows(fileLines) // filter out meaningless rows
  }

  def minimumSpread(fileLines: List[List[String]], calculateSpreads: (List[String]) => (String, Int)): (String) = {
    fileLines.map(calculateSpreads).minBy(_._2)._1 // calculate spreads and get minimum
  }
}
