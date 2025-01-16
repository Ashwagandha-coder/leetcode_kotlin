package com.leetcode_kotlin

import android.annotation.SuppressLint
import java.util.Arrays
import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue
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
 * 53. Maximum Subarray
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
 * Trie Solution
 */

class TrieNode {
    val children = mutableMapOf<Char, TrieNode>()
    var isEndOfWord = false
}

class Trie {
    val root = TrieNode()

    fun insert(word: String) {
        var node = root
        for (char in word) {
            if (!node.children.containsKey(char)) {
                node.children[char] = TrieNode()
            }
            node = node.children[char]!!
        }
        node.isEndOfWord = true
    }

    fun longestCommonPrefix(): String {
        var node = root
        val prefix = StringBuilder()
        while (node.children.size == 1 && !node.isEndOfWord) {
            val char = node.children.keys.first()
            prefix.append(char)
            node = node.children[char]!!
        }
        return prefix.toString()
    }
}

fun longestCommonPrefixWithTrie(strs: Array<String>): String {
    if (strs.isEmpty()) {
        return ""
    }

    val trie = Trie()
    for (str in strs) {
        trie.insert(str)
    }

    return trie.longestCommonPrefix()
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


/**
 * 39. Combination Sum
 * Cycle Backtrack Solution
 */

fun Solution.combinationSumI(candidates: IntArray, target: Int): List<List<Int>> {
    val res = mutableListOf<MutableList<Int>>()
    val subset = mutableListOf<Int>()
    backtrack(candidates, target, 0, 0, subset, res)
    return res
}

fun backtrack(
    cand: IntArray,
    target: Int,
    total: Int,
    index: Int,
    subset: MutableList<Int>,
    res: MutableList<MutableList<Int>>
) {
    if (total > target) return
    if (total == target) {
        res.add(ArrayList(subset))
        return
    }
    for (i in index until cand.size) {
        subset.add(cand[i])
        backtrack(cand, target, total + cand[i], i, subset, res)
        subset.removeAt(subset.size - 1)
    }
    return
}

/**
 * 39. Combination Sum
 * Iterative Solution
 */

fun combinationSumIterative(candidates: IntArray, target: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>() // Хранит итоговые уникальные комбинации
    val combinations = mutableListOf<MutableList<Int>>() // Хранитформируемые комбинации
    combinations.add(mutableListOf()) // Начинаем с пустой комбинации

    for (candidate in candidates) { // Внешний цикл: перебор кандидатов
        val newCombinations =
            mutableListOf<MutableList<Int>>() // Новые комбинации для текущего кандидата
        for (combination in combinations) { // Внутренний цикл: перебор существующих комбинаций
            var currentSum = combination.sum() // Текущая сумма элементов комбинации
            var count = 0 // Счетчик добавлений текущего кандидата

            while (currentSum + candidate <= target) { // Пока сумма не превышает цель
                count++
                val newCombination = combination.toMutableList() // Копия текущей комбинации
                repeat(count) { newCombination.add(candidate) } // Добавляем кандидата count раз

                if (currentSum + candidate == target) {
                    result.add(newCombination) // Если достигли цели, добавляем в результат
                } else {
                    newCombinations.add(newCombination) // Иначе добавляем в newCombinations для дальнейшего исследования
                }

                currentSum += candidate // Обновляем текущую сумму
            }
        }
        combinations.addAll(newCombinations) // Добавляем новые комбинации для следующего кандидата
    }

    return result // Возвращаем список уникальных комбинаций
}

/**
 * 303. Range Sum Query Immutable
 * Alternative Solution
 */

class NumArrayAlt(nums: IntArray) {
    private val prefixSums: IntArray = IntArray(nums.size + 1)

    init {
        for (i in nums.indices) {
            prefixSums[i + 1] = prefixSums[i] + nums[i]
        }
    }

    fun sumRange(left: Int, right: Int): Int {
        return prefixSums[right + 1] - prefixSums[left]
    }
}

/**
 * 2095. Delete the Middle Node of a Linked List
 */

fun deleteMiddleAlt(head: ListNode?): ListNode? {
    if (head?.next == null) return null
    var prev = head
    var slow = head
    var fast = head
    while (fast?.next != null) {
        prev = slow
        slow = slow?.next
        fast = fast?.next?.next
    }
    prev?.next = slow?.next

    return head
}

/**
 * 152. Maximum Product Subarray
 */

fun maxProductAltSolution(nums: IntArray): Int {
    return 0
}

/**
 * 206. Reverse Linked List
 * Alt Solution
 */


fun reverseListAlt(head: ListNode?): ListNode? {
    if (head?.next == null) return head // Base case: If head is null or has no next, it's the new head
    val newHead = reverseListAlt(head.next) // Recursively reverse the rest of the list
    head.next?.next = head // Reverse the link between head and its next
    head.next = null // Set head's next to null to avoid cycles
    return newHead
}

/**
 *
 * Alt Solution with 2D dp array
 */


fun longestPalindromeAlt(s: String): String {
    val n = s.length
    if (n < 2) return s

    val dp = Array(n) { BooleanArray(n) }
    var start = 0
    var maxLength = 1


    for (i in 0 until n) {
        dp[i][i] = true
    }


    for (i in 0 until n - 1) {
        if (s[i] == s[i + 1]) {
            dp[i][i + 1] = true
            start = i
            maxLength = 2
        }
    }


    for (len in 3..n) {
        for (i in 0 until n - len + 1) {
            val j = i + len - 1
            if (s[i] == s[j] && dp[i + 1][j - 1]) {
                dp[i][j] = true
                if (len > maxLength) {
                    start = i
                    maxLength = len
                }
            }
        }
    }

    return s.substring(start, start + maxLength)
}

/**
 * 392. Is Subsequence
 * Alt Solution
 */

fun isSubsequence(s: String, t: String): Boolean {
    var sp = 0
    var tp = 0
    while (sp < s.length && tp < t.length) {
        if (s[sp] == t[tp]) sp++
        tp++
    }
    return sp == s.length
}

/**
 * 796. Rotate String
 * Alt Solution , Time - O(n) , Space - O(n)
 */

fun rotateStringAlt(s: String, goal: String): Boolean {
    return if (s.length != goal.length) false else (s + s).contains(goal)
}

/**
 * 1464. Maximum Product of Two Elements in an Array
 * Time - O(n)
 * Space - O(1)
 */

fun maxProductTwoElementsAltSolution(nums: IntArray): Int {
    var one = 0
    var two = 0
    val len = nums.size
    for (i in 0 until len) {
        if (nums[i] > one) one = nums[i]
        if (one > two) {
            var temp = two
            two = one
            one = temp
        }
    }
    return (one - 1) * (two - 1)
}

/**
 * 1464. Maximum Product of Two Elements in an Array
 * Time - O(n * log k)
 * Space - O(n)
 */


@SuppressLint("NewApi")
fun maxProductTwoElementsPriorityQueueSolution(nums: IntArray): Int {
    val pq = PriorityQueue<Int> { num1, num2 -> num2 - num1 }
    pq.addAll(nums.toTypedArray())
    val one = pq.poll()
    val two = pq.poll()
    return (one - 1) * (two - 1)
}

/**
 * 23. Merge k Sorted Lists
 * Alt Solution
 * Time - O(n * log k)
 * Space - O(n)
 */

fun mergeKListsAltSolution(lists: Array<ListNode?>): ListNode? {
    var lists = lists
    if (lists.isEmpty()) return null

    while (lists.size > 1) {
        val temp: MutableList<ListNode?> = ArrayList()
        var i = 0
        while (i < lists.size) {
            val l1 = lists[i]
            val l2 = if (i + 1 < lists.size) lists[i + 1] else null
            temp.add(mergeListNodes(l1, l2))
            i += 2
        }
        lists = temp.toTypedArray<ListNode?>()
    }
    return lists.first()
}

fun mergeListNodes(l1: ListNode?, l2: ListNode?): ListNode? {
    var l1 = l1
    var l2 = l2
    var stub = ListNode(0)
    val head = stub
    while (l1 != null && l2 != null) {
        if (l1.`val` > l2.`val`) {
            stub?.next = l2
            l2 = l2?.next
        } else {
            stub?.next = l1
            l1 = l1?.next
        }
        stub = stub.next!!
    }
    stub?.next = l1 ?: l2
    return head?.next
}

/**
 * Algo Meneier
 */

fun longestPalindrome(s: String): String? {
    var s = s
    if (s.length <= 1) {
        return s
    }

    var maxLen = 1
    var maxStr = s.substring(0, 1)
    s = "#" + s.replace("".toRegex(), "#") + "#"
    val dp = IntArray(s.length)
    var center = 0
    var right = 0

    for (i in s.indices) {
        if (i < right) {
            dp[i] = min((right - i).toDouble(), dp[2 * center - i].toDouble()).toInt()
        }

        while (i - dp[i] - 1 >= 0 && i + dp[i] + 1 < s.length && s[i - dp[i] - 1] == s[i + dp[i] + 1]) {
            dp[i]++
        }

        if (i + dp[i] > right) {
            center = i
            right = i + dp[i]
        }

        if (dp[i] > maxLen) {
            maxLen = dp[i]
            maxStr = s.substring(i - dp[i], i + dp[i] + 1).replace("#".toRegex(), "")
        }
    }

    return maxStr
}

/**
 * 347. Top K Frequent Elements
 * Alt Solution
 */

fun topKFrequentAlt(nums: IntArray, k: Int): IntArray {
    val frequencyMap = nums.toList().groupingBy { it }.eachCount()
    val priorityQueue =
        PriorityQueue<Int>(compareByDescending { frequencyMap[it] })

    priorityQueue.addAll(frequencyMap.keys)

    val result = IntArray(k)
    for (i in 0 until k) {
        result[i] = priorityQueue.poll()
    }

    return result
}

/**
 * 102. Binary Tree Level Order Traversal
 * Alt Solution with Recursion
 */

fun levelOrderAltSolution(root: TreeNode?): List<List<Int>> {
    if (root == null) return listOf()
    val ans = mutableListOf<MutableList<Int>>()
    val q = LinkedList<TreeNode>()
    q.offer(root)
    levelOrderAltBfs(root, q, ans)
    return ans
}

fun levelOrderAltBfs(root: TreeNode?, q: LinkedList<TreeNode>, ans: MutableList<MutableList<Int>>) {
    if (q.isEmpty()) return
    val size = q.size
    val subset = mutableListOf<Int>()
    for (i in 0 until size) {
        val node = q.poll()
        subset.add(node.`val`)
        if (node?.left != null) q.offer(node?.left)
        if (node?.right != null) q.offer(node?.right)
    }
    ans.add(subset)
    levelOrderAltBfs(root, q, ans)
}


/**
 * 264. Ugly Number II
 * Alt Solution with priority queue
 * Time Complexity - O(n * log n)
 * Space Complexity - O(n)
 */

fun nthUglyNumberAltSolution(n: Int): Int {
    val priorityQueue = PriorityQueue<Long>()
    val seen = HashSet<Long>()

    priorityQueue.offer(1L)
    seen.add(1L)

    var currentUgly = 1L
    for (i in 1..n) {
        currentUgly = priorityQueue.poll()
        val nextUglyNumbers = listOf(currentUgly * 2, currentUgly * 3, currentUgly * 5)
        for (nextUgly in nextUglyNumbers) {
            if (!seen.contains(nextUgly)) {
                priorityQueue.offer(nextUgly)
                seen.add(nextUgly)
            }
        }
    }

    return currentUgly.toInt()
}

/**
 * 2490. Circular Sentence
 * Alt Solution
 */

fun isCircularSentenceAltSolution(sentence: String): Boolean {
    val words = sentence.split(" ")
    if (words.size == 1) {
        return words[0].first() == words[0].last()
    }
    for (i in words.indices) {
        val currentWord = words[i]
        val index = (i + 1) % words.size
        val nextWord = words[index] // Circular next word
        if (currentWord.last() != nextWord.first()) {
            return false
        }
    }
    return true
}

/**
 * 49. Group Anagrams
 * Alternative Solution
 */

fun groupAnagramsAltSolution(strs: Array<String>): MutableList<List<String>> {
    val ans: MutableMap<String, MutableList<String>> = HashMap()

    for (s in strs) {
        val count = IntArray(26)

        // Count frequency of each letter in the string
        for (c in s.toCharArray()) {
            count[c.code - 'a'.code]++
        }

        val sb = java.lang.StringBuilder()
        for (num in count) {
            sb.append(num).append("#")
        }
        val key = sb.toString()
        if (!ans.containsKey(key)) {
            ans[key] = ArrayList()
        }
        ans[key]!!.add(s)
    }

    return ArrayList(ans.values)
}

/**
 * 139. Word Break
 */


class TrieNodeWordBreak {
    val children = mutableMapOf<Char, TrieNodeWordBreak>()
    var isWordEnd = false
}

class TrieWordBreak {
    val root = TrieNodeWordBreak()

    fun insert(word: String) {
        var node = root
        for (char in word) {
            node = node.children.getOrPut(char) { TrieNodeWordBreak() }
        }
        node.isWordEnd = true
    }
}

fun wordBreakAltSolution(s: String, wordDict: List<String>): Boolean {
    val trie = TrieWordBreak()
    for (word in wordDict) {
        trie.insert(word)
    }

    return canBreak(0, s, trie)
}

fun canBreak(start: Int, s: String, trie: TrieWordBreak): Boolean {
    if (start == s.length) return true

    var node = trie.root
    for (i in start until s.length) {
        node = node.children[s[i]] ?: return false
        if (node.isWordEnd && canBreak(i + 1, s, trie)) {
            return true
        }
    }

    return false
}

/**
 * 73. Set Matrix Zeroes
 * Alternative Solution
 */

fun setZeroesAltSolution(matrix: Array<IntArray>) {
    val m = matrix.size
    val n = matrix[0].size
    var firstRowZero = false
    var firstColZero = false


    for (i in 0 until m) {
        for (j in 0 until n) {
            if (matrix[i][j] == 0) {
                if (i == 0) firstRowZero = true
                if (j == 0) firstColZero = true
                matrix[i][0] = 0
                matrix[0][j] = 0
            }
        }
    }


    for (i in 1 until m) {
        for (j in 1 until n) {
            if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                matrix[i][j] = 0
            }
        }
    }


    if (firstRowZero) {
        for (j in 0 until n) {
            matrix[0][j] = 0
        }
    }
    if (firstColZero) {
        for (i in 0 until m) {
            matrix[i][0] = 0
        }
    }
}

/**
 * 230. Kth Smallest Element in a BST
 * Alt Solution
 */

fun kthSmallestAltSolution(root: TreeNode?, k: Int): Int {
    if (root?.left == null && root?.right == null) return root?.`val` ?: 0
    val res = mutableListOf<Int>()
    val q = LinkedList<TreeNode>()
    q.offer(root)
    while (q.isNotEmpty()) {
        val size = q.size
        for (i in 0 until size) {
            val node = q.poll()
            res.add(node.`val`)
            node?.left?.let { q.offer(it) }
            node?.right?.let { q.offer(it) }
        }
    }
    res.sort()
    return res[k - 1]
}

/**
 * 3254. Find the Power of K-Size Subarrays I
 * Alt Solution
 */

fun powerOfSubarrays(nums: IntArray, k: Int): IntArray {
    if (nums.isEmpty()) return intArrayOf()
    val n = nums.size
    val results = IntArray(n - k + 1)

    for (i in 0 until n - k + 1) {
        val subarray = nums.copyOfRange(i, i + k)
        results[i] = calculatePower(subarray)
    }

    return results
}

fun calculatePower(subarray: IntArray): Int {
    return if (isConsecutiveAndSorted(subarray)) {
        subarray.last()
    } else {
        -1
    }
}

fun isConsecutiveAndSorted(arr: IntArray): Boolean {
    if (arr.isEmpty()) return true
    for (i in 1 until arr.size) {
        if (arr[i] != arr[i - 1] + 1) {
            return false
        }
    }
    return true
}

/**
 *
 */

fun reverseOddLevelsAltSolution(root: TreeNode?): TreeNode? {
    if (root == null) return null

    val queue = ArrayDeque<TreeNode>()
    queue.add(root)
    var level = 0

    while (queue.isNotEmpty()) {
        level++
        val levelSize = queue.size
        val levelNodes = mutableListOf<TreeNode>()

        for (i in 0 until levelSize) {
            val node = queue.removeFirst()
            levelNodes.add(node)

            if (node.left != null) {
                queue.add(node.left!!)
            }
            if (node.right != null) {
                queue.add(node.right!!)
            }
        }

        if (level % 2 != 0) {
            reverseLevelNodes(levelNodes)

            for (i in 0 until levelSize) {
                val node = levelNodes[i]
                if (node.left != null && node.right != null) {
                    val temp = node.left!!.`val`
                    node.left!!.`val` = node.right!!.`val`
                    node.right!!.`val` = temp
                }
            }
        }
    }

    return root
}

private fun reverseLevelNodes(nodes: MutableList<TreeNode>) {
    var left = 0
    var right = nodes.size - 1

    while (left < right) {
        val temp = nodes[left]
        nodes[left] = nodes[right]
        nodes[right] = temp
        left++
        right--
    }
}

/**
 * 78. Subsets
 * Alternative Solution using Loop
 */

fun subsetsAltSolution(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    result.add(emptyList())

    for (num in nums) {
        val newSubsets = mutableListOf<List<Int>>()
        for (subset in result) {
            val newSubset = subset.toMutableList()
            newSubset.add(num)
            newSubsets.add(newSubset)
        }
        result.addAll(newSubsets)
    }

    return result
}

/**
 * 3163. String Compression III
 * Alternative Solution
 */

fun compressAltSolution(chars: CharArray): String {
    val sb = StringBuilder()
    var i = 0
    while (i < chars.size) {
        var j = i
        while (j < chars.size && chars[j] == chars[i]) {
            j++
        }
        sb.append(chars[i])
        if (j - i > 1) {
            sb.append(j - i)
        }
        i = j
    }
    return sb.toString()
}

/**
 * 1448. Count Good Nodes in Binary Tree
 * Alternative Solution
 */

fun goodNodesAltSolution(root: TreeNode?): Int {
    if (root == null) return 0

    var goodNodesCount = 0
    val queue: Queue<Pair<TreeNode, Int>> = LinkedList()
    queue.offer(Pair(root, root.`val`)) // Initial max value is root's value

    while (queue.isNotEmpty()) {
        val (node, maxSoFar) = queue.poll()

        if (node.`val` >= maxSoFar) {
            goodNodesCount++
        }

        if (node.left != null) {
            queue.offer(Pair(node.left!!, maxOf(maxSoFar, node.left!!.`val`)))
        }

        if (node.right != null) {
            queue.offer(Pair(node.right!!, maxOf(maxSoFar, node.right!!.`val`)))
        }
    }

    return goodNodesCount
}

/**
 * 515. Find Largest Value in Each Tree Row
 * dfs - approach
 */

fun largestValueAltSolution(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    dfs(root, result, 0)
    return result
}

private fun dfs(node: TreeNode?, result: MutableList<Int>, level: Int) {
    if (node == null) return

    if (level == result.size) {
        result.add(node.`val`)
    } else {
        result[level] = maxOf(result[level], node.`val`)
    }

    dfs(node.left, result, level + 1)
    dfs(node.right, result, level + 1)
}

/**
 * 513. Find Bottom Left Tree Value
 * dfs - approach
 */

fun findBottomLeftValueAltSolution(root: TreeNode?): Int {
    var maxDepth = -1
    var value = 0

    fun dfs(root: TreeNode?, depth: Int) {
        if (root == null) return

        if (depth > maxDepth) {
            maxDepth = depth
            value = root?.`val` ?: 0
        }

        dfs(root?.left, depth + 1)
        dfs(root?.right, depth + 1)
    }
    dfs(root, 0)
    return value
}

/**
 * 378. Kth Smallest Element in a Sorted Matrix
 * Alternative Solution
 * Time - O(n * log n)
 * Space - O(1)
 */


fun kthSmallestAltSolution(matrix: Array<IntArray>, k: Int): Int {
    val n = matrix.size
    var low = matrix[0][0]
    var high = matrix[n - 1][n - 1]

    while (low < high) {
        val mid = low + (high - low) / 2
        val count = countLessOrEqual(matrix, mid)

        if (count < k) {
            low = mid + 1
        } else {
            high = mid
        }
    }

    return low
}

private fun countLessOrEqual(matrix: Array<IntArray>, target: Int): Int {
    val n = matrix.size
    var count = 0
    var row = n - 1
    var col = 0

    while (row >= 0 && col < n) {
        if (matrix[row][col] <= target) {
            count += row + 1
            col++
        } else {
            row--
        }
    }

    return count
}

/**
 * 240. Search a 2D Matrix II
 * Alternative Solution
 * Time - O(m + n)
 * Space - O(1)
 */

fun searchMatrix(matrix: Array<IntArray>?, target: Int): Boolean {
    if (matrix.isNullOrEmpty() || matrix[0].isEmpty()) {
        return false
    }
    var col = matrix[0].size - 1
    var row = 0
    while (col >= 0 && row <= matrix.size - 1) {
        if (target == matrix[row][col]) {
            return true
        } else if (target < matrix[row][col]) {
            col--
        } else if (target > matrix[row][col]) {
            row++
        }
    }
    return false
}

/**
 * 538. Convert BST to Greater Tree
 * Alternative Solution
 * Using Pair
 */

fun convertBSTAltSolution(root: TreeNode?): TreeNode? {
    return convertBSTRecursive(root, 0).first
}

fun convertBSTRecursive(root: TreeNode?, sum: Int): Pair<TreeNode?, Int> {
    if (root == null) return null to sum

    val (right, updatedSum) = convertBSTRecursive(root.right, sum)
    val newSum = updatedSum + root.`val`
    root.`val` = newSum
    val (left, finalSum) = convertBSTRecursive(root.left, newSum)

    return root to finalSum
}

/**
 * 404. Sum of Left Leaves
 * Alternative Solution
 * DFS Approach
 */

fun sumOfLeftLeavesAltSolution(root: TreeNode?): Int = dfs(root, false)
tailrec fun dfs(root: TreeNode?, isLeft: Boolean): Int {
    root ?: return 0
    if (root?.left == null && root?.right == null && isLeft) return root.`val`
    return dfs(root?.left, true) + dfs(root?.right, false)
}

/**
 * 623. Add One Row to Tree
 * Alternative Solution
 * DFS Approach
 */

fun addOneRowAltSolution(root: TreeNode?, `val`: Int, depth: Int): TreeNode? {
    if (depth == 1) {
        val new = TreeNode(`val`)
        new?.left = root
        return new
    }
    dfs(root, `val`, depth = depth, calc = 1)
    return root
}

fun dfs(root: TreeNode?, `val`: Int, depth: Int, calc: Int) {
    if (root == null) return

    if (depth - 1 == calc) {
        val l = root?.left
        val r = root?.right
        root?.left = TreeNode(`val`)
        root?.right = TreeNode(`val`)
        root?.left?.left = l
        root?.right?.right = r
    }
    dfs(root?.left, `val`, depth, calc + 1)
    dfs(root?.right, `val`, depth, calc + 1)
}

/**
 * 515. Find Largest Value in Each Tree Row
 * Alternative Solution
 * DFS Approach
 */


fun largestValuesAltSolution(root: TreeNode?): List<Int> {
    root ?: return listOf()
    val res = mutableListOf<Int>()
    fun dfs(root: TreeNode?, level: Int) {
        root ?: return
        if (res.size <= level) res.add(root.`val`)
        else res[level] = maxOf(res[level], root.`val`)
        dfs(root?.left, level + 1)
        dfs(root?.right, level + 1)
    }
    dfs(root, 0)
    return res
}






