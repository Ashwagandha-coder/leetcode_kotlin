package com.leetcode_kotlin

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class IsBalancedProdVariantTest {

    @Test
    fun isBalancedProdVariantBaseTest() {

        val root = TreeNode(3)
        root.left = TreeNode(9)
        root.right = TreeNode(20)
        root.right?.left = TreeNode(15)
        root.right?.right = TreeNode(7)

        val call = isBalancedProdVariant(root)

        assertEquals(true, call)
    }

    @Test
    fun testIsBalanced_example2() {
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.left!!.left = TreeNode(3)
        root.left!!.left!!.left = TreeNode(4)
        root.left!!.left!!.left!!.left = TreeNode(5)
        assertFalse(isBalanced(root))
    }

    @Test
    fun emptyTreeTest() {
        val root = null
        val call = isBalancedProdVariant(root)
        assertEquals(true, call)
    }


    @Test
    fun `singleNode`() {
        val root = TreeNode(1)
        assertTrue(isBalanced(root))
    }

    @Test
    fun testIsBalanced_skewedTree() {
        val root = TreeNode(1)
        root.right = TreeNode(2)
        root.right!!.right = TreeNode(3)
        assertFalse(isBalanced(root))
    }


}