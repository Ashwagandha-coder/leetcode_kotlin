package com.leetcode_kotlin.ReverseIntegerTest

import com.leetcode_kotlin.Task.twoSum.TwoSum.ReverseInteger.reverseInt
import junit.framework.TestCase.assertEquals
import org.junit.Test

class ReverseIntegerTest {

    @Test
    fun case_1() {

        val number = 324
        val expected = 423
        val actual = reverseInt(number)

        assertEquals(expected, actual)


    }


}