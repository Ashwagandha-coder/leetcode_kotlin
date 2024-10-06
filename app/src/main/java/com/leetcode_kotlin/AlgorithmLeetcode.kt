package com.leetcode_kotlin

import java.util.Arrays
import kotlin.math.abs
import kotlin.math.max


/**
 * 3190. Find Minimum Operations to Make All Elements Divisible by Three
 */

fun minimumOperations(nums: IntArray): Int {
    var res = 0

    for (n in nums) {
        if (n % 3 > 0) res++
    }

    return res
}


/**
 * 2011. Final Value of Variable After Performing Operations
 */


fun finalValueAfterOperations(opr: Array<String>): Int {
    var res = 0
    for (i in opr) {
        if (i.contains("-")) res -= 1
        else res += 1
    }
    return res
}

/**
 * 1512. Number of Good Pairs
 */

fun numIdenticalPairs(nums: IntArray): Int {
    val counts = mutableMapOf<Int, Int>()
    var ans = 0
    for (num in nums) {
        if (counts.contains(num)) ans += counts[num]!!
        counts[num] = (counts[num] ?: 0) + 1
    }
    return ans
}


/**
 * 217. Contains Duplicate
 */

fun containsDuplicate(nums: IntArray): Boolean {
    var count = 1
    val map = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
        if (map.contains(nums[i])) return true
        else {
            map.put(nums[i], 1)
        }
    }
    return false
}

/**
 * 268. Missing Number
 */


fun missingNumber(nums: IntArray): Int {
    val length = nums.size
    var sum = 0
    for (i in nums) {
        sum += i
    }
    return length * (length + 1) / 2 - sum
}

/**
 * 448. Find All Numbers Disappeared in an Array
 */

fun findDisappearedNumbers(nums: IntArray): List<Int> {
    val arr = mutableListOf<Int>()
    val set = mutableSetOf<Int>()
    for (i in nums) set.add(i)
    for (i in 1..nums.size) {
        if (!set.contains(i)) {
            arr.add(i)
        }
    }
    return arr
}

/**
 * 136. Single Number
 */

fun singleNumber(nums: IntArray): Int {
    var res = 0
    for (i in nums) res = res xor i
    return res
}

/**
 * 121. Best Time to Buy and Sell Stock
 */


fun maxProfit(prices: IntArray): Int {
    var profit = Int.MIN_VALUE
    var min = Int.MAX_VALUE
    for (i in prices.indices) {
        if (prices[i] < min) min = prices[i]
        if (prices[i] - min > profit) profit = prices[i] - min
    }
    return profit
}

/**
 * Selection Sort
 */

fun selectionSort(array: IntArray): IntArray {
    var min = Int.MAX_VALUE
    var ind = 0
    var temp = 0
    var j = 0
    while (j <= array.size - 1) {
        for (i in j until array.size) {
            if (array[i] < min) {
                min = array[i]
                ind = i
            }
        }
        temp = array[j]
        array[j] = min
        array[ind] = temp
        j++
        min = Int.MAX_VALUE
    }
    return array
}

/**
 *  Insertion Sort
 */

fun insertionSort(array: IntArray): IntArray {
    for (i in 1 until array.size) {
        var sorted = i - 1
        while (sorted > -1 && array[sorted] > array[sorted + 1]) {
            var temp = array[sorted]
            array[sorted] = array[sorted + 1]
            array[sorted + 1] = temp
            sorted--
        }
    }
    return array
}


/**
 * Fibonaci
 */


fun tabulation(param: Int): Int? {
    val cache: Array<Int?> = arrayOfNulls(param + 1)
    cache[0] = 0
    cache[1] = 1
    for (i in 2..param) {
        cache[i] = cache[i - 2]!! + cache[i - 1]!!
    }
    return cache[param]
}


fun memoization(param: Int): Int {
    val cache = IntArray(param + 1)
    return fib(param, cache)
}

fun fib(param: Int, array: IntArray): Int {
    if (param == 0) return 0
    if (param == 1) return 1
    if (array[param] == 0) {
        var a = fib(param - 2, array)
        var b = fib(param - 1, array)
        array[param] = a + b
    }
    return array[param]
}


/**
 * 303. Range Sum Query - Immutable
 */


class NumArray(val nums: IntArray) {

    fun sumRange(left: Int, right: Int): Int {
        var sum = 0
        var l = left
        var r = right
        while (l <= r) {
            sum += nums[l]
            l++
        }
        return sum
    }

}


/**
 * 338. Counting Bits
 */

fun countBits(n: Int): IntArray {
    val nums = IntArray(n + 1)
    if (n == 0) return nums
    if (n == 1) {
        nums[1] = 1
        return nums
    }
    nums[1] = 1
    var res = 0
    for (i in 2..nums.size - 1) {
        var ind = i
        while (ind > 0) {
            res += ind and 1
            ind /= 2
        }
        nums[i] = res
        res = 0
    }
    return nums
}

/**
 * 141. Linked List Cycle
 */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


fun hasCycle(head: ListNode?): Boolean {
    var slow = head
    var fast = head?.next
    while (slow != null && fast != null) {
        slow = slow?.next
        fast = fast?.next?.next
        if (slow === fast) {
            return true
        }
    }
    return false
}

/**
 *  876. Middle of the Linked List
 */

fun middleNode(head: ListNode?): ListNode? {
    var slow = head
    var fast = head?.next
    while (fast != null) {
        slow = slow?.next
        fast = fast?.next?.next
    }
    return slow
}

/**
 * 206. Reverse Linked List
 */

fun reverseList(head: ListNode?): ListNode? {
    var curr: ListNode? = head
    var next: ListNode? = null
    var prev: ListNode? = null

    while (curr != null) {
        next = curr?.next

        curr?.next = prev

        prev = curr
        curr = next
    }
    return prev
}


/**
 * 234. Palindrome Linked List
 */

fun isPalindrome(head: ListNode?): Boolean {
    if (head == null) return true

    var slow = head
    var fast = head?.next
    var count = 0
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast?.next?.next
        count++
    }
    var temp: ListNode? = null
    temp = reverse(slow?.next)
    var res = head
    while (temp != null) {
        if (res?.`val` != temp?.`val`) {
            return false
        }
        temp = temp?.next
        res = res?.next
    }
    return true
}

fun reverse(head: ListNode?): ListNode? {
    var curr: ListNode? = head
    var next: ListNode? = null
    var prev: ListNode? = null
    while (curr != null) {
        next = curr?.next
        curr?.next = prev

        prev = curr
        curr = next
    }
    return prev
}


/**
 * 83. Remove Duplicates from Sorted List
 */


fun deleteDuplicates(head: ListNode?): ListNode? {
    // 1 1 1 2 2 2 3 4 -> 1 2 3 4
    var temp: ListNode? = ListNode(101)
    var curr = temp
    temp?.next = head
    while (curr?.next != null) {
        if (curr?.`val` == curr?.next?.`val`) {
            curr?.next = curr?.next?.next
        } else curr = curr?.next
    }
    return temp?.next
}

/**
 * 21. Merge Two Sorted Lists
 */

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    val result = ListNode(0)
    var l1 = list1
    var l2 = list2
    var current = result

    while (l1 != null && l2 != null) {
        if (l1.`val` < l2.`val`) {
            current.next = l1
            l1 = l1.next
        } else {
            current.next = l2
            l2 = l2.next
        }
        current = current.next!!
    }

    if (l1 != null) current.next = l1
    if (l2 != null) current.next = l2

    return result.next
}

/**
 * 744. Find Smallest Letter Greater Than Target
 */


fun nextGreatestLetter(letters: CharArray, target: Char): Char {
    var tar = target - '0'
    for (i in 0..letters.size - 1) {
        if (tar < (letters[i] - '0')) return letters[i]
    }
    return letters[0]
}


/**
 * O(log n)
 */


fun nextGreatestLetterLogN(letters: CharArray, target: Char): Char {
    val len = letters.size
    var middle = 0
    var left = 0
    var right = len - 1
    while (left != right) {
        middle = (left + right) / 2
        if (letters[middle] <= target) {
            left = middle + 1
        } else {
            right = middle
        }
    }
    if (letters[left] <= target) return letters[0]
    return letters[left]
}

/**
 * BFS - Breath First Search
 * Time - O(n)  Space - O(n)
 */


fun bfs(root: MyTreeNode?): Int {
    if (root == null) return 0
    var maxLeftTree = bfs(root?.left)
    var maxRightTree = bfs(root?.right)

    return max(maxLeftTree, maxRightTree) + root.`val`
}

/**
 * Quick Sort
 */


fun partOfSortHoara(arr: IntArray, start: Int, end: Int): Int {
    val pivot = arr[(start + end) / 2]
    var left = start
    var right = end
    while (left <= right) {
        while (arr[left] < pivot) left++
        while (arr[right] > pivot) right--

        if (left <= right) {

            var temp = arr[left]
            arr[left] = arr[right]
            arr[right] = temp
            left++
            right--
        }
    }
    return left
}

fun quickSort(arr: IntArray, start: Int, end: Int) {
    if (start >= end) return
    var wall = partOfSortHoara(arr, start, end)
    quickSort(arr, start, wall - 1)
    quickSort(arr, start + 1, end)
}

fun wrap(arr: IntArray, start: Int, end: Int): IntArray {
    quickSort(arr, start, end)
    return arr
}

/**
 * 238. Product of Array Except Self - Brute Force
 */


fun productExceptSelfBruteForce(arr: IntArray): IntArray {
    var n = arr.size
    val ans = IntArray(n)
    var prod = 1
    for (i in arr.indices) {
        prod = 1
        for (j in arr.indices) {
            if (i != j) {
                prod *= arr[j]
            }
        }
        ans[i] = prod
    }
    return ans
}


/**
 * 238. Product of Array Except Self - Prefix
 * Time - O(n) Space - O(n)
 */


fun productExceptSelfPrefix(nums: IntArray): IntArray {
    val n = nums.size
    val pre = IntArray(n)
    val suff = IntArray(n)
    pre[0] = 1
    suff[n - 1] = 1

    for (i in 1 until n) {
        pre[i] = pre[i - 1] * nums[i - 1]
    }
    for (i in n - 2..0) {
        suff[i] = suff[i + 1] * nums[i + 1]
    }

    val ans = IntArray(n)
    for (i in 0 until n) {
        ans[i] = pre[i] * suff[i]
    }
    return ans
}

fun productExceptSelfPrefixOptimization(nums: IntArray): IntArray {
    val n = nums.size
    val ans = IntArray(n)
    Arrays.fill(ans, 1)
    var curr = 1
    for (i in 0 until n) {
        ans[i] *= curr
        curr *= nums[i]
    }
    curr = 1
    for (i in n - 1 downTo 0) {
        ans[i] *= curr
        curr *= nums[i]
    }
    return ans
}

/**
 * 287. Find the Duplicate Number
 */


fun findDuplicate(nums: IntArray): Int {
    var len = nums.size
    for (i in 0 until len) {
        var ind = abs(nums[i])
        if (nums[ind] < 0) return ind
        nums[ind] = -1 * nums[ind]
    }
    return 0
}

/**
 * 442. Find All Duplicates in an Array
 */


fun findDuplicates(nums: IntArray): List<Int> {
    if (nums.size == 1) return listOf()
    var len = nums.size
    val ans = mutableListOf<Int>()
    var ind = 0
    for (i in nums.indices) {
        ind = abs(nums[i])
        if (nums[ind - 1] > 0) {
            nums[ind - 1] *= -1
        } else ans.add(ind)
    }
    return ans
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
    } //we marked the rows and cols with true


    for (i in 0 until m) {
        for (j in 0 until n) {
            if (forRows[i] || forCols[j]) {
                matrix[i][j] = 0
            }
        }
    }
}

/**
 *
 */


fun rotate(matrix: Array<IntArray>) {
    val edgeLength = matrix.size

    var top = 0
    var bottom = edgeLength - 1

    while (top < bottom) {
        for (col in 0 until edgeLength) {
            val temp = matrix[top][col]
            matrix[top][col] = matrix[bottom][col]
            matrix[bottom][col] = temp
        }
        top++
        bottom--
    }

    for (row in 0 until edgeLength) {
        for (col in row + 1 until edgeLength) {
            val temp = matrix[row][col]
            matrix[row][col] = matrix[col][row]
            matrix[col][row] = temp
        }
    }
}

/**
 * 128. Longest Consecutive Sequence
 */

fun longestConsecutive(nums: IntArray): Int {
    val set = mutableSetOf<Int>()
    val len = nums.size
    var longest = 0
    var length = 0
    for (i in 0..len - 1) set.add(nums[i])
    for (i in 0..len - 1) {
        if (!set.contains(nums[i] - 1)) {
            length = 1

            while (set.contains(nums[i] + length)) length++

            longest = max(longest, length)
        }

    }
    return longest
}

/**
 * 257. Binary Tree Paths
 */


private fun dfs(root: MyTreeNode?, arr: MutableList<String>, sb: String) {
    var sb = sb
    if (root == null) return
    sb = sb + (root.`val`)
    if (root.left == null && root.right == null) arr.add(sb)

    dfs(root.left, arr, "$sb->")
    dfs(root.right, arr, "$sb->")
    return
}


fun binaryTreePaths(root: MyTreeNode?): List<String> {
    val arr: MutableList<String> = mutableListOf()
    dfs(root, arr, "")
    return arr
}


/**
 * 784. Letter Case Permutation
 */


private val list = mutableListOf<String>()
private var n = 0
fun letterCasePermutation(s: String): List<String> {
    n = s.length
    rec(s, 0)
    return list
}

fun rec(s: String, index: Int) {
    var sI = StringBuilder(s)
    if (index == n) {
        list.add(sI.toString())
        return
    }
    if (sI[index].isDigit()) {
        rec(sI.toString(), index + 1)
        return
    }
    sI[index] = sI[index].toUpperCase()
    rec(sI.toString(), index + 1)

    sI[index] = sI[index].toLowerCase()
    rec(sI.toString(), index + 1)
}


/**
 * 198. House Robber
 */

fun rob(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    if (nums.size == 1) return nums[0]
    val len = nums.size
    val dp = IntArray(len)
    dp[0] = nums[0]
    dp[1] = max(nums[0], nums[1])
    for (i in 2..len - 1) {
        dp[i] = max(nums[i] + dp[i - 2], dp[i - 1])
    }
    return dp[len - 1]
}

/**
 * 78. Subsets
 */


fun subsets(nums: IntArray): List<List<Int>> {
    val res: MutableList<List<Int>> = ArrayList()
    val subset: MutableList<Int> = ArrayList()

    createSubset(nums, 0, res, subset)
    return res
}

private fun createSubset(
    nums: IntArray,
    index: Int,
    res: MutableList<List<Int>>,
    subset: MutableList<Int>
) {
    if (index == nums.size) {
        res.add(ArrayList(subset))
        return
    }

    subset.add(nums[index])
    createSubset(nums, index + 1, res, subset)

    subset.removeAt(subset.size - 1)
    createSubset(nums, index + 1, res, subset)
    return
}

/**
 * 46. Permutations
 */


fun permute(nums: IntArray): MutableList<List<Int>> {
    val res: MutableList<List<Int>> = ArrayList()
    backtrack(res, ArrayList(), nums)
    return res
}

private fun backtrack(res: MutableList<List<Int>>, tempList: MutableList<Int>, nums: IntArray) {
    if (tempList.size == nums.size) {
        res.add(ArrayList(tempList))
        return
    } else {
        for (i in nums.indices) {
            if (!tempList.contains(nums[i])) {  // element already exists, skip
                tempList.add(nums[i])
                backtrack(res, tempList, nums)
                tempList.removeAt(tempList.size - 1)
            }
        }
        return
    }
}

/**
 * 77. Combinations
 */


fun combine(n: Int, k: Int): List<List<Int>> {
    val result: MutableList<List<Int>> = ArrayList()
    backtrack(result, ArrayList(), 1, n, k)
    return result
}

private fun backtrack(
    result: MutableList<List<Int>>,
    tempList: MutableList<Int>,
    start: Int,
    n: Int,
    k: Int
) {
    // If the combination is done (i.e., we've picked k numbers)
    if (tempList.size == k) {
        result.add(ArrayList(tempList)) // Add a copy of the current combination to the result list
        return
    }


    // Try all numbers from 'start' to 'n'
    for (i in start..n) {
        tempList.add(i) // Pick the number
        backtrack(result, tempList, i + 1, n, k) // Recursively pick the next number
        tempList.removeAt(tempList.size - 1) // Remove the last picked number to try another possibility
    }
    return
}

/**
 * 39. Combination Sum
 */


fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val res: MutableList<List<Int>> = ArrayList()

    makeCombination(candidates, target, 0, ArrayList(), 0, res)
    return res
}

private fun makeCombination(
    candidates: IntArray,
    target: Int,
    idx: Int,
    comb: MutableList<Int>,
    total: Int,
    res: MutableList<List<Int>>
) {
    if (total == target) {
        res.add(ArrayList(comb))
        return
    }

    if (total > target || idx >= candidates.size) {
        return
    }

    comb.add(candidates[idx])
    makeCombination(candidates, target, idx, comb, total + candidates[idx], res)
    comb.removeAt(comb.size - 1)
    makeCombination(candidates, target, idx + 1, comb, total, res)
}

/**
 * Combinations Sum II
 */


fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    val res: MutableSet<MutableList<Int>> = mutableSetOf()
    makeCombination(candidates, 0, 0, target, ArrayList(), res)
    return res.toList()
}

fun makeCombination(
    candidates: IntArray,
    index: Int,
    total: Int,
    target: Int,
    subset: MutableList<Int>,
    res: MutableSet<MutableList<Int>>
) {
    if (total == target) {
        res.add(ArrayList(subset))
        return
    }

    if (total > target || index >= candidates.size) return

    subset.add(candidates[index])
    makeCombination(candidates, index + 1, total + candidates[index], target, subset, res)

    subset.removeAt(subset.size - 1)
    makeCombination(candidates, index + 1, total, target, subset, res)
    return
}

/**
 * 90. Subsets II
 */

fun subsetsWithDup(nums: IntArray): List<List<Int>> {
    val n = nums.size
    val ans: MutableList<List<Int>> = ArrayList()
    val set: MutableList<Int> = ArrayList()
    Arrays.sort(nums)

    backtrack(nums, n, ans, set, 0)
    return ans
}

private fun backtrack(
    nums: IntArray,
    n: Int,
    ans: MutableList<List<Int>>,
    set: MutableList<Int>,
    idx: Int
) {
    var index = idx
    if (index == nums.size) {
        ans.add(ArrayList(set))
        return
    }

    set.add(nums[index])
    backtrack(nums, n, ans, set, index + 1)
    set.removeAt(set.size - 1)

    while (index + 1 < nums.size && nums[index] == nums[index + 1]) {
        index++
    }
    backtrack(nums, n, ans, set, index + 1)
    return
}


/**
 *  22. Generate Parentheses
 */

fun generateParenthesis(n: Int): MutableList<String> {
    val res: MutableList<String> = ArrayList()
    dfs(0, 0, "", n, res)
    return res
}

private fun dfs(openP: Int, closeP: Int, s: String, n: Int, res: MutableList<String>) {
    if (openP == closeP && openP + closeP == n * 2) {
        res.add(s)
        return
    }

    if (openP < n) {
        dfs(openP + 1, closeP, "$s(", n, res)
    }

    if (closeP < openP) {
        dfs(openP, closeP + 1, "$s)", n, res)
    }
    return
}

/**
 * 213. House Robber II
 */

fun robII(nums: IntArray): Int {
    if (nums.size == 1) return nums[0]
    val len = nums.size
    return max(maxRob(nums, 0, nums.size - 2), maxRob(nums, 1, nums.size - 1))
}

fun maxRob(nums: IntArray, start: Int, end: Int): Int {
    var prevRob = 0
    var maxRob = 0
    for (i in start..end) {
        var temp = max(maxRob, prevRob + nums[i])
        prevRob = maxRob
        maxRob = temp
    }
    return maxRob
}

/**
 * 14. Longest Common Prefix
 */

fun longestCommonPrefix(strs: Array<String>?): String {
    if (strs.isNullOrEmpty()) return ""

    var pref = strs[0]
    var prefLen = pref.length

    for (i in 1 until strs.size) {
        val s = strs[i]
        while (prefLen > s.length || pref != s.substring(0, prefLen)) {
            prefLen--
            if (prefLen == 0) {
                return ""
            }
            pref = pref.substring(0, prefLen)
        }
    }

    return pref
}

/**
 * 53. Maximum Subarray
 */

fun maxSubArray(nums: IntArray): Int {
    var res = nums[0]
    var total = 0
    val len = nums.size
    for (i in 0..len - 1) {
        if (total < 0) total = 0
        total += nums[i]
        res = max(res, total)
    }
    return res
}


/**
 *  220. Contains Duplicate III
 */


fun containsNearbyAlmostDuplicateIII(nums: IntArray, indexDiff: Int, valueDiff: Int): Boolean {
    val len = nums.size
    val map = mutableMapOf<Int, Int>()
    for (i in 0 until len) {
        if (map.contains(nums[i])) {
            var j = map[nums[i]]
            if (i != j) return true
            if (abs(i - j!!) <= indexDiff) return true
            if (abs(nums[i] - nums[j]!!) <= valueDiff) return true
        }
        map[nums[i]] = i
    }
    return false
}
/*
0 -> 0 - 4
1 -> 4 - 8
2 -> 8 - 11
 */


fun getKey(value: Int, base: Int): Int {
    return if (value > -1) value / (base + 1) else (value - base) / (base + 1)
}

// [8,0,2,4
fun containsNearbyAlmostDuplicate(nums: IntArray, indexDiff: Int, valueDiff: Int): Boolean {
    var j = 0
    val map = mutableMapOf<Int, Int>()

    while (j < nums.size) {
        val key = getKey(nums[j], valueDiff)
        if (map[key] != null) return true
        if (map[key - 1] != null && abs(map[key - 1]!! - nums[j]) <= valueDiff) return true
        if (map[key + 1] != null && abs(map[key + 1]!! - nums[j]) <= valueDiff) return true
        map[key] = nums[j]

        if (j >= indexDiff) {
            map.remove(getKey(nums[j - indexDiff], valueDiff))
        }
        j++
    }
    return false
}

/**
 *
 */

fun totalWays(nums: IntArray, target: Int, index: Int): Int {
    /** Base condition : At 0th index  */
    if (index == 0) {
        var ways = 0
        /** Need to consider both of these conditions separately,
         * Since, for nums[index]=0, both of the condition will satisfy
         * Hence it need to be counted twice  */
        if ((target - nums[index] == 0)) ways++
        if (target + nums[index] == 0) ways++

        return ways
    }

    val addition = totalWays(nums, target + nums[index], index - 1)
    val subtraction = totalWays(nums, target - nums[index], index - 1)

    return addition + subtraction
}

fun findTargetSumWays(nums: IntArray, target: Int): Int {
    val n = nums.size
    return totalWays(nums, target, n - 1)
}


/**
 * 219. Contains Duplicate II
 */

fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    val len = nums.size
    val map = mutableMapOf<Int, Int>()
    for (i in 0 until len) {
        if (map.contains(nums[i])) {
            var j = map[nums[i]]
            if (abs(i - j!!) <= k) return true
        }
        map[nums[i]] = i
    }
    return false
}

/**
 *
 */


fun String.isPalindrome(start: Int, end: Int): Boolean {
    var start = start
    var end = end
    while (start < end) {
        if (this[start] != this[end]) {
            return false
        }
        start++
        end--
    }
    return true
}


fun partitionHelper(
    start: Int,
    s: String,
    list: MutableList<List<String>?>,
    current: MutableList<String>
) {
    if (start == s.length) {
        list.add(ArrayList(current))
        return
    }

    for (end in start until s.length) {
        if (s.isPalindrome(start, end)) {
            current.add(s.substring(start, end + 1))
            partitionHelper(end + 1, s, list, current)
            current.removeAt(current.size - 1)
        }
    }
    return
}

fun partition(s: String): List<List<String>?> {
    val list: MutableList<List<String>?> = ArrayList()
    partitionHelper(0, s, list, ArrayList())
    return list
}

/**
 * 1876. Substrings of Size Three with Distinct Characters
 */

fun countGoodSubstrings(s: String): Int {
    val len = s.length
    var res = 0
    for (i in 0 until len - 2) {
        if (s[i] != s[i + 1] && s[i + 1] != s[i + 2] && s[i] != s[i + 2]) res++
    }
    return res
}

/**
 * 47. Permutations II
 */

var N: Int = 0
var res: MutableList<List<Int>>? = null

fun permuteUnique(nums: IntArray): List<List<Int>> {
    res = ArrayList() // List to store all unique permutations
    N = nums.size // Length of the input array
    Arrays.sort(nums) // Sort the array to handle duplicates
    helper(nums, ArrayList(), ArrayList()) // Start backtracking
    return res as ArrayList<List<Int>> // Return the list of unique permutations
}

fun helper(nums: IntArray, curr: MutableList<Int>, consumed: MutableList<Int?>) {
    // Base case: if the size of current list equals the length of nums array, a unique permutation is formed
    if (curr.size == N) {
        res!!.add(ArrayList(curr)) // Add a copy of current list to result list
        return
    }

    // Recursive case: iterate through each index in nums
    var i = 0
    while (i < N) {
        if (!consumed.contains(i)) { // Skip if the index is already consumed
            curr.add(nums[i]) // Add the element to current list
            consumed.add(i) // Mark the index as consumed
            helper(nums, curr, consumed) // Recursively call helper to explore further permutations
            curr.removeAt(curr.size - 1) // Backtrack by removing the last added element
            consumed.removeAt(consumed.size - 1) // Remove the index from consumed list


            // Skip duplicates
            while (i < N - 1 && nums[i] == nums[i + 1]) {
                i++
            }
        }
        i++
    }
    return
}

/**
 * 643. Maximum Average Subarray I
 */

fun findMaxAverage(nums: IntArray, k: Int): Double {
    var max = Double.NEGATIVE_INFINITY
    var w_sum = 0.0
    val n = nums.size
    var start = 0

    for (i in 0 until n) {
        w_sum += nums[i].toDouble()

        if ((i - start + 1) == k) {
            val avg = w_sum / k
            max = max(avg, max)
            w_sum -= nums[start].toDouble()
            start += 1
        }
    }

    return max
}








































