package com.github.contest.hashTable

/**
 * 1790. Check if One String Swap Can Make Strings Equal
 * Alternative Solution
 */


fun areAlmostEqualAltSolution(s1: String, s2: String): Boolean {
    if (s1 == s2) return true

    val diff = mutableListOf<Int>()
    for (i in s1.indices) {
        if (s1[i] != s2[i]) diff.add(i)
    }

    return when {
        diff.size > 2 || diff.size == 1 -> false
        s1[diff[0]] == s2[diff[1]] && s2[diff[0]] == s1[diff[1]] -> true
        else -> false
    }
}

/**
 *
 */

fun countBadPairsAltSolution(nums: IntArray): Long {
    val allPairs = nums.size.toLong() * (nums.size - 1)
    val allOrderedPairs = allPairs / 2

    val map = HashMap<Int, Counter>()
    nums.forEachIndexed { i, value ->
        map.getOrPut(value - i) { Counter() }.count++
    }

    var goodOrderedPairs = 0L
    for (c in map.values) {
        val goodPairs = c.count.toLong() * (c.count - 1)
        goodOrderedPairs += goodPairs / 2
    }

    return allOrderedPairs - goodOrderedPairs
}

class Counter {
    var count: Int = 0
}

/**
 * 2537. Count the Number of Good Subarrays
 * Alternative Solution Optimal
 * Hash Map Approach
 */

fun countGoodAlternativeSolution(nums: IntArray, k: Int): Long {
    var left = 0
    var count = 0L
    var totalPairs = 0L
    val freq = mutableMapOf<Int, Int>()

    for (right in nums.indices) {
        // Update the frequency of the current element
        val num = nums[right]
        val currentFreq = freq.getOrDefault(num, 0)
        // Each existing occurrence creates new pairs
        totalPairs += currentFreq
        freq[num] = currentFreq + 1

        // While the window has enough pairs, try to shrink from the left
        while (totalPairs >= k) {
            val leftNum = nums[left]
            // Before removing, reduce the pairs count
            totalPairs -= freq[leftNum]!! - 1
            freq[leftNum] = freq[leftNum]!! - 1
            if (freq[leftNum] == 0) {
                freq.remove(leftNum)
            }
            left++
        }

        // All subarrays ending at right with start <= left-1 are good
        count += left
    }

    return count
}