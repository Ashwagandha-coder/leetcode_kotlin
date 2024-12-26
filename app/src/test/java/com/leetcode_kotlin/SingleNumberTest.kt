package com.leetcode_kotlin

import org.junit.Assert.assertEquals
import org.junit.Test

class SingleNumberTest {


    @Test
    fun testSingleNumber_example1() {
        val nums = intArrayOf(2, 2, 1)
        val expected = 1
        val actual = singleNumber(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun testSingleNumber_example2() {
        val nums = intArrayOf(4, 1, 2, 1, 2)
        val expected = 4
        val actual = singleNumber(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun testSingleNumber_singleElement() {
        val nums = intArrayOf(1)
        val expected = 1
        val actual = singleNumber(nums)
        assertEquals(expected, actual)
    }
}