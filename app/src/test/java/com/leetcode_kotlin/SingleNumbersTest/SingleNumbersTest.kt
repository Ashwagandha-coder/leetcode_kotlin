package com.leetcode_kotlin.SingleNumbersTest

import com.leetcode_kotlin.Task.twoSum.TwoSum.SingleNumbers.singleNumbers
import junit.framework.TestCase.assertEquals
import org.junit.Test

class SingleNumbersTest {


    @Test
    fun case_1() {

        val value = intArrayOf(2,2,1)

        val expected = 1
        val actual = singleNumbers(value)

        assertEquals(expected, actual)

    }

}