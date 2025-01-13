package com.leetcode_kotlin


/**
 * Executing
 */


fun main() {

    val inorder = intArrayOf(9, 3, 15, 20, 7)
    val postorder = intArrayOf(9, 15, 7, 20, 3)

    buildTreeFromInorderAndPostOrder(inorder, postorder)


}

fun inorderTraversalPrint(root: TreeNode?) {
    if (root != null) {
        inorderTraversalPrint(root.left)
        print("${root.`val`} ")
        inorderTraversalPrint(root.right)
    }
}




