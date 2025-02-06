package com.github.contest.dp


/**
 * 70. Climbing Stairs
 * Prod Variant
 */

fun climbStairsProdVariant(n: Int): Int =
    (n <= 2).takeIf { it }?.let { n } ?: (3..n).fold(1 to 2) { (prev1, prev2), _ ->
        prev2 to prev1 + prev2
    }.second

private fun prodVariant(n: Int): Int = when {
    n <= 2 -> n
    else -> (3..n).fold(1 to 2) { (prev1, prev2), _ ->
        prev2 to prev1 + prev2
    }.second
}

/**
 * 516. Longest Palindromic Subsequence
 * Prod Variant
 */


fun longestPalindromicSubSequence(s: String): Int {
    if (s.hasSingle()) return 1

    val n = s.length
    val dp = Array(n) { IntArray(n) }
    s.forEachIndexed { index: Int, _ ->
        dp[index][index] = 1
    }

    (2..n).forEach { len ->
        (0..n - len).forEach { i ->
            val j = i + len - 1
            dp[i][j] = when {
                s[i] == s[j] -> dp[i + 1][j - 1] + 2
                else -> maxOf(dp[i][j - 1], dp[i + 1][j])
            }
        }
    }

    return dp[0][n - 1]
}

private fun String.hasSingle(): Boolean = when {
    this.length == 1 -> true
    else -> false
}