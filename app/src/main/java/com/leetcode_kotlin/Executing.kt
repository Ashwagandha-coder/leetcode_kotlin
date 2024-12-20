package com.leetcode_kotlin


/**
 * Executing
 */


fun main() {

    val nums = intArrayOf(1, 3, -1, -3, 5, 3, 6, 7)
    val k = 3

    maxSlidingWindow(nums, k)

}

fun workTree() {
    val root = TreeNode(1)
    root.left = TreeNode(3)
    root.right = TreeNode(2)
    root.left!!.left = TreeNode(5)
    root.left!!.right = TreeNode(3)
    root.right!!.right = TreeNode(9)

    widthOfBinaryTree(root).also { println(it) }
}




