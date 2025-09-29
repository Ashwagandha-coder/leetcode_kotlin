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

/**
 * 692. Top K Frequent Words
 * Prod Variant
 */

private val comparatorProdVariant = Comparator<FreqTopKProd> { a, b ->
    if (a.freq != b.freq) b.freq - a.freq
    else a.word.compareTo(b.word)
}

fun topKFrequentProdVariant(words: Array<String>, k: Int): List<String> =
    words.groupingBy { it }.eachCount().toList().map { FreqTopKProd(it.first, it.second) }
        .sortedWith(comparatorProdVariant).take(k).map { it.word }


private data class FreqTopKProd(val word: String, val freq: Int)