package com.leetcode_kotlin

import org.junit.Test
import org.junit.jupiter.api.Assertions.assertArrayEquals

class FindThePowerOfSubArray {


    @Test
    fun trivialCase() {
        val nums = intArrayOf(1, 2, 3, 4, 3, 2, 5)

        val k = 3

        val expected = powerOfSubarrays(nums, k)

        val actual = intArrayOf(3, 4, -1, -1, -1)

        assertArrayEquals(expected, actual)
    }

    @Test
    fun `two_trivial_case`() {
        val nums = intArrayOf(2, 2, 2, 2, 2)
        val k = 4
        val expected = powerOfSubarrays(nums, k)
        val actual = intArrayOf(-1, -1)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `non-trivial_EmptyArray`() {
        val nums = intArrayOf()
        val k = 0
        val expected = powerOfSubarrays(nums, k)
        val actual = intArrayOf()
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `non-trivial_ConsecutiveSequence`() {
        val nums = intArrayOf(1, 3, 4)
        val k = 2
        val expected = powerOfSubarrays(nums, k)
        val actual = intArrayOf(-1, 4)
        assertArrayEquals(expected, actual)
    }


}