package com.github.contest.dp

/**
 * 55. Jump Game
 * Alternative Solution
 * Recursion Approach
 */

fun canJumpAltSolution(nums: IntArray): Boolean = solve(nums, 0)

private fun solve(nums: IntArray, index: Int): Boolean {
    if (index >= nums.size - 1) return true
    if (nums[index] == 0 && index < nums.size - 1) return false

    var step = nums[index]

    while (step != 0) {
        if (solve(nums, index + step)) return true
        step--
    }

    return false
}

/**
 * 3350. Adjacent Increasing Subarrays Detection II
 * Alternative Solution - TLE
 * Time - O(k * n)
 * Space - O(n^2)
 */

fun maxIncreasingSubarraysAlternativeSolution(nums: List<Int>): Int {

    var maxK = 1
    val n = nums.size
    val dp = Array(n) { BooleanArray(n) { false } }.apply {
        for (i in 0 until n) {
            this[i][i] = true
        }
    }

    for (k in 2..n / 2) {
        for (i in 1 until n - (k * 2) + 2) {
            val startIndexFirst = i - 1
            val endIndexFirst = i + k - 2
            val startIndexSecond = i + k - 1
            val endIndexSecond = i + (k * 2) - 2

            dp[startIndexFirst][endIndexFirst] = when {
                dp[startIndexFirst][endIndexFirst - 1] && nums[endIndexFirst - 1] < nums[endIndexFirst] -> true
                else -> false
            }

            dp[startIndexSecond][endIndexSecond] = when {
                dp[startIndexSecond][endIndexSecond - 1] && nums[endIndexSecond - 1] < nums[endIndexSecond] -> true
                else -> false
            }

            if (dp[startIndexFirst][endIndexFirst] && dp[startIndexSecond][endIndexSecond]) maxK = k
        }
    }

    return maxK
}