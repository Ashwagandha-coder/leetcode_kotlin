package com.github.contest.heap

import java.util.PriorityQueue

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