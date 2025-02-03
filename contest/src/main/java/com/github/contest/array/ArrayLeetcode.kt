package com.github.contest.array

import com.github.contest.removeIfEmptyBucket

/**
 * 2540. Minimum Common Value
 */

fun getCommon(nums1: IntArray, nums2: IntArray): Int {
    var minCommonValue = Int.MAX_VALUE
    val set = mutableSetOf<Int>()
    for (num in nums1) set.add(num)
    var i = 0
    while (i < nums2.size && !set.contains(nums2[i])) {
        i++
    }
    if (i < nums2.size && set.contains(nums2[i])) minCommonValue = nums2[i]
    return if (minCommonValue == Int.MAX_VALUE) -1 else minCommonValue
}

/**
 * 350. Intersection of Two Arrays II
 */

fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val res = mutableListOf<Int>()
    val map = mutableMapOf<Int, Int>()
    for (num in nums1) map[num] = map.getOrDefault(num, 0) + 1
    for (num in nums2) {
        if (map.contains(num)) {
            res.add(num)
            map.removeIfEmptyBucket(num)
        }
    }
    return res.toIntArray()
}