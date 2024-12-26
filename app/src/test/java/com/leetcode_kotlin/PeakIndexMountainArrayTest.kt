package com.leetcode_kotlin

import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals

class PeakIndexMountainArrayTest {

    @Test
    fun `trivial_case_first`() {
        val arr = intArrayOf(0, 1, 0)
        val expected = peakIndexInMountainArray(arr)
        val actual = 1
        assertEquals(expected, actual)
    }

    @Test
    fun `odd-len_case`() {
        val arr = intArrayOf(0, 1, 2, 5, 2)
        val expected = peakIndexInMountainArray(arr)
        val actual = 3
        assertEquals(expected, actual)
    }

    @Test
    fun `even-len_case`() {
        val arr = intArrayOf(0, 1, 3, 7, 4, 2)
        val expected = peakIndexInMountainArray(arr)
        val actual = 3
        assertEquals(expected, actual)
    }


}