package com.github.contest.bitManipulation

/**
 * 1863. Sum of All Subset XOR Totals
 */

fun subsetXORSum(nums: IntArray): Int {
    var totalXORSum = 0

    fun calculateSubsetXOR(index: Int, currentXOR: Int) {
        if (index == nums.size) {
            totalXORSum += currentXOR
            return
        }

        // Include the current element
        calculateSubsetXOR(index + 1, currentXOR xor nums[index])

        // Exclude the current element
        calculateSubsetXOR(index + 1, currentXOR)
    }

    calculateSubsetXOR(0, 0)
    return totalXORSum
}

/**
 * 191. Number of 1 Bits
 */

fun hammingWeight(n: Int): Int {
    var num = n
    var count = 0

    while (num != 0) {
        count += num and 1
        num = num ushr 1
    }

    return count
}

/**
 * 461. Hamming Distance
 */

fun hammingDistance(x: Int, y: Int): Int {
    var res = x xor y
    var count = 0

    while (res != 0) {
        count += res and 1
        res = res ushr 1
    }

    return count
}