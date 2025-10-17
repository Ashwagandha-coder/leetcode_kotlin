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


/**
 * 3350. Adjacent Increasing Subarrays Detection II
 */

fun maxIncreasingSubarrays(nums: List<Int>): Int {

    var left = 1
    var right = nums.size / 2
    var ans = 1

    while (left <= right) {
        val k = (left + right) shr 1

        if (canFindAdjacentSubArray(nums, k)) {
            ans = k
            left = k + 1
        } else right = k - 1
    }

    return ans
}

private fun canFindAdjacentSubArray(nums: List<Int>, k: Int): Boolean {
    val n = nums.size
    val incLen = IntArray(n).apply {
        this[0] = 1
    }

    for (i in 1 until n) {
        incLen[i] = when {
            nums[i - 1] < nums[i] -> incLen[i - 1] + 1
            else -> 1
        }
    }

    for (i in 0 until n - (k * 2) + 1) {
        val endIndexFirst = i + k - 1
        val endIndexSecond = i + (k * 2) - 1

        if (incLen[endIndexFirst] >= k && incLen[endIndexSecond] >= k) return true
    }

    return false
}