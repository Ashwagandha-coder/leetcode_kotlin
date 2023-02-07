package com.leetcode_kotlin.RomanToInt

import com.leetcode_kotlin.Task.twoSum.TwoSum.RomanToInteger.romanToInteger
import junit.framework.TestCase.assertEquals
import org.junit.Test

class RomanToIntTest {

    @Test
    fun case_1() {

        val value = "V"
        val expected = 5
        val actual = romanToInteger(value)

        assertEquals(expected, actual)


    }

    @Test
    fun case_2() {

        val value = "X"
        val expected = 10
        val actual = romanToInteger(value)

        assertEquals(expected, actual)

    }

    @Test
    fun case_3() {

        val value = "IV"
        val expected = 4
        val actual = romanToInteger(value)

        assertEquals(expected, actual)

    }

    @Test
    fun case_4() {

        val value = "IX"
        val expected = 9
        val actual = romanToInteger(value)

        assertEquals(expected, actual)

    }

    @Test
    fun case_5() {

        val value = "III"
        val expected = 3
        val actual = romanToInteger(value)

        assertEquals(expected, actual)


    }


}