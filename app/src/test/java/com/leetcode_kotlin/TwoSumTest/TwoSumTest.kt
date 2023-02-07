package com.leetcode_kotlin.TwoSumTest

import com.leetcode_kotlin.Task.twoSum.TwoSum.TwoSum.twoSumMain
import junit.framework.Assert.assertEquals
import org.junit.Test

class TwoSumTest {


    @Test
    fun case_1() {

        val expected = intArrayOf(0,1).forEach { "$it " }

        val actual = twoSumMain(intArrayOf(2,7,11,15),9).forEach { "$it " }

        assertEquals(expected, actual)


    }

}