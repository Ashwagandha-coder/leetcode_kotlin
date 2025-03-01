package com.github.contest.hashTable.test

import com.github.contest.hashTable.areAlmostEqual
import junit.framework.TestCase.assertEquals
import org.junit.Test


/**
 * 1790. Check if One String Swap Can Make Strings Equal
 * Test
 */

class CheckIfOneStringSwapCanMakeStringsEqualTest {


    @Test
    fun `first_case`() {
        val s1 = "bank"
        val s2 = "kanb"

        val expected = true
        val actual = areAlmostEqual(s1, s2)
        assertEquals(expected, actual)
    }


    @Test
    fun `one_element`() {
        val s1 = "a"
        val s2 = "b"

        val actual = areAlmostEqual(s1, s2)
        assertEquals(false, actual)
    }


    @Test
    fun `two_equals_string`() {
        val s1 = "anna"
        val s2 = "anna"

        val actual = areAlmostEqual(s1, s2)

        assertEquals(true, actual)
    }


}