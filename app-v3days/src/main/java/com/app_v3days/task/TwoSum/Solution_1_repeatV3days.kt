package com.app_v3days.task

fun main() {

    twoSumRepeatV3days(intArrayOf(2,7,11,15),9).forEach { println(it) }

}



fun twoSumRepeatV3days(nums: IntArray, target: Int): IntArray {

    var result = intArrayOf(0)

    val size = nums.size

    if (nums.size == 2 && nums[0] + nums[1] == target)
        result = intArrayOf(0,1)

    else {

        for (i in 0..size - 2) {
            for (j in i + 1..size - 1) {
                if (nums[i] + nums[j] == target) {
                    result = intArrayOf(i,j)
                }
            }
        }


    }

    return result



}