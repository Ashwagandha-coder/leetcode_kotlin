package com.github.contest.binaryTree

/**
 * 1261. Find Elements in a Contaminated Binary Tree
 * Prod Variant
 */

class FindElementProdVariant(root: TreeNode?) {

    private val values = buildSet {
        fun dfs(root: TreeNode?, value: Int) {
            if (root == null) return

            root.`val` = value
            add(value)

            dfs(root?.left, value * 2 + 1)
            dfs(root?.right, value * 2 + 2)
        }
        dfs(root, 0)
    }

    fun find(target: Int): Boolean = values.contains(target)

}