package com.leetcode_kotlin


/**
 * Executing
 */


fun main() {

    val matrix = arrayOf(
        intArrayOf(1, 1, 1),
        intArrayOf(1, 0, 1),
        intArrayOf(1, 1, 1)
    )

    setZeroesAltSolution(matrix)

}

fun bstIteratorData(): BSTIterator {
    val root = TreeNode(7)
    root.left = TreeNode(3)
    root.right = TreeNode(15)
    root.right?.left = TreeNode(9)
    root.right?.right = TreeNode(20)

    return BSTIterator(root)
}


fun flattenData(): TreeNode? {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(5)
    root.left?.left = TreeNode(3)
    root.left?.right = TreeNode(4)
    root.right?.right = TreeNode(6)
    return root
}

fun test() {
    val num = listOf(4, 5, 6, 67, 8)
    val res = num.maxByOrNull { it == 68 }
    println(res)
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

fun createTreeNodeForPathSumIII(): TreeNode {
    val root = TreeNode(10)
    root.left = TreeNode(5)
    root.right = TreeNode(-3)
    root.left!!.left = TreeNode(3)
    root.left!!.right = TreeNode(2)
    root.right!!.right = TreeNode(11)
    root?.left?.left?.left = TreeNode(3)
    root?.left?.left?.right = TreeNode(-2)
    root?.left?.right?.right = TreeNode(1)
    return root
}



