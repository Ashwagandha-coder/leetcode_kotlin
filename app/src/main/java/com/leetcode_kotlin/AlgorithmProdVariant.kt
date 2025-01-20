package com.leetcode_kotlin

import android.annotation.SuppressLint
import java.util.LinkedList
import java.util.PriorityQueue
import kotlin.math.abs


class ProdVariant {

    companion object {
        val value = ProdVariant()
    }
}

/**
 * 121. Best Time to Buy and Sell Stock
 * Prod Variant
 */

fun maxProfitIProdVariant(nums: IntArray): Int {
    var maxProfit = Int.MIN_VALUE
    var minPrice = Int.MAX_VALUE
    nums.forEach { price ->
        minPrice = minOf(minPrice, price)
        maxProfit = maxOf(maxProfit, price - minPrice)
    }
    return maxProfit
}


fun maxProfitIProdVariantWithFold(prices: IntArray): Int {
    return prices.fold(Pair(Int.MAX_VALUE, 0)) { (minPrice, maxProfit), price ->
        val currentMinPrice = minOf(minPrice, price)
        val currentMaxProfit = maxOf(maxProfit, price - minPrice)
        Pair(currentMinPrice, currentMaxProfit)
    }.second
}


/**
 * 123. Best Time to Buy and Sell Stock III
 * Prod Variant
 */


fun ProdVariant.maxProfitIII(prices: IntArray): Int {
    var buy1 = Int.MAX_VALUE
    var buy2 = Int.MAX_VALUE
    var sell1 = Int.MIN_VALUE
    var sell2 = Int.MIN_VALUE
    prices.forEach {
        buy1 = minOf(buy1, it)
        sell1 = maxOf(sell1, it - buy1)
        buy2 = minOf(buy2, it - sell1)
        sell2 = maxOf(sell2, it - buy2)
    }
    return sell2
}

/**
 * 268. Missing Number
 * Prod Variant
 */


fun ProdVariant.missingNumber(nums: IntArray): Int {
    var res = nums.size
    nums.forEachIndexed { index, _ ->
        res += index
    }
    return res - nums.sum()
}

/**
 * 188.Best Time to Buy and Sell Stock IV
 * Prod Variant
 */


fun maxProfitIV(prices: IntArray, k: Int): Int {
    val n = prices.size
    if (n == 0 || k == 0) {
        return 0
    }

    // Если k достаточно большое, используемупрощенный подход
    if (k >= n / 2) {
        return prices.asSequence().zipWithNext() // Соединяем элементы последовательно
            .filter { (prev, curr) -> curr > prev } // Фильтруем пары, где текущий элемент больше предыдущего
            .sumOf { (prev, curr) -> curr - prev } // Суммируем разницы
    }

    // Функциональный DP с использованием fold
    return (1..k).fold(Pair(IntArray(n) { Int.MIN_VALUE }, IntArray(n) { 0 })) { (buy, sell), i ->
        val newBuy = prices.indices.drop(1).map { j ->
            maxOf(buy[j - 1], sell[j - 1] - prices[j - 1])
        }.toIntArray()

        val newSell = prices.indices.drop(1).map { j ->
            maxOf(sell[j - 1], newBuy[j - 1] + prices[j - 1])
        }.toIntArray()

        Pair(newBuy, newSell)
    }.second.last() // Возвращаем последний элемент массива sell
}

/**
 * 122. Best Time to Buy and Sell Stock II
 * Prod Variant
 */

fun maxProfitIIProdVariant(prices: IntArray): Int =
    prices.asSequence().zipWithNext().filter { (prev, curr) -> curr > prev }
        .sumOf { (prev, curr) -> curr - prev }


/**
 * 100.Same Tree
 * Prod Variant
 */

fun isSameTreeProdVariant(p: TreeNode?, q: TreeNode?): Boolean {
    return when {
        p == null && q == null -> true
        p == null || q == null -> false
        p.`val` != q.`val` -> false
        else -> isSameTreeProdVariant(p.left, q.left) && isSameTreeProdVariant(p.right, q.right)
    }
}

/**
 * 2415.Reverse Odd Level of al Binary Tree
 * Prod Variant
 */

fun reverseOddLevelBinaryTree(root: TreeNode?): TreeNode? {
    dfsProdVariant(root?.left, root?.right, 1)
    return root
}

fun dfsProdVariant(left: TreeNode?, right: TreeNode?, level: Int) {
    when {
        left == null && right == null -> return
        level % 2 != 0 -> {
            val temp = left?.`val`
            left?.`val` = right?.`val`!!
            right?.`val` = temp!!
        }

        else -> {
            dfsProdVariant(left?.left, right?.right, level + 1)
            dfsProdVariant(left?.right, right?.left, level + 1)
        }

    }
}

/**
 * 322. Coin Change
 * Prod Variant
 */

fun coinChangeProdVariant(coins: IntArray, amount: Int): Int {
    val dp = IntArray(amount + 1) { Int.MAX_VALUE }.apply {
        this[0] = 0
    }

    coins.forEach { coin ->
        (coin..amount).forEach { i ->
            if (dp[i - coin] != Int.MAX_VALUE) {
                dp[i] = minOf(dp[i], 1 + dp[i - coin])
            }
        }
    }
    return dp[amount].takeIf { it != Int.MAX_VALUE } ?: -1
}

/**
 * 51. N-Queens
 * Prod Variant
 */

fun solveNQueensProdVariant(n: Int): List<List<String>> {
    val initialBoard = Array(n) { CharArray(n) { '.' } }
    return solve(initialBoard, 0, n)
}


fun isSafe(board: Array<CharArray>, row: Int, col: Int, n: Int): Boolean = (0 until row).none { i ->
    board[i][col] == 'Q' || // Check column
            col - row + i >= 0 && board[i][col - row + i] == 'Q' || // Check main diagonal
            col + row - i < n && board[i][col + row - i] == 'Q'  // Check anti-diagonal
}


fun solve(board: Array<CharArray>, row: Int, n: Int): List<List<String>> = if (row == n) {
    listOf(board.map { it.joinToString("") })
} else {
    (0 until n).filter { col -> isSafe(board, row, col, n) }.flatMap { col ->
        val newBoard = board.map { it.copyOf() }.toTypedArray()
        newBoard[row][col] = 'Q'
        solve(newBoard, row + 1, n)
    }
}


/**
 * 128. Longest Consecutive Sequence
 * Prod Variant
 */


fun longestConsecutiveSequenceProdVariant(nums: IntArray): Int {
    val set = nums.toHashSet()
    return set.filter { !set.contains(it - 1) }.maxOfOrNull { num ->
        generateSequence(num) { s -> s + 1 }.takeWhile {
            set.contains(it)
        }.count()
    } ?: 0
}


/**
 * 448. Find All Numbers Disappeared in an Array
 * Prod Variant
 */

fun findDisappearedNumberProdVariant(nums: IntArray): List<Int> {
    val mark = -1
    val res = mutableListOf<Int>()
    nums.forEach {
        val ind = abs(it)
        if (nums[ind - 1] > 0) nums[ind - 1] *= mark
    }
    nums.forEachIndexed { index, i ->
        if (nums[index] > 0) res.add(index + 1)
    }
    return res
}

/**
 * 448. Find All Numbers Disappeared in an Array
 * Prod Variant II
 */


fun findDisappearedNumberProdVariantII(nums: IntArray): List<Int> {
    val mark = -1
    nums.forEach {
        val index = abs(it)
        if (nums[index - 1] > 0) nums[index - 1] *= mark
    }

    return (1..nums.size).filter { nums[it - 1] > 0 }
}

/**
 * 485. Max Consecutive Ones
 * Prod Variant
 */

fun findMaxConsecutiveOnesProdVariant(nums: IntArray): Int {
    var longest = 0
    var max = 0
    nums.forEach {
        if (it == 1) max++
        if (it == 0) {
            longest = maxOf(longest, max)
            max = 0
        }
    }
    return maxOf(longest, max)
}

/**
 * 485. Max Consecutive Ones
 * Prod Variant II
 */


fun findMaxConsecutiveOnesProdVariantII(nums: IntArray): Int {
    return nums.fold(0 to 0) { (maxCount, currentCount), num ->
        if (num == 1) {
            val updatedCurrentCount = currentCount + 1
            maxOf(maxCount, updatedCurrentCount) to updatedCurrentCount
        } else {
            maxCount to 0
        }
    }.first
}

/**
 * 643. Maximum Average Subarray I
 * Prod Variant
 */

fun findMaxAverageProdVariant(nums: IntArray, k: Int): Int {
    var sum = nums.take(k).sum()
    var maxSum = sum
    for (i in k until nums.size) {
        sum += nums[i]
        sum -= nums[i - k]
        maxSum = maxOf(maxSum, sum)
    }
    return maxSum / k
}

/**
 * 1876. Substrings of Size Three with Distinct Characters
 * Prod Variant
 */

fun countGoodSubstringsProdVariant(s: String): Int = s.windowed(3).count { it.toSet().size == 3 }


/**
 * 392. Is Subsequence
 * Prod Variant
 */


fun isSubsequenceProdVariant(s: String, t: String): Boolean {
    var sIndex = 0
    t.forEach {
        if (sIndex < s.length && s[sIndex] == it) sIndex++
    }
    return sIndex == s.length
}

/**
 * 5. Longest Palindromic Substring
 * Prod Variant
 * Time - O(n^3)
 * Space - O(n^2)
 */

fun String.longestPalindrome(): String {
    return (1..length).flatMap { i ->
        (0 until length - i + 1).map { j ->
            substring(j, j + 1)
        }
    }.filter { it == it.reversed() }.maxByOrNull { it.length } ?: ""
}

/**
 * 7. Reverse Integer
 * Prod Variant
 */

fun Int.reverse(number: Int): Int {
    val reversed = number.toString().reversed()
    return try {
        reversed.toInt()
    } catch (e: NumberFormatException) {
        0
    }
}

/**
 * 206. Reverse Linked List
 * Prod Variant
 */

fun ListNode.reverse(): ListNode? {
    return when {
        this == null || next == null -> this
        else -> {
            val tail = next?.reverse()
            next?.next = this
            next = null
            tail
        }
    }
}

/**
 * 506. Relative Ranks
 * Prod Variant
 */

@SuppressLint("NewApi")
fun findRelativeRanksProdVariant(nums: IntArray): Array<String> {
    val pq = PriorityQueue<Int> { a, b -> b - a }
    val map = mutableMapOf<Int, Int>()
    val res = Array(nums.size) { "" }
    nums.forEachIndexed { e, index ->
        map[e] = index
        pq.offer(e)
    }
    repeat(nums.size) {
        val num = pq.poll()
        val index = map.getOrDefault(num, 0)
        res[index] = when (it) {
            1 -> "Gold Medal"
            2 -> "Silver Medal"
            3 -> "Bronze Medal"
            else -> num.toString()
        }
    }
    return res
}

/**
 * 102. Binary Tree Level Order Traversal
 * Prod Variant
 * Time - O(n)
 * Space - O(W) where W - is width in each level in tree
 */

fun levelOrderProdVariant(root: TreeNode?): List<List<Int>> = bfsProdVariant(root)

fun bfsProdVariant(root: TreeNode?): List<List<Int>> {
    val res = mutableListOf<MutableList<Int>>()
    if (root == null) return res
    val queue = LinkedList<TreeNode>()
    while (queue.isNotEmpty()) {
        val size = queue.size
        val subset = mutableListOf<Int>()
        repeat(size) {
            val node = queue.poll()
            subset.add(node.`val`)
            node.left?.let { queue.offer(it) }
            node.right?.let { queue.offer(it) }
        }
        res.add(subset)
    }
    return res
}

/**
 * 113. Path Sum II
 * Prod Variant
 * Time - O(n)
 * Space - O(H) where H - is height tree
 */

fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
    val result: MutableList<List<Int>> = ArrayList()
    val currentPath: MutableList<Int> = ArrayList()
    dfsPathSumProdVariant(root, currentPath, 0, targetSum, result)
    return result
}


fun dfsPathSumProdVariant(
    node: TreeNode?,
    currentPath: List<Int>,
    currentSum: Int,
    target: Int,
    result: MutableList<List<Int>>
) {
    node ?: return // If node is null, return

    val newPath = currentPath + node.`val`
    val newSum = currentSum + node.`val`

    if (node.left == null && node.right == null && newSum == target) {
        result.add(newPath) // Add the path to the result
    } else {
        node.left?.let {
            dfsPathSumProdVariant(
                it, newPath, newSum, target, result
            )
        }
        node.right?.let {
            dfsPathSumProdVariant(
                it, newPath, newSum, target, result
            )
        }
    }
}


/**
 * 39. Combination Sum
 * Prod Variant
 * Time - O(2^N)
 * Space - O(N)
 */

fun combinationSumProdVariant(candidates: IntArray, target: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    backtrackProdVariant(candidates, mutableListOf(), target, 0, result)
    return result
}

fun backtrackProdVariant(
    candidates: IntArray,
    combination: List<Int>,
    remaining: Int,
    start: Int,
    res: MutableList<List<Int>>
) {
    if (remaining == 0) {
        res.add(combination)
        return
    }

    if (remaining < 0) {
        return
    }

    for (i in start until candidates.size) {
        backtrackProdVariant(
            candidates, (combination + candidates[i]), remaining - candidates[i], i, res
        )
    }
    return
}

/**
 * 347. Top K Frequent Elements
 * Prod Variant
 */

fun topKFrequentProdVariant(nums: IntArray, k: Int): IntArray {
    return nums.toList().groupingBy { it } // Group elements by their values
        .eachCount() // Count the frequency of each element
        .entries // Get the entries (key-value pairs)
        .sortedByDescending { it.value } // Sort by frequency in descending order
        .take(k) // Take the top k elements
        .map { it.key } // Extract the keys (elements)
        .toIntArray() // Convert to IntArray
}

/**
 * 2490. Circular Sentence
 * Prod Variant
 */

fun isCircularSentenceProdVariant(sentence: String): Boolean {
    val words = sentence.split(" ")

    if (words.size == 1) {
        return words[0].first() == words[0].last()
    }

    return words.zipWithNext { current, next -> current.last() == next.first() }
        .all { it } && words.last().last() == words.first().first()
}

/**
 * 264. Ugly Number II
 * Prod Variant
 */

fun nthUglyNumberProdVariant(n: Int): Int {
    val uglyNumbers = mutableListOf(1)
    var (p2, p3, p5) = arrayOf(0, 0, 0) // Destructuring declaration
    repeat(n - 1) {
        val nextUgly = listOf(uglyNumbers[p2] * 2, uglyNumbers[p3] * 3, uglyNumbers[p5] * 5).min()
        uglyNumbers.add(nextUgly)

        if (nextUgly == uglyNumbers[p2] * 2) p2++
        if (nextUgly == uglyNumbers[p3] * 3) p3++
        if (nextUgly == uglyNumbers[p5] * 5) p5++

    }
    return uglyNumbers.last()
}

/**
 * 110. Balanced Binary Tree
 * Prod Variant
 */


fun isBalancedProdVariant(root: TreeNode?): Boolean {
    return when {
        root == null -> true
        else -> abs(
            heightProdVariant(root?.left) - heightProdVariant(root?.right)
        ) <= 1 && isBalancedProdVariant(root?.left) && isBalancedProdVariant(root?.right)
    }
}

fun heightProdVariant(root: TreeNode?): Int = when {
    root == null -> 0
    else -> 1 + maxOf(heightProdVariant(root?.left), heightProdVariant(root?.right))
}

/**
 * 73. Set Matrix Zeroes
 * Prod Variant
 */

fun setZeroesProdVariant(matrix: Array<IntArray>) {
    val m = matrix.size
    val n = matrix[0].size
    var firstRowZero = false
    var firstColZero = false


    matrix.forEachIndexed { i, row ->
        row.forEachIndexed { j, value ->
            if (value == 0) {
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


    if (firstRowZero) matrix[0].fill(0)
    if (firstColZero) for (i in 0 until m) matrix[i][0] = 0
}

/**
 * 287. Find the Duplicate Number
 * Prod Variant
 */

fun findDuplicateProdVariant(nums: IntArray): Int {
    nums.forEach {
        val ind = abs(nums[it])
        if (nums[ind] < 0) return ind
        nums[ind] *= -1
    }
    return 0
}

/**
 * 101. Symmetric Tree
 * Prod Variant
 */

fun isSymmetricProdVariant(root: TreeNode?): Boolean =
    dfsIsSymmetricProdVariant(root?.left, root?.right)

fun dfsIsSymmetricProdVariant(left: TreeNode?, right: TreeNode?): Boolean {
    return when {
        left == null && right == null -> true
        left == null || right == null -> false
        left?.`val` != right?.`val` -> false
        else -> dfsIsSymmetricProdVariant(left?.left, right?.right) &&
                dfsIsSymmetricProdVariant(
                    left?.right,
                    right?.left
                )
    }
}

/**
 * 136. Single Number
 * Prod Variant
 */

fun singleNumberProdVariant(nums: IntArray): Int = nums.reduce { acc, i -> acc xor i }

/**
 * 98. Validate Binary Search Tree
 * Prod Variant
 */

fun isValidBSTProdVariant(root: TreeNode?): Boolean =
    isValidBSTDFSProdVariant(root, Long.MIN_VALUE, Long.MAX_VALUE)

fun isValidBSTDFSProdVariant(root: TreeNode?, min: Long, max: Long): Boolean {
    return when {
        root == null -> true
        !(root.`val` < max && root.`val` > min) -> false
        else -> isValidBSTDFSProdVariant(
            root?.left,
            min,
            root.`val`.toLong()
        ) && isValidBSTDFSProdVariant(
            root?.right,
            root.`val`.toLong(),
            max
        )
    }
}

/**
 * 307. Range Sum Query - Mutable
 * Prod Variant
 */

class NumArrayProdVariant(nums: IntArray) {

    private val prefixSum = IntArray(nums.size + 1) { 0 }

    init {
        for (i in nums.indices) {
            prefixSum[i + 1] = prefixSum[i] + nums[i]
        }
    }

    fun update(index: Int, `val`: Int) {
        val diff = `val` - (prefixSum[index + 1] - prefixSum[index])
        for (i in index + 1..prefixSum.lastIndex) {
            prefixSum[i] += diff
        }
    }

    fun sumRange(left: Int, right: Int): Int = prefixSum[right + 1] - prefixSum[left]
}

/**
 * 852. Peak Index in a Mountain Array
 * Prod Variant
 */

fun peakIndexInMountainArrayProdVariant(arr: IntArray): Int {
    var (low, high) = 0 to arr.size - 1

    while (low < high) {
        val mid = low + (high - low) / 2
        if (arr[mid] < arr[mid + 1]) low = mid + 1
        else high = mid
    }
    return low
}

/**
 * 278. First Bad Version
 * Prod Variant
 */


fun firstBadVersionProdVariant(n: Int): Int {
    val result = (1..n).toList().binarySearch {
        if (isBadVersion(it)) -1 else 1
    }
    return if (result < 0) -result - 1 else result
}

/**
 * 513. Find Bottom Left Tree Value
 * Prod Variant
 */

fun findBottomLeftValueProdVariant(root: TreeNode?): Int {
    return findBottomLeftValueRecursive(root, 0, Int.MIN_VALUE to 0).first
}

private tailrec fun findBottomLeftValueRecursive(
    node: TreeNode?,
    depth: Int,
    currentResult: Pair<Int, Int>
): Pair<Int, Int> {
    if (node == null) return currentResult

    val (currentValue, currentDepth) = currentResult
    val newResult = if (depth > currentDepth) node.`val` to depth else currentResult

    return findBottomLeftValueRecursive(
        node.left,
        depth + 1,
        findBottomLeftValueRecursive(node.right, depth + 1, newResult)
    )
}

/**
 * 404. Sum of Left Leaves
 * Prod Variant
 */

fun sumOfLeftLeavesProdVariant(root: TreeNode?): Int {
    fun dfs(node: TreeNode?, isLeft: Boolean): Int = when {
        node == null -> 0
        node.left == null && node.right == null && isLeft -> node.`val`
        else -> dfs(node.left, true) + dfs(node.right, false)
    }

    return dfs(root, false)
}

/**
 * 701. Insert into a Binary Search Tree
 * Prod Variant
 */

fun insertIntoBSTProdVariant(root: TreeNode?, `val`: Int): TreeNode? =
    when {
        root == null -> TreeNode(`val`)
        `val` < root.`val` -> {
            root.left = insertIntoBST(root.left, `val`)
            root
        }

        else -> {
            root.right = insertIntoBST(root.right, `val`)
            root
        }
    }


/**
 * 71. Simplify Path
 * Prod Variant
 */

fun simplifyPathProdVariant(path: String): String {
    val stack = ArrayDeque<String>()
    val components = path.split("/")
    for (component in components) {
        when (component) {
            "", "." -> continue
            ".." -> if (stack.isNotEmpty()) stack.removeLast()
            else -> stack.addLast(component)
        }
    }
    return buildString {
        stack.forEach {
            append("/").append(it)
        }
    }.ifEmpty { "/" }
}

