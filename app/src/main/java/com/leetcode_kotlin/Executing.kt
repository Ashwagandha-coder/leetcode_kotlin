package com.leetcode_kotlin

/**
 * Executing
 */

fun main() {


    val numArray = NumArrayAlt(intArrayOf(-2, 0, 3, -5, 2, -1))
    val sum1 = numArray.sumRange(0, 2) // sum1 = 1
    val sum2 = numArray.sumRange(2, 5) // sum2 = -1
    val sum3 = numArray.sumRange(0, 5) // sum3 = -3

    println(sum1)
    println(sum2)
    println(sum3)


}