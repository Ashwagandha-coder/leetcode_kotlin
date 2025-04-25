package com.github.contest.hashTable


/**
 * 1790. Check if One String Swap Can Make Strings Equal
 * Prod Variant
 */


fun areAlmostEqualProdVariant(s1: String, s2: String): Boolean =
    when {
        s1 == s2 -> true
        s1.length != s2.length -> false
        else -> s1.zip(s2).withIndex().filter { it.value.first != it.value.second }.map { it.index }
            .let { diff ->
                diff.size == 2 && s1[diff[0]] == s2[diff[1]] && s1[diff[1]] == s2[diff[0]]
            }
    }

/**
 * 2965. Find Missing and Repeated Values
 * Prod Variant
 */

fun findMissingAndRepeatedValuesProdVariant(grid: Array<IntArray>): IntArray {
    val map = mutableMapOf<Int, Int>()
    val res = IntArray(2)
    val n = grid.size

    grid.forEach { row ->
        row.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
    }

    map.forEach { (num, count) ->
        if (count == 2) {
            res[0] = num
            return@forEach
        }
    }

    (1..(n * n)).forEach {
        if (!map.contains(it)) res[1] = it
    }

    return res
}


/**
 * 2799. Count Complete Subarrays in an Array
 * Prod Variant
 */

fun countCompleteSubArrayProdVariant(nums: IntArray): Int {
    val unique = nums.distinct().size
    var count = 0
    val freq = mutableMapOf<Int, Int>()
    var left = 0
    val n = nums.size

    nums.forEachIndexed { right, num ->
        freq[num] = freq.getOrDefault(num, 0) + 1

        while (freq.size == unique) {
            count += n - right
            val delete = nums[left]
            freq[delete] = freq.getOrDefault(delete, 0) - 1
            if (freq[delete] == 0) freq.remove(delete)
            left++
        }
    }

    return count
}

