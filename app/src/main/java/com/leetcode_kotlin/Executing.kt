package com.leetcode_kotlin


/**
 * Executing
 */


fun main() {

    val head = intArrayOf(-10, -3, 0, 5, 9).toListNode()

    sortedListToBST(head)

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


