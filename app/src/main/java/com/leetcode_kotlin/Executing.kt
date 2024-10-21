package com.leetcode_kotlin

/**
 * Executing
 */

fun main() {


    val node = TreeNode(1)
    node?.left = TreeNode(2)

    val oth = TreeNode(1)
    oth?.right = TreeNode(2)

    isSameTreeProdVariant(node, oth).let {
        println("$it ")
    }

}