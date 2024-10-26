package com.leetcode_kotlin


/**
 * Executing
 */



fun main() {

    val root = TreeNode(3)
    root.left = TreeNode(1)
    root.right = TreeNode(4)
    root.right!!.left = TreeNode(2)

    recoverTree(root)

    root.also {
        println(it.`val`)
    }

}

