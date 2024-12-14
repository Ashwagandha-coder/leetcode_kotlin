package com.leetcode_kotlin

import org.junit.Assert.assertEquals
import org.junit.Test

class NumArrayProdVariantTest {

    @Test
    fun testNumArray_example1() {
        val numArray = NumArrayProdVariant(intArrayOf(1, 3, 5))
        assertEquals(9, numArray.sumRange(0, 2))
        numArray.update(1, 2)
        assertEquals(8, numArray.sumRange(0, 2))
    }

    @Test
    fun testNumArray_example2() {
        val numArray = NumArrayProdVariant(intArrayOf(0, 9, 5, 7, 3))
        assertEquals(15, numArray.sumRange(2, 4)) // sum([5, 7, 3]) = 15
        assertEquals(24, numArray.sumRange(0, 4)) // sum([0, 9, 5, 7, 3]) = 24
        numArray.update(4, 5)
        assertEquals(17, numArray.sumRange(2, 4)) // sum([5, 7, 5]) = 17
        assertEquals(26, numArray.sumRange(0, 4)) // sum([0, 9, 5, 7, 5]) = 26
    }

    @Test
    fun testNumArray_singleElement() {
        val numArray = NumArrayProdVariant(intArrayOf(5))
        assertEquals(5, numArray.sumRange(0, 0))
        numArray.update(0, 10)
        assertEquals(10, numArray.sumRange(0, 0))
    }

}