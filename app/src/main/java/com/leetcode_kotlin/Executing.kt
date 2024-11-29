package com.leetcode_kotlin


/**
 * Executing
 */


fun main() {

    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)

    val save = maxPathSum(root)
    println(save)

}




