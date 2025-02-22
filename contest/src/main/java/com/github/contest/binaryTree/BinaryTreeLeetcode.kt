package com.github.contest.binaryTree

import java.util.LinkedList

/**
 * 1261. Find Elements in a Contaminated Binary Tree
 */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class FindElements(private val root: TreeNode?) {

    fun find(target: Int): Boolean = bfs(target)

    private fun bfs(target: Int): Boolean {
        if (target == 0 && root != null) return true
        val queue = LinkedList<Pair<Int, TreeNode?>>()
        queue.offer(0 to root)
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val (index, node) = queue.poll()
                if (index == target) return true
                if (index > target) return false
                node?.left?.let { queue.offer((index * 2 + 1) to it) }
                node?.right?.let { queue.offer((index * 2 + 2) to it) }
            }
        }

        return false
    }

}

/**
 * 1028. Recover a Tree From Preorder Traversal
 */

fun recoverPreorderTraversal(traversal: String): TreeNode? {
    val path = mutableListOf<TreeNode>()
    var pos = 0
    while (pos < traversal.length) {
        var level = 0
        while (traversal[pos] == '-') {
            level++
            pos++
        }
        var value = 0
        while (pos < traversal.length && traversal[pos].isDigit()) {
            value = value * 10 + (traversal[pos] - '0')
            pos++
        }
        val node = TreeNode(value)
        if (level == path.size) {
            if (path.isNotEmpty()) {
                path.last().left = node
            }
        } else {
            while (level < path.size) {
                path.removeLast()
            }
            path.last().right = node
        }
        path.add(node)
    }
    return path.firstOrNull()
}
