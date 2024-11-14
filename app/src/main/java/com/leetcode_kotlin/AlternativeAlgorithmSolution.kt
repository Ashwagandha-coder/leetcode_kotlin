package com.leetcode_kotlin

import android.annotation.SuppressLint
import java.util.Arrays
import java.util.LinkedList
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






