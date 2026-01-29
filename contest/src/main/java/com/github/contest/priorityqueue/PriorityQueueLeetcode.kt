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

/**
 * 2182. Construct String With Repeat Limit
 */

fun repeatLimitedString(s: String, repeatLimit: Int): String {
    val freq = s.eachLetter()
    val pq = PriorityQueue<Char> { a, b -> b.compareTo(a) }.apply {
        populateLetter(freq)
    }
    val res = StringBuilder()

    while (pq.isNotEmpty()) {
        val curr = pq.poll()
        val index = curr - 'a'
        val count = minOf(freq[index], repeatLimit)

        repeat(count) {
            res.append(curr)
        }

        freq[index] -= count

        if (freq[index] > 0) {
            if (pq.isEmpty()) break
            val next = pq.poll()
            res.append(next)
            val nextIndex = next - 'a'
            freq[nextIndex]--

            if (freq[nextIndex] > 0) pq.offer(next)
            pq.offer(curr)
        }
    }

    return res.toString()
}

private fun String.eachLetter(): IntArray {
    if (isEmpty()) return intArrayOf()

    val freq = IntArray(26)
    for (char in this) {
        freq[char - 'a']++
    }

    return freq
}

private fun PriorityQueue<Char>.populateLetter(lettersFreq: IntArray) {
    for (i in 0 until lettersFreq.size) {
        if (lettersFreq[i] > 0) this.offer(Char(i + 'a'.code))
    }
}

/**
 * 2343. Query Kth Smallest Trimmed Number
 * Priority Queue Approach
 */

fun smallestTrimmedNumbers(nums: Array<String>, queries: Array<IntArray>): IntArray {
    val answer = IntArray(queries.size)
    val pq = PriorityQueue { a: Pair<String, Int>, b: Pair<String, Int> ->
        if (a.first != b.first) a.first.compareTo(b.first)
        else a.second - b.second
    }

    for (j in 0 until queries.size) {
        val trimmed = mutableListOf<String>()
        val kth = queries[j][0]
        val trim = queries[j][1]
        var k = 0
        var ans = 0

        for (num in nums) {
            val len = num.length
            var str = ""
            for (i in len - trim until len) {
                str += num[i]
            }
            trimmed.add(str)
        }

        trimmed.forEachIndexed { index, elem ->
            pq.offer(Pair(elem, index))
        }

        while (pq.isNotEmpty() && k != kth) {
            ans = pq.poll().second
            k++
        }
        pq.clear()

        answer[j] = ans
    }

    return answer
}

