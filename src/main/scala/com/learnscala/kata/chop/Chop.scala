package com.learnscala.kata.chop

class Chop {

  def chop(searched: Int, array: List[Int]): Int = {
    chopRecursive(searched, array, 0)
  }

  def chopRecursive(searched: Int, array: List[Int], leftIndex: Int): Int = {

    if (array.lengthCompare(1) < 0) return -1

    val middle = (array.length / 2).ceil.toInt
    val (left, right) = array.splitAt(middle)

    right.head match {
      case value if value == searched => middle + leftIndex
      case value if value < searched => chopRecursive(searched, right.tail, leftIndex + middle + 1)
      case value if value > searched => chopRecursive(searched, left, leftIndex)
    }
  }
}
