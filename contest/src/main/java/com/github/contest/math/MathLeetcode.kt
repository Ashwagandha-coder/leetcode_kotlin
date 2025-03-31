package com.github.contest.math


import kotlin.math.abs
import kotlin.math.sqrt

/**
 * 1025. Divisor Game
 */

fun divisorGame(n: Int): Boolean = n % 2 == 0

/**
 * 1780. Check if Number is a Sum of Powers of Three
 */

fun checkPowersOfThree(n: Int): Boolean {
    var num = n
    while (num > 0) {
        if (num % 3 == 2) {
            return false
        }
        num /= 3
    }
    return true
}

/**
 * 2579. Count Total Number of Colored Cells
 */


fun coloredCells(n: Int): Long = when {
    n == 1 -> 1L
    else -> coloredCells(n - 1) + 4L * (n - 1).toLong()
}

/**
 * 2523. Closest Prime Numbers in Range
 */


fun closestPrimes(left: Int, right: Int): IntArray {
    val primes = mutableListOf<Int>()
    val isPrime = BooleanArray(right + 1) { true }
    isPrime[0] = false
    isPrime[1] = false

    for (p in 2..sqrt(right.toDouble()).toInt()) {
        if (isPrime[p]) {
            for (i in p * p..right step p) {
                isPrime[i] = false
            }
        }
    }

    for (p in left..right) {
        if (isPrime[p]) {
            primes.add(p)
        }
    }

    if (primes.size < 2) return intArrayOf(-1, -1)

    var minDiff = Int.MAX_VALUE
    var result = intArrayOf(-1, -1)
    for (i in 0 until primes.size - 1) {
        val diff = primes[i + 1] - primes[i]
        if (diff < minDiff) {
            minDiff = diff
            result[0] = primes[i]
            result[1] = primes[i + 1]
        }
    }

    return result
}

/**
 * 2033. Minimum Operations to Make a Uni-Value Grid
 */

fun minOperations(grid: Array<IntArray>, x: Int): Int {
    val nums = mutableListOf<Int>()
    for (row in grid) {
        for (num in row) {
            nums.add(num)
        }
    }
    nums.sort()
    val n = nums.size
    val median = nums[n / 2]
    var ans = 0
    for (num in nums) {
        val diff = abs(num - median)
        if (diff % x != 0) {
            return -1
        }
        ans += diff / x
    }
    return ans
}
