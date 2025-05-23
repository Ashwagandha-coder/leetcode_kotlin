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