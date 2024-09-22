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








