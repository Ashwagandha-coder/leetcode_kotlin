package com.github.contest.simulation

/**
 * 3507. Minimum Pair Removal to Sort Array I
 */

fun minimumPairRemoval(nums: IntArray): Int {
    var operations = 0
    val list = nums.toMutableList()

    while (isNonIncreasing(list)) {
        var minSum = Int.MAX_VALUE
        var minIndex = -1

        for (i in 0 until list.size - 1) {
            if (list[i] + list[i + 1] < minSum) {
                minSum = list[i] + list[i + 1]
                minIndex = i
            }
        }

        list[minIndex] = minSum
        list.removeAt(minIndex + 1)
        operations++
    }

    return operations
}

fun isNonIncreasing(nums: List<Int>): Boolean {
    for (i in 0 until nums.size - 1) {
        if (nums[i] > nums[i + 1]) return true
    }
    return false
}