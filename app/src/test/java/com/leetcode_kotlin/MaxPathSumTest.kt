package com.leetcode_kotlin

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class MaxPathSumTest {

    @Test
    fun `trivialCase`() {
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(3)

        val expected = maxPathSum(root)
        val actual = 6
        assertEquals(expected, actual)
    }

}