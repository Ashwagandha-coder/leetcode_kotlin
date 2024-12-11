package com.leetcode_kotlin

import org.junit.Assert.assertEquals
import org.junit.Test

class BSTIteratorTest {

    @Test
    fun testBSTIterator_example1() {
        val root = TreeNode(7)
        root.left = TreeNode(3)
        root.right = TreeNode(15)
        root.right!!.left = TreeNode(9)
        root.right!!.right = TreeNode(20)

        val iterator = BSTIterator(root)
        val expected = listOf(3, 7, 9, 15, 20)
        val actual = mutableListOf<Int>()
        while (iterator.hasNext()) {
            actual.add(iterator.next())
        }

        assertEquals(expected, actual)
    }

    @Test
    fun testBSTIterator_singleNode() {
        val root = TreeNode(5)
        val iterator = BSTIterator(root)
        val expected = listOf(5)
        val actual = mutableListOf<Int>()
        while (iterator.hasNext()) {
            actual.add(iterator.next())
        }

        assertEquals(expected, actual)
    }

    @Test
    fun testBSTIterator_emptyTree() {
        val root: TreeNode? = null
        val iterator = BSTIterator(root)
        val expected = emptyList<Int>()
        val actual = mutableListOf<Int>()
        while (iterator.hasNext()) {
            actual.add(iterator.next())
        }

        assertEquals(expected, actual)
    }
}