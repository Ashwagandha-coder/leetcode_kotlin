package com.github.contest.array

/**
 * 2540. Minimum Common Value
 * Alternative Solution
 * Time - O(n)
 * Space - O(1)
 */

fun getCommonAlternativeSolution(nums1: IntArray, nums2: IntArray): Int {
    var p1 = 0
    var p2 = 0

    while (p1 < nums1.size && p2 < nums2.size) {
        when {
            nums1[p1] == nums2[p2] -> return nums1[p1]
            nums1[p1] < nums2[p2] -> p1++
            else -> p2++
        }
    }

    return -1
}

/**
 * 922. Sort Array By Parity II
 * Alternative Solution
 */

fun sortArrayByParityIIAlternativeSolution(nums: IntArray): IntArray {
    var evenIndex = 0
    var oddIndex = 1
    while (evenIndex < nums.size && oddIndex < nums.size) {
        while (evenIndex < nums.size && nums[evenIndex] % 2 == 0) evenIndex += 2
        while (oddIndex < nums.size && nums[oddIndex] % 2 != 0) oddIndex += 2
        if (evenIndex < nums.size && oddIndex < nums.size) {
            nums[evenIndex] = nums[oddIndex].also { nums[oddIndex] = nums[evenIndex] }
        }
    }

    return nums
}

/**
 * 2460. Apply Operations to an Array
 * Alternative Solution
 */

fun applyOperationsAlternativeSolution(nums: IntArray): IntArray {
    for (i in 0 until nums.size - 1) {
        if (nums[i] == nums[i + 1]) {
            nums[i] *= 2
            nums[i + 1] = 0
        }
    }

    var insertPosition = 0
    for (i in nums.indices) {
        if (nums[i] != 0) {
            nums[insertPosition] = nums[i]
            insertPosition++
        }
    }

    while (insertPosition < nums.size) {
        nums[insertPosition] = 0
        insertPosition++
    }

    return nums

}