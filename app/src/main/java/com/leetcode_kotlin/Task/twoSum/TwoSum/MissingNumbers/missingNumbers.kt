package com.leetcode_kotlin.Task.twoSum.TwoSum.MissingNumbers

fun missingNumbers(nums: IntArray): Int {

    val length = nums.size
    var sum = 0

    for (i in nums)
        sum += i

    return length * (length + 1) / 2 - sum

}