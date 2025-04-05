package com.github.contest.dp

import com.github.contest.abs


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

/**
 * 2370. Longest Ideal Subsequence
 * Prod Variant
 */


fun longestIdealStringProdVariant(s: String, k: Int): Int {
    val dp = IntArray(26) { 0 }

    s.forEach {
        val index = it - 'a'
        var len = 0
        (0..25).forEach { prev ->
            if (abs(prev - index) <= k) len = maxOf(len, dp[prev])
        }
        dp[index] = maxOf(dp[index], len + 1)
    }

    return dp.max()
}


fun longestIdealStringProdVariantII(s: String, k: Int): Int =
    s.fold(IntArray(26)) { dp, c ->
        val currIndex = c - 'a'
        dp.apply {
            this[currIndex] = maxOf(this[currIndex], (0..25).maxOf { prevIndex ->
                if (abs(currIndex - prevIndex) <= k) this[prevIndex] else 0
            } + 1)
        }
    }.max()


/**
 * 1143. Longest Common Subsequence
 * Prod Variant
 */

fun longestCommonSubsequenceProdVariant(text1: String, text2: String): Int {
    val n = text1.length
    val m = text2.length
    val dp = Array(n + 1) { IntArray(m + 1) }

    (1..n).forEach { row ->
        (1..m).forEach { col ->
            dp[row][col] = when {
                text1[row - 1] == text2[col - 1] -> dp[row - 1][col - 1] + 1
                else -> maxOf(dp[row - 1][col], dp[row][col - 1])
            }
        }
    }

    return dp.lastElement()
}

private fun Array<IntArray>.lastElement(): Int = this.last().last()


/**
 * 1048. Longest String Chain
 * Prod Variant
 */

fun longestStrChainProdVariant(words: Array<String>): Int {
    val sortedWords = words.sortedBy { it.length }
    val dp = mutableMapOf<String, Int>()


    return sortedWords.maxOf { word ->
        var currentChain = word.indices.maxOf { index ->
            val predecessor = word.removeRange(index, index + 1)
            dp.getOrDefault(predecessor, 0) + 1
        }
        dp[word] = currentChain
        currentChain
    }
}

/**
 * 1027. Longest Arithmetic Subsequence
 * Prod Variant
 */

fun longestArithSeqLengthProdVariant(nums: IntArray): Int {
    val dp = Array(nums.size) { mutableMapOf<Int, Int>() }
    var longest = 0

    return (1 until nums.size).maxOf { i ->
        (0 until i).maxOf { j ->
            val diff = nums[i] - nums[j]
            val len = dp[j].getOrDefault(diff, 1) + 1
            dp[i][diff] = len
            len
        }
    }
}

/**
 * 2140. Solving Questions With Brainpower
 * Prod Variant
 */


fun mostPointsProdVariant(questions: Array<IntArray>): Long {
    val n = questions.size
    val dp = LongArray(n)
    questions.forEachReversedIndexed { index, arr ->
        val points = arr[0]
        val brainpower = arr[1]
        dp[index] = points + when {
            brainpower + index + 1 < n -> dp[brainpower + index + 1]
            else -> 0L
        }
        dp[index] = maxOf(dp[index], dp[index + 1])
    }

    return dp.first()
}

fun <T> Array<T>.forEachReversedIndexed(action: (Int, T) -> Unit) {
    for (i in indices) action(i, this[i])
}