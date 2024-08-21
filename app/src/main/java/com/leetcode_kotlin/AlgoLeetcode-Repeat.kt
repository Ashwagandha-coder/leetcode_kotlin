package com.leetcode_kotlin

fun main() {
    println("Hello World")
}

class Repeat


fun Repeat.missingNumber(nums: IntArray): Int {
    var sum = 0
    var len = nums.size
    for (i in 0..len - 1) sum += nums[i]
    return len * (len + 1) / 2 - sum
}


fun Repeat.singleNumber(nums: IntArray): Int {
    var res = 0
    for (i in 0..nums.size - 1) {
        res = res xor nums[i]
    }
    return res
}


fun Repeat.findDisappearedNumbers(nums: IntArray): List<Int> {
    val len = nums.size
    val set = mutableSetOf<Int>()
    val list = mutableListOf<Int>()
    for (i in 0..len - 1) set.add(nums[i])
    for (i in 1..len) {
        if (!set.contains(i)) list.add(i)
    }
    return list
}