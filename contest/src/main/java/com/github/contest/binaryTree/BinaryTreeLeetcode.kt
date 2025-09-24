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

/**
 * 2641. Cousins in Binary Tree II
 */

fun replaceValueInTree(root: TreeNode?): TreeNode? {
    root ?: return null

    val queue = LinkedList<TreeNode>().apply { offer(root) }
    val (nodeToParent, sumLevels, parentToChildrenSum) = bfsRelative(root)
    var level = 0

    while (queue.isNotEmpty()) {
        val size = queue.size
        val levelSum = sumLevels[level]

        for (i in 0 until size) {
            val node = queue.poll()

            if (level == 0) {
                node.`val` = 0
            } else {
                val parent = nodeToParent[node]!!
                val siblingsSum = parentToChildrenSum[parent]!!
                node.`val` = levelSum - siblingsSum
            }

            node?.left?.let {
                queue.offer(it)
            }

            node?.right?.let {
                queue.offer(it)
            }
        }

        level++
    }

    return root
}

private fun bfsRelative(root: TreeNode): TreeNodeRelative {

    val queue = LinkedList<TreeNode>().apply { offer(root) }
    val nodeToParent = mutableMapOf<TreeNode, TreeNode?>().apply { this[root] = null }
    val parentToChildrenSum = mutableMapOf<TreeNode, Int>()
    val sumLevels = mutableListOf<Int>()

    while (queue.isNotEmpty()) {
        val size = queue.size
        var levelSum = 0

        for (i in 0 until size) {
            val node = queue.poll()
            var childsSum = 0
            levelSum += node.`val`

            node?.left?.let {
                nodeToParent[it] = node
                childsSum += it.`val`
                queue.offer(it)
            }

            node?.right?.let {
                nodeToParent[it] = node
                childsSum += it.`val`
                queue.offer(it)
            }

            parentToChildrenSum[node] = childsSum
        }

        sumLevels.add(levelSum)
    }

    return TreeNodeRelative(
        nodeToParent = nodeToParent,
        sumLevels = sumLevels,
        parentToChildrenSum = parentToChildrenSum
    )
}

private data class TreeNodeRelative(
    val nodeToParent: Map<TreeNode, TreeNode?>,
    val sumLevels: List<Int>,
    val parentToChildrenSum: Map<TreeNode, Int>
)

/**
 * 617. Merge Two Binary Trees
 */

fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
    if (root1 == null && root2 == null) return null
    root1 ?: return root2
    root2 ?: return root1

    val newRoot = TreeNode(root1.`val` + root2.`val`)
    newRoot.left = mergeTrees(root1?.left, root2?.left)
    newRoot?.right = mergeTrees(root1?.right, root2?.right)

    return newRoot
}

/**
 * 572. Subtree of Another Tree
 */

fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {

    val queue = LinkedList<TreeNode>().apply {
        offer(root)
    }

    while (queue.isNotEmpty()) {
        val size = queue.size

        for (i in 0 until size) {
            val node = queue.poll()
            val nodeVal = node?.`val` ?: 0
            val subRootVal = subRoot?.`val` ?: 0

            if (nodeVal == subRootVal) {
                if (isSameTree(node, subRoot)) return true
            }

            node?.left?.let {
                queue.offer(it)
            }

            node?.right?.let {
                queue.offer(it)
            }
        }
    }

    return false

}

private fun isSameTree(root: TreeNode?, subRoot: TreeNode?): Boolean {
    if (root == null && subRoot == null) return true
    if (root?.`val` != subRoot?.`val`) return false
    root ?: return false
    subRoot ?: return false

    return isSameTree(root?.left, subRoot?.left) && isSameTree(root?.right, subRoot?.right)
}


/**
 * 655. Print Binary Tree
 */

fun printTree(root: TreeNode?): List<List<String>> {
    root ?: return listOf()

    val rows = height(root)
    val col = (1 shl rows) - 1
    val res = MutableList(rows) { _ ->
        MutableList(col) { "" }
    }
    val rootPos = (col - 1) / 2
    val queue = LinkedList<Triple<TreeNode, Int, Int>>().apply {
        val triple = Triple(root, 0, rootPos)
        offer(triple)
    }

    while (queue.isNotEmpty()) {
        val size = queue.size

        for (i in 0 until size) {
            val (node, level, col) = queue.poll()
            val offset = 1 shl (rows - level - 2)

            res[level][col] = node.`val`.toString()

            node.left?.let {
                val triple = Triple(it, level + 1, col - offset)
                queue.offer(triple)
            }

            node.right?.let {
                val triple = Triple(it, level + 1, col + offset)
                queue.offer(triple)
            }
        }
    }

    return res
}

private fun height(root: TreeNode?): Int = when {
    root == null -> 0
    else -> 1 + maxOf(height(root.left), height(root.right))
}
