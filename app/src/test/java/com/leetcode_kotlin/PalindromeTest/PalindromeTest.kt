package com.leetcode_kotlin.PalindromeTest

import com.leetcode_kotlin.PalindromeNumber.palindromeNumber
import junit.framework.Assert.assertEquals
import org.junit.Test

class PalindromeTest {


    @Test
    fun case_1() {

        val expected = palindromeNumber(121)
        val actual = true

        assertEquals(expected, actual)


    }

    @Test
    fun case_2() {

        val expected = false
        val actual = palindromeNumber(-121)

        assertEquals(expected,actual)


    }

    @Test
    fun case_3() {

        val expected = false
        val actual = palindromeNumber(10)


    }

}