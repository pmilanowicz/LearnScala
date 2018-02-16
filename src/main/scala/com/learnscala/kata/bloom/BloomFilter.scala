package com.learnscala.kata.bloom

import java.security.MessageDigest

class BloomFilter {

  val bloomArray: Array[Int] = Array.fill[Int](4080)(0)

  def add(s: String): Unit = indexes(s).foreach(bloomArray(_) = 1)

  def added(s: String) : Boolean = {
    val hashIndexes = indexes(s)

    hashIndexes.count(bloomArray(_) == 1) == hashIndexes.length
  }

  private def hash(name: String, s: String): String = {
    MessageDigest.getInstance(name).digest(s.getBytes).map(0xFF & _).map { "%02x".format(_) }.foldLeft(""){_ + _}
  }

  private def indexes(s: String): List[Int] = List(stringToInt(md5(s)), stringToInt(sha1(s)))
  private def md5(s: String)= hash("MD5", s)
  private def sha1(s: String) = hash("SHA1", s)
  private def stringToInt(s: String): Int = s.getBytes.map(x => x.toInt - 48).sum
}
