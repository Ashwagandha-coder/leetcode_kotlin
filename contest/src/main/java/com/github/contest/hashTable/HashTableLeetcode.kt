package com.github.contest.hashTable

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

/**
 * 1002. Find Common Characters
 */


fun commonChars(words: Array<String>): List<String> {
    val minFreq = IntArray(26) { Int.MAX_VALUE }

    for (word in words) {
        val charFreq = IntArray(26)
        for (c in word) {
            charFreq[c - 'a']++
        }

        for (i in 0 until 26) {
            minFreq[i] = minOf(minFreq[i], charFreq[i])
        }
    }

    val result = mutableListOf<String>()
    for (i in 0 until 26) {
        repeat(minFreq[i]) {
            result.add((i + 'a'.code).toChar().toString())
        }
    }

    return result
}

/**
 * 1790. Check if One String Swap Can Make Strings Equal
 */

fun areAlmostEqual(s1: String, s2: String): Boolean {
    if (s1 == s2) return true

    for (i in s1.indices) {
        for (j in i + 1 until s1.length) {
            var temp = s2.swap(i, j)
            if (temp == s1) return true
        }
    }

    for (i in s2.indices) {
        for (j in i + 1 until s2.length) {
            var temp = s2.swap(i, j)
            if (temp == s1) return true
        }
    }

    return false
}

private fun String.swap(from: Int, to: Int): String {
    var arr = this.toCharArray()
    var temp = arr[from]
    arr[from] = arr[to]
    arr[to] = temp
    return String(arr)
}