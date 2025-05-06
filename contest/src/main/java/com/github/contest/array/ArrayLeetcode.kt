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

/**
 * 2873. Maximum Value of an Ordered Triplet I
 */

fun maximumTripletValueI(nums: IntArray): Long {
    var max = 0L
    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            for (k in j + 1 until nums.size) {
                max = maxOf(max, ((nums[i] - nums[j]).toLong() * nums[k].toLong()))
            }
        }
    }

    return max
}


/**
 * 2874. Maximum Value of an Ordered Triplet II
 */


fun maximumTripletValue(nums: IntArray): Long {
    var maxi = Int.MIN_VALUE
    var diff = 0
    var res = 0L

    for (i in nums.indices) {
        maxi = maxOf(maxi, nums[i])
        if (i >= 2) res = maxOf(res, (diff.toLong() * nums[i]))
        if (i >= 1) diff = maxOf(diff, (maxi - nums[i]))
    }

    return res
}

/**
 * 189. Rotate Array
 */

fun rotate(nums: IntArray, k: Int) {
    if (k % nums.size != 0) {
        val cache = mutableListOf<Int>()
        val bound = when {
            k > nums.size -> {
                val temp = k % nums.size
                nums.size - temp
            }

            else -> nums.size - k
        }
        for (i in bound until nums.size) {
            cache.add(nums[i])
        }

        for (i in 0 until bound) {
            cache.add(nums[i])
        }

        for (i in 0 until cache.size) {
            nums[i] = cache[i]
        }
    }
}

/**
 * 228. Summary Ranges
 */

fun summaryRanges(nums: IntArray): List<String> {
    val result = mutableListOf<String>()
    if (nums.isEmpty()) return result

    var start = nums[0]
    var prev = nums[0]

    for (i in 1 until nums.size) {
        if (nums[i] == prev + 1) {
            prev = nums[i]
        } else {
            if (start == prev) {
                result.add("$start")
            } else {
                result.add("$start->$prev")
            }
            start = nums[i]
            prev = nums[i]
        }
    }

    // Add the last range
    if (start == prev) {
        result.add("$start")
    } else {
        result.add("$start->$prev")
    }

    return result
}

/**
 * 1920. Build Array from Permutation
 */


fun buildArray(nums: IntArray): IntArray {
    val new = IntArray(nums.size)

    nums.forEachIndexed { index, _ ->
        new[index] = nums[nums[index]]
    }

    return new
}

