package com.leetcode_kotlin.Task.twoSum.TwoSum.FindDisapearedNumbers

fun findDisappearedNumbers(nums: IntArray): List<Int> {

    val result = mutableListOf<Int>()
    val nums = nums.sorted().toMutableList()
    println(nums)
    val range = nums.indices
    var count = 1

    for (i in range) {

        if (nums[i] == nums[count])
            nums[count] = nums[count] + 1
        if (nums[i] > nums[count]) {
            nums[count] = nums[count] + 2
            result.add(nums[count] + 2)
        }
        if (count == nums.size - 1)
            return result

        count++
    }

    return result


// Unfinished


}
