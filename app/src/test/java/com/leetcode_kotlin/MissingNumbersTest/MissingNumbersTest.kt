package com.leetcode_kotlin.MissingNumbersTest

import com.leetcode_kotlin.Task.twoSum.TwoSum.MissingNumbers.missingNumbers
import junit.framework.TestCase.assertEquals
import org.junit.Test

class MissingNumbersTest {

    @Test
    fun case_1() {

        val value = intArrayOf(3,0,1)

        val expected = 2
        val actual = missingNumbers(value)

        assertEquals(expected, actual)


    }

}