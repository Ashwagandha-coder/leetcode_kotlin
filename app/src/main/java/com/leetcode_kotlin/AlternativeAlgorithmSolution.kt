package com.leetcode_kotlin

import java.util.Arrays
import java.util.PriorityQueue
import kotlin.math.abs
import kotlin.math.max


class Solution

/**
 * 53. Maximum Subarray
 * Algorithm Kadane, Time - O(n), Space - O(1)
 */

fun maxSubArrayAlternative(nums: IntArray): Int {
    var res = nums[0]
    var curr = 0
    for (i in nums) {
        curr = max(i, curr + i)
        res = max(res, curr)
    }
    return res
}

/**
 * Tabulation
 * Time - O(n), Space - O(n)
 */


fun maxSubArrayDP(nums: IntArray): Int {
    val n = nums.size
    val dp = IntArray(n)
    dp[0] = nums[0]
    for (i in 1 until n) {
        dp[i] = (nums[i] + (max(0.0, dp[i - 1].toDouble()))).toInt()
    }
    var max = Int.MIN_VALUE
    for (i in dp.indices) {
        if (dp[i] > max) max = dp[i]
    }
    return max
}

/**
 * Combinations Sum II
 */


fun combinationSum2Other(candidates: IntArray, target: Int): List<List<Int>> {
    Arrays.sort(candidates)
    val res: MutableList<List<Int>> = ArrayList()

    dfs(candidates, target, 0, ArrayList(), res)
    return res
}


private fun dfs(
    candidates: IntArray,
    target: Int,
    start: Int,
    comb: MutableList<Int>,
    res: MutableList<List<Int>>
) {
    if (target < 0) {
        return
    }

    if (target == 0) {
        res.add(ArrayList(comb))
        return
    }

    for (i in start until candidates.size) {
        if (i > start && candidates[i] == candidates[i - 1]) {
            continue
        }

        if (candidates[i] > target) {
            break
        }

        comb.add(candidates[i])
        dfs(candidates, target - candidates[i], i + 1, comb, res)
        comb.removeAt(comb.size - 1)
    }
    return
}


/**
 * 128. Longest Consecutive Sequence
 * Priority Queue
 * O(n * logn) - Time
 * O(n) - Space
 */

fun Solution.longestConsecutive(nums: IntArray): Int {
    if (nums.isEmpty() || nums.size == 1) {
        return nums.size
    }
    val pq = PriorityQueue<Int>()
    for (i in nums.indices) {
        pq.add(nums[i])
    }
    var ans = 1
    var count = 1
    var prev = pq.remove()
    while (!pq.isEmpty()) {
        val present = pq.remove()
        if (present == prev) {
        } else if (abs((present - prev).toDouble()) == 1.0) {
            count++
            ans = max(ans.toDouble(), count.toDouble()).toInt()
            prev = present
        } else {
            count = 1
            prev = present
        }
    }
    return ans
}

/**
 * 78. Subsets
 * Bit Manipulation
 * Time - O(2^n)
 * Space - O(n)
 */

fun Solution.subsets(nums: IntArray): List<List<Int>> {
    val result: MutableList<List<Int>> = ArrayList()
    val n = nums.size
    for (i in 0 until (1 shl n)) {
        val subset: MutableList<Int> = ArrayList()
        for (j in 0 until n) {
            if ((i and (1 shl j)) > 0) {
                subset.add(nums[j])
            }
        }
        result.add(subset)
    }
    return result
}



