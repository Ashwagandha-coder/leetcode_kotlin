package com.leetcode_kotlin

import org.junit.Assert.assertEquals
import org.junit.Test

class LargestValueTreeTest {

    @Test
    fun testLargestValues_basicCase() {
        val root = TreeNode(1)
        root.left = TreeNode(3)
        root.right = TreeNode(2)
        root.left!!.left = TreeNode(5)
        root.left!!.right = TreeNode(3)
        root.right!!.right = TreeNode(9)


        val largestValues = largestValues(root)

        assertEquals(listOf(1, 3, 9), largestValues)
    }

    @Test
    fun testLargestValues_emptyTree() {
        val root: TreeNode? = null

        val largestValues = largestValues(root)

        assertEquals(emptyList<Int>(), largestValues)
    }

    @Test
    fun testLargestValues_singleNode() {
        val root = TreeNode(5)


        val largestValues = largestValues(root)

        assertEquals(listOf(5), largestValues)
    }

    @Test
    fun testLargestValues_skewedTree() {
        val root = TreeNode(1)
        root.right = TreeNode(2)
        root.right!!.right = TreeNode(3)
        root.right!!.right!!.right = TreeNode(4)

        val largestValues = largestValues(root)

        assertEquals(listOf(1, 2, 3, 4), largestValues)
    }
}