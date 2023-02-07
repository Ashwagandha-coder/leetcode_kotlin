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


}