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

/**
 * 2843. Count Symmetric Integers
 */

fun countSymmetricIntegers(low: Int, high: Int): Int {
    var count = 0

    for (num in low..high) {
        val digits = num.toString().length
        when (digits) {
            2 -> {
                val first = num / 10
                val second = num % 10
                if (first == second) count++
            }

            4 -> {
                val onePart = num / 100
                val twoPart = num % 100
                val first = onePart / 10 + onePart % 10
                val second = twoPart / 10 + twoPart % 10
                if (first == second) count++
            }

            else -> continue
        }
    }

    return count
}

/**
 * 1399. Count Largest Group
 */

fun countLargestGroup(n: Int): Int {
    val freq = IntArray(40)
    var maxCount = 0

    for (i in 1..n) {
        var sum = 0
        var x = i
        while (x > 0) {
            sum += x % 10
            x /= 10
        }
        freq[sum]++
        maxCount = maxOf(maxCount, freq[sum])
    }

    var groupCount = 0
    for (count in freq) if (count == maxCount) groupCount++

    return groupCount
}

/**
 *
 */

fun numberOfPowerfulInt(start: Long, finish: Long, limit: Int, s: String): Long {
    var num = s.toLong()
    var counter = 0L
    var powerful = num
    var factor = 10

    if (num > finish || "$limit$num".toLong() < start) return 0L
    if (start == finish || num == finish) return 1L

    while (num < finish) {
        var count = limit
        powerful = "$count$powerful".toLong()
        while (powerful > finish && count != 0) {
            count--
            powerful = "$count$num".toLong()
        }
        if (count == 0) {

        }
        if (counter == 0L) counter += count
        else {
            val temp = count * factor
            counter += temp
            factor *= 10
        }
        num = powerful
    }

    return if (s.toLong() in start..finish) counter + 1L else counter
}

/**
 * 1295. Find Numbers with Even Number of Digits
 */

val POW = intArrayOf(100_000, 10_000, 1_000, 100, 10, 1)

fun findNumbers(nums: IntArray): Int = nums.filter {
    isEven(it)
}.count()

private fun isEven(num: Int): Boolean {
    var even = true

    for (p in POW) {
        if (num >= p) break
        even = !even
    }

    return even
}

/**
 * 3024. Type of Triangle
 */

fun triangleType(nums: IntArray): String {
    nums.sort()
    val first = nums.first()
    val mid = nums[nums.size / 2]
    val last = nums.last()

    return when {
        first + mid <= last -> "none"
        first == mid && mid == last -> "equilateral"
        first == mid || mid == last -> "isosceles"
        else -> "scalene"
    }
}

