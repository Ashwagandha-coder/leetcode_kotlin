package com.github.contest.priorityqueue

/**
 * 347. Top K Frequent Elements
 */

fun topKFrequentProdVariant(nums: IntArray, k: Int): IntArray {
    val freq = mutableMapOf<Int, Int>()
    val repeated = Array<MutableList<Int>>(nums.size + 1) { mutableListOf() }

    for (num in nums) freq[num] = freq.getOrDefault(num, 0) + 1

    for ((num, count) in freq) {
        repeated[count].add(num)
    }

    return repeated.flatMap { it }.takeLast(k).toIntArray()
}