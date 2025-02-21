package com.github.contest.binaryTree

import java.util.LinkedList

/**
 * 1261. Find Elements in a Contaminated Binary Tree
 */

class TreeNode(`val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class FindElements(private val root: TreeNode?) {

    fun find(target: Int): Boolean = bfs(target)

    private fun bfs(target: Int): Boolean {
        if (target == 0 && root != null) return true
        val queue = LinkedList<Pair<Int, TreeNode?>>()
        var counter = 0
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