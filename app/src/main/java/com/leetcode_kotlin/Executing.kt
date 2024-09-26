package com.leetcode_kotlin

/**
 * Executing
 */

fun main() {

    var arr = IntArray(50000)

    subsetsWithDup(arr).forEach {
        print("$it ")
    }


}