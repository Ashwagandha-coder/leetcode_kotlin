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

/**
 * 2099. Find Subsequence of Length K With the Largest Sum
 * Prod Variant
 */

fun maxSubsequenceProdVariant(nums: IntArray, k: Int): IntArray {
    val heap = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })

    nums.forEachIndexed { index, num ->
        heap.offer(index to num)
        if (heap.size > k) heap.poll()
    }

    return mutableListOf<Pair<Int, Int>>()
        .apply { heap.forEach { add(it) } }
        .sortedBy { it.second }
        .map { it.first }
        .toIntArray()
}

fun maxSubsequenceProdVariantII(nums: IntArray, k: Int): IntArray =
    nums.mapIndexed { index, num -> num to index }
        .let { pairs ->
            PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
                .apply {
                    pairs.forEach {
                        offer(it)
                        if (size > k) poll()
                    }
                }.let { heap ->
                    List(heap.size) { heap.poll() }
                        .sortedBy { it.second }
                        .map { it.first }
                        .toIntArray()
                }
        }







