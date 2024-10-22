package com.leetcode_kotlin

import java.util.Arrays
import java.util.Collections
import java.util.LinkedList
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
                nums,
                subset,
                indexList
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
    node: TreeNode?,
    targetSum: Int,
    currentPath: MutableList<Int>,
    result: MutableList<List<Int>>
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
    start: Int,
    s: String,
    list: MutableList<List<String>?>,
    current: MutableList<String>
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
    val l = dfs(root?.left, new) + temp
    val r = dfs(root?.right, new)
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
    k: Int,
    n: Int,
    index: Int,
    subset: MutableList<Int>,
    res: MutableList<MutableList<Int>>
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
        } else
            return
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
    row: Int,
    n: Int,
    solutions: MutableList<MutableList<String>>,
    board: Array<CharArray>
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
    row: Int,
    n: Int,
    board: Array<CharArray>
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
 *
 */


fun solveSudoku(board: Array<CharArray>): Unit {
    backtrack(board, 0)
}

fun backtrack(board: Array<CharArray>, row: Int) {
    if (row == 9) return
    for (col in 0..8) {
        val num = number(board, row, col)
        if (num != -1) {
            board[row][col] = num.toChar()
            backtrack(board, row + 1)
            board[row][col] = '.'
        }
    }
}

fun number(board: Array<CharArray>, row: Int, col: Int): Int {
    val valid = Array<Boolean>(10) { false }
    valid[0] = true

    for (i in 0..8) {
        if (board[row][i] != '.') {
            val num = (board[row][i]).code / 10
            valid[num] = true
        }
    }

    for (i in 0..8) {
        if (board[i][col] != '.') {
            val num = board[i][col].code / 10
            valid[num] = true
        }
    }

    var i = 0
    var j = 0
    while (i <= 2) {
        while (j <= 2) {
            if (board[i][j] != '.') {
                val num = board[i][j].code / 10
                valid[num] = true
            }
            j++
        }
        j = 0
        i++
    }
    var counter = 0
    var ind = 0
    for (i in 0..8) {
        if (!valid[i]) {
            ind = i
            counter++
        }
    }

    if (counter > 1) return -1
    return ind

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
    val res: MutableList<Long> = ArrayList() // To store sum of each level
    val q: Queue<TreeNode?> = LinkedList() // Queue for level-order traversal
    q.add(root) // Start BFS from the root node

    while (!q.isEmpty()) {
        val n = q.size // Number of nodes at the current level
        var sum: Long = 0 // Sum of node values at the current level

        for (i in 0 until n) {
            val node = q.poll()
            sum += node!!.`val`.toLong()

            if (node!!.left != null) q.add(node!!.left)
            if (node!!.right != null) q.add(node!!.right)
        }
        res.add(sum) // Store the sum of the current level
    }

    if (k > res.size) return -1

    res.sortWith(Collections.reverseOrder()) // Sort level sums in descending order

    return res[k - 1] // Return the k-th largest sum
}





























