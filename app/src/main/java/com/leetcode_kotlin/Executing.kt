package com.leetcode_kotlin

import java.util.PriorityQueue


/**
 * Executing
 */


fun main() {

    usingComparator()

}

fun test() {
    val num = listOf(4, 5, 6, 67, 8)
    val res = num.maxByOrNull { it == 68 }
    println(res)
}

fun createTreeNodeForBFS(): TreeNode {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left!!.left = TreeNode(4)
    root.left!!.right = TreeNode(5)
    root.right!!.left = TreeNode(6)
    root.right!!.right = TreeNode(7)
    return root
}

fun createTreeNodeForPathSumIII(): TreeNode {
    val root = TreeNode(10)
    root.left = TreeNode(5)
    root.right = TreeNode(-3)
    root.left!!.left = TreeNode(3)
    root.left!!.right = TreeNode(2)
    root.right!!.right = TreeNode(11)
    root?.left?.left?.left = TreeNode(3)
    root?.left?.left?.right = TreeNode(-2)
    root?.left?.right?.right = TreeNode(1)
    return root
}


class Impl : Comparable<Int> {
    override fun compareTo(other: Int): Int = 0
}


fun queueWork() {
    val comparable = object : Comparable<Int> {
        override fun compareTo(other: Int): Int {
            TODO("Not yet implemented")
        }
    }
}


