package com.leetcode_kotlin

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class SearchRangeTest {


    @Test
    fun testSearchRange_basicCase() {
        val nums = intArrayOf(5, 7, 7, 8, 8, 10)
        val target = 8
        val expected = intArrayOf(3, 4)
        val actual = searchRange(nums, target)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun testSearchRange_targetNotFound() {
        val nums = intArrayOf(5, 7, 7, 8, 8, 10)
        val target = 6
        val expected = intArrayOf(-1, -1)
        val actual = searchRange(nums, target)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun testSearchRange_singleElement() {
        val nums = intArrayOf(5)
        val target = 5
        val expected = intArrayOf(0, 0)
        val actual = searchRange(nums, target)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun testSearchRange_emptyArray() {
        val nums = intArrayOf()
        val target = 5
        val expected = intArrayOf(-1, -1)
        val actual = searchRange(nums, target)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun testSearchRange_allSameElement() {
        val nums = intArrayOf(8, 8, 8, 8, 8)
        val target = 8
        val expected = intArrayOf(0, 4)
        val actual = searchRange(nums, target)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun testSearchRange_targetAtBeginning() {
        val nums = intArrayOf(5, 7, 7, 8, 8, 10)
        val target = 5
        val expected = intArrayOf(0, 0)
        val actual = searchRange(nums, target)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun testSearchRange_targetAtEnd() {
        val nums = intArrayOf(5, 7, 7, 8, 8, 10)
        val target = 10
        val expected = intArrayOf(5, 5)
        val actual = searchRange(nums, target)
        assertArrayEquals(expected, actual)
    }
}