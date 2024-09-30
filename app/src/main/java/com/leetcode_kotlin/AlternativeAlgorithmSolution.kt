package com.leetcode_kotlin

import kotlin.math.max


/**
 * 53. Maximum Subarray
 * Algorithm Kadane, Time - O(n), Space - O(1)
 */

fun maxSubArrayAlternative(nums: IntArray): Int {
    var res = nums[0]
    var curr = 0
    for (i in nums) {
        curr = max(i, curr + i)
        res = max(res, curr)
    }
    return res
}