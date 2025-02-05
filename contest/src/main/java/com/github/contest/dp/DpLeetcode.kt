package com.github.contest.dp

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