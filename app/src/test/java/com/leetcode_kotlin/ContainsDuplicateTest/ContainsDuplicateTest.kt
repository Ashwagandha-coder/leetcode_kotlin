package com.leetcode_kotlin.ContainsDuplicateTest

import com.leetcode_kotlin.Task.twoSum.TwoSum.ContainmsDublicate.containsDuplicate
import junit.framework.TestCase.assertEquals
import org.junit.Test

class ContainsDuplicateTest {

    @Test
    fun case_1() {


        val value = intArrayOf(1,2,3,4,4,5)

        val expected = true
        val actual = containsDuplicate(value)

        assertEquals(expected, actual)
    }

}