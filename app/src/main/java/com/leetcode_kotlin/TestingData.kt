package com.leetcode_kotlin


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

object Node {

    fun node(): TreeNode {
        val node = TreeNode(1)
        node.left = TreeNode(2)
        node.right = TreeNode(3)
        node?.left?.right = TreeNode(5)
        return node
    }


    fun pathSumII(): TreeNode {
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

    fun findWaysData() = intArrayOf(1, 1, 1, 1, 1)

    fun maxSubArrayKadane() = intArrayOf(-5, -4, -1)

    fun maxSubArrayDP() = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)

    fun candidatesCombinationSum() = intArrayOf(10, 1, 2, 7, 6, 1, 5)
}







