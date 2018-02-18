package com.learnscala.kata.anagrams

import scala.collection.mutable

class Anagrams {

  private var hashMap: mutable.HashMap[String, List[String]] = mutable.HashMap.empty[String, List[String]]

  def add(word: String): Unit = {
    val key = anagramKey(word)

    if (!hashMap.contains(key)) {
      hashMap += (key -> List[String](word))
    } else {
      hashMap.update(key, hashMap(key) ::: List(word))
    }
  }

  def anagrams(): mutable.HashMap[String, List[String]] = hashMap.filter(_._2.lengthCompare(1) > 0)

  private def anagramKey(s: String): String = {
    s.toLowerCase.toCharArray.sortWith(_ < _).mkString("")
  }
}
