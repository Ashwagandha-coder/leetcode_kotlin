package com.leetcode_kotlin


/**
 * Executing
 */


fun main() {

    val arr = intArrayOf(3, 4, 5, 2)
    maxProductTwoElementsPriorityQueueSolution(arr).also { println(it) }


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


