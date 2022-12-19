package com.leetcode_kotlin

import com.leetcode_kotlin.TwoSum.twoSumMain
import junit.framework.Assert.assertEquals
import org.junit.Test

class Solution {


    @Test
    fun case_1() {

        val expected = intArrayOf(0,1).forEach { "$it " }

        val actual = twoSumMain(intArrayOf(2,7,11,15),9).forEach { "$it " }

        assertEquals(expected, actual)


    }

}