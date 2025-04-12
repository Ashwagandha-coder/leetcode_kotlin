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