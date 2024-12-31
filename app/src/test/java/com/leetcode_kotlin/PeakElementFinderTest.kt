package com.leetcode_kotlin

import org.junit.Assert.assertEquals
import org.junit.Test

class PeakElementFinderTest {


    @Test
    fun testFindPeakElement_basicCase() {
        val nums = intArrayOf(1, 2, 3, 1)
        val expected = 2
        val actual = findPeakElement(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun testFindPeakElement_multiplePeaks() {
        val nums = intArrayOf(1, 2, 1, 3, 5, 6, 4)
        val expected = 5
        val actual = findPeakElement(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun testFindPeakElement_singleElement() {
        val nums = intArrayOf(1)
        val expected = 0
        val actual = findPeakElement(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun testFindPeakElement_increasingSequence() {
        val nums = intArrayOf(1, 2)
        val expected = 1
        val actual = findPeakElement(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun testFindPeakElement_decreasingSequence() {
        val nums = intArrayOf(2, 1)
        val expected = 0
        val actual = findPeakElement(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun testFindPeakElement_increasingSequencePeakAtEnd() {
        val nums = intArrayOf(1, 2, 3)
        val expected = 2
        val actual = findPeakElement(nums)
        assertEquals(expected, actual)
    }
}