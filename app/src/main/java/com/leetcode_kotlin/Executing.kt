package com.leetcode_kotlin


/**
 * Executing
 */


fun main() {


    val arr = intArrayOf(1, 4, 6, 7, 3, 7, 7)
    arr.drop(1).forEachIndexed { index, num ->
        println("$index $num")
    }

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




