package com.leetcode_kotlin

/**
 * Executing
 */

fun main() {
    val arr = intArrayOf(1,2,50,4)
    minimumOperations(arr)
}


/**
 * 3190. Find Minimum Operations to Make All Elements Divisible by Three
 */

fun minimumOperations(nums: IntArray): Int {
    var res = 0

    for (n in nums) {
        if (n % 3 > 0) res++
    }

    return res
}


/**
 * 2011. Final Value of Variable After Performing Operations
 */


fun finalValueAfterOperations(opr: Array<String>): Int {
    var res = 0
    for (i in opr) {
        if (i.contains("-")) res -= 1
        else res += 1
    }
    return res
}



