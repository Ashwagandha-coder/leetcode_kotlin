package com.github.contest.dp

import com.github.contest.abs


/**
 * 1137. N-th Tribonacci Number
 */

fun tribonacci(n: Int): Int {
    if (n == 0 || n == 1) return n
    if (n == 2) return 1
    val dp = IntArray(n + 1)
    dp[0] = 0
    dp[1] = 1
    dp[2] = 1
    for (i in 3..n) {
        dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1]
    }
    return dp[n]
}

/**
 * 1668. Maximum Repeating Substring
 */

fun maxRepeating(sequence: String, word: String): Int {
    var ans = 1
    while (sequence.contains(word.repeat(ans))) ans++
    return ans - 1
}


/**
 * 118. Pascal's Triangle
 */

fun generate(numRows: Int): List<List<Int>> {
    if (numRows == 1) return listOf(listOf(1))
    if (numRows == 2) return listOf(listOf(1), listOf(1, 1))
    val dp = fill(numRows)
    var cells = 1
    for (i in 2 until numRows) {
        var prev = 0
        var curr = 1
        repeat(cells) {
            dp[i][it + 1] = dp[i - 1][prev] + dp[i - 1][curr]
            prev++
            curr++
        }
        cells++
    }
    return dp
}


private fun fill(rows: Int): List<MutableList<Int>> {
    val res = mutableListOf<MutableList<Int>>()
    for (i in 0 until rows) {
        val new = mutableListOf<Int>()
        repeat(i + 1) {
            new.add(1)
        }
        res.add(new)
    }
    return res
}

/**
 * 119. Pascal's Triangle II
 */

fun getRow(rowIndex: Int): List<Int> {
    if (rowIndex == 0) return listOf(1)
    if (rowIndex == 1) return listOf(1, 1)
    var row = 1
    var prev = mutableListOf(1, 1)
    var curr = mutableListOf<Int>()
    for (i in 2 until rowIndex + 1) {
        curr = mutableListOf()
        repeat(i + 1) {
            curr.add(1)
        }
        repeat(row) {
            curr[it + 1] = prev[it] + prev[it + 1]
        }
        prev = curr
        row++
    }
    return curr
}

/**
 * 70. Climbing Stairs
 */

fun climbStairs(n: Int): Int {
    if (n <= 2) return n
    val dp = IntArray(n)
    dp[0] = 1
    dp[1] = 2
    for (i in 2 until n) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }
    return dp[n - 1]
}

/**
 * 516. Longest Palindromic Subsequence
 */


fun longestPalindromeSubseq(s: String): Int {
    if (s.hasSingle()) return 1
    val n = s.length
    val dp = Array(n) { IntArray(n) }

    for (i in s.indices) dp[i][i] = 1

    for (len in 2..n) {
        for (i in 0..n - len) {
            var j = (len - 1) + i
            if (s[i] == s[j]) dp[i][j] = dp[i + 1][j - 1] + 2
            else dp[i][j] = maxOf(dp[i][j - 1], dp[i + 1][j])
        }
    }
    return dp[0][n - 1]
}

private fun String.hasSingle(): Boolean = when {
    this.length == 1 -> true
    else -> false
}

/**
 * 647. Palindromic Substrings
 */


fun countSubstrings(s: String): Int {
    if (s.hasSingle()) return 1
    val n = s.length
    var counter = s.length
    val dp = Array(n) { BooleanArray(n) }
    for (i in 0 until n) dp[i][i] = true

    for (len in 2..n) {
        for (i in 0..n - len) {
            val j = i + len - 1
            when {
                len == 2 -> {
                    if (s[i] == s[j]) {
                        counter++
                        dp[i][j] = true
                    }
                }

                else -> {
                    if (s[i] == s[j] && dp[i + 1][j - 1]) {
                        counter++
                        dp[i][j] = true
                    }
                }
            }
        }
    }

    return counter
}

/**
 * 2370. Longest Ideal Subsequence
 */

fun longestIdealString(s: String, k: Int): Int {
    val dp = IntArray(26) { 0 }

    for (c in s) {
        val currIndex = c - 'a'
        var maxLength = 0
        for (prevIndex in 0..25) {
            if (abs(currIndex - prevIndex) <= k) {
                maxLength = maxOf(maxLength, dp[prevIndex])
            }
        }
        dp[currIndex] = maxOf(dp[currIndex], maxLength + 1)
    }

    return dp.maxOrNull() ?: 0
}

/**
 * 1025. Divisor Game
 * Dp Approach
 */

fun divisorGameDp(n: Int): Boolean {
    if (n <= 1) return false
    val dp = BooleanArray(n + 1)
    dp[1] = false

    for (i in 2..n) {
        for (x in 1 until i) {
            if (i % x == 0 && !dp[i - x]) {
                dp[i] = true
                break
            }
        }
    }

    return dp[n]
}

/**
 * 2900. Longest Unequal Adjacent Groups Subsequence I
 */

fun getLongestSubsequence(words: Array<String>, groups: IntArray): List<String> {
    val dp = BooleanArray(words.size) { false }
    dp[0] = true
    var j = 0
    for (i in 1 until groups.size) {
        if (groups[i] != groups[j]) {
            dp[i] = true
            j = i
        }
    }
    var res = mutableListOf<String>()
    for (i in words.indices) {
        if (dp[i]) res.add(words[i])
    }

    return res
}