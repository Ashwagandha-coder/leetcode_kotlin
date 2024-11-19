package com.leetcode_kotlin

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class GroupAnagramTest {

    @Test
    fun trivialCase() {
        val arr = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")

        val actual = groupAnagramsAltSolution(arr)

        val expected =
            mutableListOf(listOf("bat"), listOf("eat", "tea", "ate"), listOf("nat"), listOf("tan"))

        assertEquals(expected, actual)
    }

}