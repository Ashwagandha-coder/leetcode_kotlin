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

/**
 * 1424. Diagonal Traverse II
 * Prod Variant
 */

fun findDiagonalOrderProdVariant(nums: List<List<Int>>): IntArray {
    val diagonals = mutableMapOf<Int, MutableList<Int>>()

    nums.forEachIndexed { row, _ ->
        nums[row].forEachIndexed { col, num ->
            diagonals.getOrPut(row + col) { mutableListOf() }.let { it.add(num) }
        }
    }

    return generateSequence(0) { it + 1 }
        .takeWhile { diagonals.containsKey(it) }
        .flatMap { diagonals[it]!!.reversed() }
        .let { it.toList().toIntArray() }
}


fun findDiagonalOrderProdVariantII(nums: List<List<Int>>): IntArray {
    PriorityQueue { a: Pair<Int, Pair<Int, Int>>, b: Pair<Int, Pair<Int, Int>> ->
        if (a.second.first != b.second.first) a.second.first - b.second.first
        else b.first - a.first
    }.apply {
        nums.forEachIndexed { row, _ ->
            nums[row].forEachIndexed { col, num ->
                offer(row to (row + col to num))
            }
        }
    }.apply {
        return mutableListOf<Int>().also {
            while (this.isNotEmpty()) it.add(this.poll().second.second)
        }.toIntArray()
    }
}



