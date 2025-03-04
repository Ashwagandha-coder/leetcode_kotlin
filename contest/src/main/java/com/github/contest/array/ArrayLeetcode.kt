package com.github.contest.array

/**
 * 1800. Maximum Ascending Subarray Sum
 */

fun maxAscendingSum(nums: IntArray): Int {
    if (nums.hasSingle()) return nums[0]
    var maxAscending = 0
    var sum = nums[0]
    for (i in 1 until nums.size) {
        if (nums[i] > nums[i - 1]) sum += nums[i]
        else {
            maxAscending = maxOf(maxAscending, sum)
            sum = nums[i]
        }
    }
    maxAscending = maxOf(maxAscending, sum)
    return maxAscending
}

private fun IntArray.hasSingle(): Boolean = when {
    this.size == 1 -> true
    else -> false
}

/**
 * 135. Candy
 */

fun candy(ratings: IntArray): Int {
    val candies = IntArray(ratings.size) { 1 }
    for (i in 1 until ratings.size) {
        if (ratings[i] > ratings[i - 1]) {
            candies[i] = candies[i - 1] + 1
        }
    }
    for (i in ratings.size - 2 downTo 0) {
        if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
            candies[i] = candies[i + 1] + 1
        }
    }
    return candies.sum()
}

/**
 * 922. Sort Array By Parity II
 */

fun sortArrayByParityII(nums: IntArray): IntArray {
    val even = mutableListOf<Int>()
    val odd = mutableListOf<Int>()
    for (num in nums) {
        if (num % 2 == 0) even.add(num)
        else odd.add(num)
    }

    for (i in nums.indices) {
        nums[i] = if (i % 2 == 0) even.removeLast() else odd.removeLast()
    }

    return nums
}

/**
 * 2460. Apply Operations to an Array
 */

fun applyOperations(nums: IntArray): IntArray {
    for (i in 0 until nums.size - 1) {
        if (nums[i] == nums[i + 1]) {
            nums[i] *= 2
            nums[i + 1] = 0
        }
    }
    var i = 0
    var j = 1
    while (i < nums.size && j < nums.size) {
        while (i < nums.size && nums[i] != 0) i++
        j = i
        while (j < nums.size && nums[j] == 0) j++
        if (i < nums.size && j < nums.size) {
            nums.swap(i, j)
            i++
            j++
        }
    }

    return nums
}

private fun IntArray.swap(from: Int, to: Int) {
    val temp = this[from]
    this[from] = this[to]
    this[to] = temp
}

/**
 * 2161. Partition Array According to Given Pivot
 */

fun pivotArray(nums: IntArray, pivot: Int): IntArray {
    if (nums.hasSingle()) return nums
    val res = mutableListOf<Int>()
    for (i in nums.indices) {
        if (nums[i] < pivot) res.add(nums[i])
    }
    for (i in nums.indices) {
        if (nums[i] == pivot) res.add(nums[i])
    }
    for (i in nums.indices) {
        if (nums[i] > pivot) res.add(nums[i])
    }

    return res.toIntArray()
}

/**
 * 2570. Merge Two 2D Arrays by Summing Values
 */


fun mergeArrays(nums1: Array<IntArray>, nums2: Array<IntArray>): Array<IntArray> {
    val map = mutableMapOf<Int, Int>()

    for (pair in nums1) {
        val key = pair[0]
        val value = pair[1]
        map[key] = map.getOrDefault(key, 0) + value
    }

    for (pair in nums2) {
        val key = pair[0]
        val value = pair[1]
        map[key] = map.getOrDefault(key, 0) + value
    }

    return map.toSortedMap().map { (key, value) ->
        intArrayOf(key, value)
    }.toTypedArray()
}




