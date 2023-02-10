package com.leetcode_kotlin.findDisappearedNumbersTest

import com.leetcode_kotlin.Task.twoSum.TwoSum.FindDisapearedNumbers.findDisappearedNumbers
import junit.framework.TestCase.assertEquals
import org.junit.Test

class FindDisappearedNumbersTest {


    @Test
    fun case_1() {

        val value = intArrayOf(4,3,2,7,8,2,3,1)

        val expected = listOf(5,6)
        val actual = findDisappearedNumbers(value)

        assertEquals(expected, actual)


    }

}