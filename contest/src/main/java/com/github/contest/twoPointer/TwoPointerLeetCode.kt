package com.github.contest.twoPointer

/**
 * 165. Compare Version Numbers
 */

fun compareVersion(version1: String, version2: String): Int {
    val firstNumber = version1.split(".").map { it.toInt() }
    val secondNumber = version2.split(".").map { it.toInt() }

    for (i in 0 until maxOf(firstNumber.size, secondNumber.size)) {
        val p1 = if (i < firstNumber.size) firstNumber[i] else 0
        val p2 = if (i < secondNumber.size) secondNumber[i] else 0

        when {
            p1 != p2 -> {
                return if (p1 > p2) 1 else -1
            }
        }
    }
    return 0
}

/**
 * 42. Trapping Rain Water
 */


fun trap(height: IntArray): Int {
    if (height.isEmpty()) return 0

    var left = 0
    var right = height.size - 1
    var leftMax = height[left]
    var rightMax = height[right]
    var water = 0

    while (left < right) {
        if (leftMax < rightMax) {
            left++
            leftMax = maxOf(leftMax, height[left])
            water += leftMax - height[left]
        } else {
            right--
            rightMax = maxOf(rightMax, height[right])
            water += rightMax - height[right]
        }
    }

    return water
}

/**
 * 2200. Find All K-Distant Indices in an Array
 */

fun findKDistantIndices(nums: IntArray, key: Int, k: Int): List<Int> {
    val result = mutableSetOf<Int>()
    for (j in nums.indices) {
        if (nums[j] == key) {
            val start = maxOf(0, j - k)
            val end = minOf(nums.size - 1, j + k)
            for (i in start..end) {
                result.add(i)
            }
        }
    }
    return result.sorted()
}