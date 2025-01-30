package com.leetcode_kotlin

import android.os.Build
import android.support.annotation.RequiresApi
import java.util.Arrays
import java.util.Collections
import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min


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
 * Classical Fibbonaci
 */


fun classicalFib(n: Int): Int {
    if (n == 0 || n == 1) return n
    var a = classicalFib(n - 1)
    var b = classicalFib(n - 2)
    return a + b
}


/**
 * Optimization Fibonaci
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
    cache[0] = 0
    cache[1] = 1
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
 * 48. Rotate Image
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


private fun dfs(root: TreeNode?, arr: MutableList<String>, sb: String) {
    var sb = sb
    if (root == null) return
    sb = sb + (root.`val`)
    if (root.left == null && root.right == null) arr.add(sb)

    dfs(root.left, arr, "$sb->")
    dfs(root.right, arr, "$sb->")
    return
}


fun binaryTreePaths(root: TreeNode?): List<String> {
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
    nums: IntArray, index: Int, res: MutableList<List<Int>>, subset: MutableList<Int>
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
    result: MutableList<List<Int>>, tempList: MutableList<Int>, start: Int, n: Int, k: Int
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
    nums: IntArray, n: Int, ans: MutableList<List<Int>>, set: MutableList<Int>, idx: Int
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
    for (i in 0 until len) {
        if (total < 0) total = 0
        total += nums[i]
        res = max(res, total)
    }
    return res
}


/**
 *  220. Contains Duplicate III
 */

fun slidingWindow(nums: IntArray, k: Int, valueDiff: Int): Boolean {
    var i = 0
    var j = k
    val n = nums.size
    while (j < n) {
        if (abs((nums[i] - nums[j]).toDouble()) <= valueDiff) return true
        i++
        j++
    }
    return false
}

fun containsNearbyAlmostDuplicate(nums: IntArray, indexDiff: Int, valueDiff: Int): Boolean {
    if (valueDiff == 0) {
        val map = HashMap<Int, Int>()
        for (i in nums.indices) {
            if (map.containsKey(nums[i])) {
                if (abs((map[nums[i]]!! - i).toDouble()) <= indexDiff) return true
            }
            map[nums[i]] = i
        }
        return false
    }
    val j = indexDiff
    val n = nums.size
    var ss = false
    for (k in 1..j) {
        ss = slidingWindow(nums, k, valueDiff)
        if (ss) return true
    }
    return false
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

fun helper(nums: IntArray, subset: MutableList<Int>, indexList: MutableList<Int?>) {
    // Base case: if the size of current list equals the length of nums array, a unique permutation is formed
    if (subset.size == N) {
        res!!.add(ArrayList(subset)) // Add a copy of current list to result list
        return
    }

    // Recursive case: iterate through each index in nums
    var i = 0
    while (i < N) {
        if (!indexList.contains(i)) { // Skip if the index is already consumed
            subset.add(nums[i]) // Add the element to current list
            indexList.add(i) // Mark the index as consumed
            helper(
                nums, subset, indexList
            ) // Recursively call helper to explore further permutations
            subset.removeAt(subset.size - 1) // Backtrack by removing the last added element
            indexList.removeAt(indexList.size - 1) // Remove the index from consumed list


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

/**
 * 386. Lexicographical Numbers
 */


fun lexicalOrder(n: Int): List<Int> {
    if (n == 1) return listOf(1)
    var curr = 1
    val res = mutableListOf<Int>()
    for (i in 1..n) {
        res.add(curr)
        if (curr * 10 <= n) curr *= 10
        else {
            while (curr % 10 == 9 || curr >= n) curr /= 10
            curr++
        }
    }
    return res
}

/**
 * 113.Path Sum II
 */


fun pathSumII(root: TreeNode?, targetSum: Int): List<List<Int>> {
    val result: MutableList<List<Int>> = ArrayList()
    val currentPath: MutableList<Int> = ArrayList()
    dfs(root, targetSum, currentPath, result)
    return result
}

private fun dfs(
    node: TreeNode?, targetSum: Int, currentPath: MutableList<Int>, result: MutableList<List<Int>>
) {
    if (node == null) {
        return
    }

    currentPath.add(node.`val`)

    if (node.left == null && node.right == null && targetSum == node.`val`) {
        result.add(ArrayList(currentPath))
    } else {
        dfs(node.left, targetSum - node.`val`, currentPath, result)
        dfs(node.right, targetSum - node.`val`, currentPath, result)
    }

    currentPath.removeAt(currentPath.size - 1)
    return
}


/**
 * Path Sum
 */

fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    if (root == null) {
        return false
    }

    if (root.left == null && root.right == null) {
        return targetSum == root.`val`
    }

    val leftSum = hasPathSum(root.left, targetSum - root.`val`)
    val rightSum = hasPathSum(root.right, targetSum - root.`val`)

    return leftSum || rightSum
}

/**
 * 226. Invert Binary Tree
 */

fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return null
    invert(root)
    return root
}

fun invert(root: TreeNode?) {
    if (root == null) return
    else {
        val temp = root.left
        root.left = root.right
        root.right = temp
    }
    invert(root.left)
    invert(root.right)
    return
}

/**
 * 2415. Reverse Odd Levels of Binary Tree
 */

fun reverseOdd(left: TreeNode?, right: TreeNode?, level: Int) {
    if (left == null || right == null) return

    // Swap nodes' values at odd levels
    if (level % 2 != 0) {
        val temp = left.`val`
        left.`val` = right.`val`
        right.`val` = temp
    }


    // Recursive calls for the next level
    reverseOdd(left.left, right.right, level + 1)
    reverseOdd(left.right, right.left, level + 1)
}

fun reverseOddLevels(root: TreeNode?): TreeNode? {
    if (root == null) return null
    reverseOdd(root.left, root.right, 1)
    return root
}

/**
 * 142. Linked List Cycle II
 */


fun detectCycle(head: ListNode?): ListNode? {
    var head = head
    var slow = head
    var fast = head
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast?.next?.next
        if (slow === fast) {
            while (fast != head) {
                head = head?.next
                fast = fast?.next
            }
            return head
        }
    }
    return null
}

/**
 * 100. Same Tree
 */


fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null) {
        return true
    }

    if (p != null && q != null && p.`val` == q.`val`) {
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }

    return false
}


/**
 * 101. Symmetric Tree
 */


fun isSymmetric(root: TreeNode?): Boolean {
    return dfs(root?.left, root?.right)
}

fun dfs(left: TreeNode?, right: TreeNode?): Boolean {
    var leftVal = left?.`val`
    var rightVal = right?.`val`

    if (leftVal != rightVal) return false

    if (left != null && right != null) {
        return dfs(left.left, right.right) && dfs(left.right, right.left)
    }

    return true
}

/**
 * 104. Maximum Depth of Binary Tree
 */


fun maxDepth(root: TreeNode?): Int {
    return dfs(root, 0)
}

fun dfs(root: TreeNode?, depth: Int): Int {
    if (root == null) return depth

    val l = dfs(root.left, depth + 1)
    val r = dfs(root.right, depth + 1)
    if (l > r) return l
    return r
}

/**
 * 122. Best Time to Buy and Sell Stock II
 */


fun maxProfitII(prices: IntArray): Int {
    var profit = 0

    for (i in 1 until prices.size) {
        if (prices[i] > prices[i - 1]) {
            profit += prices[i] - prices[i - 1]
        }
    }

    return profit
}

/**
 * 131. Palindrome Partitioning
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
    start: Int, s: String, list: MutableList<List<String>?>, current: MutableList<String>
) {
    if (start == s.length) {
        list.add(ArrayList(current))
        return
    }

    for (j in start until s.length) {
        if (s.isPalindrome(start, j)) {
            current.add(s.substring(start, j + 1))
            partitionHelper(j + 1, s, list, current)
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
 * 1448. Count Good Nodes in Binary Tree
 */


fun goodNodes(root: TreeNode?): Int {
    return dfsGoodNodes(root, Int.MIN_VALUE)
}

fun dfsGoodNodes(root: TreeNode?, max: Int): Int {
    if (root == null) return 0
    var temp = 0
    var value = root?.`val`
    if (value!! >= max) temp++
    var new = max(max, value!!)
    val l = dfsGoodNodes(root?.left, new) + temp
    val r = dfsGoodNodes(root?.right, new)
    return l + r
}

/**
 * 216. Combination Sum III
 */


fun combinationSum3(k: Int, n: Int): List<List<Int>> {
    val res = mutableListOf<MutableList<Int>>()
    if (n == 1) return res
    val subset = mutableListOf<Int>()
    backtrack(k, n, 1, subset, res)
    return res
}

fun backtrack(
    k: Int, n: Int, index: Int, subset: MutableList<Int>, res: MutableList<MutableList<Int>>
) {
    if (n < 0) return
    if (subset.size == k && n == 0) {
        res.add(ArrayList(subset))
        return
    }
    for (i in index..9) {
        if (!subset.contains(i)) {
            subset.add(i)
            backtrack(k, n - i, index + 1, subset, res)
            subset.removeAt(subset.size - 1)
        } else return
    }
    return
}

/**
 * 17. Letter Combinations of a Phone Number
 */


fun letterCombinations(digits: String): List<String> {
    val map = mutableMapOf<Char, String>()
    map['2'] = "abc";
    map['3'] = "def";
    map['4'] = "ghi";
    map['5'] = "jkl";
    map['6'] = "mno";
    map['7'] = "pqrs";
    map['8'] = "tuv";
    map['9'] = "wxyz";
    val res = mutableListOf<String>()
    backtracking(digits, 0, StringBuilder(), res, map)
    return res
}

fun backtracking(
    digits: String,
    index: Int,
    subset: StringBuilder,
    res: MutableList<String>,
    numbers: Map<Char, String>
) {
    if (index == digits.length) {
        res.add(subset.toString())
        return
    }
    val letter = numbers[digits[index]]
    for (let in 0 until (letter?.length ?: 2)) {
        subset.append(letter?.get(let) ?: "")
        backtracking(digits, index + 1, subset, res, numbers)
        subset.deleteCharAt(subset.length - 1)
    }
}

/**
 * 51. N-Queens
 * Time - O(n!)
 * Space - O(n)
 */

// . . . .
// .
// .
// .

// n = 4
fun solveNQueens(n: Int): List<List<String>> {
    val solutions = mutableListOf<MutableList<String>>()
    val board = Array(n) { CharArray(n) { '.' } }

    backtracking(0, n, solutions, board)
    return solutions
}


fun backtracking(
    row: Int, n: Int, solutions: MutableList<MutableList<String>>, board: Array<CharArray>
) {
    if (row == n) {
        solutions.add(board.map { it.joinToString("") } as MutableList<String>)
        return
    }

    for (col in 0 until n) {
        if (isValid(row, col, board, n)) {
            board[row][col] = 'Q'
            backtracking(row + 1, n, solutions, board)
            board[row][col] = '.'
        }
    }
    return
}

fun isValid(row: Int, col: Int, board: Array<CharArray>, n: Int): Boolean {
    // Проверка по вертикали
    for (i in 0 until row) {
        if (board[i][col] == 'Q') return false
    }
    // по диагонали влево-вверх
    var i = row - 1
    var j = col - 1
    while (i >= 0 && j >= 0) {
        if (board[i][j] == 'Q') return false
        i--
        j--
    }
    // по диагонали вправо-вверх
    i = row - 1
    j = col + 1
    while (i >= 0 && j < n) {
        if (board[i][j] == 'Q') return false
        i--
        j++
    }
    return true // Если все ок
}

/**
 * 52. N-Queens II
 * Time - O(n!)
 * Space - O(n)
 */

fun totalNQueens(n: Int): Int {
    val board = Array(n) { CharArray(n) { '.' } }
    val res = backtracking(0, n, board)
    return res
}

fun backtracking(
    row: Int, n: Int, board: Array<CharArray>
): Int {
    if (row == n) {
        return 1
    }
    var count = 0
    for (col in 0 until n) {
        if (isValidII(row, col, board, n)) {
            board[row][col] = 'Q'
            count += backtracking(row + 1, n, board)
            board[row][col] = '.'
        }
    }
    return count
}

fun isValidII(row: Int, col: Int, board: Array<CharArray>, n: Int): Boolean {
    for (i in 0 until row) {
        if (board[i][col] == 'Q') return false
    }
    var i = row - 1
    var j = col - 1
    while (i >= 0 && j >= 0) {
        if (board[i][j] == 'Q') return false
        i--
        j--
    }

    i = row - 1
    j = col + 1
    while (i >= 0 && j < n) {
        if (board[i][j] == 'Q') return false
        i--
        j++
    }
    return true
}


/**
 * 123. Best Time to Buy and Sell Stock III
 */


fun maxProfitIII(prices: IntArray): Int {
    var buy1 = Int.MAX_VALUE
    var buy2 = Int.MAX_VALUE
    var sell1 = 0
    var sell2 = 0
    val len = prices.size

    for (i in 0 until len) {
        buy1 = min(buy1, prices[i]);
        sell1 = max(sell1, prices[i] - buy1);
        buy2 = min(buy2, prices[i] - sell1);
        sell2 = max(sell2, prices[i] - buy2);
    }

    return sell2;
}

/**
 * 188. Best Time to Buy and Sell Stock IV
 * O(n * k) - Time
 * O(k) - Space
 */

// 7 1 5 3 2 9
// k = 2

fun maxProfitWithKTransactionsOptimized(prices: IntArray, k: Int): Int {
    val n = prices.size
    if (n == 0 || k == 0) {
        return 0 // Нет прибыли, если нет цен или транзакций не разрешены
    }

    // Если k достаточно большое, чтобы позволить покупать и продавать каждый день, используем более простой подход
    if (k >= n / 2) {
        var profit = 0
        for (i in 1 until n) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1]
            }
        }
        return profit
    }

    // Используем оптимизированный по памяти DP
    val buy =
        IntArray(k + 1) { Int.MIN_VALUE } // buy[i] - максимальная прибыль при покупке до i транзакциями
    val profit =
        IntArray(k + 1) { 0 } // sell[i] - максимальная прибыль при продаже до i транзакциями

    for (price in prices) { // Итерируемся по ценам
        for (i in 1..k) { // Итерируемся по количеству транзакций
            buy[i] = maxOf(buy[i], profit[i - 1] - price) // Обновляем buy[i]
            profit[i] = maxOf(profit[i], buy[i] + price) // Обновляем sell[i]
        }
    }

    return profit[k] // Возвращаем максимальную прибыль с k транзакциями
}

/**
 * 307. Range Sum Query - Mutable
 */


class NumArrayII(val nums: IntArray) {

    fun update(index: Int, `val`: Int) {
        val value = `val`
        nums[index] = value
    }

    fun sumRange(left: Int, right: Int): Int {
        var l = left
        var sum = 0
        while (l <= right) {
            sum += nums[l]
            l++
        }
        return sum
    }

}

/**
 * 304. Range Sum Query 2D - Immutable
 */

class NumMatrix(private val matrix: Array<IntArray>) {

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        var top = row1
        var bottom = row2
        var l = col1
        var r = col2
        var sum = 0
        while (top <= bottom) {
            while (l <= r) {
                sum += matrix[top][l]
                l++
            }
            l = col1
            top++
        }
        return sum
    }

}


/**
 * BFS - Breath First Search
 */

class TreeNodeParametrized<T>(val value: T) {
    val children: MutableList<TreeNodeParametrized<T>> = mutableListOf()

}

fun <T> bfs(root: TreeNodeParametrized<T>): List<T> {
    val result = mutableListOf<T>()
    val queue: Queue<TreeNodeParametrized<T>> = LinkedList()

    queue.offer(root)

    while (queue.isNotEmpty()) {
        val node = queue.poll()
        result.add(node.value)

        for (child in node.children) {
            queue.offer(child)
        }
    }

    return result
}

/**
 * 2583. Kth Largest Sum in a Binary Tree
 */


fun kthLargestLevelSum(root: TreeNode?, k: Int): Long {
    val res: MutableList<Long> = ArrayList()
    val q: Queue<TreeNode?> = LinkedList()
    q.add(root)

    while (!q.isEmpty()) {
        val n = q.size
        var sum: Long = 0

        for (i in 0 until n) {
            val node = q.poll()
            sum += node!!.`val`.toLong()

            if (node!!.left != null) q.add(node!!.left)
            if (node!!.right != null) q.add(node!!.right)
        }
        res.add(sum)
    }

    if (k > res.size) return -1

    res.sortWith(Collections.reverseOrder())

    return res[k - 1]
}

/**
 * 2095. Delete the Middle Node of a Linked List
 */

fun deleteMiddle(head: ListNode?): ListNode? {
    if (head?.next == null) return null
    var count = 0
    var p = head
    while (p != null) {
        p = p?.next
        count++
    }
    count /= 2
    p = head
    val cache = p
    while (count - 1 != 0) {
        p = p?.next
        count--
    }
    var temp = p?.next?.next
    p?.next = temp
    return cache
}

/**
 * 37. Sudoku Solver
 * Time - O(9(N∗N))
 * Space - O(N*N)
 */


fun wrapSudoku(board: Array<CharArray>) {
    solveSudoku(board)
}


fun solveSudoku(board: Array<CharArray>): Boolean {
    for (row in 0..8) {
        for (col in 0..8) {
            if (board[row][col] == '.') { // Empty cell is represented by'.'
                for (num in '1'..'9') {
                    if (isValid(board, row, col, num)) {
                        board[row][col] = num

                        if (solveSudoku(board)) {
                            return true
                        } else {
                            board[row][col] = '.' // Backtrack
                        }
                    }
                }
                return false // No valid number found
            }
        }
    }
    return true // Puzzle solved
}

private fun isValid(board: Array<CharArray>, row: Int, col: Int, num: Char): Boolean {
    // Check row
    for (i in 0..8) {
        if (board[row][i] == num) {
            return false
        }
    }

    // Check column
    for (i in 0..8) {
        if (board[i][col] == num) {
            return false
        }
    }

    // Check 3x3 subgrid
    val subgridRowStart = row / 3 * 3
    val subgridColStart = col / 3 * 3
    for (i in subgridRowStart until subgridRowStart + 3) {
        for (j in subgridColStart until subgridColStart + 3) {
            if (board[i][j] == num) {
                return false
            }
        }
    }

    return true // Number is valid
}


/**
 * 322. Coin Change
 */


fun coinChange(coins: IntArray, amount: Int): Int {
    val minCoins = IntArray(amount + 1)
    Arrays.fill(minCoins, amount + 1)
    minCoins[0] = 0

    for (i in 1..amount) {
        for (j in coins.indices) {
            if (i - coins[j] >= 0) {
                minCoins[i] = minOf(minCoins[i], (1 + minCoins[i - coins[j]]))
                // Min(2, 1)
            }
        }
    }

    return if (minCoins[amount] != amount + 1) minCoins[amount] else -1
}


/**
 * 94. Binary Tree Inorder Traversal
 */


fun inorderTraversal(root: TreeNode?): List<Int> {
    val res = mutableListOf<Int>()
    dfs(root, res)
    return res
}

fun dfs(root: TreeNode?, res: MutableList<Int>) {
    if (root == null) return
    dfs(root?.left, res)
    res.add(root.`val`)
    dfs(root?.right, res)
}

/**
 *
 */


fun generateTrees(n: Int): List<TreeNode?> {
    if (n == 0) {
        return ArrayList()
    }

    val memo: MutableMap<String, List<TreeNode?>> = HashMap()

    return generateTreesHelper(1, n, memo)
}

private fun generateTreesHelper(
    start: Int, end: Int, memo: MutableMap<String, List<TreeNode?>>
): List<TreeNode?> {
    val key = "$start-$end"
    if (memo.containsKey(key)) {
        return memo[key]!!
    }

    val trees: MutableList<TreeNode?> = ArrayList()
    if (start > end) {
        trees.add(null)
        return trees
    }

    for (rootVal in start..end) {
        val leftTrees = generateTreesHelper(start, rootVal - 1, memo)
        val rightTrees = generateTreesHelper(rootVal + 1, end, memo)

        for (leftTree in leftTrees) {
            for (rightTree in rightTrees) {
                val root = TreeNode(rootVal)
                root.left = leftTree
                root.right = rightTree
                trees.add(root)
            }
        }
    }

    memo[key] = trees
    return trees
}

/**
 * 98. Validate Binary Search Tree
 */


fun isValidBST(root: TreeNode?): Boolean {
    return valid(root, Long.MIN_VALUE, Long.MAX_VALUE)
}

private fun valid(node: TreeNode?, minimum: Long, maximum: Long): Boolean {
    if (node == null) return true

    if (!(node.`val` > minimum && node.`val` < maximum)) return false

    return valid(node.left, minimum, node.`val`.toLong()) && valid(
        node.right, node.`val`.toLong(), maximum
    )
}

/**
 * 99.Recover Binary Search Tree
 */

/*
    1
   / \
  2   3
 / \   \
4   5   2
 */

fun recoverTree(root: TreeNode?) {
    val state = State() // Создаем объект для хранения состояния
    inorder(root, state)
    // Меняем значения двух переставленных узлов местами
    val temp = state.first!!.`val`
    state.first!!.`val` = state.second!!.`val`
    state.second!!.`val` = temp
}

private fun inorder(root: TreeNode?, state: State) {
    if (root == null) return

    inorder(root.left, state)

    // Проверяем на переставленные узлы
    if (state.prev != null && state.prev!!.`val` > root.`val`) {
        if (state.first == null) {
            state.first = state.prev
        }
        state.second = root
    }
    state.prev = root

    inorder(root.right, state)
}

// Внутренний класс для хранения состояния
private class State {
    var first: TreeNode? = null
    var second: TreeNode? = null
    var prev: TreeNode? = null
}

/**
 * 108. Convert Sorted Array to Binary Search Tree
 */

fun sortedArrayToBST(nums: IntArray): TreeNode? {
    return dfs(nums, 0, nums.size - 1)
}

/*
-10,-3,0,5,9
 */
fun dfs(nums: IntArray, left: Int, right: Int): TreeNode? {
    if (left > right) return null
    var mid = (left + right) / 2
    val root = TreeNode(nums[mid])
    root?.left = dfs(nums, left, mid - 1)
    root?.right = dfs(nums, mid + 1, right)
    return root
}

/**
 * 485. Max Consecutive Ones
 */


fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var count = 0
    var local = 0
    val len = nums.size
    for (i in 0 until len) {
        if (nums[i] == 1) local++
        if (nums[i] == 0) {
            count = max(count, local)
            local = 0
        }
    }
    count = max(count, local)
    return count
}


/**
 * 349. Intersection of Two Arrays
 */

fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val map = mutableMapOf<Int, Int>()
    val res = mutableListOf<Int>()
    val len = nums1.size
    val len2 = nums2.size
    for (i in 0 until len) {
        map[nums1[i]] = i
    }
    for (i in 0 until len2) {
        if (map.contains(nums2[i])) {
            res.add(nums2[i])
            map.remove(nums2[i])
        }
    }
    return res.toIntArray()
}

/**
 * 500. Keyboard Row
 */

fun findWords(words: Array<String>) = words.filter { word ->
    rows.any { it.containsAll(word.lowercase().toList()) }
}.toTypedArray()

private val rows = listOf("qwertyuiop", "asdfghjkl", "zxcvbnm").map { it.toList() }


/**
 * 2. Add Two Numbers
 */

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var l1 = l1
    var l2 = l2
    var dummy: ListNode? = ListNode(0)
    val res = dummy
    var total = 0
    var carry = 0

    while (l1 != null || l2 != null || carry != 0) {
        total = carry

        if (l1 != null) {
            total += l1.`val`
            l1 = l1.next
        }
        if (l2 != null) {
            total += l2.`val`
            l2 = l2.next
        }

        val num = total % 10
        carry = total / 10
        dummy?.next = ListNode(num)
        dummy = dummy?.next
    }

    return res?.next
}

/**
 * 152. Maximum Product Subarray
 */

fun maxProduct(nums: IntArray): Int {
    var max = nums[0]
    var min = nums[0]
    var ans = nums[0]
    val len = nums.size
    for (i in 1 until len) {
        if (nums[i] < 0) {
            var temp = max
            max = min
            min = temp
        }

        max = maxOf(nums[i], max * nums[i])
        min = minOf(nums[i], min * nums[i])

        ans = maxOf(ans, max)
    }
    return ans
}

/**
 * 5. Longest Palindromic Substring
 */


fun longestPalindrome(s: String?): String? {
    if (s.isNullOrEmpty()) {
        return ""
    }

    var start = 0
    var end = 0
    val len = s.length
    for (i in 0 until len) {
        val odd = expandAroundCenter(s, i, i)
        val even = expandAroundCenter(s, i, i + 1)
        val maxLen = max(odd.toDouble(), even.toDouble()).toInt()

        if (maxLen > end - start) {
            start = i - (maxLen - 1) / 2
            end = i + maxLen / 2
        }
    }

    return s.substring(start, end + 1)
}

private fun expandAroundCenter(s: String, left: Int, right: Int): Int {
    var left = left
    var right = right
    while (left >= 0 && right < s.length && s[left] == s[right]) {
        left--
        right++
    }
    return right - left - 1
}

/**
 * 1957. Delete Characters to Make Fancy String
 */


fun makeFancyString(s: String): String? {
    val ans = java.lang.StringBuilder()
    ans.append(s[0])
    val n = s.length
    var cnt = 1
    for (i in 1 until n) {
        if (s[i] == ans[ans.length - 1]) {
            cnt++
            if (cnt < 3) {
                ans.append(s[i])
            }
        } else {
            cnt = 1
            ans.append(s[i])
        }
    }
    return ans.toString()
}


/**
 * 2490. Circular Sentence
 */

fun isCircularSentence(sentence: String): Boolean {
    val len = sentence.length
    val first = sentence[0]
    var last = '1'
    for (i in 1 until len) {
        if (sentence[i] == ' ') {
            last = sentence[i - 1]
        }
        if (sentence[i - 1] == ' ' && sentence[i] == last) continue
        if (sentence[i - 1] == ' ' && sentence[i] != last) return false
    }
    return first == sentence[len - 1]
}

/**
 * 792. Number of Matching Subsequences
 */


fun numMatchingSubSequence(s: String, words: Array<String>): Int {
    var count = 0
    val len = words.size
    for (word in words) {
        var temp = word
        var i = 0
        var j = 0
        while (j < s.length && i < temp.length) {
            if (s[j] == temp[i]) i++
            j++
        }
        if (i >= temp.length) count++
    }
    return count
}

/**
 * 796. Rotate String
 */


fun rotateString(s: String, goal: String): Boolean {
    if (s.isEmpty()) return true
    var temp = s
    val len = s.length
    for (i in 0 until len) {
        if (temp == goal) return true
        temp = s.substring(i + 1, len)
        temp += s.substring(0, i + 1)
    }
    return false
}

/**
 * 3163. String Compression III
 */

fun compressedString(word: String): String {
    val comp = java.lang.StringBuilder()
    var cnt = 1
    val n = word.length
    var ch = word[0]
    for (i in 1 until n) {
        if (word[i] == ch && cnt < 9) {
            cnt++
        } else {
            comp.append(cnt).append(ch)
            ch = word[i]
            cnt = 1
        }
    }
    comp.append(cnt).append(ch)
    return comp.toString()
}

/**
 * 2914. Minimum Number of Changes to Make Binary String Beautiful
 */

fun minChanges(s: String): Int {
    var count = 0
    val len = s.length
    for (i in 0 until len - 1 step 2) {
        if (s[i] != s[i + 1]) count++
    }
    return count
}


/**
 * 7. Reverse Integer
 */

fun reverse(x: Int): Int {
    var x = x
    var res = 0
    while (x != 0) {
        var digit = x % 10
        x /= 10
        if (res > Int.MAX_VALUE / 10 || (res == Int.MAX_VALUE / 10 && digit > 7)) return 0
        if (res < Int.MIN_VALUE / 10 || (res == Int.MIN_VALUE / 10 && digit < -8)) return 0
        res = res * 10 + digit
    }
    return res
}

/**
 * 102. Binary Tree Level Order Traversal
 */

fun levelOrder(root: TreeNode?): List<List<Int>> {
    if (root == null) return listOf()
    return bfs(root)
}

private fun bfs(root: TreeNode?): List<List<Int>> {
    val q = LinkedList<TreeNode>()
    val res = mutableListOf<MutableList<Int>>()
    q.offer(root)
    while (q.isNotEmpty()) {
        val size = q.size
        val subset = mutableListOf<Int>()
        for (i in 0 until size) {
            val node = q.poll()
            subset.add(node.`val`)
            if (node?.left != null) q.offer(node?.left)
            if (node?.right != null) q.offer(node?.right)
        }
        res.add(subset)
    }
    return res
}

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 */

fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
    if (root == null) return listOf()
    val res = bfsZigZag(root)
    for (i in 1 until res.size step 2) Collections.reverse(res[i])
    return res
}

fun bfsZigZag(root: TreeNode?): List<List<Int>> {
    val q = LinkedList<TreeNode>()
    val res = mutableListOf<MutableList<Int>>()
    var zigzag = true
    q.offer(root)
    while (q.isNotEmpty()) {
        val size = q.size
        val subset = mutableListOf<Int>()
        for (i in 0 until size) {
            val node = q.poll()
            subset.add(node.`val`)
            if (node?.left != null) q.offer(node?.left)
            if (node?.right != null) q.offer(node?.right)
        }
        res.add(subset)
    }
    return res
}

/**
 * 107. Binary Tree Level Order Traversal II
 */

fun levelOrderBottom(root: TreeNode?): List<List<Int>> = bfsOrderBottom(root)

fun bfsOrderBottom(root: TreeNode?): List<List<Int>> {
    if (root == null) return listOf()
    val q = LinkedList<TreeNode>()
    val res = mutableListOf<MutableList<Int>>()
    q.offer(root)
    while (q.isNotEmpty()) {
        val size = q.size
        val subset = mutableListOf<Int>()
        for (i in 0 until size) {
            val node = q.poll()
            subset.add(node.`val`)
            if (node?.left != null) q.offer(node?.left)
            if (node?.right != null) q.offer(node?.right)
        }
        res.add(subset)
    }
    reverse(res)
    return res
}

fun reverse(obj: MutableList<MutableList<Int>>) {
    var i = 0
    var j = obj.size - 1
    while (i < j) {
        var temp = obj[i]
        obj[i] = obj[j]
        obj[j] = temp
        i++
        j--
    }
}

/**
 * 109. Convert Sorted List to Binary Search Tree
 */


fun sortedListToBST(head: ListNode?): TreeNode? {
    if (head == null) return null
    if (head.next == null) return TreeNode(head.`val`)

    var slow = head
    var fast = head
    var prev: ListNode? = null

    // Finding the middle element
    while (fast?.next != null) {
        prev = slow
        slow = slow!!.next
        fast = fast.next!!.next
    }

    // Create the root node with the middle element
    val root = TreeNode(slow!!.`val`)

    // Disconnect the left part of the list
    fast = slow!!.next
    if (prev != null) {
        prev.next = null
    }

    // Recursively build left and right subtrees
    root.left = sortedListToBST(head) // Left subtree
    root.right = sortedListToBST(fast) // Right subtree

    return root
}

/**
 * 3. Longest Substring Without Repeating Characters
 */

fun lengthOfLongestSubstring(s: String): Int {
    var left = 0
    var maxLength = 0
    val charSet = HashSet<Char>()

    for (right in 0 until s.length) {
        while (charSet.contains(s[right])) {
            charSet.remove(s[left])
            left++
        }

        charSet.add(s[right])
        maxLength = max(maxLength.toDouble(), (right - left + 1).toDouble()).toInt()
    }

    return maxLength
}

/**
 * 300. Longest Increasing Subsequence
 */

fun lengthOfLIS(nums: IntArray): Int {
    val dp = IntArray(nums.size) { 1 }
    val len = nums.size
    var ans = 1
    for (i in 0 until len) {
        for (j in 0 until i) {
            if (nums[i] > nums[j]) {
                dp[i] = maxOf(dp[i], dp[j] + 1)
                ans = maxOf(ans, dp[i])
            }
        }
    }
    return ans
}


/**
 * 1464. Maximum Product of Two Elements in an Array
 * Time - O(n * logn)
 */

fun maxProductTwoElements(nums: IntArray): Int {
    nums.sort()
    val len = nums.size
    return (nums[len - 1] - 1) * (nums[len - 2] - 1)
}

/**
 * 215. Kth Largest Element in an Array
 */


@RequiresApi(Build.VERSION_CODES.N)
fun findKthLargest(nums: IntArray, k: Int): Int {
    val pq = PriorityQueue<Int> { a, b -> b - a }
    pq.addAll(nums.toTypedArray())
    var res = 0
    for (i in 0 until k) res = pq.poll()
    return res
}

/**
 * 23. Merge k Sorted Lists
 */

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    if (lists.isEmpty()) return null
    val pq = PriorityQueue<Int>()
    val len = lists.size
    for (i in 0 until len) {
        var head = lists[i]
        while (head != null) {
            pq.offer(head.`val`)
            head = head?.next
        }
    }
    var stub = ListNode(0)
    val ans = stub
    while (pq.isNotEmpty()) {
        val value = pq.poll()
        val node = ListNode(value)
        stub.next = node
        stub = stub.next!!
    }
    return ans.next
}


/**
 * 92. Reverse Linked List II
 */

fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
    if (head == null || left == right) {
        return head
    }

    val dummy = ListNode(0)
    dummy.next = head
    var prev: ListNode? = dummy

    for (i in 0 until left - 1) {
        prev = prev!!.next
    }

    val cur = prev!!.next

    for (i in 0 until right - left) {
        val temp = cur!!.next
        cur!!.next = temp!!.next
        temp!!.next = prev!!.next
        prev!!.next = temp
    }

    return dummy.next
}

/**
 * 506. Relative Ranks
 */

fun findRelativeRanks(score: IntArray): Array<String> {
    val pq = PriorityQueue<Int> { a, b -> b - a }
    val map = mutableMapOf<Int, Int>()
    val len = score.size
    val ans = Array(len) { "" }
    var count = 1
    val gold = "Gold Medal"
    val silver = "Silver Medal"
    val bronze = "Bronze Medal"
    for (i in 0 until len) {
        map[score[i]] = i
        pq.offer(score[i])
    }
    while (pq.isNotEmpty()) {
        val num = pq.poll()
        val index = map[num]
        if (count == 1) ans[index!!] = gold
        if (count == 2) ans[index!!] = silver
        if (count == 3) ans[index!!] = bronze
        if (count > 3) ans[index!!] = count.toString()
        count++
    }
    return ans
}

/**
 * 347. Top K Frequent Elements
 */

fun topKFrequent(nums: IntArray, k: Int): IntArray? {
    val map: MutableMap<Int, Int> = HashMap()
    for (n in nums) {
        map[n] = map.getOrDefault(n, 0) + 1
    }

    val heap = PriorityQueue { a: Map.Entry<Int, Int>, b: Map.Entry<Int, Int> ->
        b.value.compareTo(a.value)
    }

    for (entry in map.entries) {
        heap.offer(entry)
    }

    val res = IntArray(k)
    for (i in 0 until k) {
        res[i] = heap.poll().key
    }

    return res
}

/**
 * 437. Path Sum III
 */

fun pathSumIII(root: TreeNode?, targetSum: Int): Int {
    val prefixSumMap = mutableMapOf(0L to 1) // Use Long for keys
    var count = 0

    fun dfs(node: TreeNode?, currentSum: Long) { // Use Long for currentSum
        node ?: return

        val newSum = currentSum + node.`val`
        count += prefixSumMap.getOrDefault(
            newSum - targetSum.toLong(), 0
        ) // Convert targetSum to Long
        prefixSumMap[newSum] = prefixSumMap.getOrDefault(newSum, 0) + 1

        dfs(node.left, newSum)
        dfs(node.right, newSum)

        prefixSumMap[newSum] = prefixSumMap.getOrDefault(newSum, 0) - 1
    }

    dfs(root, 0L) // Start DFS with initial currentSum as Long
    return count
}

/**
 * 264. Ugly Number II
 */

fun nthUglyNumber(n: Int): Int {
    val uglyNumbers = IntArray(n)
    uglyNumbers[0] = 1

    var p2 = 0
    var p3 = 0
    var p5 = 0

    for (i in 1 until n) {
        val nextUgly = minOf(uglyNumbers[p2] * 2, uglyNumbers[p3] * 3, uglyNumbers[p5] * 5)
        uglyNumbers[i] = nextUgly

        if (nextUgly == uglyNumbers[p2] * 2) p2++
        if (nextUgly == uglyNumbers[p3] * 3) p3++
        if (nextUgly == uglyNumbers[p5] * 5) p5++
    }

    return uglyNumbers[n - 1]
}

/**
 * 263. Ugly Number
 */

fun isUgly(n: Int): Boolean {
    if (n == 0) return false
    var n = n
    while (n != 1) {
        if (n % 2 == 0) {
            n /= 2
            continue
        }
        if (n % 3 == 0) {
            n /= 3
            continue
        }
        if (n % 5 == 0) {
            n /= 5
            continue
        }
        return false
    }
    return true
}

/**
 * 3254. Find the Power of K-Size Subarrays I
 */

fun resultsArray(nums: IntArray, k: Int): IntArray {
    val len = nums.size
    val res = IntArray(len - k + 1)
    var max = 0
    var left = 0
    for (i in 0 until len) {
        var isSorted = true
        if (i - left == (k - 1)) {
            var j = i
            while (j > left) {
                if (nums[j] <= nums[j - 1]) {
                    isSorted = false
                    break
                }
                if (nums[j] - 1 != nums[j - 1]) {
                    isSorted = false
                    break
                }
                max = maxOf(max, nums[j])
                j--
            }
            max = maxOf(max, nums[j])
            if (isSorted) res[left] = max
            else res[left] = -1
            max = 0
            left++
        }
    }
    return res
}

/**
 * 114. Flatten Binary Tree to Linked List
 */


fun flatten(root: TreeNode?): Unit {
    if (root == null) return

    flatten(root.left)
    flatten(root.right)

    if (root.left != null) {
        var tail = root.left
        while (tail?.right != null) {
            tail = tail?.right
        }
        tail?.right = root.right
        root.right = root.left
        root.left = null
    }
    return
}

/**
 * 49. Group Anagrams
 */

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val ans: MutableMap<String, MutableList<String>> = HashMap()

    for (s in strs) {
        val chars = s.toCharArray()
        chars.sort()
        val key = String(chars)
        if (!ans.containsKey(key)) {
            ans[key] = ArrayList()
        }
        ans[key]!!.add(s)
    }
    val res = mutableListOf<List<String>>()
    res.addAll(ans.values)
    return res
}

/**
 * 110. Balanced Binary Tree
 */


fun isBalanced(root: TreeNode?): Boolean {
    if (root == null) return true

    val leftHeight = height(root.left)
    val rightHeight = height(root.right)

    return abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right)
}

fun height(node: TreeNode?): Int {
    if (node == null) return 0
    return 1 + maxOf(height(node.left), height(node.right))
}

/**
 * 2461. Maximum Sum of Distinct Subarrays With Length K
 */


fun maximumSubarraySum(nums: IntArray, k: Int): Long {
    var sum = 0L
    val map = mutableMapOf<Int, Int>()
    val len = nums.size
    var left = 0
    var local = 0L
    for (i in 0 until len) {
        local += nums[i].toLong()
        map[nums[i]] = map.getOrDefault(nums[i], 0) + 1
        if (i - left == (k - 1)) {
            if (map.size == k) sum = maxOf(sum, local)
            map[nums[i - (k - 1)]] = map.getOrDefault(nums[i - (k - 1)], 0) - 1
            val value = map.getOrDefault(nums[i - (k - 1)], 0)
            if (value == 0) map.remove(nums[i - (k - 1)])
            local -= nums[i - (k - 1)].toLong()
            left++
        }
    }
    return sum
}


/**
 * 144. Binary Tree Preorder Traversal
 */

fun preorderTraversal(root: TreeNode?): List<Int> {
    val res = mutableListOf<Int>()
    preorder(root, res)
    return res
}

fun preorder(root: TreeNode?, res: MutableList<Int>) {
    root ?: return
    res.add(root.`val` ?: 0)
    preorder(root?.left, res)
    preorder(root?.right, res)
    return
}

/**
 * 145. Binary Tree Postorder Traversal
 */


fun postorderTraversal(root: TreeNode?): List<Int> {
    val res = mutableListOf<Int>()
    postorder(root, res)
    return res
}

fun postorder(root: TreeNode?, res: MutableList<Int>) {
    root ?: return
    postorder(root?.left, res)
    postorder(root?.right, res)
    res.add(root.`val` ?: 0)
}

/**
 * 129. Sum Root to Leaf Numbers
 */

fun sumNumbers(root: TreeNode?): Int {
    return dfs(root, 0, 0)
}

fun dfs(root: TreeNode?, local: Int, sum: Int): Int {
    var local = local
    var sum = sum
    if (root == null) return sum
    if (root?.left == null && root?.right == null) {
        local += root?.`val` ?: 0
        sum += local
        return sum
    }
    local += root?.`val` ?: 0
    local *= 10
    sum = dfs(root?.left, local, sum)
    sum = dfs(root?.right, local, sum)
    return sum
}


/**
 * 139. Word Break
 */


fun wordBreak(s: String, wordDict: List<String>): Boolean {
    val dp = BooleanArray(s.length + 1)
    dp[0] = true

    for (i in 1 until dp.size) {
        for (j in 0 until i) {
            if (dp[j] && wordDict.contains(s.substring(j, i))) {
                dp[i] = true
                break
            }
        }
    }

    return dp[s.length]
}

/**
 * 173. Binary Search Tree Iterator
 */


class BSTIterator(root: TreeNode?) {
    private val stack = ArrayDeque<TreeNode>()

    init {
        pushLeftNodes(root)
    }

    fun hasNext(): Boolean {
        return stack.isNotEmpty()
    }

    fun next(): Int {
        val node = stack.removeLast()
        pushLeftNodes(node.right)
        return node.`val`
    }

    private fun pushLeftNodes(node: TreeNode?) {
        var current = node
        while (current != null) {
            stack.addLast(current)
            current = current.left
        }
    }
}

/**
 * 222. Count Complete Tree Nodes
 */

fun countNodes(root: TreeNode?): Int {
    root ?: return 0
    return bfsCountNodes(root)
}

fun bfsCountNodes(root: TreeNode?): Int {
    val q = LinkedList<TreeNode>()
    var count = 0
    q.offer(root)
    while (q.isNotEmpty()) {
        val size = q.size
        count += size
        for (i in 0 until size) {
            val node = q.poll()
            if (node?.left != null) q.offer(node?.left)
            if (node?.right != null) q.offer(node?.right)
        }
    }
    return count
}

/**
 * 199. Binary Tree Right Side View
 */

fun rightSideView(root: TreeNode?): List<Int> {
    return if (root == null) listOf() else bfsRightSideView(root)
}

fun bfsRightSideView(root: TreeNode?): List<Int> {
    val res = mutableListOf<Int>()
    val q = LinkedList<TreeNode>()
    q.offer(root)
    while (q.isNotEmpty()) {
        val size = q.size
        for (i in 0 until size) {
            val node = q.poll()
            if (i == size - 1) res.add(node.`val`)
            node?.left?.let { q.offer(it) }
            node?.right?.let { q.offer(it) }
        }
    }
    return res
}

/**
 * 230. Kth Smallest Element in a BST
 */

fun kthSmallest(root: TreeNode?, k: Int): Int {
    val res = mutableListOf<Int>()
    inorder(root, res)
    return res[k - 1]
}

fun inorder(root: TreeNode?, res: MutableList<Int>) {
    when (root) {
        null -> return
        else -> {
            inorder(root?.left, res)
            res.add(root.`val`)
            inorder(root?.right, res)
        }
    }
}


/**
 * 124. Binary Tree Maximum Path Sum
 */


fun maxPathSum(root: TreeNode?): Int {
    val maxSumHolder = IntHolder(Int.MIN_VALUE)
    maxPathSumRecursive(root, maxSumHolder)
    return maxSumHolder.value
}

fun maxPathSumRecursive(node: TreeNode?, maxSumHolder: IntHolder): Int {
    if (node == null) {
        return 0
    }

    val leftSum = maxOf(maxPathSumRecursive(node.left, maxSumHolder), 0)
    val rightSum = maxOf(maxPathSumRecursive(node.right, maxSumHolder), 0)


    maxSumHolder.value = maxOf(maxSumHolder.value, node.`val` + leftSum + rightSum)


    return node.`val` + maxOf(leftSum, rightSum)
}


class IntHolder(var value: Int)


/**
 * 297. Serialize and Deserialize Binary Tree
 */


class Codec() {
    // Encodes a tree to a single string.
    fun serialize(root: TreeNode?): String {
        if (root == null) return ""

        val result = StringBuilder()
        val queue = ArrayDeque<TreeNode?>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()

            if (node == null) {
                result.append("null,")
            } else {
                result.append("${node.`val`},")
                queue.add(node.left)
                queue.add(node.right)
            }
        }

        return result.toString().dropLast(1) // Remove trailing comma
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        if (data.isEmpty()) return null

        val values = data.split(",").toTypedArray()
        val root = TreeNode(values[0].toInt())
        val queue = ArrayDeque<TreeNode?>()
        queue.add(root)
        var i = 1

        while (queue.isNotEmpty() && i < values.size) {
            val node = queue.removeFirst()

            if (values[i] != "null") {
                node?.left = TreeNode(values[i].toInt())
                queue.add(node?.left)
            }
            i++

            if (i < values.size && values[i] != "null") {
                node?.right = TreeNode(values[i].toInt())
                queue.add(node?.right)
            }
            i++
        }

        return root
    }
}

/**
 * 449. Serialize and Deserialize BST
 */


@Suppress("UNREACHABLE_CODE")
class Codec449() {

    fun serialize(root: TreeNode?): String {
        if (root == null) return ""
        val sb = StringBuilder()
        val queue: Queue<TreeNode?> = LinkedList()
        queue.offer(root)

        while (queue.isNotEmpty()) {
            val node = queue.poll()
            if (node == null) {
                sb.append("null,")
            } else {
                sb.append(node.`val`).append(",")
                queue.offer(node.left)
                queue.offer(node.right)
            }
        }

        return sb.toString().substring(0, sb.length - 1)


        fun deserialize(data: String): TreeNode? {
            if (data.isEmpty()) return null

            val values = data.split(",").toTypedArray()
            val queue: Queue<TreeNode?> = LinkedList()
            val root = TreeNode(values[0].toInt())
            queue.offer(root)
            var i = 1

            while (queue.isNotEmpty() && i < values.size) {
                val node = queue.poll()
                if (node != null) {
                    if (values[i] != "null") {
                        node.left = TreeNode(values[i].toInt())
                        queue.offer(node.left)
                    }
                    i++
                    if (i < values.size && values[i] != "null") {
                        node.right = TreeNode(values[i].toInt())
                        queue.offer(node.right)
                    }
                    i++
                }
            }

            return root
        }
    }
}

/**
 * 450. Delete Node in a BST
 */


fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
    if (root == null) return null

    if (key < root.`val`) {
        root.left = deleteNode(root.left, key)
    } else if (key > root.`val`) {
        root.right = deleteNode(root.right, key)
    } else {

        if (root.left == null) return root.right
        if (root.right == null) return root.left


        var successor = root.right
        while (successor!!.left != null) {
            successor = successor.left
        }

        root.`val` = successor.`val`


        root.right = deleteNode(root.right, successor.`val`)
    }

    return root
}

/**
 * 508. Most Frequent Subtree Sum
 */

fun findFrequentTreeSum(root: TreeNode?): IntArray {
    val sumFrequencyMap = mutableMapOf<Int, Int>()
    calculateSubtreeSums(root, sumFrequencyMap)

    val maxFrequency = sumFrequencyMap.values.maxOrNull() ?: 0
    val mostFrequentSums = sumFrequencyMap.filterValues { it == maxFrequency }.keys.toIntArray()

    return mostFrequentSums
}

private fun calculateSubtreeSums(node: TreeNode?, sumFrequencyMap: MutableMap<Int, Int>): Int {
    if (node == null) return 0

    val leftSum = calculateSubtreeSums(node.left, sumFrequencyMap)
    val rightSum = calculateSubtreeSums(node.right, sumFrequencyMap)

    val subtreeSum = node.`val` + leftSum + rightSum
    sumFrequencyMap[subtreeSum] = sumFrequencyMap.getOrDefault(subtreeSum, 0) + 1

    return subtreeSum
}

/**
 * 654. Maximum Binary Tree
 */

fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
    if (nums.isEmpty()) return null

    val maxIndex = findMaxIndex(nums)
    val root = TreeNode(nums[maxIndex])

    root.left = constructMaximumBinaryTree(nums.copyOfRange(0, maxIndex))
    root.right = constructMaximumBinaryTree(nums.copyOfRange(maxIndex + 1, nums.size))

    return root
}

private fun findMaxIndex(nums: IntArray): Int {
    var maxIndex = 0
    for (i in 1 until nums.size) {
        if (nums[i] > nums[maxIndex]) {
            maxIndex = i
        }
    }
    return maxIndex
}

/**
 * 662. Maximum Width of Binary Tree
 */


fun widthOfBinaryTree(root: TreeNode?): Int {
    if (root == null) return 0

    var maxWidth = 0
    val queue: Queue<Pair<TreeNode, Int>> = LinkedList()
    queue.offer(Pair(root, 0)) // Initial index of root is 0

    while (queue.isNotEmpty()) {
        val levelSize = queue.size
        var leftmostIndex = -1
        var rightmostIndex = -1

        for (i in 0 until levelSize) {
            val (node, index) = queue.poll()

            if (leftmostIndex == -1) {
                leftmostIndex = index
            }
            rightmostIndex = index

            if (node.left != null) {
                queue.offer(Pair(node.left!!, 2 * index + 1)) // Left child index
            }
            if (node.right != null) {
                queue.offer(Pair(node.right!!, 2 * index + 2)) // Right child index
            }
        }

        maxWidth = maxOf(maxWidth, rightmostIndex - leftmostIndex + 1)
    }

    return maxWidth
}

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 */

fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    if (preorder.isEmpty() || inorder.isEmpty()) {
        return null
    }

    val rootValue = preorder[0]
    val root = TreeNode(rootValue)

    val rootIndexInInorder = inorder.indexOf(rootValue)

    root.left = buildTree(
        preorder.copyOfRange(1, rootIndexInInorder + 1), inorder.copyOfRange(0, rootIndexInInorder)
    )
    root.right = buildTree(
        preorder.copyOfRange(rootIndexInInorder + 1, preorder.size),
        inorder.copyOfRange(rootIndexInInorder + 1, inorder.size)
    )

    return root
}

/**
 * 451. Sort Characters By Frequency
 */

fun frequencySort(s: String): String {
    val pq = PriorityQueue<Pair<Int, Char>> { a, b -> b.first - a.first }
    val map = mutableMapOf<Char, Int>()
    val len = s.length
    for (i in 0 until len) {
        map[s[i]] = map.getOrDefault(s[i], 0) + 1
    }
    for (i in 0 until len) {
        val obj = Pair(map.getOrDefault(s[i], 0), s[i])
        pq.offer(obj)
        map.remove(s[i])
    }
    var res = ""
    while (pq.isNotEmpty()) {
        val obj = pq.poll()
        repeat(obj.first) { res += obj.second }
    }
    return res
}

/**
 * 116. Populating Next Right Pointers in Each Node
 */

fun connect(root: Node?): Node? {
    if (root == null) return null
    bfs(root)
    return root
}

fun bfs(root: Node) {
    val q = LinkedList<Node>()
    q.offer(root)
    while (q.isNotEmpty()) {
        val size = q.size
        var prev: Node? = null
        for (i in 0 until size) {
            val node = q.poll()
            if (size % 2 == 0) {
                if (prev == null) prev = node
                else {
                    prev?.next = node
                    prev = node
                }
            }
            if (node?.left != null) q.offer(node?.left)
            if (node?.right != null) q.offer(node?.right)
        }
    }
}

/**
 * 373. Find K Pairs with Smallest Sums
 */

fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    if (nums1.isEmpty() || nums2.isEmpty() || k == 0) {
        return result
    }

    val priorityQueue =
        PriorityQueue<Triple<Int, Int, Int>>(compareBy { nums1[it.first] + nums2[it.second] })

    for (i in 0 until minOf(nums1.size, k)) {
        priorityQueue.offer(Triple(i, 0, nums1[i] + nums2[0]))
    }

    while (priorityQueue.isNotEmpty() && result.size < k) {
        val (i, j, _) = priorityQueue.poll()
        result.add(listOf(nums1[i], nums2[j]))

        if (j + 1 < nums2.size) {
            priorityQueue.offer(Triple(i, j + 1, nums1[i] + nums2[j + 1]))
        }
    }

    return result
}

/**
 * 658. Find K Closest Elements
 */

fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
    val priorityQueue = PriorityQueue<Pair<Int, Int>>(compareBy { (num, index) ->
        Math.abs(num - x) * 10000 + index // Custom comparator
    })

    for (index in arr.indices) {
        priorityQueue.offer(arr[index] to index)
    }

    val result = mutableListOf<Int>()
    for (i in 0 until k) {
        result.add(priorityQueue.poll().first)
    }

    result.sortWith(compareBy { arr.indexOf(it) }) //Sort by original index

    return result
}

/**
 * 239. Sliding Window Maximum
 */


fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    val result = IntArray(nums.size - k + 1)
    val deque = LinkedList<Int>()

    for (i in nums.indices) {

        while (deque.isNotEmpty() && deque.first() <= i - k) {
            deque.removeFirst()
        }


        while (deque.isNotEmpty() && nums[deque.last()] <= nums[i]) {
            deque.removeLast()
        }

        deque.addLast(i)


        if (i >= k - 1) {
            result[i - k + 1] = nums[deque.first()]
        }
    }

    return result
}

/**
 * 295. Find Median from Data Stream
 */

class MedianFinder() {
    private val maxHeap = PriorityQueue<Int>(Collections.reverseOrder()) // Stores smaller half
    private val minHeap = PriorityQueue<Int>() // Stores larger half

    fun addNum(num: Int) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num)
        } else {
            minHeap.offer(num)
        }

        // Balance the heaps to maintain median property
        if (maxHeap.size > minHeap.size + 1) {
            minHeap.offer(maxHeap.poll())
        } else if (minHeap.size > maxHeap.size) {
            maxHeap.offer(minHeap.poll())
        }
    }

    fun findMedian(): Double {
        return if (maxHeap.size == minHeap.size) {
            (maxHeap.peek() + minHeap.peek()).toDouble() / 2
        } else {
            maxHeap.peek().toDouble() // Max heap has one more element for odd size
        }
    }
}

/**
 * 1346. Check If N and Its Double Exist
 */

fun checkIfExist(arr: IntArray): Boolean {
    val map = mutableMapOf<Int, Int>()
    for (i in 0 until arr.size) {
        if (!map.contains(arr[i])) map[arr[i]] = i
        else if (arr[i] == 0) return true
    }
    for (i in 0 until arr.size) {
        if (arr[i] != 0 && map.contains(arr[i] * 2)) return true
    }
    return false
}

/**
 * 2109. Adding Spaces to a String
 */

fun addSpaces(s: String, spaces: IntArray): String {
    val result = StringBuilder()
    var spacesIndex = 0

    for (i in s.indices) {
        if (spacesIndex < spaces.size && i == spaces[spacesIndex]) {
            result.append(" ")
            spacesIndex++
        }
        result.append(s[i])
    }

    return result.toString()
}

/**
 * 117. Populating Next Right Pointers in Each Node II
 */

fun connectII(root: Node?): Node? {
    val q = LinkedList<Node>()
    q.offer(root)
    while (q.isNotEmpty()) {
        val size = q.size
        var prev: Node? = null
        for (i in 0 until size) {
            val node = q.poll()
            if (prev == null) {
                prev = node
            } else {
                prev?.next = node
                prev = node
            }
            if (node?.left != null) q.offer(node?.left)
            if (node?.right != null) q.offer(node?.right)
        }
    }
    return root
}


/**
 * 331. Verify Preorder Serialization of a Binary Tree
 */


fun isValidSerialization(preorder: String): Boolean {
    val nodes = preorder.split(",")
    var diff = 1

    for (node in nodes) {
        diff--

        if (diff < 0) {
            return false
        }

        if (node != "#") {
            diff += 2
        }
    }

    return diff == 0
}

/**
 * 404. Sum of Left Leaves
 */

fun sumOfLeftLeaves(root: TreeNode?): Int {
    if (root == null) return 0

    var sum = 0
    val queue = LinkedList<Pair<TreeNode, Boolean>>()
    queue.offer(root to false)

    while (queue.isNotEmpty()) {
        val (node, isLeft) = queue.poll()

        if (node.left == null && node.right == null && isLeft) {
            sum += node.`val`
        }

        if (node.left != null) {
            queue.offer(node.left!! to true)
        }
        if (node.right != null) {
            queue.offer(node.right!! to false)
        }
    }

    return sum
}

/**
 * 111. Minimum Depth of Binary Tree
 */

fun minDepth(root: TreeNode?): Int {
    if (root == null) return 0

    val queue = LinkedList<TreeNode>()
    queue.offer(root)
    var depth = 1

    while (queue.isNotEmpty()) {
        val levelSize = queue.size

        for (i in 0 until levelSize) {
            val node = queue.poll()

            if (node.left == null && node.right == null) {
                return depth // Found a leaf node, return depth
            }

            if (node.left != null) {
                queue.offer(node.left!!)
            }
            if (node.right != null) {
                queue.offer(node.right!!)
            }
        }

        depth++
    }
    return depth
}

/**
 * 513. Find Bottom Left Tree Value
 */

fun findBottomLeftValue(root: TreeNode?): Int = bfsFindBottomLeftValue(root)

fun bfsFindBottomLeftValue(root: TreeNode?): Int {
    val q = LinkedList<TreeNode>()
    var value = 0
    q.offer(root)
    while (q.isNotEmpty()) {
        val size = q.size
        var leftMost = true
        for (i in 0 until size) {
            val node = q.poll()
            if (node?.left == null && node?.right == null && leftMost) {
                value = node.`val`
                leftMost = false
            }
            if (node?.left != null) q.offer(node?.left)
            if (node?.right != null) q.offer(node?.right)
        }
        if (q.isEmpty()) return value
    }
    return value
}

/**
 * 515. Find Largest Value in Each Tree Row
 */

fun largestValues(root: TreeNode?): List<Int> {
    if (root == null) return listOf()
    val q = LinkedList<TreeNode>()
    val res = mutableListOf<Int>()
    q.offer(root)
    while (q.isNotEmpty()) {
        val size = q.size
        var max = Int.MIN_VALUE
        for (i in 0 until size) {
            val node = q.poll()
            max = maxOf(max, node.`val`)
            if (node?.left != null) q.offer(node?.left)
            if (node?.right != null) q.offer(node?.right)
        }
        res.add(max)
    }
    return res
}

/**
 * 530. Minimum Absolute Difference in BST
 */

fun getMinimumDifference(root: TreeNode?): Int {
    var minDiff = Int.MAX_VALUE
    var prev: Int? = null

    fun inorder(root: TreeNode?) {
        if (root == null) return

        inorder(root.left)

        prev?.let {
            minDiff = minOf(minDiff, root.`val` - it)
        }
        prev = root.`val`

        inorder(root.right)
    }

    inorder(root)
    return minDiff
}

/**
 * 852. Peak Index in a Mountain Array
 */


fun peakIndexInMountainArray(A: IntArray): Int {
    var l = 0
    var r = A.size - 1
    var m: Int
    while (l < r) {
        m = (l + r) / 2
        if (A[m] < A[m + 1]) l = m + 1
        else r = m
    }
    return l
}

/**
 * 162. Find Peak Element
 */

fun findPeakElement(nums: IntArray): Int {
    var l = 0
    var r = nums.size - 1
    while (l < r) {
        var m = (l + r) / 2
        if (nums[m] < nums[m + 1]) l = m + 1
        else r = m
    }
    return l
}

/**
 * 240. Search a 2D Matrix II
 */

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    val len = matrix.size
    for (i in 0 until len) {
        val arr = matrix[i]
        val ans = local(arr, target)
        if (ans) return true
    }
    return false
}

fun local(nums: IntArray, target: Int): Boolean {
    if (nums.size == 1 && nums[0] == target) return true
    var l = 0
    var r = nums.size - 1
    while (l < r) {
        var m = (l + r) / 2
        if (nums[m] == target) return true
        if (nums[m] > target) r = m
        else l = m + 1
    }
    return if (nums[l] == target) true else false
}

/**
 * 34. Find First and Last Position of Element in Sorted Array
 */

fun searchRange(nums: IntArray, target: Int): IntArray {
    val firstPosition = findFirstPosition(nums, target)
    val lastPosition = findLastPosition(nums, target)

    return intArrayOf(firstPosition, lastPosition)
}

private fun findFirstPosition(nums: IntArray, target: Int): Int {
    var low = 0
    var high = nums.size - 1
    var firstPosition = -1

    while (low <= high) {
        val mid = low + (high - low) / 2

        if (nums[mid] == target) {
            firstPosition = mid
            high = mid - 1
        } else if (nums[mid] < target) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }

    return firstPosition
}

private fun findLastPosition(nums: IntArray, target: Int): Int {
    var low = 0
    var high = nums.size - 1
    var lastPosition = -1

    while (low <= high) {
        val mid = low + (high - low) / 2

        if (nums[mid] == target) {
            lastPosition = mid
            low = mid + 1
        } else if (nums[mid] < target) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }

    return lastPosition
}

/**
 * 278. First Bad Version
 */

open class VersionControl() {

    open fun firstBadVersion(n: Int): Int {
        return 0
    }
}

fun isBadVersion(n: Int): Boolean = true

class SolutionOth : VersionControl() {

    override fun firstBadVersion(n: Int): Int {
        // 1 2
        if (n == 1) return 1
        var l = 0L
        var r = (n - 1).toLong()
        var elem = -1L
        while (l <= r) {
            var m = (l + r) / 2
            var res = isBadVersion((m + 1).toInt())
            if (res) {
                elem = m + 1
                r = m
            } else l = m + 1
            if (l == r && l == m && r == m) break
        }
        return elem.toInt()
    }
}

/**
 * 275. H-Index II
 */

fun hIndex(citations: IntArray): Int {
    val n = citations.size
    var left = 0
    var right = n - 1

    while (left <= right) {
        val mid = left + (right - left) / 2
        if (citations[mid] >= n - mid) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }

    return n - left
}

/**
 * 378. Kth Smallest Element in a Sorted Matrix
 */

fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
    val pq = PriorityQueue<Int>()
    val len = matrix.size
    for (i in 0 until len) {
        for (j in 0 until len) {
            pq.offer(matrix[i][j])
        }
    }
    var res = 0
    for (i in 0 until k) {
        res = pq.poll()
    }
    return res
}

/**
 * 74. Search a 2D Matrix
 */

fun searchMatrix2D(matrix: Array<IntArray>, target: Int): Boolean {
    var row = 0
    var col = matrix[0].size - 1
    while (row < matrix.size && col >= 0) {
        if (matrix[row][col] == target) return true
        else if (matrix[row][col] < target) row++
        else col--
    }
    return false
}

/**
 * 33. Search in Rotated Sorted Array
 */


fun search(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1

    while (left <= right) {
        val mid = left + (right - left) / 2

        if (nums[mid] == target) {
            return mid
        }

        if (nums[left] <= nums[mid]) {
            if (target >= nums[left] && target < nums[mid]) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        } else {
            if (target > nums[mid] && target <= nums[right]) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
    }

    return -1
}

/**
 * 81. Search in Rotated Sorted Array II
 */


fun searchII(nums: IntArray, target: Int): Boolean {
    var l = 0
    var r = nums.size - 1
    while (l <= r) {
        var m = l + (r - l) / 2
        if (nums[m] == target) return true
        if (nums[l] == nums[m] && nums[m] == nums[r]) {
            l++
            r--
        } else if (nums[l] <= nums[m]) {
            if (nums[l] <= target && nums[m] >= target) r = m - 1
            else l = m + 1
        } else {
            if (target > nums[m] && target <= nums[r]) l = m + 1
            else r = m - 1
        }
    }
    return false
}

/**
 * 1422. Maximum Score After Splitting a String
 */

fun maxScore(s: String): Int {
    var maxScore = 0
    var zeros = 0
    var ones = 0


    for (char in s) {
        if (char == '1') {
            ones++
        }
    }

    for (i in 0 until s.length - 1) {
        if (s[i] == '0') {
            zeros++
        } else {
            ones--
        }
        maxScore = maxOf(maxScore, zeros + ones)
    }

    return maxScore
}

/**
 * 538. Convert BST to Greater Tree
 */


fun convertBST(root: TreeNode?): TreeNode? {
    var sum = 0
    fun dfs(root: TreeNode?) {
        if (root == null) return
        dfs(root?.right)
        sum += root.`val`
        root.`val` = sum
        dfs(root?.left)
    }
    dfs(root)
    return root
}

/**
 * 2559. Count Vowel Strings in Ranges
 */

fun vowelStrings(words: Array<String>, queries: Array<IntArray>): IntArray {
    val n = words.size
    val prefixSum = IntArray(n + 1) { 0 }


    for (i in 1..n) {
        prefixSum[i] =
            prefixSum[i - 1] + if (isVowel(words[i - 1][0]) && isVowel(words[i - 1].last())) 1 else 0
    }


    val result = IntArray(queries.size)
    for (i in queries.indices) {
        val start = queries[i][0]
        val end = queries[i][1]
        result[i] = prefixSum[end + 1] - prefixSum[start]
    }

    return result
}


private fun isVowel(char: Char): Boolean {
    return char in "aeiou"
}

/**
 * 543. Diameter of Binary Tree
 */

fun diameterOfBinaryTree(root: TreeNode?): Int {
    var diameter = 0

    fun dfs(node: TreeNode?): Int {
        if (node == null) {
            return 0
        }

        val leftDepth = dfs(node.left)
        val rightDepth = dfs(node.right)

        diameter = maxOf(diameter, leftDepth + rightDepth)

        return maxOf(leftDepth, rightDepth) + 1
    }

    dfs(root)
    return diameter
}

/**
 * 25. Reverse Nodes in k-Group
 */


fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    if (head == null || k == 1) return head

    var current = head
    var prev: ListNode? = null
    var next: ListNode? = null
    var count = 0


    var temp = current
    for (i in 0 until k) {
        if (temp == null) return head
        temp = temp.next
    }


    while (count < k && current != null) {
        next = current.next
        current.next = prev
        prev = current
        current = next
        count++
    }


    if (next != null) {
        head.next = reverseKGroup(next, k)
    }

    return prev
}

/**
 * 138. Copy List with Random Pointer
 */

class NodeCopy(var `val`: Int) {
    var next: NodeCopy? = null
    var random: NodeCopy? = null
}

fun copyRandomList(head: NodeCopy?): NodeCopy? {
    if (head == null) return null

    val map = mutableMapOf<NodeCopy, NodeCopy>()


    var current = head
    while (current != null) {
        map[current] = NodeCopy(current.`val`)
        current = current.next
    }


    current = head
    while (current != null) {
        val copy = map[current]!!
        copy.next = map[current.next]
        copy.random = map[current.random]
        current = current.next
    }

    return map[head]
}

/**
 * 383. Ransom Note
 */


fun canConstruct(ransomNote: String, magazine: String): Boolean {
    val map = mutableMapOf<Char, Int>()
    var len = magazine.length
    for (i in 0 until len) map[magazine[i]] = map.getOrDefault(magazine[i], 0) + 1
    len = ransomNote.length
    for (i in 0 until len) {
        if (!map.contains(ransomNote[i])) return false
        map[ransomNote[i]] = map.getOrDefault(ransomNote[i], 0) - 1
        if (map[ransomNote[i]] == 0) map.remove(ransomNote[i])
    }
    return true
}

/**
 * 19. Remove Nth Node From End of List
 */

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    if (head?.next == null && n == 1) return null
    var curr = head
    var size = 0
    while (curr != null) {
        size++
        curr = curr?.next
    }
    curr = head
    var prev: ListNode? = null
    var index = size - n
    if (index == 0) return head?.next
    while (curr != null) {
        if (index == 0) {
            val temp = curr?.next
            curr?.next = null
            prev?.next = null
            prev?.next = temp
            break
        }
        index--
        prev = curr
        curr = curr?.next
    }
    return head
}

/**
 * 82. Remove Duplicates from Sorted List II
 */

fun deleteDuplicatesII(head: ListNode?): ListNode? {
    head ?: return null
    var prev: ListNode? = null
    var curr: ListNode? = ListNode(-101)
    val ans = curr
    curr?.next = head
    while (curr != null) {
        if (curr?.`val` == curr?.next?.`val` ?: -101) {
            var temp = curr?.next
            while (temp?.`val` == curr?.`val`) temp = temp?.next
            curr?.next?.next = null
            curr?.next = null
            prev?.next = temp
            curr = temp
        } else {
            prev = curr
            curr = curr?.next
        }
    }
    return ans?.next
}

/**
 * 86. Partition List
 */


fun partition(head: ListNode?, x: Int): ListNode? {
    var head = head
    val smallList = ListNode(101)
    val bigList = ListNode(101)
    var small: ListNode? = smallList
    var big: ListNode? = bigList

    while (head != null) {
        if (head.`val` < x) {
            small!!.next = head
            small = small!!.next
        } else {
            big!!.next = head
            big = big!!.next
        }

        head = head.next
    }

    small!!.next = bigList.next
    big!!.next = null

    return smallList.next
}

/**
 * 61. Rotate List
 */


fun rotateRight(head: ListNode?, k: Int): ListNode? {
    var k = k
    if (head?.next == null || k == 0) return head


    var length = 1
    var tail = head
    while (tail!!.next != null) {
        length++
        tail = tail!!.next
    }


    k %= length
    if (k == 0) return head


    val breakPoint = length - k
    var current = head
    for (i in 1 until breakPoint) {
        current = current!!.next
    }


    val newHead = current!!.next
    current!!.next = null
    tail!!.next = head

    return newHead
}

/**
 * 24. Swap Nodes in Pairs
 */

fun swapPairs(head: ListNode?): ListNode? {
    if (head == null || head?.next == null) return head
    var curr = head
    var dummy = ListNode(101)
    dummy?.next = head
    var prev = dummy
    while (curr != null && curr?.next != null) {
        val temp = curr?.next?.next
        val second = curr?.next

        second?.next = curr
        curr?.next = temp
        prev?.next = second

        prev = curr
        curr = temp
    }
    return dummy?.next
}

/**
 * 328. Odd Even Linked List
 */

fun oddEvenList(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    var oddList: ListNode? = ListNode(101)
    var evenList: ListNode? = ListNode(101)
    var odd = oddList
    var even = evenList
    var curr: ListNode? = ListNode(101)
    curr?.next = head
    var index = 0
    while (curr != null) {
        if (index % 2 == 0) {
            val temp = curr?.next
            evenList?.next = temp
            evenList = evenList?.next
        } else {
            val temp = curr?.next
            oddList?.next = temp
            oddList = oddList?.next
        }
        curr = curr?.next
        index++
    }
    evenList?.next = odd?.next
    var ans = even
    val q = ans
    while (ans?.next != null) ans = ans?.next
    ans?.next = odd?.next
    return q?.next
}

/**
 * 143. Reorder List
 */


fun reorderList(head: ListNode?): Unit {
    var curr = head
    val res = mutableListOf<ListNode>()
    while (curr != null) {
        res.add(curr)
        curr = curr?.next
    }
    var ans: ListNode? = ListNode(10001)
    var i = 0
    var j = res.size - 1
    while (i < j) {
        val one = res[i]
        one?.next = null
        ans?.next = one
        ans = ans?.next
        val second = res[j]
        second?.next = null
        ans?.next = second
        ans = ans?.next
        i++
        j--
    }
    if (i == j) {
        val node = res[i]
        node?.next = null
        ans?.next = node
    }

}

/**
 * 700. Search in a Binary Search Tree
 */

fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
    if (root == null) return null

    if (`val` == root.`val`) return root

    return if (root.`val` > `val`) searchBST(root?.left, `val`) else searchBST(root?.right, `val`)
}

/**
 * 701. Insert into a Binary Search Tree
 */

fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
    if (root == null) {
        return TreeNode(`val`)
    }

    if (`val` < root.`val`) {
        root.left = insertIntoBST(root.left, `val`)
    } else {
        root.right = insertIntoBST(root.right, `val`)
    }

    return root
}

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 */

fun buildTreeFromInorderAndPostOrder(inorder: IntArray, postorder: IntArray): TreeNode? {
    return buildTreeRecursive(inorder, postorder, 0, inorder.size - 1, postorder.size - 1)
}

private fun buildTreeRecursive(
    inorder: IntArray,
    postorder: IntArray,
    inorderStart: Int,
    inorderEnd: Int,
    postorderIndex: Int
): TreeNode? {
    if (inorderStart > inorderEnd) {
        return null
    }

    val rootVal = postorder[postorderIndex]
    val root = TreeNode(rootVal)


    val inorderIndex = inorder.indexOf(rootVal)


    root.right =
        buildTreeRecursive(inorder, postorder, inorderIndex + 1, inorderEnd, postorderIndex - 1)

    val nextPostorderIndex = postorderIndex - (inorderEnd - inorderIndex) - 1
    root.left =
        buildTreeRecursive(inorder, postorder, inorderStart, inorderIndex - 1, nextPostorderIndex)


    return root
}

/**
 * 623. Add One Row to Tree
 */


fun addOneRow(root: TreeNode?, `val`: Int, depth: Int): TreeNode? {
    if (depth == 1) {
        return TreeNode(`val`).apply { left = root }
    }

    val queue = ArrayDeque<TreeNode>()
    queue.add(root!!)

    var currentDepth = 1
    while (queue.isNotEmpty()) {
        val levelSize = queue.size

        if (currentDepth == depth - 1) {

            for (i in 0 until levelSize) {
                val node = queue.removeFirst()

                val tempLeft = node.left
                val tempRight = node.right

                node.left = TreeNode(`val`).apply { left = tempLeft }
                node.right = TreeNode(`val`).apply { right = tempRight }
            }
            break
        } else {

            for (i in 0 until levelSize) {
                val node = queue.removeFirst()
                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
            }
        }

        currentDepth++
    }

    return root
}

/**
 * 671. Second Minimum Node In a Binary Tree
 */

fun findSecondMinimumValue(root: TreeNode?): Int {
    val q = LinkedList<TreeNode>()
    q.offer(root)
    val res = mutableListOf<Int>()
    while (q.isNotEmpty()) {
        val size = q.size
        for (i in 0 until size) {
            val node = q.poll()
            res.add(node.`val`)
            node?.left?.let { q.offer(it) }
            node?.right?.let { q.offer(it) }
        }
    }
    var first = Int.MAX_VALUE
    var second = Long.MAX_VALUE
    for (i in 0 until res.size) {
        first = minOf(first, res[i])
    }
    for (i in 0 until res.size) {
        if (res[i] != first) second = minOf(second, res[i].toLong())
    }
    return if (second == Long.MAX_VALUE) -1 else second.toInt()
}

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 */

fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    var current = root

    while (current != null) {
        when {
            p == null || q == null -> return null
            p.`val` < current.`val` && q.`val` < current.`val` -> current =
                current.left

            p.`val` > current.`val` && q.`val` > current.`val` -> current =
                current.right

            else -> return current
        }
    }

    return null
}

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 */

fun lowestCommonAncestorBinaryTree(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (root == null || root == p || root == q) {
        return root // Base cases: root is null, p, or q
    }

    val left = lowestCommonAncestorBinaryTree(root.left, p, q) // Search in left subtree
    val right = lowestCommonAncestorBinaryTree(root.right, p, q) // Search in right subtree

    return if (left != null && right != null) root else left ?: right // Determine LCA
}


/**
 * 155. Min Stack
 */


class MinStack() {

    private val stack: MutableList<Int> = mutableListOf()
    private val minStack: MutableList<Int> = mutableListOf()

    fun push(`val`: Int) {
        stack.add(`val`)
        if (minStack.isEmpty() || `val` <= minStack.last()) {
            minStack.add(`val`)
        }
    }

    fun pop() {
        if (stack.isNotEmpty()) {
            val top = stack.removeLast()
            if (minStack.isNotEmpty() && top == minStack.last()) {
                minStack.removeLast()
            }
        }
    }

    fun top(): Int {
        return stack.lastOrNull() ?: -1
    }

    fun getMin(): Int {
        return minStack.lastOrNull() ?: -1
    }
}


/**
 * 71. Simplify Path
 */


fun simplifyPath(path: String): String {
    val stack = ArrayDeque<String>()
    val components = path.split("/")

    for (component in components) {
        when (component) {
            "", "." -> continue // Ignore empty or "." components
            ".." -> {
                if (stack.isNotEmpty()) {
                    stack.removeLast() // Go up one level
                }
            }

            else -> stack.addLast(component) // Add valid component to stack
        }
    }

    // Build the simplified path
    val result = StringBuilder()
    while (stack.isNotEmpty()) {
        result.append("/").append(stack.removeFirst())
    }

    return if (result.isEmpty()) "/" else result.toString()
}


/**
 * 863. All Nodes Distance K in Binary Tree
 */

fun distanceK(root: TreeNode?, target: TreeNode?, k: Int): List<Int> {
    val result = mutableListOf<Int>()
    val parentMap = HashMap<TreeNode, TreeNode?>()

    // 1. Build parent map using DFS
    fun dfs(node: TreeNode?, parent: TreeNode?) {
        if (node == null) return
        parentMap[node] = parent
        dfs(node.left, node)
        dfs(node.right, node)
    }
    dfs(root, null)

    // 2. Perform BFS from target node
    val queue = ArrayDeque<TreeNode>()
    queue.add(target!!)
    val visited = HashSet<TreeNode>()
    visited.add(target)
    var distance = 0

    while (queue.isNotEmpty()) {
        val levelSize = queue.size
        for (i in 0 until levelSize) {
            val currentNode = queue.removeFirst()

            if (distance == k) {
                result.add(currentNode.`val`)
            }

            // Explore neighbors (parent, left, right)
            val neighbors = listOfNotNull(
                parentMap[currentNode],
                currentNode.left,
                currentNode.right
            )

            for (neighbor in neighbors) {
                if (neighbor != null && neighbor !in visited) {
                    visited.add(neighbor)
                    queue.add(neighbor)
                }
            }
        }
        distance++
    }

    return result
}

/**
 * 1609. Even Odd Tree
 */

fun isEvenOddTree(root: TreeNode?): Boolean {
    val q = LinkedList<TreeNode>()
    q.offer(root)
    var level = 0
    while (q.isNotEmpty()) {
        val size = q.size
        var evenTemp: TreeNode? = null
        var oddTemp: TreeNode? = null
        for (i in 0 until size) {
            val node = q.poll()

            if (level % 2 == 0) {
                if (node.`val` % 2 == 0) return false
                evenTemp = if (evenTemp == null) {
                    node
                } else {
                    if (evenTemp.`val` >= node.`val`) return false
                    else node
                }
            } else {
                if (node.`val` % 2 != 0) return false
                oddTemp = if (oddTemp == null) {
                    node
                } else {
                    if (oddTemp.`val` <= node.`val`) return false
                    else node
                }
            }
            node?.left?.let { q.offer(it) }
            node?.right?.let { q.offer(it) }
        }
        level++
    }
    return true
}

/**
 * 125. Valid Palindrome
 */

fun isPalindrome(s: String): Boolean {
    var res = ""
    var s = s.lowercase()
    for (symbol in s) {
        if (isWord(symbol) || isDigit(symbol)) res += symbol
    }
    var i = 0
    var j = res.length - 1
    while (i < j) {
        if (res[i] != res[j]) return false
        i++
        j--
    }
    return true
}

fun isWord(s: Char): Boolean {
    return s in "abcdefghijklmnopqrstuvwxyz"
}

fun isDigit(s: Char): Boolean {
    return s in "0123456789"
}

/**
 * 680. Valid Palindrome II
 */


fun validPalindrome(s: String): Boolean {
    var left = 0
    var right = s.length - 1

    while (left < right) {
        if (s[left] != s[right]) {
            return isPalindromeValid(s, left + 1, right) || isPalindromeValid(s, left, right - 1)
        }
        left++
        right--
    }

    return true
}

private fun isPalindromeValid(s: String, left: Int, right: Int): Boolean {
    var l = left
    var r = right
    while (l < r) {
        if (s[l] != s[r]) {
            return false
        }
        l++
        r--
    }
    return true
}

/**
 * 150. Evaluate Reverse Polish Notation
 */

fun evalRPN(tokens: Array<String>): Int {
    val stack = ArrayDeque<Int>()
    for (token in tokens) {
        when (token) {
            "+", "-", "*", "/" -> {
                val operand2 = stack.removeLast()
                val operand1 = stack.removeLast()
                val result = when (token) {
                    "+" -> operand1 + operand2
                    "-" -> operand1 - operand2
                    "*" -> operand1 * operand2
                    "/" -> operand1 / operand2
                    else -> 0
                }
                stack.addLast(result)
            }

            else -> stack.addLast(token.toInt())
        }
    }
    return stack.removeLast()
}


/**
 * 783. Minimum Distance Between BST Nodes
 */

fun minDiffInBST(root: TreeNode?): Int {
    if (root == null) return Int.MAX_VALUE

    val values = mutableListOf<Int>()
    inorderTraversal(root, values)

    var minDiff = Int.MAX_VALUE
    for (i in 1 until values.size) {
        minDiff = minOf(minDiff, values[i] - values[i - 1])
    }
    return minDiff
}

private fun inorderTraversal(root: TreeNode?, values: MutableList<Int>): List<Int> {
    if (root == null) return values

    inorderTraversal(root?.left, values)
    values.add(root.`val`)
    inorderTraversal(root?.right, values)
    return values
}

/**
 * 290. Word Pattern
 */


fun wordPattern(pattern: String, s: String): Boolean {
    val patternToWord = mutableMapOf<Char, String>()
    val wordToPattern = mutableMapOf<String, Char>()

    val words = s.split(" ")

    if (pattern.length != words.size) {
        return false
    }

    for (i in pattern.indices) {
        val char = pattern[i]
        val word = words[i]

        if (patternToWord.containsKey(char)) {
            if (patternToWord[char] != word) {
                return false
            }
        } else if (wordToPattern.containsKey(word)) {
            if (wordToPattern[word] != char) {
                return false
            }
        } else {
            patternToWord[char] = word
            wordToPattern[word] = char
        }
    }

    return true
}

/**
 * 1022. Sum of Root To Leaf Binary Numbers
 */

fun sumRootToLeaf(root: TreeNode?): Int {
    return dfsSumRootToLeaf(root, 0)
}

private fun dfsSumRootToLeaf(node: TreeNode?, currentSum: Int): Int {
    if (node == null) {
        return 0
    }

    val newSum = (currentSum shl 1) + node.`val`

    if (node.left == null && node.right == null) {
        return newSum
    }

    return dfsSumRootToLeaf(node.left, newSum) + dfsSumRootToLeaf(node.right, newSum)
}


/**
 * 703. Kth Largest Element in a Stream
 */


class KthLargest(private val k: Int, nums: IntArray) {
    private val minHeap: PriorityQueue<Int> = PriorityQueue() // Use min-heap

    init {
        nums.forEach { add(it) }
        while (minHeap.size > k) {
            minHeap.poll()
        }
    }

    fun add(`val`: Int): Int {
        minHeap.offer(`val`)
        if (minHeap.size > k) {
            minHeap.poll()
        }
        return minHeap.peek()
    }
}

fun pruneTree(root: TreeNode?): TreeNode? {
    if (root == null || root.`val` == 0) return null
    dfs(root)
    return root
}

private tailrec fun dfs(root: TreeNode?) {
    if (root == null) return
    if (root?.left?.`val` == 0 && root?.left?.left == null && root?.left?.right == null) {
        root?.left = null
    }
    if (root?.right?.`val` == 0 && root?.right?.left == null && root?.right?.right == null) {
        root?.right = null
    }
    if (root?.left?.`val` == 0 && root?.left?.left?.`val` == 0 && root?.left?.right?.`val` == 0) {
        root?.left = null
    }
    dfs(root?.left)
    dfs(root?.right)
}


/**
 * 872. Leaf-Similar Trees
 */


fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
    val list1 = mutableListOf<Int>()
    val list2 = mutableListOf<Int>()
    dfsleafSimillar(root1, list1)
    dfsleafSimillar(root2, list2)
    if (list1.size != list2.size) return false
    for (i in 0 until list1.size) {
        if (list1[i] != list2[i]) return false
    }
    return true
}

fun dfsleafSimillar(root: TreeNode?, list: MutableList<Int>) {
    if (root == null) return
    if (root?.left == null && root?.right == null) list.add(root.`val`)
    dfs(root?.left, list)
    dfs(root?.right, list)
}


/**
 * 502. IPO
 */

fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
    val n = profits.size
    val projects = Array(n) { i -> Pair(capital[i], profits[i]) }
    projects.sortBy { it.first }

    val pq = PriorityQueue<Int> { a, b -> b - a }

    var i = 0
    var currentCapital = w

    for (j in 0 until k) {
        while (i < n && projects[i].first <= currentCapital) {
            pq.offer(projects[i].second)
            i++
        }

        if (pq.isEmpty()) {
            break
        }
        currentCapital += pq.poll()
    }

    return currentCapital
}


/**
 * 225. Implement Stack using Queues
 */

class MyStack() {

    private val stack = mutableListOf<Int>()

    fun push(x: Int) {
        stack.add(x)
    }

    fun pop(): Int {
        return stack.removeLast()
    }

    fun top(): Int {
        return stack.last()
    }

    fun empty(): Boolean {
        return stack.isEmpty()
    }

}

/**
 * 232. Implement Queue using Stacks
 */

class MyQueue() {

    private val queue = mutableListOf<Int>()

    fun push(x: Int) {
        queue.add(x)
    }

    fun pop(): Int {
        return queue.removeFirst()
    }

    fun peek(): Int {
        return queue.first()
    }

    fun empty(): Boolean {
        return queue.isEmpty()
    }

}


/**
 * 67. Add Binary
 */


fun addBinary(a: String, b: String): String {
    var i = a.length - 1
    var j = b.length - 1
    var carry = 0
    val result = StringBuilder()

    while (i >= 0 || j >= 0 || carry > 0) {
        val digitA = if (i >= 0) a[i] - '0' else 0
        val digitB = if (j >= 0) b[j] - '0' else 0

        val sum = digitA + digitB + carry
        result.insert(0, sum % 2) // Insert at the beginning
        carry = sum / 2

        i--
        j--
    }

    return result.toString()
}


/**
 * 190. Reverse Bits
 */

fun reverseBits(n: Int): Int {
    var result = 0
    for (i in 0..31) {
        result = (result shl 1) or (n ushr i and 1)
    }
    return result
}

/**
 * 1922. Count Good Numbers
 */


fun countGoodNumbers(n: Long): Int {
    val evenDigits = (n + 1) / 2 // Number of positions for even digits
    val oddDigits = n / 2 // Number of positions for odd digits
    val MOD = 1000000007
    return (power(5, evenDigits, MOD) * power(4, oddDigits, MOD) % MOD).toInt()
}

private fun power(base: Long, exp: Long, MOD: Int): Long {
    var res = 1L
    var base = base
    var exp = exp

    while (exp > 0) {
        if (exp % 2 == 1L) {
            res = (res * base) % MOD
        }
        base = (base * base) % MOD
        exp /= 2
    }

    return res
}


/**
 * 231. Power of Two
 */

fun isPowerOfTwo(n: Int): Boolean = power(n, 2)

private tailrec fun power(n: Int, k: Int): Boolean {
    if (n == 1) return true
    if (n % k != 0 || n == 0) return false
    return power(n / k, k)
}

/**
 * 60. Permutation Sequence
 */

fun getPermutation(n: Int, k: Int): String {
    val subset = mutableListOf<Int>()
    val res = mutableListOf<MutableList<Int>>()
    val base = mutableListOf<Int>()
    for (i in 0 until n) base.add(i + 1)
    backtrack(base, subset, res)
    var ans = ""
    val arr = res[k - 1]
    for (i in 0 until arr.size) ans += arr[i].toString()
    return ans
}

fun backtrack(base: List<Int>, subset: MutableList<Int>, res: MutableList<MutableList<Int>>) {
    if (subset.size == base.size) {
        res.add(ArrayList(subset))
        return
    }
    for (i in 0 until base.size) {
        if (!subset.contains(base[i])) {
            subset.add(base[i])
            backtrack(base, subset, res)
            subset.removeAt(subset.size - 1)
        }
    }
}

/**
 * 44. Wildcard Matching
 */


fun isMatch(s: String, p: String): Boolean {
    val n = s.length
    val m = p.length
    val dp = Array(n + 1) { BooleanArray(m + 1) }

    dp[0][0] = true


    for (j in 1 until m + 1) {
        if (p[j - 1] == '*') {
            dp[0][j] = dp[0][j - 1]
        }
    }


    for (i in 1 until n + 1) {
        for (j in 1 until m + 1) {
            if (p[j - 1] == '*') {
                dp[i][j] = dp[i][j - 1] || dp[i - 1][j]
            } else if (p[j - 1] == '?' || s[i - 1] == p[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1]
            }
        }
    }

    return dp[n][m]
}


/**
 * 273. Integer to English Words
 */


private val belowTwenty = arrayOf(
    "",
    "One",
    "Two",
    "Three",
    "Four",
    "Five",
    "Six",
    "Seven",
    "Eight",
    "Nine",
    "Ten",
    "Eleven",
    "Twelve",
    "Thirteen",
    "Fourteen",
    "Fifteen",
    "Sixteen",
    "Seventeen",
    "Eighteen",
    "Nineteen"
)
private val belowHundred =
    arrayOf("", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety")
private val thousands = arrayOf("", "Thousand", "Million", "Billion")


fun numberToWords(num: Int): String {
    if (num == 0) return "Zero"

    var i = 0
    var words = ""
    var num = num

    while (num > 0) {
        if (num % 1000 != 0) {
            words = helper(num % 1000) + " " + thousands[i] + " " + words
        }
        num /= 1000
        i++
    }

    return words.trim()
}

private fun helper(num: Int): String {
    if (num == 0) return ""
    if (num < 20) return belowTwenty[num]
    if (num < 100) return belowHundred[num / 10] + (if (num % 10 != 0) " " + belowTwenty[num % 10] else "")
    return belowTwenty[num / 100] + " Hundred" + (if (num % 100 != 0) " " + helper(num % 100) else "")
}


/**
 * 3304. Find the K-th Character in String Game I
 */

fun kthCharacter(k: Int): Char {
    val res = rec(k, "a")
    return res[k - 1]
}

private fun rec(k: Int, word: String): String {
    if (word.length >= k) return word
    var res = word
    for (char in word) res += nextLetter(char)
    val ans = rec(k, res)
    return ans
}

fun nextLetter(s: Char): Char {
    val alp = "abcdefghijklmnopqrstuvwxyz"
    if (s != 'z') {
        val i = alp.indexOf(s)
        return alp[i + 1]
    } else return 'a'
}

/**
 * 3407. Substring Matching Pattern
 */


fun substringMatchingPattern(s: String, p: String): Boolean {
    for (i in s.indices) {
        if (isMatch(s, p, i)) {
            return true
        }
    }
    return false
}

private fun isMatch(s: String, p: String, start: Int): Boolean {
    var sIdx = start
    var pIdx = 0
    var starIdx = -1
    var sTmpIdx = -1

    while (sIdx < s.length) {
        if (pIdx < p.length && (p[pIdx] == s[sIdx])) {
            sIdx++
            pIdx++
        } else if (pIdx < p.length && p[pIdx] == '*') {
            starIdx = pIdx
            sTmpIdx = sIdx
            pIdx++
        } else if (starIdx == -1) {
            return false
        } else {
            pIdx = starIdx + 1
            sTmpIdx++
            sIdx = sTmpIdx
        }
    }

    while (pIdx < p.length && p[pIdx] == '*') {
        pIdx++
    }

    return pIdx == p.length
}

/**
 * 1545. Find Kth Bit in Nth Binary String
 */

fun findKthBit(n: Int, k: Int): Char {
    if (n == 1) {
        return '0'
    }

    val length = (1 shl n) - 1 // 2^n - 1
    val mid = length / 2 + 1

    return if (k == mid) {
        '1'
    } else if (k < mid) {
        findKthBit(n - 1, k)
    } else {
        invert(findKthBit(n - 1, length - k + 1))
    }
}

private fun invert(bit: Char): Char {
    return if (bit == '0') '1' else '0'
}







