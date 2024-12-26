package com.leetcode_kotlin

import org.junit.Assert.assertEquals
import org.junit.Test

class FindBottomLeftTreeTest {

    @Test
    fun testFindBottomLeftValue_basicCase() {
        val root = TreeNode(2)
        root.left = TreeNode(1)
        root.right = TreeNode(3)


        val bottomLeftValue = findBottomLeftValue(root)

        assertEquals(1, bottomLeftValue)
    }


    @Test
    fun testFindBottomLeftValue_singleNode() {
        val root = TreeNode(5)


        val bottomLeftValue = findBottomLeftValue(root)

        assertEquals(5, bottomLeftValue)
    }

    @Test
    fun testFindBottomLeftValue_deeperTree() {
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(3)
        root.left!!.left = TreeNode(4)
        root.right!!.left = TreeNode(5)
        root.right!!.right = TreeNode(6)
        root.right!!.left!!.left = TreeNode(7)


        val bottomLeftValue = findBottomLeftValue(root)

        assertEquals(7, bottomLeftValue)
    }
}