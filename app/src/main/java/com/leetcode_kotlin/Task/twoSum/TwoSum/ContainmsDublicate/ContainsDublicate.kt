package com.leetcode_kotlin.Task.twoSum.TwoSum.ContainmsDublicate

fun containsDuplicate(nums: IntArray): Boolean {

    var set = mutableSetOf<Int>()

    for (i in nums)
        set.add(i)

    if (set.size == nums.size)
        return false
    else
        return true

}

fun sol2(nums: IntArray): Boolean {

    var set = mutableSetOf<Int>()

    for (num in nums) {
        if (set.contains(num)) {
            return true
        }
        set.add(num)

    }

    return false

}

