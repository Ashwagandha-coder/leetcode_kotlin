package com.leetcode_kotlin

import java.util.Arrays
import java.util.PriorityQueue
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min


class Solution {
    companion object {
        val value = Solution()
    }
}

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


/**
 * Max Rob I
 * Optimazing DP, Time - O(n) Space - O(1)
 */


fun Solution.maxRob(nums: IntArray): Int {
    val len = nums.size
    var alt = 0
    var max = 0
    for (i in 0 until len) {
        var temp = max(max, alt + nums[i])
        alt = max
        max = temp
    }
    return max
}

/**
 * 1876. Substrings of Size Three with Distinct Characters
 * Time - O(n)
 * Space - O(1) - set
 */


fun Solution.countGoodSubstrings(s: String): Int {
    val n = s.length
    var cnt = 0
    //Create a HashSet for charachters storage
    val charSet = HashSet<Char>()
    for (i in 0 until n - 2) {
        //Find a Substring of length 3
        val substring = s.substring(i, i + 3)

        var isUnique = true
        for (c in substring.toCharArray()) {
            // Try to add the character to the set
            if (!charSet.add(c)) {
                isUnique = false // If add returns false, it's a duplicate
                break // No need to check further
            }
        }

        if (isUnique) {
            cnt++ // It's a good substring
        }
        charSet.clear()
    }
    return cnt
}

/**
 * Solution with Map
 * Time - O(n)
 * Space - O(1)
 */

fun Solution.countGoodSubstringsAlternative(s: String): Int {
    var goodSubstringsCount = 0
    val map: MutableMap<Char, Int> = HashMap()
    val len = s.length
    val k = 3
    for (i in 0 until len) {
        val currCharacter = s[i]
        map[currCharacter] = map.getOrDefault(currCharacter, 0) + 1

        // if we processed a window of k elements, here the window is of size 3.
        if (i >= k - 1) {
            if (map.size == 3) {
                goodSubstringsCount++
                map.remove(s[i - 2])
            } else {
                val characterToRemove = s[i - 2]
                if (map[characterToRemove] == 1) {
                    map.remove(characterToRemove)
                } else {
                    map[characterToRemove] = map.getOrDefault(characterToRemove, 0) - 1
                }
            }
        }
    }

    return goodSubstringsCount
}

/**
 * 268. Missing Number
 * Time - O(n)
 * Space - O(1)
 */


fun Solution.missingNumber(nums: IntArray): Int {
    val len = nums.size
    var res = len
    for (i in 0 until len) {
        res += i - nums[i]
    }
    return res
}

/**
 * 448. Find All Numbers Disappeared in an Array
 * Time - O(n)
 * Space - O(1)
 * Marking
 */

fun Solution.findDisappearedNumbers(nums: IntArray): List<Int> {
    val len = nums.size
    val res = mutableListOf<Int>()
    for (i in 0 until len) {
        var ind = abs(nums[i]) - 1
        if (nums[ind] > 0) {
            nums[ind] *= -1
        }
    }
    for (i in 0 until len) {
        if (nums[i] > 0) res.add(i + 1)
    }
    return res
}

/**
 * 386. Lexicographical Numbers
 * Recursion dfs
 * Time - O(n)
 * Space - O(n)
 */


fun Solution.lexicalOrder(n: Int): List<Int> {
    val res = mutableListOf<Int>()
    for (i in 1..9) {
        dfs(i, n, res)
    }
    return res
}

private fun dfs(number: Int, n: Int, res: MutableList<Int>) {
    if (number > n) return
    res.add(number)
    for (i in 0..9) {
        dfs(number * 10 + i, n, res)
    }
    return
}

/**
 * 121. Best Time to Buy and Sell Stock
 * Time - O(n)
 * Space - O(1)
 */

fun Solution.maxProfit(prices: IntArray): Int {
    var profit = Int.MIN_VALUE
    var min = Int.MAX_VALUE
    val len = prices.size
    for (i in 0 until len) {
        min = min(min, prices[i])
        if (prices[i] - min > profit) profit = prices[i] - min
    }
    return profit
}

/**
 * 14. Longest Common Prefix
 * Time -
 * Space -
 */


fun Solution.longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) {
        return ""
    }
    if (strs.size == 1) {
        return strs[0]
    }
    val trie = Trie()
    for (str in strs) {
        trie.insert(str)
    }
    return trie.search(strs[0], strs.size)
}


internal class TrieNode {
    var child: Array<TrieNode?> = arrayOfNulls(26)
    var isEnd: Boolean = false
    var count: Int = 0

    fun containsKey(ch: Char): Boolean {
        return (child[ch.code - 'a'.code] != null)
    }

    fun get(ch: Char): TrieNode? {
        return child[ch.code - 'a'.code]
    }

    fun put(ch: Char, node: TrieNode?) {
        child[ch.code - 'a'.code] = node
    }

    fun setEnd() {
        isEnd = true
    }
}

internal class Trie {
    private var root: TrieNode = TrieNode()

    fun insert(word: String) {
        var node: TrieNode? = root
        for (element in word) {
            if (!node!!.containsKey(element)) {
                node.put(element, TrieNode())
            }
            node.get(element)!!.count++
            node = node.get(element)
        }
        node!!.setEnd()
    }

    fun search(word: String, n: Int): String {
        var node: TrieNode? = root
        for (i in word.indices) {
            val ch = word[i]
            if (node!!.get(ch) != null && node.get(ch)!!.count == n) {
                node = node.get(ch)
            } else {
                return word.substring(0, i)
            }
        }
        return word
    }
}

/**
 * 220. Contains Duplicate III
 * Bucket Sort
 */

fun Solution.containsNearbyAlmostDuplicate(
    nums: IntArray,
    indexDiff: Int,
    valueDiff: Int
): Boolean {
    if (valueDiff < 0) return false
    val map: MutableMap<Long, Long> = HashMap()
    val w = valueDiff.toLong() + 1
    for (i in nums.indices) {
        val key: Long = getID(nums[i].toLong(), w)
        if (map.containsKey(key)) return true
        if (map.containsKey(key - 1) && abs((nums[i] - map[key - 1]!!).toDouble()) < w) return true
        if (map.containsKey(key + 1) && abs((nums[i] - map[key + 1]!!).toDouble()) < w) return true
        map[key] = nums[i].toLong()
        if (i >= indexDiff) map.remove(getID(nums[i - indexDiff].toLong(), w))
    }
    return false
}

private fun getID(value: Long, w: Long): Long {
    return if (value < 0) (value + 1) / w - 1 else value / w
}

/**
 * 386. Lexicographical Numbers
 * Iterative Stack Solution
 */


fun Solution.lexicalOrderWithStack(n: Int): List<Int> {
    val stack = ArrayDeque<StackState>()
    val result = ArrayList<Int>()
    for (i in 1..9) {
        dfs(i, n, stack, result)
    }
    return result
}

private fun dfs(number: Int, n: Int, stack: ArrayDeque<StackState>, result: MutableList<Int>) {
    stack.addLast(StackState(number, 0))
    while (stack.isNotEmpty()) {
        val state = stack.removeLast()
        if (state.number <= n) {
            if (state.i == 0) {
                result.add(state.number)
                state.number *= 10
            }
            if (state.i++ <= 9) {
                stack.addLast(state)
                stack.addLast(StackState(state.number + state.i - 1, 0))
            }
        }
    }
}

class StackState(var number: Int, var i: Int)