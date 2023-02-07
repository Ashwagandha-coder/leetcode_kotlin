package com.leetcode_kotlin.Task.twoSum.TwoSum.RomanToInteger

fun romanToInteger(s: String): Int {

    var number = 0
    var result = 0
    val range = s.length - 1 downTo 0

    for (j in range) {
        when (s[j]) {
            'I' -> number = 1
            'V' -> number = 5
            'X' -> number = 10
            'L' -> number = 50
            'C' -> number = 100
            'D' -> number = 500
            'M' -> number = 1000

        }

        if (4 * number < result) result -= number
        else result += number

    }

    return result

}

