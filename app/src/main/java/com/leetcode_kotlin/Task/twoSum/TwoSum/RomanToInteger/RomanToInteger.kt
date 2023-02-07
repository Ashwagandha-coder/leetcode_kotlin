package com.leetcode_kotlin.Task.twoSum.TwoSum.RomanToInteger

fun romanToInteger(s: String): Int {

    val list = listOf("I","V","X","L","C","D","M")
    val map = mapOf<String,Int>("I" to 1,"V" to 5,"X" to 10,"L" to 50,"C" to 100,"D" to 500,"M" to 1000)

    var param = 0

    for (i in map) {
        if (i.key == s)
            return i.value

    }

    for (j in s.length - 1..0) {

        when(s[j]) {
            'I' -> param = 1
            'V' -> param = 5
            'X' -> param = 10
            'L' -> param = 50
            'C' -> param = 100
            'D' -> param = 500
            'M' -> param = 1000

        }


    }

    return 0

}
