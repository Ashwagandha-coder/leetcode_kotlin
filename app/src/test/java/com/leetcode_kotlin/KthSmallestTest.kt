package com.leetcode_kotlin

import org.junit.Assert.assertEquals
import org.junit.Test

class KthSmallestTest {


    @Test
    fun testKthSmallest_example1() {
        val root = TreeNode(3)
        root.left = TreeNode(1)
        root.right = TreeNode(4)
        root.left!!.right = TreeNode(2)
        val k = 1
        val expected = 1
        val actual = kthSmallest(root, k)
        assertEquals(expected, actual)
    }

    @Test
    fun testKthSmallest_example2() {
        val root = TreeNode(5)
        root.left = TreeNode(3)
        root.right = TreeNode(6)
        root.left!!.left = TreeNode(2)
        root.left!!.right = TreeNode(4)
        root.left!!.left!!.left = TreeNode(1)
        val k = 3
        val expected = 3
        val actual = kthSmallest(root, k)
        assertEquals(expected, actual)
    }

    @Test
    fun testKthSmallest_singleNode() {
        val root = TreeNode(1)
        val k = 1
        val expected = 1
        val actual = kthSmallest(root, k)
        assertEquals(expected, actual)
    }

    @Test
    fun testKthSmallest_kEqualsN() {
        val root = TreeNode(3)
        root.left = TreeNode(1)
        root.right = TreeNode(4)
        root.left!!.right = TreeNode(2)
        val k = 4 // k equals the number of nodes
        val expected = 4
        val actual = kthSmallest(root, k)
        assertEquals(expected, actual)
    }
}