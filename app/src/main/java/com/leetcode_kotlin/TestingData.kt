package com.leetcode_kotlin

import java.util.LinkedList


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
    var random: Node? = null
}

fun TreeNode.printTreeNodes(): List<Int?> {
    val root = this
    val q = LinkedList<TreeNode>()
    val res = mutableListOf<Int>()
    q.offer(root)
    while (q.isNotEmpty()) {
        val node = q.poll()
        res.add(node.`val`)
        if (root?.left != null) q.offer(root?.left)
        if (root?.right != null) q.offer(root?.right)
        else q.offer(null)
    }
    return res
}

fun List<String>.toTreeNode(): TreeNode? {
    if (this.isEmpty()) return null
    val root = TreeNode(this[0].toInt())
    val q = LinkedList<TreeNode>()
    q.offer(root)
    var i = 1
    while (q.isNotEmpty() && i < this.size) {
        val node = q.poll()
        if (this[i] != "null") {
            val new = TreeNode(this[i].toInt())
            node?.left = new
            q.offer(new)
        }
        i++
        if (i < this.size && this[i] != "null") {
            val new = TreeNode(this[i].toInt())
            node?.right = new
            q.offer(new)
        }
        i++
    }
    return root
}

fun ListNode.printListNode() {
    var p = this
    while (p?.next != null) {
        print("${p.`val`} -> ")
        p = p?.next!!
    }
    print("${p.`val`} ")
}

object LinkedListData {

    fun cycleLinkedListData(): ListNode {
        val head = ListNode(3)
        val pos = ListNode(2)
        head.next = pos
        head.next?.next = ListNode(0)
        head.next?.next?.next = ListNode(-4)
        head.next?.next?.next?.next = pos
        return head
    }

    fun cycleLinkedListDataII(): ListNode {
        val head = ListNode(3)
        val pos = ListNode(2)
        head.next = ListNode(10)
        head.next?.next = ListNode(0)
        head.next?.next?.next = ListNode(-4)
        head.next?.next?.next?.next = ListNode(20)
        head.next?.next?.next?.next?.next = pos
        return head
    }

    fun makeListNode(arr: IntArray): ListNode {
        if (arr.isEmpty()) return ListNode(0)
        var stub = ListNode(arr[0])
        val head = stub
        for (i in 1 until arr.size) {
            val temp = ListNode(arr[i])
            stub.next = temp
            stub = stub.next!!
        }
        return head
    }


}

fun ListNode.toList(): List<Int> {
    val res = mutableListOf<Int>()
    var curr = this
    while (curr?.next != null) {
        res.add(curr.`val`)
        curr = curr?.next!!
    }
    res.add(curr.`val`)
    return res
}


object NodeForTree {

    fun node(): TreeNode {
        val node = TreeNode(1)
        node.left = TreeNode(2)
        node.right = TreeNode(3)
        node?.left?.right = TreeNode(5)
        return node
    }


    fun pathSumIIData(): TreeNode {
        val root = TreeNode(5)
        root.left = TreeNode(4)
        root.right = TreeNode(8)
        root.left?.left = TreeNode(11)
        root.right?.right = TreeNode(4)
        root.right?.left = TreeNode(13)
        root.left?.left?.left = TreeNode(7)
        root.left?.left?.right = TreeNode(2)
        root.right?.right?.right = TreeNode(1)
        root.right?.right?.left = TreeNode(5)
        return root
    }

    fun reverseOddLevelsOfBinaryTreeData(): TreeNode {
        val root = TreeNode(2)
        root.left = TreeNode(3)
        root.right = TreeNode(5)
        root.left?.left = TreeNode(8)
        root.left?.right = TreeNode(13)
        root.right?.right = TreeNode(34)
        root.right?.left = TreeNode(21)
        return root
    }

    fun sameTreeData(): TreeNode {
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(3)
        return root
    }
}

object Numbers {
    fun combineData() = Pair(4, 2)
}

object Strings {
    fun letterCasePermutationsData() = "a1b2"

}

object MyArrays {
    fun numIdenticalPairsData() = intArrayOf(1, 2, 3, 1, 1, 3)

    fun containsDuplicateData() = intArrayOf(1, 2, 3, 1)

    fun missingNumberData() = intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1)

    fun findDisappearedNumbersData() = intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)

    fun findDuplicates() = intArrayOf(1, 3, 4, 2, 2)

    fun singleNumberData() = intArrayOf(4, 1, 2, 1, 2)

    fun maxProfitData() = intArrayOf(7, 1, 5, 3, 6, 4)

    fun sortingData() = intArrayOf(3, 5, 4, 1, 8)

    fun quickSortData() = intArrayOf(3, 2, 4, 9, 4, 5, 7)

    fun combineSumData() = Pair(intArrayOf(2, 3, 6, 7), 7)

    fun permutationsData() = intArrayOf(1, 2, 3)

    fun permutationsUniqueData() = intArrayOf(1, 1, 2)

    fun subsetData() = intArrayOf(1, 2, 3)

    fun subsetDataWithDup() = intArrayOf(1, 2, 2)

    fun maxRobData() = intArrayOf(2, 7, 9, 3, 1)

    fun containsDuplicateIIIData() = intArrayOf(8, 7, 15, 1, 6, 1, 9, 15)

    fun containsDuplicateIndexDiffValueDiffData() = Pair(2, 3)

    fun findWaysData() = intArrayOf(1, 1, 1, 1, 1)

    fun maxSubArrayKadane() = intArrayOf(-5, -4, -1)

    fun maxSubArrayDP() = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)

    fun candidatesCombinationSum() = intArrayOf(10, 1, 2, 7, 6, 1, 5)
}

object DynamicProgramming {
    fun maxProfitIIData() = intArrayOf(7, 1, 5, 3, 6, 4)
}

class SolveSudoku {

    fun makeSudoku(): Array<CharArray> = arrayOf(
        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )


}

object Matrix {
    fun createMatrix() = arrayOf(
        intArrayOf(3, 0, 1, 4, 2),
        intArrayOf(5, 6, 3, 2, 1),
        intArrayOf(1, 2, 0, 1, 5),
        intArrayOf(4, 1, 0, 1, 7),
        intArrayOf(1, 0, 3, 0, 5)
    )
}


fun bstIteratorData(): BSTIterator {
    val root = TreeNode(7)
    root.left = TreeNode(3)
    root.right = TreeNode(15)
    root.right?.left = TreeNode(9)
    root.right?.right = TreeNode(20)

    return BSTIterator(root)
}


fun flattenData(): TreeNode? {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(5)
    root.left?.left = TreeNode(3)
    root.left?.right = TreeNode(4)
    root.right?.right = TreeNode(6)
    return root
}

fun test() {
    val num = listOf(4, 5, 6, 67, 8)
    val res = num.maxByOrNull { it == 68 }
    println(res)
}

fun createTreeNodeForBFS(): TreeNode {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left!!.left = TreeNode(4)
    root.left!!.right = TreeNode(5)
    root.right!!.left = TreeNode(6)
    root.right!!.right = TreeNode(7)
    return root
}

fun createTreeNodeForPathSumIII(): TreeNode {
    val root = TreeNode(10)
    root.left = TreeNode(5)
    root.right = TreeNode(-3)
    root.left!!.left = TreeNode(3)
    root.left!!.right = TreeNode(2)
    root.right!!.right = TreeNode(11)
    root?.left?.left?.left = TreeNode(3)
    root?.left?.left?.right = TreeNode(-2)
    root?.left?.right?.right = TreeNode(1)
    return root
}

fun workTree() {
    val root = TreeNode(1)
    root.left = TreeNode(3)
    root.right = TreeNode(2)
    root.left!!.left = TreeNode(5)
    root.left!!.right = TreeNode(3)
    root.right!!.right = TreeNode(9)

    widthOfBinaryTree(root).also { println(it) }
}


fun leaf() {
    val root1 = listOf(3, 5, 1, 6, 2, 9, 8, null, null, 7, 4).map { it.toString() }.toTreeNode()
    val root2 =
        listOf(3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8).map { it.toString() }
            .toTreeNode()

    leafSimilar(root1, root2).also { println(it) }
}


fun isPalindromeL(head: ListNode?): Boolean {
    var size = 0
    var curr = head
    while (curr != null) {
        size++
        curr = curr?.next
    }
    var ans = size / 2
    curr = head
    while (ans != 0) {
        ans--
        curr = curr?.next
    }
    var new = if (size % 2 == 0) reverseL(curr) else reverseL(curr?.next)
    curr = head
    while (curr != null && new != null) {
        if (curr?.`val` != new?.`val`) return false
        curr = curr?.next
        new = new?.next
    }
    return true
}

fun reverseL(head: ListNode?): ListNode? {
    head ?: return head
    var curr = head
    var prev: ListNode? = null
    var next: ListNode? = null
    while (curr != null) {
        next = curr?.next
        curr?.next = prev
        prev = curr
        curr = next
    }
    return prev
}

fun binaryTreePruning() {

    val root = listOf(1, 0, 1, 0, 0, 0, 1).map { it.toString() }.toTreeNode()

    pruneTree(root)
}

fun isOddEvenTreeLaunch() {

    val root = listOf(5, 4, 2, 3, 3, 7).map { it.toString() }.toTreeNode()

    isEvenOddTree(root)
}

fun tree() {
    val root = listOf(2, 2, 5, null, null, 5, 7).map { it.toString() }.toTreeNode()

    findSecondMinimumValueAltSolution(root)
}

fun distanceKData() {
    val root = listOf(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4).map { it.toString() }.toTreeNode()
    val target = TreeNode(5)
    val k = 2
    distanceK(root, root?.left, k).apply { println(this) }
}

fun inorderTraversalPrint(root: TreeNode?) {
    if (root != null) {
        inorderTraversalPrint(root.left)
        print("${root.`val`} ")
        inorderTraversalPrint(root.right)
    }
}







