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

/**
 * 572. Subtree of Another Tree
 * Alternative Solution
 * Serialization
 */

fun isSubtreeSerialization(root: TreeNode?, subRoot: TreeNode?): Boolean {

    val stringRoot = serialize(root)
    val stringSubRoot = serialize(subRoot)

    return stringRoot.contains(stringSubRoot)
}


fun serialize(root: TreeNode?): String {
    if (root == null) return "null"

    return "#${root.`val`} ${serialize(root.left)} ${serialize(root.right)}"
}

/**
 * 652. Find Duplicate Subtrees
 * Alternative Solution
 * Using Serialize + Traverse
 */

fun findDuplicateSubtreesOtherSolution(root: TreeNode?): List<TreeNode?> {
    val result = mutableListOf<TreeNode?>()
    val subtreeMap = mutableMapOf<String, Int>() // serialization -> count
    serialize(root, subtreeMap, result)
    return result
}

private fun serialize(
    node: TreeNode?,
    subtreeMap: MutableMap<String, Int>,
    result: MutableList<TreeNode?>
): String {
    if (node == null) return "#"

    // Postorder serialization: left + right + root
    val serial = buildString {
        append(serialize(node.left, subtreeMap, result))
        append(",")
        append(serialize(node.right, subtreeMap, result))
        append(",")
        append(node.`val`)
    }


    val count = subtreeMap.getOrDefault(serial, 0)
    subtreeMap[serial] = count + 1


    if (count == 1) {
        result.add(node)
    }

    return serial
}

/**
 * 1302. Deepest Leaves Sum
 * Alternative Solution
 */

fun deepestLeavesSumAlternativeSolution(root: TreeNode?): Int {
    val depth = maxDepth(root)
    return dfsDeepestLeaves(root, 1, depth)
}

fun dfsDeepestLeaves(root: TreeNode?, level: Int, depth: Int): Int = when {
    root == null -> 0
    level == depth -> root.`val`
    else -> dfsDeepestLeaves(root.left, level + 1, depth) + dfsDeepestLeaves(
        root.right,
        level + 1,
        depth
    )
}