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