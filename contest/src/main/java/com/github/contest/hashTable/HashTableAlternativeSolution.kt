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