package com.github.contest.array

import java.util.PriorityQueue
import kotlin.math.abs


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

/**
 * 56. Merge Intervals
 */

fun merge(intervals: Array<IntArray>): Array<IntArray> {
    if (intervals.size == 1) return intervals

    val pq = PriorityQueue { a: IntArray, b: IntArray -> a[0] - b[0] }
    val k = 2
    var temp = IntArray(k)
    val res = mutableListOf<IntArray>()

    for (interval in intervals) {
        pq.offer(interval)
    }

    val (start, end) = pq.poll()
    temp[0] = start
    temp[1] = end

    while (pq.isNotEmpty()) {
        val (start, end) = pq.poll()
        if (temp[1] in start..end) temp[1] = end
        else if (temp[1] < start) {
            res.add(temp)
            temp = IntArray(k)
            temp[0] = start
            temp[1] = end
        }
    }

    res.add(temp)

    return res.toTypedArray()
}

/**
 * 2918. Minimum Equal Sum of Two Arrays After Replacing Zeros
 */

fun minSum(nums1: IntArray, nums2: IntArray): Long {
    val zerosOne = nums1.countLong { it == 0 }
    val zerosTwo = nums2.countLong { it == 0 }
    val sumOne = nums1.sumLong() + zerosOne
    val sumTwo = nums2.sumLong() + zerosTwo

    return when {
        sumOne == sumTwo -> sumOne
        sumOne < sumTwo -> if (zerosOne > 0) sumTwo else -1L
        else -> if (zerosTwo > 0) sumOne else -1L
    }
}

private fun IntArray.countLong(predicate: (Int) -> Boolean): Long {
    var count = 0L
    for (element in this) {
        if (predicate(element)) count++
    }
    return count
}

private fun IntArray.sumLong(): Long {
    var sum = 0L
    for (element in this) sum += element
    return sum
}

/**
 * 1550. Three Consecutive Odds
 */

fun threeConsecutiveOdds(arr: IntArray): Boolean {
    var consecutive = 3

    for (num in arr) {
        if (isOdd(num)) consecutive--
        else consecutive = 3

        if (consecutive == 0) return true
    }

    return false
}

fun isOdd(number: Int) = when {
    number % 2 != 0 -> true
    else -> false
}

/**
 * 73. Set Matrix Zeroes
 */


fun setZeroes(matrix: Array<IntArray>) {
    val m = matrix.size
    val n = matrix[0].size

    val forRows = BooleanArray(m)
    val forCols = BooleanArray(n)

    for (i in 0 until m) {
        for (j in 0 until n) {
            if (matrix[i][j] == 0) {
                forRows[i] = true
                forCols[j] = true
            }
        }
    }


    for (i in 0 until m) {
        for (j in 0 until n) {
            if (forRows[i] || forCols[j]) {
                matrix[i][j] = 0
            }
        }
    }
}

/**
 * 3355. Zero Array Transformation I
 */


fun isZeroArray(nums: IntArray, queries: Array<IntArray>): Boolean {
    val diff = IntArray(nums.size)
    var pref = 0

    for (query in queries) {
        val (l, r) = query
        diff[l]++
        if (r + 1 < nums.size) diff[r + 1]--
    }


    for (i in nums.indices) {
        pref += diff[i]
        if (nums[i] > pref) return false
    }

    return true
}

/**
 * 2932. Maximum Strong Pair XOR I
 */

fun maximumStrongPairXor(nums: IntArray): Int {
    val pairs = mutableListOf<Pair<Int, Int>>()

    for (i in nums.indices) {
        pairs.add(Pair(nums[i], nums[i]))
        for (j in i + 1 until nums.size) {
            pairs.add(Pair(nums[i], nums[j]))
        }
    }

    return pairs
        .filter { abs(it.first - it.second) <= minOf(it.first, it.second) }
        .maxOf { it.first xor it.second }
}

/**
 * 2016. Maximum Difference Between Increasing Elements
 */

fun maximumDifference(nums: IntArray): Int {
    var diff = -1

    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            if (nums[i] < nums[j]) diff = maxOf(diff, nums[j] - nums[i])
        }
    }

    return diff
}


