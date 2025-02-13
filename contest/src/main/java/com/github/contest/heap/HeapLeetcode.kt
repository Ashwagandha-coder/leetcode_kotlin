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