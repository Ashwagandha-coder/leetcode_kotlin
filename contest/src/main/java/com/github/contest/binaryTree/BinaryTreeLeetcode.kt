package com.github.contest.binaryTree

import java.util.LinkedList
import kotlin.math.abs

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

/**
 * 563. Binary Tree Tilt
 */

fun findTilt(root: TreeNode?): Int {
    root ?: return 0
    return dfs(root).second
}

private fun dfs(root: TreeNode?): Pair<Int, Int> {
    if (root == null) return Pair(0, 0)

    val left = dfs(root?.left)
    val right = dfs(root?.right)
    val newTilt = abs(left.first - right.first)

    return Pair(root.`val` + left.first + right.first, newTilt + left.second + right.second)
}

/**
 * 993. Cousins in Binary Tree
 */

fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
    root ?: return false
    val queue = LinkedList<Pair<Int, TreeNode>>()
    queue.offer(0 to root)

    while (queue.isNotEmpty()) {
        val size = queue.size
        var parentX = 0
        var parentY = 0
        var isX = false
        var isY = false

        for (i in 0 until size) {
            val (parentValue, node) = queue.poll()

            if (node.`val` == x) {
                parentX = parentValue
                isX = true
            }

            if (node.`val` == y) {
                parentY = parentValue
                isY = true
            }

            if (isX && isY) {
                if (parentX != parentY) return true
            }

            node.left?.let {
                queue.offer(node.`val` to it)
            }

            node.right?.let {
                queue.offer(node.`val` to it)
            }

        }
    }

    return false
}

/**
 * 2331. Evaluate Boolean Binary Tree
 */

fun evaluateTree(root: TreeNode?): Boolean {
    if (root?.left == null && root?.right == null) {
        return when (root?.`val`) {
            1 -> true
            else -> false
        }
    }

    val left = evaluateTree(root?.left)
    val right = evaluateTree(root?.right)

    return when (root.`val`) {
        2 -> left || right
        else -> left && right
    }
}
