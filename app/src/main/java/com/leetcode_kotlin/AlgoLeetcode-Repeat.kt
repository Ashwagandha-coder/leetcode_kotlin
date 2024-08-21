package com.leetcode_kotlin

import kotlin.math.max

fun main() {
    val nodes = RepeatTreeNode(1)
    nodes.left = RepeatTreeNode(4)
    nodes.right = RepeatTreeNode(7)
    nodes.left?.left = RepeatTreeNode(2)
    nodes.left?.right = RepeatTreeNode(3)
    nodes.left?.right?.left = RepeatTreeNode(2)

    nodes.right?.left = RepeatTreeNode(5)
    nodes.right?.right = RepeatTreeNode(4)

    val res = bfs(nodes)
    println(res)
}

class Repeat


fun Repeat.missingNumber(nums: IntArray): Int {
    var sum = 0
    var len = nums.size
    for (i in 0..len - 1) sum += nums[i]
    return len * (len + 1) / 2 - sum
}


fun Repeat.singleNumber(nums: IntArray): Int {
    var res = 0
    for (i in 0..nums.size - 1) {
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


fun bfs(root: RepeatTreeNode?): Int {
    if (root == null) return 0

    var minDepthSum = bfs(root.left)
    var maxDepthSum = bfs(root.right)

    return max(maxDepthSum, minDepthSum) + root.value
}