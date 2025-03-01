package com.leetcode_kotlin

import org.junit.Assert.assertEquals
import org.junit.Test


/**
 * 404. Sum of Left Leaves
 * Test Cases
 */

class SumOfLeftLeavesTest {

    @Test
    fun testSumOfLeftLeaves_singleNode() {
        val root = TreeNode(3)
        val solution = Solution()
        val sum = sumOfLeftLeaves(root)
        assertEquals(0, sum)
    }

    @Test
    fun testSumOfLeftLeaves_onlyLeftLeaf() {
        val root = TreeNode(3).apply {
            left = TreeNode(9)
        }
        val solution = Solution()
        val sum = sumOfLeftLeaves(root)
        assertEquals(9, sum)
    }

    @Test
    fun testSumOfLeftLeaves_onlyRightLeaf() {
        val root = TreeNode(3).apply {
            right = TreeNode(20)
        }
        val solution = Solution()
        val sum = sumOfLeftLeaves(root)
        assertEquals(0, sum)
    }

    @Test
    fun testSumOfLeftLeaves_multipleLeftLeaves() {
        val root = TreeNode(3).apply {
            left = TreeNode(9)
            right = TreeNode(20).apply {
                left = TreeNode(15)
                right = TreeNode(7)
            }
        }
        val solution = Solution()
        val sum = sumOfLeftLeaves(root)
        assertEquals(24, sum)
    }

    @Test
    fun testSumOfLeftLeaves_leftLeavesWithRightSubtree() {
        val root = TreeNode(3).apply {
            left = TreeNode(9).apply {
                right = TreeNode(10)
            }
            right = TreeNode(20).apply {
                left = TreeNode(15)
                right = TreeNode(7)
            }
        }
        val solution = Solution()
        val sum = sumOfLeftLeaves(root)
        assertEquals(15, sum)
    }
}