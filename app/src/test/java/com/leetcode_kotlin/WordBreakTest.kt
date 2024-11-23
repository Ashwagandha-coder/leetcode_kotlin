package com.leetcode_kotlin

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class WordBreakTest {


    @Test
    fun baseCase() {

        val s = "leetcode"

        val arr = listOf("leet", "code")

        val call = wordBreak(s, arr)

        assertEquals(true, call)

    }


    @Test
    fun `two trivial case`() {
        val s = "applepenapple"

        val dictionary = listOf("apple", "pen", "apple")

        val call = wordBreak(s, dictionary)

        assertEquals(true, call)

    }

    @Test
    fun `trivial false case`() {
        val s = "advertisment"

        val dict = listOf("adver", "verti", "tism", "ment")

        val call = wordBreak(s, dict)

        assertEquals(false, call)
    }


    @Test
    fun `empty input string`() {

        val s = ""

        val dictionary = listOf("leet", "code")

        val call = wordBreak(s, dictionary)

        assertEquals(true, call)

    }

}