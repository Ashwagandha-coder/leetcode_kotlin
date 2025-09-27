package com.github.contest.binaryTree

import java.util.LinkedList

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun TreeNode?.printTree() {
    if (this == null) println("null")

    val printedTree = printTree(this)

    printedTree.forEach {
        it.joinToString(" ").also { level ->
            println(level)
        }
    }
}


fun List<Int?>.toTreeNode(): TreeNode? {

    val root = TreeNode(this.first()!!)
    val queue = LinkedList<TreeNode>().apply {
        offer(root)
    }

    var i = 1

    while (queue.isNotEmpty() && i < size) {
        val node = queue.poll()

        if (i < size && this[i] != null) {
            node.left = TreeNode(this[i]!!)
            queue.offer(node.left)
        }

        i++

        if (i < size && this[i] != null) {
            node.right = TreeNode(this[i]!!)
            queue.offer(node.right)
        }

        i++
    }

    return root
}

private fun List<Int?>.validationTree(): Unit? {
    if (isEmpty()) return null
    if (first() == null) throw IllegalArgumentException("First Element Shouldn't be NULL")


    for (i in 0 until size) {

        if (this[i] == null) {

            val leftChildIndex = 2 * i + 1
            val rightChildIndex = 2 * i + 2

            if (leftChildIndex < size && this[leftChildIndex] != null) throw IllegalArgumentException(
                "Left subTree shouldn't have child"
            )
            if (rightChildIndex < size && this[rightChildIndex] != null) throw IllegalArgumentException(
                "Right subTree shouldn't have child"
            )
        }
    }

    return Unit
}