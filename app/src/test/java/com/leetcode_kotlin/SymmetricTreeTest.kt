package com.leetcode_kotlin

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SymmetricTreeTest {

    @Test
    fun `trivialCase`() {
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(2)
        root.left!!.left = TreeNode(3)
        root.left!!.right = TreeNode(4)
        root.right!!.left = TreeNode(4)
        root.right!!.right = TreeNode(3)
        assertTrue(isSymmetric(root))
    }

    @Test
    fun `trivialCase2`() {
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(2)
        root.left!!.right = TreeNode(3)
        root.right!!.right = TreeNode(3)
        assertFalse(isSymmetric(root))
    }

    @Test
    fun `emptyTree`() {
        val root: TreeNode? = null
        assertTrue(isSymmetric(root))
    }

    @Test
    fun `singleNode`() {
        val root = TreeNode(1)
        assertTrue(isSymmetric(root))
    }

    @Test
    fun `unbalancedTree`() {
        val root = TreeNode(1)
        root.left = TreeNode(2)
        assertFalse(isSymmetric(root))
    }


}