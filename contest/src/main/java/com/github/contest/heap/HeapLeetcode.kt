package com.github.contest.heap

import com.github.contest.abs
import java.util.PriorityQueue
import kotlin.math.floor
import kotlin.math.sqrt

/**
 * 3066. Minimum Operations to Exceed Threshold Value II
 */

fun minOperations(nums: IntArray, k: Int): Int {
    var operation = 0
    val pq = PriorityQueue<Long>()
    for (num in nums) pq.offer(num.toLong())

    while (pq.size > 1 && pq.peek() < k) {
        val x = pq.poll()
        val y = pq.poll()
        val new = minOf(x, y) * 2 + maxOf(x, y)
        pq.offer(new)
        operation++
    }

    return operation
}

/**
 * 2208. Minimum Operations to Halve Array Sum
 */

fun halveArray(nums: IntArray): Int {
    val pq = PriorityQueue<Double>(reverseOrder())
    var sum = 0.0
    for (num in nums) {
        pq.offer(num.toDouble())
        sum += num
    }

    var operations = 0
    var halvedSum = 0.0
    while (halvedSum < (sum / 2)) {
        val largest = pq.poll()
        val halved = largest / 2
        halvedSum += halved
        pq.offer(halved)
        operations++
    }

    return operations
}


/**
 * 2500. Delete Greatest Value in Each Row
 */


fun deleteGreatestValue(grid: Array<IntArray>): Int {
    for (row in grid) row.sort()

    var sum = 0

    for (j in 0 until grid[0].size) {
        var maxVal = 0
        for (i in 0 until grid.size) {
            maxVal = maxOf(maxVal, grid[i][j])
        }

        sum += maxVal
    }

    return sum
}

/**
 * 3318. Find X-Sum of All K-Long Subarrays I
 */


fun findXSum(nums: IntArray, k: Int, x: Int): IntArray {
    if (nums.hasSingle()) return intArrayOf(nums[0])
    val n = nums.size
    val res = IntArray(n - k + 1)

    for (i in 0 until res.size) {
        res[i] = nums.calculateXSum(i, k + i - 1, k, x)
    }

    return res
}

private fun IntArray.hasSingle(): Boolean = when {
    this.size == 1 -> true
    else -> false
}


private fun IntArray.calculateXSum(startIndex: Int, endIndex: Int, k: Int, x: Int): Int {
    when {
        startIndex > endIndex -> throw IndexOutOfBoundsException("$startIndex")
        endIndex > this.size -> throw IndexOutOfBoundsException("$endIndex")
    }
    val counts = mutableMapOf<Int, Int>()
    for (i in startIndex..endIndex) counts[this[i]] = counts.getOrDefault(this[i], 0) + 1

    val pq = PriorityQueue<Pair<Int, Int>> { a: Pair<Int, Int>, b: Pair<Int, Int> ->
        if (a.second != b.second) b.second - a.second
        else b.first - a.first
    }

    for ((num, count) in counts) pq.offer(Pair(num, count))

    var x = x
    var sum = 0
    while (pq.isNotEmpty() && x != 0) {
        val (num, count) = pq.poll()
        sum += (num * count)
        x--
    }

    return sum
}

/**
 * 1046. Last Stone Weight
 */


fun lastStoneWeight(stones: IntArray): Int {
    if (stones.size == 1) return stones[0]
    val pq = PriorityQueue<Int>(reverseOrder())
    pq.addAllOfIntArray(stones)

    while (pq.isNotEmpty() && pq.size != 1) {
        val x = pq.poll()
        val y = pq.poll()
        if (x != y) pq.offer(abs(x - y))
    }

    return if (pq.hasSingle()) pq.poll() else 0
}

private fun <T> PriorityQueue<T>.hasSingle(): Boolean = when {
    this.size == 1 -> true
    else -> false
}

private fun PriorityQueue<Int>.addAllOfIntArray(nums: IntArray) {
    nums.forEach { this.offer(it) }
}

/**
 * 2558. Take Gifts From the Richest Pile
 */


fun pickGifts(gifts: IntArray, k: Int): Long {
    val pq = PriorityQueue<Long>(reverseOrder())

    for (gift in gifts) pq.offer(gift.toLong())

    repeat(k) {
        val num = pq.poll()
        val changed = sqrt(num.toDouble()).toLong()
        pq.offer(changed)
    }

    return pq.sum()

}

private fun PriorityQueue<Long>.sum(): Long {
    var sum = 0L
    while (this.isNotEmpty()) sum += this.poll()
    return sum
}


/**
 * 1962. Remove Stones to Minimize the Total
 */

fun minStoneSum(piles: IntArray, k: Int): Int {
    val pq = PriorityQueue<Int>(reverseOrder())
    pq.addAll(piles.toList())
    repeat(k) {
        val num = pq.poll()
        val changed = num - floor(num / 2.0).toInt()
        pq.offer(changed)
    }

    return pq.sum()
}

private fun PriorityQueue<Int>.sum(): Int {
    var sum = 0
    while (this.isNotEmpty()) sum += this.poll()
    return sum
}

/**
 * 2974. Minimum Number Game
 */

fun numberGame(nums: IntArray): IntArray {
    val heap = PriorityQueue<Int> { a, b -> a - b }
    for (num in nums) heap.offer(num)
    var i = 0
    while (heap.isNotEmpty()) {
        val a = heap.poll()
        val b = heap.poll()
        nums[i] = b
        nums[i + 1] = a
        i += 2
    }

    return nums
}
