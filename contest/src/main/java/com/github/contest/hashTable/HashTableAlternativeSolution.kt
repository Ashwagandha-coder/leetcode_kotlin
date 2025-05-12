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

        val num = nums[right]
        val currentFreq = freq.getOrDefault(num, 0)

        totalPairs += currentFreq
        freq[num] = currentFreq + 1


        while (totalPairs >= k) {
            val leftNum = nums[left]

            totalPairs -= freq[leftNum]!! - 1
            freq[leftNum] = freq[leftNum]!! - 1
            if (freq[leftNum] == 0) {
                freq.remove(leftNum)
            }
            left++
        }


        count += left
    }

    return count
}

/**
 * 2094. Finding 3-Digit Even Numbers
 */

fun findEvenNumbersAlternativeSolution(digits: IntArray): IntArray {
    val freq = IntArray(10)
    digits.forEach { freq[it]++ }

    val result = mutableListOf<Int>()

    for (h in 1..9) {
        if (freq[h] == 0) continue

        for (t in 0..9) {
            if (freq[t] == 0 || (t == h && freq[t] < 2)) continue

            for (u in 0..8 step 2) {
                if (freq[u] == 0) continue
                if (u == h && u == t && freq[u] < 3) continue
                if (u == h && freq[u] < 2) continue
                if (u == t && freq[u] < 2) continue

                result.add(h * 100 + t * 10 + u)
            }
        }
    }

    return result.sorted().toIntArray()
}