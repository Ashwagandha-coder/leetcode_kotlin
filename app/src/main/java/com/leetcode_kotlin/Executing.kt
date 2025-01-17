package com.leetcode_kotlin


/**
 * Executing
 */


fun main() {

    val root = listOf(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4).map { it.toString() }.toTreeNode()
    val p = TreeNode(5)
    val q = TreeNode(1)

    lowestCommonAncestorBinaryTree(root, p, q).also { println(it) }


}

fun inorderTraversalPrint(root: TreeNode?) {
    if (root != null) {
        inorderTraversalPrint(root.left)
        print("${root.`val`} ")
        inorderTraversalPrint(root.right)
    }
}




