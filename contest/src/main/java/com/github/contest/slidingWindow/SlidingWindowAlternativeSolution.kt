package com.github.contest.slidingWindow


/**
 * 76. Minimum Window Substring
 * Optimum Solution O(n + m)
 */

fun minWindowOptimumSolution(s: String, t: String): String {
    if (s.isEmpty() || t.isEmpty()) return ""

    val targetMap = mutableMapOf<Char, Int>()
    for (char in t) {
        targetMap[char] = targetMap.getOrDefault(char, 0) + 1
    }

    var left = 0
    var right = 0
    var minLength = Int.MAX_VALUE
    var minStart = 0
    val required = targetMap.size
    var formed = 0
    val windowCounts = mutableMapOf<Char, Int>()


    while (right < s.length) {
        val char = s[right]
        windowCounts[char] = windowCounts.getOrDefault(char, 0) + 1

        if (targetMap.containsKey(char) && windowCounts[char] == targetMap[char]) {
            formed++
        }

        while (left <= right && formed == required) {
            if (right - left + 1 < minLength) {
                minLength = right - left + 1
                minStart = left
            }

            val leftChar = s[left]
            windowCounts[leftChar] = windowCounts.getOrDefault(leftChar, 0) - 1
            if (targetMap.containsKey(leftChar) && windowCounts[leftChar]!! < targetMap[leftChar]!!) {
                formed--
            }
            left++
        }

        right++
    }

    return if (minLength == Int.MAX_VALUE) "" else s.substring(minStart, minStart + minLength)
}

/**
 * 2760. Longest Even Odd Subarray With Threshold
 * Alternative Solution with O(n) Time Complexity
 */

fun longestAlternatingSubArrayAlternativeSolution(nums: IntArray, threshold: Int): Int {
    var maxLength = 0
    var currentLength = 0

    for (i in nums.indices) {

        if (nums[i] <= threshold &&
            (currentLength == 0 && isEven(nums[i]) || currentLength > 0 && nums[i] % 2 != nums[i - 1] % 2)
        ) {
            currentLength++
            maxLength = maxOf(maxLength, currentLength)
        } else currentLength = if (nums[i] % 2 == 0 && nums[i] <= threshold) 1 else 0

    }

    return maxLength
}

private fun isEven(number: Int) = when {
    number % 2 == 0 -> true
    else -> false
}

/**
 * 2653. Sliding Subarray Beauty
 * Alternative Solution (TLE) must be classic sliding window
 */

fun getSubArrayBeautyAlternativeSolution(nums: IntArray, k: Int, x: Int): IntArray {
    var numbers = IntArray(101)
    val res = mutableListOf<Int>()

    nums.toList().windowed(k) {
        it.forEach { elem ->
            val value = elem + 50
            numbers[value]++
        }
        var cnt = 0

        for (i in numbers.indices) {
            if (numbers[i] > 0) cnt += numbers[i]
            if (cnt >= x) {
                if (i >= 50) res.add(0) else res.add(-(50 - i))
                break
            }
        }

        numbers = IntArray(101)
    }

    return res.toIntArray()
}


