package com.leetcode_kotlin


/**
 * Executing
 */


fun main() {

    distanceKData()


}

fun tree() {
    val root = listOf(2, 2, 5, null, null, 5, 7).map { it.toString() }.toTreeNode()

    findSecondMinimumValueAltSolution(root)
}

fun distanceKData() {
    val root = listOf(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4).map { it.toString() }.toTreeNode()
    val target = TreeNode(5)
    val k = 2
    distanceK(root, root?.left, k).apply { println(this) }
}

fun inorderTraversalPrint(root: TreeNode?) {
    if (root != null) {
        inorderTraversalPrint(root.left)
        print("${root.`val`} ")
        inorderTraversalPrint(root.right)
    }
}




