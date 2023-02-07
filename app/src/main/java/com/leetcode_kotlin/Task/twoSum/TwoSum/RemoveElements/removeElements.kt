package com.leetcode_kotlin.Task.twoSum.TwoSum.RemoveElements



fun removeElements(nums: IntArray, value: Int): Int {

    var temp = 0
    var count = 0
    val range = nums.indices

    for (i in range) {
        if (nums[i] != value) {
            temp = nums[i]
            nums[count] = nums[i]
            nums[i] = temp
            count++
        }

    }
    return count

}

fun main() {

    val massive = intArrayOf(3,2,2,3)
    val elem = 2

    val result = removeElements(massive,elem)

    println(result)


}