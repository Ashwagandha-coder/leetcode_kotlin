package com.leetcode_kotlin.TwoSum



fun main() {

    make(intArrayOf(3,2,3),6)

}

fun make(nums: IntArray, target: Int): IntArray {

    var result = intArrayOf(0)

    for (i in 0 .. nums.size - 1)
        for (j in nums.size - 1 .. 0) {
            if ((i + j) == target)
                result = intArrayOf(i,j)
        }

    return result

}

// solution - ???