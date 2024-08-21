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


