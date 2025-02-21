package com.github.contest.binaryTree

/**
 * 1261. Find Elements in a Contaminated Binary Tree
 * Alternative Solution
 * DFS + SET
 */

class FindElementsAlternativeSolution(root: TreeNode?) {

    private val values: MutableSet<Int> = mutableSetOf()

    init {
        recover(root, 0)
    }


    private fun recover(node: TreeNode?, value: Int) {
        if (node == null) return

        node.`val` = value
        values.add(value)

        recover(node.left, 2 * value + 1)
        recover(node.right, 2 * value + 2)
    }

    fun find(target: Int): Boolean {
        return values.contains(target)
    }
}