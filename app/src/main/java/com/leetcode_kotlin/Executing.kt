package com.leetcode_kotlin


/**
 * Executing
 */


fun main() {


    val arr = intArrayOf(1, 4, 6, 7, 3, 7, 7)
    arr.drop(1).forEachIndexed { index, num ->
        println("$index $num")
    }

}



