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

/**
 * 617. Merge Two Binary Trees
 */

fun mergeTreesProdVariant(root1: TreeNode?, root2: TreeNode?): TreeNode? = when {
    root1 == null && root2 == null -> null
    root1 == null -> root2
    root2 == null -> root1
    else -> {
        val newRoot = TreeNode(root1.`val` + root2.`val`)
        newRoot.left = mergeTreesProdVariant(root1?.left, root2.left)
        newRoot.right = mergeTreesProdVariant(root1?.right, root2?.right)
        newRoot
    }
}

/**
 * 652. Find Duplicate Subtrees
 * Prod Variant
 * Using DFS
 */

fun findDuplicateSubtreesProdVariant(root: TreeNode?): List<TreeNode?> {
    val hashToTreeNode = mutableMapOf<String, TreeNode>()
    return buildList {
        fun dfs(root: TreeNode?): String {
            if (root == null) return "#"

            val hash = buildString {
                append(root.`val`)
                append(",")
                append("${dfs(root.left)}")
                append(",")
                append("${dfs(root.right)}")
            }

            add(hash to root)
            hashToTreeNode[hash] = root

            return hash
        }
        dfs(root)
    }.groupingBy { it.first }
        .eachCount()
        .toList()
        .filter { it.second > 1 }
        .let { freq ->
            buildList {
                freq.forEach {
                    add(hashToTreeNode[it.first])
                }
            }
        }

}

/**
 * 606. Construct String from Binary Tree
 * Prod Variant
 */

fun tree2strProdVariant(root: TreeNode?): String = when {
    root == null -> "()"
    else -> buildString {
        append(root.`val`)
        root.left?.let {
            append("(")
            append(tree2strProdVariant(it))
            append(")")
        }
        root.right?.let {
            if (root.left == null) append("()")
            append("(")
            append(tree2strProdVariant(it))
            append(")")
        }
    }
}
