package com.app_v3days.TwoSum

import com.app_v3days.task.twoSumRepeatV3days
import org.junit.Assert.assertArrayEquals
import org.junit.Test

class TestTwoSum {


    @Test
    fun case_1() {

        val expected = intArrayOf(0,1)
        val actual = twoSumRepeatV3days(intArrayOf(2,7,11,15),9)


        assertArrayEquals(expected,actual)

    }

}