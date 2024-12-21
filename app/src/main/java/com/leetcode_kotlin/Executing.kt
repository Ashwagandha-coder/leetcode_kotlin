package com.leetcode_kotlin


/**
 * Executing
 */


fun main() {

    val s = "LeetcodeHelpsMeLearn"
    val spaces = intArrayOf(8, 13, 15)

    addSpaces(s, spaces)

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




