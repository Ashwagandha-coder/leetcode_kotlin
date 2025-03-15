package com.github.contest.binarySearch

/**
 * 2560. House Robber IV
 */


fun minCapability(nums: IntArray, k: Int): Int {
    val n = nums.size
    fun isPossible(cap: Int): Boolean {
        var count = 0
        var i = 0
        while (i < n) {
            if (nums[i] <= cap) {
                count++
                i += 2
            } else {
                i++
            }
        }
        return count >= k
    }

    var left = nums.minOrNull() ?: 0
    var right = nums.maxOrNull() ?: 0
    var ans = right

    while (left <= right) {
        val mid = left + (right - left) / 2
        if (isPossible(mid)) {
            ans = mid
            right = mid - 1
        } else {
            left = mid + 1
        }
    }

    return ans
}
