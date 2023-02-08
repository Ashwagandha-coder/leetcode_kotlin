package com.leetcode_kotlin.Task.twoSum.TwoSum.ReverseInteger

fun reverseInt(value: Int): Int {

    var result = 0
    var num = value

    while (num != 0) {
        num = num % 10
        result = result + num
        result = result * 10
        num = num / 10

    }


    return result

}