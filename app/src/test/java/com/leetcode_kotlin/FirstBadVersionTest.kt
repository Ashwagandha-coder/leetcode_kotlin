package com.leetcode_kotlin

import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals

class FirstBadVersionTest {


    /**
     * isBadVersion - is fake api in Leetcode
     */

    @Test
    fun `range-case`() {
        val expected = 1
        val actual = firstBadVersionProdVariant(1)
        assertEquals(expected, actual)
    }



}