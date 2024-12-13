package com.leetcode_kotlin

import org.junit.Assert.assertEquals
import org.junit.Test

class NthUglyNumberTest {



    @Test
    fun testNthUglyNumber_example1() {
        val n = 10
        val expected = 12
        val actual = nthUglyNumber(n)
        assertEquals(expected, actual)
    }

    @Test
    fun testNthUglyNumber_example2() {
        val n = 1
        val expected = 1
        val actual = nthUglyNumber(n)
        assertEquals(expected, actual)
    }

    @Test
    fun testNthUglyNumber_largeN() {
        val n = 1500
        val expected = 859963392 // Expected value for n = 1500
        val actual= nthUglyNumber(n)
        assertEquals(expected, actual)
    }

    @Test
    fun testNthUglyNumber_boundaryCase() {
        val n = 1690
        val expected = 2123366400 // Expected value for n = 1690
        val actual = nthUglyNumber(n)
        assertEquals(expected, actual)
    }
}