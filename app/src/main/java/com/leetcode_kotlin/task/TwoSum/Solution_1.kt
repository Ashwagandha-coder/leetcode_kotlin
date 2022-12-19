package com.leetcode_kotlin.task

fun main() {


    twoSum(intArrayOf(3,2,3),6).forEach { print("$it ") }


}


fun twoSum(nums: IntArray, target: Int): IntArray {

    var result = intArrayOf(0)

    if (nums.size == 2 && nums[0] + nums[1] == target)
        result = intArrayOf(0,1)
    else {

        for (i in 0 .. nums.size - 2)
            for (j in i + 1 .. nums.size - 1) {
                if (nums[i] + nums[j] == target)
                    result = intArrayOf(i,j)
            }


    }

    return result


}

