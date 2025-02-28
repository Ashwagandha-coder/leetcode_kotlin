package com.github.contest.heap

import java.util.PriorityQueue

/**
 * 3066. Minimum Operations to Exceed Threshold Value II
 * Alternative Solution
 */


fun minOperationsAlternativeSolution(nums: IntArray, k: Int): Int {
    var operations = 0
    val pq = PriorityQueue<Long>()
    pq.addNums(nums)

    while (pq.size > 1 && pq.peek() < k) {
        val x = pq.poll()
        val y = pq.poll()
        val new = minOf(x, y) * 2 + maxOf(x, y)
        pq.offer(new)
        operations++
    }

    return operations
}

private fun PriorityQueue<Long>.addNums(nums: IntArray) {
    val list = mutableListOf<Long>()
    nums.forEach { list.add(it.toLong()) }
    this.addAll(list)
}

/**
 * 2500. Delete Greatest Value in Each Row
 * Alternative Solution
 */


fun deleteGreatestValueAltSolution(grid: Array<IntArray>): Int {
    val pqRows = Array(grid.size) { PriorityQueue<Int>(reverseOrder()) }

    for (i in 0 until grid.size) {
        for (num in grid[i]) {
            pqRows[i].offer(num)
        }
    }

    var sum = 0

    while (pqRows[0].isNotEmpty()) {
        var maxVal = 0
        for (pq in pqRows) {
            maxVal = maxOf(maxVal, pq.poll())
        }
        sum += maxVal
    }

    return sum
}

/**
 * 1424. Diagonal Traverse II
 * Alternative Solution
 */


fun findDiagonalOrderAlternativeSolution(nums: List<List<Int>>): IntArray {
    if (nums.hasSingle()) nums[0].toIntArray()
    val map = mutableMapOf<Int, MutableList<Int>>()
    for (i in nums.indices) {
        for (j in 0 until nums[i].size) {
            map.getOrPut(i + j) { mutableListOf() }.let { it.add(nums[i][j]) }
        }
    }
    var diagonal = 0
    val result = mutableListOf<Int>()
    while (map.contains(diagonal)) {
        val values = map.getOrDefault(diagonal, mutableListOf())
        for (i in values.size - 1 downTo 0) result.add(values[i])
        diagonal++
    }

    return result.toIntArray()
}

private fun <T> List<T>.hasSingle(): Boolean = when {
    this.size == 1 -> true
    else -> false
}

/**
 * 2231. Largest Number After Digit Swaps by Parity
 * Alternative Solution
 */


fun largestIntegerAltSolution(num: Int): Int {
    if (num <= 99) return num
    val odd = PriorityQueue<Int>(reverseOrder())
    val even = PriorityQueue<Int>(reverseOrder())
    val str = num.toString()
    val len = str.length

    for (i in 0 until len) {
        if (str[i].digitToInt() % 2 == 0) {
            even.offer(str[i].digitToInt())
        } else odd.offer(str[i].digitToInt())
    }

    var res = 0
    for (i in 0 until len) {
        if (str[i].digitToInt() % 2 == 0) {
            val value = even.poll()
            if (value != 0) res += value

        } else {
            val value = odd.poll()
            if (value != 0) res += value

        }
        if (even.isNotEmpty() || odd.isNotEmpty()) res *= 10
    }

    return res
}