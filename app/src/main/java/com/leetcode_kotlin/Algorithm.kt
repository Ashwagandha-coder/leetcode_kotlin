package com.leetcode_kotlin

/**
 * Executing
 */

fun main() {
    println(containsDuplicate(intArrayOf(1,2,3,7)))
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


/**
 * 217. Contains Duplicate
 */

fun containsDuplicate(nums: IntArray): Boolean {
    var count = 1
    val map = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
        if (map.contains(nums[i])) return true
        else {
            map.put(nums[i], 1)
        }
    }
    return false
}

/**
 * 268. Missing Number
 */


fun missingNumber(nums: IntArray): Int {
    val length = nums.size
    var sum = 0
    for (i in nums) {
        sum += i
    }
    return length * (length + 1) / 2 - sum
}

/**
 * 448. Find All Numbers Disappeared in an Array
 */

fun findDisappearedNumbers(nums: IntArray): List<Int> {
    val arr = mutableListOf<Int>()
    val set = mutableSetOf<Int>()
    for (i in nums) set.add(i)
    for (i in 1..nums.size) {
        if (!set.contains(i)) {
            arr.add(i)
        }
    }
    return arr
}

/**
 * 136. Single Number
 */

fun singleNumber(nums: IntArray): Int {
    var res = 0
    for (i in nums) res = res xor i
    return res
}





