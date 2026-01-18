package com.github.contest.math

import java.util.LinkedList

/**
 * 171. Excel Sheet Column Number
 * Recursion Approach
 */

fun titleToNumberAltSol(columnTitle: String, base: Int = columnTitle.length - 1): Int = when {
    columnTitle.length == 1 -> columnTitle.first() - 'A' + 1
    else -> {
        val value = columnTitle.first() - 'A' + 1
        var pow = 1
        repeat(base) { pow *= 26 }
        (value * pow) + titleToNumberAltSol(columnTitle.substring(1, columnTitle.length), base - 1)
    }
}

/**
 * 279. Perfect Squares
 * Alternative Solution
 * BFS Approach
 * O(n * sqrt(n)) - Time
 * (n) - Space
 */


fun numSquaresAlternativeSolution(n: Int): Int {
    val squares = generateSquares(n)
    val queue = LinkedList<Int>().apply {
        offer(n)
    }
    var level = 0

    while (queue.isNotEmpty()) {
        val size = queue.size
        level++

        for (i in 0 until size) {
            val curr = queue.poll()

            for (square in squares) {
                if (square == curr) return level
                val next = curr - square
                if (next < 0) break
                queue.offer(next)
            }
        }
    }

    return -1
}

private fun generateSquares(n: Int): List<Int> = buildList {
    var square = 1
    while (square * square <= n) {
        add(square * square)
        square++
    }
}

/**
 * 507. Perfect Number
 * Recursive Solution
 */

fun checkPerfectNumber(num: Int, sum: Int = 1, index: Int = 2): Boolean = when {
    num == 1 -> false
    index * index <= num -> {
        var newSum = sum
        if (num % index == 0) {
            newSum += index
            if (index != (num / index)) newSum += (num / index)
        }
        checkPerfectNumber(num, newSum, index + 1)
    }

    else -> sum == num
}
