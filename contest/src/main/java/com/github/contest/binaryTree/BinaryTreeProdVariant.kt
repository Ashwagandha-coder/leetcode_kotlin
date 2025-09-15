package com.github.contest.binaryTree

import java.util.LinkedList

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

/**
 * 993. Cousins in Binary Tree
 * Prod Variant I
 */

fun isCousinsProdVariant(root: TreeNode?, x: Int, y: Int): Boolean {
    root ?: return false
    val queue = LinkedList<Pair<TreeNode, Int>>().apply {
        offer(root to 0)
    }

    while (queue.isNotEmpty()) {
        val size = queue.size
        val levelNodes = buildList {
            repeat(size) {
                val (node, parentValue) = queue.poll()
                add(node to parentValue)
                node.left?.let {
                    queue.offer(it to node.`val`)
                }
                node.right?.let {
                    queue.offer(it to node.`val`)
                }
            }
        }

        val potentialValue = levelNodes.filter { it.first.`val` == x || it.first.`val` == y }

        when (potentialValue.size) {
            2 -> if (potentialValue.first().second != potentialValue.last().second) return true
            1 -> return false
        }
    }

    return false
}