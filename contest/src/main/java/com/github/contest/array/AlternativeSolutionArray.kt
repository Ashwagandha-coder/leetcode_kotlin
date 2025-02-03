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