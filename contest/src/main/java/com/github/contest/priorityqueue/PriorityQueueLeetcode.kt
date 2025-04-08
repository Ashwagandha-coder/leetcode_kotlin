package com.github.contest.priorityqueue

import java.util.PriorityQueue

/**
 * 347. Top K Frequent Elements
 */

fun topKFrequent(nums: IntArray, k: Int): IntArray? {
    val map: MutableMap<Int, Int> = HashMap()
    for (n in nums) {
        map[n] = map.getOrDefault(n, 0) + 1
    }

    val heap = PriorityQueue { a: Map.Entry<Int, Int>, b: Map.Entry<Int, Int> ->
        b.value.compareTo(a.value)
    }

    for (entry in map.entries) {
        heap.offer(entry)
    }

    val res = IntArray(k)
    for (i in 0 until k) {
        res[i] = heap.poll().key
    }

    return res
}