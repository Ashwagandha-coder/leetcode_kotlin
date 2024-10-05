package com.leetcode_kotlin

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




