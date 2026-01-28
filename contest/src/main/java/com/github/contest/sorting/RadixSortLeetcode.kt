package com.github.contest.sorting

/**
 * 2343. Query Kth Smallest Trimmed Number
 */

fun smallestTrimmedNumbers(nums: Array<String>, queries: Array<IntArray>): IntArray {
    val answer = IntArray(queries.size)

    for (q in 0 until queries.size) {
        val kth = queries[q][0]
        val trim = queries[q][1]
        val trimmed = storeTrimmedNumbers(nums, trim)
        val indexesByValue = storeIndexesByValue(trimmed)
        trimmed.radixSort()
        val indexes = indexesByValue.getOrDefault(trimmed[kth - 1], listOf())
        val index = when {
            indexes.size == 1 -> indexes.first()
            else -> indexes[findKthIndex(trimmed, kth, trimmed[kth - 1])]
        }
        val ans = index
        answer[q] = ans
    }

    return answer
}

fun findKthIndex(sortedNums: Array<String>, kth: Int, num: String): Int {
    val startIndex = kth - 1
    var ind = 0
    for (i in startIndex downTo 0) {
        if (sortedNums[i] == num) ind++
        else break
    }

    return ind - 1
}


fun storeTrimmedNumbers(nums: Array<String>, trim: Int): Array<String> {
    val trimmed = nums.copyOf()

    for (n in 0 until nums.size) {
        val len = nums[n].length
        var concatTrim = ""
        for (i in len - trim until len) concatTrim += nums[n][i]
        trimmed[n] = concatTrim
    }

    return trimmed
}

fun <T> storeIndexesByValue(nums: Array<T>): Map<T, List<Int>> {
    if (nums.isEmpty()) return mapOf()

    val indexes = mutableMapOf<T, MutableList<Int>>()

    for (i in 0 until nums.size) {
        val key = nums[i]
        if (indexes.contains(key)) indexes[key]?.add(i)
        else indexes[key] = indexes.getOrDefault(key, mutableListOf(i))
    }

    return indexes
}

fun Array<String>.radixSort() {
    if (this.isEmpty()) return

    for (index in this[0].length - 1 downTo 0) {
        countSortByIndex(this, index)
    }
}

private fun countSortByIndex(nums: Array<String>, index: Int) {
    val output = nums.copyOf()
    val counts = IntArray(10)

    for (num in nums) {
        val digit = num[index].digitToInt()
        counts[digit]++
    }

    for (i in 1 until 10) counts[i] += counts[i - 1]

    for (i in nums.size - 1 downTo 0) {
        val digit = nums[i][index].digitToInt()
        output[counts[digit] - 1] = nums[i]
        counts[digit]--
    }

    for (i in 0 until output.size) nums[i] = output[i]
}