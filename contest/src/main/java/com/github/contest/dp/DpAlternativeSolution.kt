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