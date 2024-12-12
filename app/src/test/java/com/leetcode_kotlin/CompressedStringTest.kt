package com.leetcode_kotlin

import org.junit.Assert.assertEquals
import org.junit.Test

class CompressedStringTest {

    @Test
    fun testCompressedString_example1() {
        val word = "aaabbcddd"
        val expected = "3a2b1c3d"
        val actual = compressedString(word)
        assertEquals(expected, actual)
    }

    @Test
    fun testCompressedString_example2() {
        val word = "a"
        val expected = "1a"
        val actual = compressedString(word)
        assertEquals(expected, actual)
    }

    @Test
    fun testCompressedString_example3() {
        val word = "aabcccccaaa"
        val expected = "2a1b5c3a"
        val actual = compressedString(word)
        assertEquals(expected, actual)
    }

    @Test
    fun testCompressedString_example4() {
        val word = "aaaaaaaaaab"
        val expected = "9a1a1b" // Note: Count is limited to 9
        val actual = compressedString(word)
        assertEquals(expected, actual)
    }

}