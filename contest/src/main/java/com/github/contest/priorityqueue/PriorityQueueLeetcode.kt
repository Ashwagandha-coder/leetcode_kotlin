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

/**
 * 692. Top K Frequent Words
 */

private val comparator: Comparator<FrequentWords> = Comparator { a, b ->
    if (a.freq != b.freq) b.freq - a.freq
    else a.word.compareTo(b.word)
}

fun topKFrequent(words: Array<String>, k: Int): List<String> {
    val freq = words.groupingBy { it }.eachCount()
    val pq = PriorityQueue(comparator)
    val res = mutableListOf<String>()
    var k = k

    for ((word, count) in freq) {
        val obj = FrequentWords(word, count)
        pq.offer(obj)
    }

    while (pq.isNotEmpty() && k != 0) {
        val (word, _) = pq.poll()
        res.add(word)
        k--
    }

    return res
}

private data class FrequentWords(val word: String, val freq: Int)
