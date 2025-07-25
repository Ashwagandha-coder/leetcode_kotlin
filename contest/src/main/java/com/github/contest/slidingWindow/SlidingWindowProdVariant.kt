package com.github.contest.slidingWindow

/**
 * 30. Substring with Concatenation of All Words
 * Prod Variant
 */

fun findSubstringProdVariant(s: String, words: Array<String>): List<Int> {
    val res = mutableListOf<Int>()
    val totalLen = words[0].length * words.size
    val wordLen = words[0].length
    val store = mutableMapOf<String, Int>()

    if (totalLen > s.length) return res

    for (word in words) store[word] = store.getOrDefault(word, 0) + 1

    var left = 0

    for (right in s.indices) {
        if (right - left == totalLen - 1) {
            val str = s.substring(left, right + 1)
            if (isValidWord(str, store, wordLen)) res.add(left)
            left++
        }
    }

    return res
}

private fun isValidWord(s: String, map: Map<String, Int>, window: Int): Boolean {
    val seen = mutableMapOf<String, Int>()

    s.windowed(window, window) {
        seen[it.toString()] = seen.getOrDefault(it, 0) + 1
    }

    return when {
        equalsMap(seen, map) -> true
        else -> false
    }
}

private fun equalsMap(comparable: Map<String, Int>, base: Map<String, Int>): Boolean {

    for ((str, count) in comparable) {
        when {
            !base.contains(str) || base[str] != count -> return false
            else -> continue
        }
    }

    return true
}


/**
 * Prod Variant with More Kotlin Sugar
 */

fun findSubstringProdVariantII(s: String, words: Array<String>): List<Int> {
    val wordLength = words.first().length
    val totalLength = wordLength * words.size

    if (s.length < totalLength) return listOf()

    val wordCount = words.groupingBy { it }.eachCount()


    return (0..s.length - totalLength).filter { start ->
        val seen = mutableMapOf<String, Int>()
        words.indices.all { i ->
            val word = s.substring(start + i * wordLength, start + (i + 1) * wordLength)
            wordCount.containsKey(word) && seen.merge(word, 1, Int::plus)!! <= wordCount[word]!!
        }
    }
}

/**
 * 3392. Count Subarrays of Length Three With a Condition
 * Prod Variant
 */

fun countSubArraysProdVariant(nums: IntArray): Int =
    nums.toList().windowed(3).count {
        (it.first() + it.last()).toDouble() == it[1].toDouble() / 2.0
    }

/**
 * 3364. Minimum Positive Sum Subarray
 * Prod Variant
 */

fun minimumSumSubarrayProdVariant(nums: List<Int>, l: Int, r: Int): Int = buildList {
    (l..r).forEach { window ->
        nums.windowed(window).map { it.sum() }.filter { it > 0 }.forEach { add(it) }
    }
}.minOrNull() ?: -1

/**
 * 187. Repeated DNA Sequences
 * Prod Variant
 */

fun findRepeatedDnaSequencesProdVariant(s: String): List<String> = when {
    s.length < 10 -> listOf()
    else -> buildList {
        s.windowed(10).map { it }.groupingBy { it }.eachCount().forEach { (key, value) ->
            if (value > 1) add(key)
        }
    }
}

/**
 * 1052. Grumpy Bookstore Owner
 * Prod Variant
 */

fun maxSatisfiedProdVariant(customers: IntArray, grumpy: IntArray, minutes: Int): Int {
    var notGrumpy = 0
    var maxCustomers = 0

    customers.forEachIndexed { index, elem ->
        if (grumpy[index] == 0) notGrumpy += elem
    }


    customers.withIndex().windowed(minutes) { window ->
        val sum = window.sumOf {
            if (grumpy[it.index] == 1) it.value
            else 0
        }

        maxCustomers = maxOf(maxCustomers, notGrumpy + sum)
    }

    return maxCustomers
}

/**
 * 1052. Grumpy Bookstore Owner
 * Prod Variant
 * Memory Limit Exceeded
 */

fun maxSatisfiedProdVariantII(customers: IntArray, grumpy: IntArray, minutes: Int): Int =
    customers.foldIndexed(0) { index, acc, value ->
        if (grumpy[index] == 0) acc + value
        else acc
    } + customers.withIndex().windowed(minutes).map { window ->
        window.sumOf {
            if (grumpy[it.index] == 1) it.value
            else 0
        }

    }.max()


