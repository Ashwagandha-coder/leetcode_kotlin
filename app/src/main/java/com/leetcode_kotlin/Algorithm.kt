package com.leetcode_kotlin

/**
 * Executing
 */

fun main() {
   numIdenticalPairs(intArrayOf(1,1,1,1))
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

/**
 * 1512. Number of Good Pairs
 */

fun numIdenticalPairs(nums: IntArray): Int {
    val counts = mutableMapOf<Int, Int>()
    var ans = 0
    for (num in nums) {
        if (counts.contains(num)) ans += counts[num]!!
        counts[num] = (counts[num] ?: 0) + 1
    }
    return ans
}



