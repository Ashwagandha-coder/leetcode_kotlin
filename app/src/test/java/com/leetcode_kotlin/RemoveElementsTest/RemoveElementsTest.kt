package com.leetcode_kotlin.RemoveElementsTest

import com.leetcode_kotlin.Task.twoSum.TwoSum.RemoveElements.removeElements
import junit.framework.TestCase.assertEquals
import org.junit.Test

class RemoveElementsTest {

    @Test
    fun case_1() {

        val massive = intArrayOf(3,2,2,3)
        val value = 2

        val expected = 2
        val actual = removeElements(massive,value)

        assertEquals(expected, actual)

    }

    @Test
    fun case_2() {

        val massive = intArrayOf(0,1,2,2,3,0,4,2)
        val value = 2

        val expected = 5
        val actual = removeElements(massive,value)

        assertEquals(expected, actual)

    }
}