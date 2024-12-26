package com.leetcode_kotlin

import org.junit.Assert.assertEquals
import org.junit.Test

class ValidateBSTest {


    @Test
    fun testIsValidBST_validBST() {
        val root = TreeNode(2)
        root.left = TreeNode(1)
        root.right = TreeNode(3)

        assertEquals(true, isValidBST(root))
    }

    @Test
    fun testIsValidBST_invalidBST() {
        val root = TreeNode(5)
        root.left = TreeNode(1)
        root.right = TreeNode(4)
        root.right!!.left = TreeNode(3)
        root.right!!.right = TreeNode(6)

        assertEquals(false, isValidBST(root))
    }

    @Test
    fun testIsValidBST_singleNode() {
        val root = TreeNode(10)

        assertEquals(true, isValidBST(root))
    }

    @Test
    fun testIsValidBST_emptyTree() {
        val root: TreeNode? = null

        assertEquals(true, isValidBST(root))
    }

    @Test
    fun testIsValidBST_leftSubtreeViolation() {
        val root = TreeNode(5)
        root.left = TreeNode(7)
        root.right = TreeNode(10)

        assertEquals(false, isValidBST(root))
    }

    @Test
    fun testIsValidBST_rightSubtreeViolation() {
        val root = TreeNode(5)
        root.left = TreeNode(3)
        root.right = TreeNode(4)

        assertEquals(false, isValidBST(root))
    }
}