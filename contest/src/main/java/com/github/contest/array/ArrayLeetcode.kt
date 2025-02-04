package com.github.contest.array

/**
 * 1800. Maximum Ascending Subarray Sum
 */

fun maxAscendingSum(nums: IntArray): Int {
    if (nums.hasSingle()) return nums[0]
    var maxAscending = 0
    var sum = nums[0]
    for (i in 1 until nums.size) {
        if (nums[i] > nums[i - 1]) sum += nums[i]
        else {
            maxAscending = maxOf(maxAscending, sum)
            sum = nums[i]
        }
    }
    maxAscending = maxOf(maxAscending, sum)
    return maxAscending
}

private fun IntArray.hasSingle(): Boolean = when {
    this.size == 1 -> true
    else -> false
}

/**
 * 135. Candy
 */

fun candy(ratings: IntArray): Int {
    val candies = IntArray(ratings.size) {1}
    for (i in 1 until ratings.size) {
        if (ratings[i] > ratings[i - 1]) {
            candies[i] = candies[i - 1] + 1
        }
    }
    for (i in ratings.size - 2 downTo 0) {
        if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
            candies[i] = candies[i + 1] + 1
        }
    }
    return candies.sum()
}