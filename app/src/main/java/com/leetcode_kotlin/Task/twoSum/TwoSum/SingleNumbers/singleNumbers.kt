package com.leetcode_kotlin.Task.twoSum.TwoSum.SingleNumbers

// XOR

fun singleNumbers(nums: IntArray): Int {

    var result = 0

    for (num in nums) {
        result = result xor num

    }

    return result
}

