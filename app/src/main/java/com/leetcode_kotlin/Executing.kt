package com.leetcode_kotlin


/**
 * Executing
 */


fun main() {



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


