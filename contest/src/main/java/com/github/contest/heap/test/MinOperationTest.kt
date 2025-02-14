package com.github.contest.heap.test

import com.github.contest.heap.minOperationProdVariant
import junit.framework.TestCase.assertEquals
import org.junit.Test

class MinOperationTest {


    @Test
    fun `trivial_case`() {
        val arr = intArrayOf(2, 10, 12, 1, 3)
        val k = 10
        val actual = minOperationProdVariant(arr, k)
        val expected = 2
        assertEquals(expected, actual)
    }


    @Test
    fun `two_elements`() {
        val arr = intArrayOf(2, 3)
        val k = 3
        val actual = minOperationProdVariant(arr, k)
        val expected = 1
        assertEquals(expected, actual)
    }

}