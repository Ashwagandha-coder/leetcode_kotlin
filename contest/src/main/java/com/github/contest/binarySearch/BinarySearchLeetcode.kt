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
 *
 */

fun twoSum(numbers: IntArray, target: Int): IntArray {
    var boundIndex = numbers.size - 1
    var nullIndex = 0
    for (i in numbers.indices) {
        if (numbers[i] > target) {
            boundIndex = i - 1
        }
        if (numbers[i] == 0) nullIndex = i
    }

    for (i in boundIndex downTo 0) {
        var left = 0
        var right = i
        val tar = target - numbers[i]
        if (tar == 0) return intArrayOf(i + 1, nullIndex + 1)
        while (left <= right) {
            var mid = (left + right) / 2
            if (numbers[mid] == tar) return intArrayOf(mid + 1, i + 1)
            if (numbers[mid] < tar) mid = left + 1
            else right = mid - 1
        }
    }

    return intArrayOf()
}
