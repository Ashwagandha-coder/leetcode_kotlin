package com.leetcode_kotlin.Task.twoSum.TwoSum.ReverseInteger

fun reverseInt(value: Int): Int {

    var result = 0
    var num = value
    val param = value

    while (num != 0) {
        num = param % 10
        result = result + num
        result = result * 10
        num = param / 10

    }
    result = result / 10


    return result

}

// Недоделал

fun main() {

    println(reverseInt(324))

}