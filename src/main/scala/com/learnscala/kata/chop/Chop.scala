package com.learnscala.kata.chop

class Chop {

  def chop(searched: Int, array: List[Int]): Int = {

    var (left, right) = (0, array.length - 1)
    var index = middle(left, right)

    while (left <= right) {

      array(index) match {
        case value if value.compareTo(searched) == 0 => return index
        case value if value.compareTo(searched) > 0 => right = index - 1
        case value if value.compareTo(searched) < 0 => left = index + 1
        case _ => return -1
      }

      index = middle(left, right)
    }

    - 1
  }

  def middle(left: Int, right: Int): Int = {
    (left + right) / 2
  }
}
