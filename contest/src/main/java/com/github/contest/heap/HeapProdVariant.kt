package com.github.contest.heap

import java.util.PriorityQueue

/**
 * 3066. Minimum Operations to Exceed Threshold Value II
 * Prod Variant
 */

fun minOperationProdVariant(nums: IntArray, k: Int): Int {
    var operation = 0
    val pq = PriorityQueue<Long>().apply { nums.forEach { offer(it.toLong()) } }

    while (pq.size > 1 && pq.peek() < k) {
        val (x, y) = listOf(pq.poll(), pq.poll()).sorted()
        pq.offer(x * 2 + y)
        operation++
    }

    return operation
}



