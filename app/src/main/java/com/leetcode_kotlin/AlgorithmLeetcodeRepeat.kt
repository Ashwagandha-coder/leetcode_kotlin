package com.leetcode_kotlin

import java.util.LinkedList
import kotlin.math.abs
import kotlin.math.max


class Repeat {
    companion object {
        val value = Repeat()
    }
}


fun Repeat.missingNumber(nums: IntArray): Int {
    var sum = 0
    var len = nums.size
    for (i in 0 until len) sum += nums[i]
    return len * (len + 1) / 2 - sum
}


fun Repeat.singleNumber(nums: IntArray): Int {
    var res = 0
    for (i in 0 until nums.size) {
        res = res xor nums[i]
    }
    return res
}


fun Repeat.findDisappearedNumbers(nums: IntArray): List<Int> {
    val len = nums.size
    val set = mutableSetOf<Int>()
    val list = mutableListOf<Int>()
    for (i in 0..len - 1) set.add(nums[i])
    for (i in 1..len) {
        if (!set.contains(i)) list.add(i)
    }
    return list
}

class RepeatTreeNode(val value: Int) {
    var left: RepeatTreeNode? = null
    var right: RepeatTreeNode? = null
}


fun Repeat.bfs(root: RepeatTreeNode?): Int {
    if (root == null) return 0

    var minDepthSum = bfs(root.left)
    var maxDepthSum = bfs(root.right)

    return max(maxDepthSum, minDepthSum) + root.value
}

fun Repeat.productExceptSelf(nums: IntArray): IntArray {
    val len = nums.size
    val ans = IntArray(len)
    for (i in 0..len - 1) ans[i] = 1
    var curr = 1
    for (i in 0..len - 1) {
        ans[i] *= curr
        curr *= nums[i]
    }
    curr = 1
    for (i in len - 1 downTo 0) {
        ans[i] *= curr
        curr *= nums[i]
    }
    return ans
}

/**
 * Repeat Sorting
 */

fun Repeat.bubbleSort(arr: IntArray): IntArray {
    var len = arr.size
    while (len != 0) {
        var pointer = 0
        for (i in 1 until len) {
            if (arr[i - 1] > arr[i]) {
                swap(arr, i - 1, i)
                pointer = i
            }
        }
        len = pointer
    }
    return arr
}

fun Repeat.swap(arr: IntArray, start: Int, end: Int) {
    var tmp = arr[start]
    arr[start] = arr[end]
    arr[end] = tmp
}

fun swap(arr: IntArray, start: Int, end: Int) {
    var tmp = arr[start]
    arr[start] = arr[end]
    arr[end] = tmp
}


fun Repeat.selectionSort(arr: IntArray): IntArray {
    val len = arr.size
    for (i in 0 until len) {
        var min_index = i
        for (j in i + 1 until len) {
            if (arr[min_index] > arr[j]) min_index = j
        }
        if (min_index != i) {
            swap(arr, min_index, i)
        }
    }
    return arr
}

fun Repeat.insertionSort(arr: IntArray): IntArray {
    val len = arr.size
    for (i in 1 until len) {
        var sorted = i - 1
        while (sorted > -1 && arr[sorted] > arr[sorted + 1]) {
            swap(arr, sorted, sorted + 1)
            sorted--
        }
    }
    return arr
}

fun Repeat.quickSort(arr: IntArray): IntArray {
    quickSortHoara(arr, 0, arr.size - 1)
    return arr
}

private fun quickSortHoara(arr: IntArray, start: Int, end: Int) {
    if (start >= end) return
    var wall = partSortHoara(arr, start, end)
    quickSortHoara(arr, start, wall - 1)
    quickSortHoara(arr, wall, end)
}

private fun partSortHoara(arr: IntArray, left: Int, right: Int): Int {
    var left = left
    var right = right
    var pivot = arr[(left + right) / 2]
    while (left <= right) {
        while (arr[left] < pivot) left++
        while (arr[right] > pivot) right--
        if (left <= right) {
            swap(arr, left, right)
            left++
            right--
        }
    }

    return left

}


fun Repeat.rotate(matrix: Array<IntArray>): Unit {
    val len = matrix.size
    // flip
    var top = 0
    var bottom = len - 1
    while (top < bottom) {
        for (col in 0 until len) {
            swapMatrix(matrix, top, bottom, col)
        }
        top++
        bottom--
    }
    // transpose
    for (i in 0 until len) {
        for (j in i + 1 until len) {
            swapMatrix(matrix, i, j)
        }
    }

}


fun Repeat.swapMatrix(matrix: Array<IntArray>, top: Int, bottom: Int, col: Int) {
    var temp = matrix[top][col]
    matrix[top][col] = matrix[bottom][col]
    matrix[bottom][col] = temp
}

fun Repeat.swapMatrix(matrix: Array<IntArray>, row: Int, col: Int) {
    var temp = matrix[row][col]
    matrix[row][col] = matrix[col][row]
    matrix[col][row] = temp
}


fun Repeat.selectSort(arr: IntArray): IntArray {
    val len = arr.size
    for (i in 0 until len) {
        var min_index = i
        for (j in i + 1 until len) {
            if (arr[min_index] > arr[j]) min_index = j
        }
        if (min_index != i) {
            var temp = arr[min_index]
            arr[min_index] = arr[i]
            arr[i] = arr[min_index]
        }
    }
    return arr
}

/**
 * Sample Solution
 */


fun Repeat.lexicalOrder(n: Int): List<Int> {
    if (n == 1) return listOf(1)
    val res = mutableListOf<Int>()
    var curr = 1
    for (i in 1..n) {
        res.add(curr)
        if (curr * 10 <= n) curr *= 10
        else {
            while (curr % 10 == 9 || curr >= n) {
                curr /= 10
            }
            curr += 1
        }
    }
    return res
}


/**
 * Selection Sort Repeat
 */


fun Repeat.selectionSort2(arr: IntArray): IntArray {
    val len = arr.size
    for (i in 0 until len) {
        var min = i
        for (j in i + 1 until len) {
            if (arr[min] > arr[j]) min = j
        }
        if (min != i) swapSelectionSort(arr, min, i)
    }
    return arr
}

fun Repeat.swapSelectionSort(nums: IntArray, start: Int, end: Int) {
    var temp = nums[start]
    nums[start] = nums[end]
    nums[end] = temp
}


/**
 * Repeat Quick Sort
 */


fun Repeat.wrapQuickSort2(arr: IntArray): IntArray {
    quickSort2(arr, 0, arr.size - 1)
    return arr
}

fun Repeat.quickSort2(arr: IntArray, start: Int, end: Int) {
    if (start >= end) return
    val wall = partSortHoara2(arr, start, end)
    quickSort2(arr, start, wall - 1)
    quickSort2(arr, wall, end)
}

internal fun partSortHoara2(arr: IntArray, start: Int, end: Int): Int {
    var left = start
    var right = end
    val pivot = arr[(left + right) / 2]
    while (left <= right) {
        while (arr[left] < pivot) left++
        while (arr[right] > pivot) right--
        if (left <= right) {
            customSwap(arr, left, right)
            left++
            right--
        }
    }
    return left
}

internal fun customSwap(nums: IntArray, start: Int, end: Int) {
    var temp = nums[start]
    nums[start] = nums[end]
    nums[end] = temp
}


/**
 * Repeat Subset
 */

fun Repeat.subset(nums: IntArray): List<List<Int>> {
    val res = mutableListOf<MutableList<Int>>()
    val subset = mutableListOf<Int>()
    return res
}

fun Repeat.backTrackSubset(
    nums: IntArray,
    index: Int,
    subset: MutableList<Int>,
    res: MutableList<MutableList<Int>>
) {
    if (index == nums.size) {
        res.add(ArrayList(subset))
        return
    }

    subset.add(nums[index])
    backTrackSubset(nums, index + 1, subset, res)

    subset.removeAt(subset.size - 1)
    backTrackSubset(nums, index + 1, subset, res)
    return
}


fun Repeat.selectionSort3(arr: IntArray): IntArray {
    val len = arr.size
    for (i in 0 until len) {
        var min = i
        for (j in i + 1 until len) {
            if (arr[min] > arr[j]) min = j
        }
        if (min != i) {
            swapSelectionSortElement(arr, min, i)
        }
    }
    return arr
}

fun Repeat.swapSelectionSortElement(arr: IntArray, start: Int, end: Int) {
    var temp = arr[start]
    arr[start] = arr[end]
    arr[end] = temp
}

/**
 * Repeat Quick Sort
 */


fun Repeat.myWrap(arr: IntArray): IntArray {
    wrapQuickSort(arr, 0, arr.size - 1)
    return arr
}

fun Repeat.wrapQuickSort(arr: IntArray, start: Int, end: Int) {
    if (start >= end) return
    val wall = partOfSortHoaraRepeat(arr, start, end)
    wrapQuickSort(arr, start, wall - 1)
    wrapQuickSort(arr, wall, end)
}

fun Repeat.partOfSortHoaraRepeat(arr: IntArray, start: Int, end: Int): Int {
    var left = start
    var right = end
    val pivot = arr[(left + right) / 2]
    while (left <= right) {
        while (arr[left] < pivot) left++
        while (arr[right] > pivot) right--
        if (left <= right) {
            swapElementQuickSort(arr, left, right)
            left++
            right--
        }
    }
    return left
}

fun Repeat.swapElementQuickSort(arr: IntArray, start: Int, end: Int) {
    var temp = arr[start]
    arr[start] = arr[end]
    arr[end] = temp
}

/**
 *  generate Parentheses
 */


fun Repeat.generateParentheses(n: Int): List<String> {
    val res = mutableListOf<String>()
    generateParenthesesDfs(n, 0, 0, "", res)
    return res
}

private fun dfs(n: Int, open: Int, close: Int, subset: String, res: MutableList<String>) {
    if (open == close && open + close == n * 2) {
        res.add(subset)
        return
    }
    if (open < n) {
        dfs(n, open + 1, close, "$subset(", res)
    }

    if (close < open) {
        dfs(n, open, close + 1, "$subset)", res)
    }
    return
}

/**
 * Longest Consecutive SubSequence
 */


/**
 * Longest Common Prefix
 */


fun longestCommonPrefix(strs: Array<String>): String {
    val map = mutableMapOf<Char, Int>()
    val size = strs.size
    var prefix = ""
    for (str in strs) {
        var len = str.length - 1
        for (j in 0 until len) {
            if (!map.contains(str[j])) map[str[j]] = 1
            else {
                var value = map[str[j]]
                value = value!! + 1
                map[str[j]] = value
            }
            if (map[str[j]] == size) prefix += str[j]
        }
    }
    return prefix
}


/**
 * genearte paranthesis
 */

fun Repeat.generate(n: Int): List<String> {
    val res = mutableListOf<String>()
    generateParenthesesDfs(n, 0, 0, "", res)
    return res
}

private fun Repeat.dfs(n: Int, openC: Int, close: Int, subset: String, res: MutableList<String>) {
    if (openC == close && openC + close == n * 2) {
        res.add(subset)
        return
    }

    if (openC < n) {
        generateParenthesesDfs(n, openC + 1, close, subset, res)
    }
    if (close < openC) {
        generateParenthesesDfs(n, openC, close + 1, subset, res)
    }
    return
}

/**
 * Repeat Selection Sort
 * 3.10.24
 */


fun Repeat.selectionSortRepeat(arr: IntArray): IntArray {
    val len = arr.size
    for (i in 0 until len) {
        var min = i
        for (j in i + 1 until len) {
            if (arr[min] > arr[j]) min = j
        }
        if (min != i) swapSelectionSortRepeat(arr, min, i)
    }
    return arr
}

fun Repeat.swapSelectionSortRepeat(arr: IntArray, start: Int, end: Int) {
    var temp = arr[start]
    arr[start] = arr[end]
    arr[end] = temp
}


/**
 * 22. Generate Parentheses
 */

fun Repeat.generateParenthesis(n: Int): List<String> {
    val res = mutableListOf<String>()
    generateParenthesesDfs(n, 0, 0, "", res)
    return res
}

fun Repeat.generateParenthesesDfs(
    n: Int,
    openC: Int,
    close: Int,
    subset: String,
    res: MutableList<String>
) {
    if (openC == close && openC + close == n * 2) {
        res.add(subset)
        return
    }
    if (openC < n) {
        generateParenthesesDfs(n, openC + 1, close, "$subset(", res)
    }
    if (close < openC) {
        generateParenthesesDfs(n, openC, close + 1, "$subset)", res)
    }
    return
}

/**
 * 213. House Robber II
 */

fun Repeat.rob(nums: IntArray): Int {
    if (nums.size == 1) return nums[0]
    return max(nums.maxRob(0, nums.size - 2), nums.maxRob(1, nums.size - 1))
}

fun IntArray.maxRob(start: Int, end: Int): Int {
    var alt = 0
    var max = 0
    for (i in start..end) {
        var temp = max(max, alt + this[i])
        alt = max
        max = temp
    }
    return max
}

/**
 *  46.Permutations
 */


fun Repeat.permute(nums: IntArray): MutableList<List<Int>> {
    val res: MutableList<List<Int>> = ArrayList()
    backtrack(res, ArrayList(), nums)
    return res
}

private fun Repeat.backtrack(
    res: MutableList<List<Int>>,
    tempList: MutableList<Int>,
    nums: IntArray
) {
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
    }
    return
}

/**
 * Repeat Bubble Sort
 */


fun Repeat.bubbleSortRepeat(arr: IntArray): IntArray {
    val len = arr.size
    for (i in 0 until len) {
        for (j in i + 1 until len) {
            if (arr[i] > arr[j]) {
                arr.swapBubbleSort(i, j)
            }
        }
    }
    return arr
}

fun IntArray.swapBubbleSort(start: Int, end: Int) {
    var temp = this[start]
    this[start] = this[end]
    this[end] = temp
}

/**
 * Repeat Lexicographical Numbers
 */


fun Repeat.lexicalOrderOther(n: Int): List<Int> {
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
 * Repeat countGoodSubstrings
 * With Set Solution
 */


fun Repeat.countGoodSubstrings(s: String): Int {
    val len = s.length
    val set = mutableSetOf<Char>()
    val k = 3
    var count = 0
    for (i in 0 until len - (k - 1)) {
        var substring = s.substring(i, i + k)
        var isUnique = true
        for (c in substring) {
            if (!set.add(c)) {
                isUnique = false
                break
            }
        }
        if (isUnique) {
            count++
        }
        set.clear()
    }
    return count
}

/**
 * 46. Permutations
 */

fun Repeat.permuteOther(nums: IntArray): List<List<Int>> {
    val res = mutableListOf<MutableList<Int>>()
    val subset = mutableListOf<Int>()
    rec(nums, subset, res)
    return res
}

fun rec(nums: IntArray, subset: MutableList<Int>, res: MutableList<MutableList<Int>>) {
    if (subset.size == nums.size) {
        res.add(ArrayList(subset))
        return
    } else {
        for (i in nums.indices) {
            if (!subset.contains(nums[i])) {
                subset.add(nums[i])
                rec(nums, subset, res)
                subset.removeAt(subset.size - 1)
            }
        }
    }
    return
}

/**
 * Repeat findDisappearedNumbers
 * Time - O(n)
 * Space - O(1)
 */

fun Repeat.findDisappearedNumbersOther(nums: IntArray): List<Int> {
    val res = ArrayList<Int>()
    val mark = -1
    val len = nums.size
    for (i in 0 until len) {
        var ind = abs(nums[i]) - 1
        if (nums[ind] > 0) nums[ind] *= mark
    }
    for (i in 0 until len) {
        if (nums[i] > 0) res.add(i + 1)
    }
    return res
}

/**
 * Repeat Contains Duplicate III
 */

fun Repeat.containsNearbyAlmostDuplicate(nums: IntArray, indexDiff: Int, valueDiff: Int): Boolean {
    val len = nums.size
    if (valueDiff == 0) {
        val map = mutableMapOf<Int, Int>()
        for (i in 0 until len) {
            if (map.contains(nums[i])) {
                var j = map.get(nums[i])
                if (abs(i - j!!) <= indexDiff) return true
            }
            map[nums[i]] = i
        }
        return false
    }
    var state = false
    for (k in 1..indexDiff) {
        state = slidingWindow(k, len, valueDiff, nums)
        if (state) return true
    }
    return state
}

fun Repeat.slidingWindow(k: Int, len: Int, valueDiff: Int, nums: IntArray): Boolean {
    var i = 0
    var j = k
    while (j < len) {
        if (abs(nums[i] - nums[j]) <= valueDiff) return true
        i++
        j++
    }
    return false
}


/**
 * Repeat contains duplicate III
 */


fun Repeat.containsNearbyAlmostDuplicateIII(
    nums: IntArray,
    indexDiff: Int,
    valueDiff: Int
): Boolean {
    if (valueDiff == 0) {
        val map = mutableMapOf<Int, Int>()
        val len = nums.size
        for (i in 0 until len) {
            if (map.contains(nums[i])) {
                val j = map[nums[i]]
                if (abs(i - j!!) <= indexDiff) return true
            }
            map[nums[i]] = i
        }
        return false
    }
    var ans = false
    for (k in 1..indexDiff) {
        ans = nums.slidingWindow(k, valueDiff)
        if (ans) return true
    }
    return ans
}

fun IntArray.slidingWindow(k: Int, valueDiff: Int): Boolean {
    var j = k
    var i = 0
    val len = this.size
    while (j < len) {
        if (abs(this[i] - this[j]) <= valueDiff) return true
        i++
        j++
    }
    return false
}

/**
 * Repeat Insertion Sort
 */

fun Repeat.insertionSortProd(arr: IntArray): IntArray {
    val len = arr.size
    for (i in 1 until len) {
        var sorted = i - 1
        while (sorted > -1 && arr[sorted] > arr[sorted + 1]) {
            swapInsertionSort(arr, sorted, sorted + 1)
            sorted--
        }
    }
    return arr
}

fun Repeat.swapInsertionSort(arr: IntArray, left: Int, right: Int) {
    var temp = arr[left]
    arr[left] = arr[right]
    arr[right] = temp
}

/**
 * Repeat tabulation for fibonacci
 */

fun Repeat.tabulation(param: Int): Int {
    val arr = IntArray(param + 1)
    arr[0] = 0
    arr[1] = 1
    for (i in 2..param) {
        arr[i] = arr[i - 1] + arr[i - 2]
    }
    return arr[param]
}

/**
 * Repeat memoization for fibonacci
 */

fun Repeat.memoization(param: Int): Int {
    val cache = IntArray(param + 1)
    cache[0] = 0
    cache[1] = 1
    return fib(param, cache)
}

fun Repeat.fibMemoization(param: Int, cache: IntArray): Int {
    if (param == 0) return 0
    if (param == 1) return 1
    if (cache[param] == 0) {
        var a = fibMemoization(param - 2, cache)
        var b = fibMemoization(param - 1, cache)
    }
    return cache[param]
}

/**
 * Repeat insertion Sort yet
 */

fun insertionSortRepeatInOctember(arr: IntArray): IntArray {
    val len = arr.size
    for (i in 0 until len) {
        var sorted = i - 1
        while (sorted > -1 && arr[sorted] > arr[sorted + 1]) {
            val temp = arr[sorted]
            arr[sorted] = arr[sorted + 1]
            arr[sorted + 1] = temp
            sorted--
        }
    }
    return arr
}

/**
 * Repeat Contains Duplicate III
 */

fun Repeat.containsDuplicateNearbyAlmost(arr: IntArray, indexDiff: Int, valueDiff: Int): Boolean {
    val map = mutableMapOf<Int, Int>()
    val len = arr.size
    val w = valueDiff + 1
    for (i in 0 until len) {
        val key = id(arr[i], w)
        if (map.contains(key)) return true
        if (map.contains(key - 1) && abs(arr[i] - map[key - 1]!!) <= valueDiff) return true
        if (map.contains(key + 1) && abs(arr[i] - map[key + 1]!!) <= valueDiff) return true
        map[key] = arr[i]
        if (i >= indexDiff) map.remove(id(arr[i - indexDiff], w))
    }
    return false
}

fun Repeat.id(value: Int, w: Int): Int {
    return if (value < 0) value + 1 / w + 1 else value / w
}

/**
 * Repeat Combinations
 */

fun Repeat.combine(n: Int, k: Int): List<List<Int>> {
    if (n == 1 && k == 1) return listOf(listOf(1))
    val res = mutableListOf<MutableList<Int>>()
    val subset = mutableListOf<Int>()
    backtracking(n, k, 1, subset, res)
    return res
}

fun Repeat.backtracking(
    n: Int,
    k: Int,
    index: Int,
    subset: MutableList<Int>,
    res: MutableList<MutableList<Int>>
) {
    if (subset.size == k) {
        res.add(ArrayList(subset))
        return
    }
    for (i in index..n) {
        subset.add(i)
        backtracking(n, k, i + 1, subset, res)
        subset.removeAt(subset.size - 1)
    }
    return
}

/**
 * Repeat Best Time and Sell Stocks
 */

fun Repeat.maxProfit(prices: IntArray): Int {
    var profit = 0
    val len = prices.size
    for (i in 1 until len) {
        if (prices[i] > prices[i - 1]) {
            profit += prices[i] - prices[i - 1]
        }
    }
    return profit
}

/**
 * Repeat Same Tree
 */

fun Repeat.isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    val one = p?.`val`
    val two = q?.`val`

    if (one != two) return false

    if (p != null && q != null) {
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }

    return true
}

/**
 * Repeat Reverse odd level of a Binary Tree
 */

fun Repeat.reverseOddLevels(root: TreeNode?): TreeNode? {
    dfs(root?.left, root?.right, 1)
    return root
}

fun dfs(left: TreeNode?, right: TreeNode?, level: Int) {
    if (left == null && right == null) return

    if (level % 2 != 0) {
        val temp = left?.`val`
        left?.`val` = right?.`val`!!
        right?.`val` = temp!!
    }
    dfs(left?.left, right?.right, level + 1)
    dfs(left?.right, right?.left, level + 1)
    return
}

/**
 * Repeat Range Sum Query - Immutable
 */

class RepeatNumArray(val nums: IntArray) {

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
 * Repeat BFS
 */


fun Repeat.bfs(root: TreeNode?): List<Int> {
    val q = LinkedList<TreeNode>()
    val res = mutableListOf<Int>()
    q.offer(root)

    while (q.isNotEmpty()) {
        val node = q.poll()
        res.add(node.`val`)
        if (node?.left != null) q.offer(node?.left)
        if (node?.right != null) q.offer(node?.right)
    }
    return res
}


/**
 * Repeat Selection Sort
 */

fun Repeat.selectionSortFinalOctember(arr: IntArray): IntArray {
    val len = arr.size
    for (i in 0 until len) {
        var min = i
        for (j in i + 1 until len) {
            if (arr[j] < arr[min]) min = j
        }
        if (min != i) {
            val temp = arr[min]
            arr[min] = arr[i]
            arr[i] = temp
        }
    }
    return arr
}

/**
 * 448. Find All Numbers Disappeared in an Array
 * Repeat
 */

fun findDisappearedNumbersRepeat(nums: IntArray): List<Int> {
    val res = mutableListOf<Int>()
    val mark = -1
    val len = nums.size
    for (i in 0 until len) {
        val ind = abs(nums[i])
        if (nums[ind - 1] > 0) nums[ind - 1] *= mark
    }
    for (i in 0 until len) {
        if (nums[i] > 0) res.add(i + 1)
    }
    return res
}

/**
 * 1876. Substrings of Size Three with Distinct Characters
 * Repeat
 */

fun countGoodSubstringsRepeat(s: String): Int {
    val len = s.length
    val set = mutableSetOf<Char>()
    val k = 3
    var count = 0
    for (i in 0 until len - 2) {
        val sub = s.substring(i, k + i)
        var isUnique = true
        for (char in sub) {
            if (!set.add(char)) {
                isUnique = false
                break
            }
        }
        if (isUnique) count++
        set.clear()
    }
    return count
}

/**
 * BFS Repeat
 */

fun bfsRepeat(root: TreeNode): List<Int> {
    if (root == null) return listOf()
    val queue = LinkedList<TreeNode>()
    val res = mutableListOf<Int>()
    queue.offer(root)
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 0 until size) {
            val node = queue.poll()
            res.add(node.`val`)
            node.also {
                if (it.left != null) queue.offer(node?.left)
                if (it.right != null) queue.offer(node?.right)
            }
        }
    }
    return res
}

/**
 * Repeat Length Incresing Subsequnce
 */

fun Repeat.lengthOfIncreasingSubsequence(nums: IntArray): Int {
    val len = nums.size
    val dp = IntArray(len) { 1 }
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
 * Repeat longest Palindrome
 */

fun longestPalindromeRepeat(s: String): String {
    if (s.length == 1) return s
    val len = s.length
    val dp = Array(len) { BooleanArray(len) }
    var maxLen = 0
    var start = 0
    var end = 0
    for (i in 0 until len) dp[i][i] = true
    for (i in 0 until len - 1) {
        if (s[i] == s[i + 1]) {
            dp[i][i + 1] = true
            start = i
            end = i + 1
            maxLen = 2
        }
    }
    for (size in 3..len) {
        for (i in 0 until (len - size) + 1) {
            var j = i + (size - 1)
            if (s[i] == s[j] && dp[i + 1][j - 1]) {
                dp[i][j] = true
                if (size > maxLen) {
                    maxLen = size
                    start = i
                    end = j
                }
            }
        }
    }
    return s.substring(start, end + 1)
}