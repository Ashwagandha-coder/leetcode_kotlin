package com.leetcode_kotlin

object Node {

    fun node(): MyTreeNode {
        val node = MyTreeNode(1)
        node.left = MyTreeNode(2)
        node.right = MyTreeNode(3)
        node?.left?.right = MyTreeNode(5)
        return node
    }
}

object Strings {
    fun letterCasePermutationsData() = "a1b2"

}

object MyArrays {
    fun numIdenticalPairsData() = intArrayOf(1, 2, 3, 1, 1, 3)

    fun containsDuplicateData() = intArrayOf(1, 2, 3, 1)

    fun missingNumberData() = intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1)

    fun findDisappearedNumbersData() = intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)

    fun singleNumberData() = intArrayOf(4, 1, 2, 1, 2)

    fun maxProfitData() = intArrayOf(7, 1, 5, 3, 6, 4)

    fun subset() = intArrayOf(1, 2, 3)

    fun sortingData() = intArrayOf(3, 5, 4, 1, 8)
}


class TreeNode(val value: Int) {
    var left: MyTreeNode? = null
    var right: MyTreeNode? = null
}

class MyTreeNode(var `val`: Int) {
    var left: MyTreeNode? = null
    var right: MyTreeNode? = null
}





