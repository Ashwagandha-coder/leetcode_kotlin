package com.leetcode_kotlin.Task.twoSum.TwoSum.RomanToInteger

fun romanToInteger(s: String): Int {

    val list = listOf("I","V","X","L","C","D","M")
    val map = mapOf<String,Int>("I" to 1,"V" to 5,"X" to 10,"L" to 50,"C" to 100,"D" to 500,"M" to 1000)

    for (i in map) {
        if (i.key == s) {
            return i.value
        }
    }

    return 0

}
