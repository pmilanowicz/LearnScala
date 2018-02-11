package com.learnscala.kata.chop

class Chop {

  def chop(searched: Int, array: List[Int]): Int = {

    var (left, right) = (0, array.length - 1)

    var middle: Int = 0

    while (left <= right) {
      middle = ((left + right) / 2).floor.toInt

      array(middle) match {
        case value if value.compareTo(searched) == 0 => return middle
        case value if value.compareTo(searched) > 0 => right = middle - 1
        case value if value.compareTo(searched) < 0 => left = middle + 1
        case _ => return -1
      }

    }

    - 1
  }
}
