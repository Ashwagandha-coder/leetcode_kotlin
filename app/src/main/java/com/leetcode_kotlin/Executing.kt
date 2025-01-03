package com.leetcode_kotlin


/**
 * Executing
 */


fun main() {


    val root = listOf("1", "1").toTreeNode()
    val sub = listOf("1").toTreeNode()

    isSubtree(root, sub).also { println(it) }
}






