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
    fun emptyTreeTest() {
        val root = null

        val call = isBalancedProdVariant(root)

        assertEquals(true, call)

    }



}