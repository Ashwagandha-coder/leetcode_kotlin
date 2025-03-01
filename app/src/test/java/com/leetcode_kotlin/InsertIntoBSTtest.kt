package com.leetcode_kotlin

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     varleft: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class InsertIntoBSTtest {
    @Test
    fun testInsertIntoBST_emptyTree() {
        val root: TreeNode? = null
        val solution = Solution()
        val newRoot = insertIntoBST(root, 5)
        assertEquals(5, newRoot?.`val`) // New root should have value 5
        assertEquals(null, newRoot?.left) // Left child should be null
        assertEquals(null, newRoot?.right) // Right child should benull
    }

    @Test
    fun testInsertIntoBST_existingTree() {
        val root = TreeNode(4).apply {
            left = TreeNode(2).apply {
                left = TreeNode(1)
                right = TreeNode(3)
            }
            right = TreeNode(7)
        }
        val solution = Solution()
        val newRoot = insertIntoBST(root, 5)


        val expectedInorder = listOf(1, 2, 3, 4, 5, 7)
        val actualInorder = inorderTraversal(newRoot)
        assertEquals(expectedInorder, actualInorder)
    }


    private fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        fun inorder(node: TreeNode?) {
            if (node != null) {
                inorder(node.left)
                result.add(node.`val`)
                inorder(node.right)
            }
        }
        inorder(root)
        return result
    }
}