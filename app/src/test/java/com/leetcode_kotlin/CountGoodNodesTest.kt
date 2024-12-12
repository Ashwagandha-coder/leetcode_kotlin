package com.leetcode_kotlin

import org.junit.Assert.assertEquals
import org.junit.Test

class CountGoodNodesTest {


    @Test
    fun testGoodNodes_example1() {
        val root = TreeNode(3)
        root.left = TreeNode(1)
        root.left!!.left = TreeNode(3)
        root.right = TreeNode(4)
        root.right!!.left = TreeNode(1)
        root.right!!.right = TreeNode(5)

        val expected = 4
        val actual = goodNodes(root)
        assertEquals(expected, actual)
    }

    @Test
    fun testGoodNodes_example2() {
        val root = TreeNode(3)
        root.left = TreeNode(3)
        root.right = TreeNode(4)
        root.right!!.left = TreeNode(4)
        root.right!!.right = TreeNode(5)

        val expected = 5
        val actual = goodNodes(root)
        assertEquals(expected, actual)
    }

    @Test
    fun testGoodNodes_example3() {
        val root = TreeNode(1)

        val expected = 1
        val actual = goodNodes(root)
        assertEquals(expected, actual)
    }
}