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