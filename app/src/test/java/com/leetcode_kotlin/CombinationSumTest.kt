package com.leetcode_kotlin

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class CombinationSumTest {

    @Test
    fun trivialCase() {

        val target = 7
        val cand = intArrayOf(2, 3, 6, 7)
        val expected = listOf(listOf(2, 2, 3), listOf(7))
        val actual = combinationSum(cand, target)
        assertArrayEquals(expected.toTypedArray(), actual.toTypedArray())
    }

    @Test
    fun trivialCase_2() {

        val target = 1
        val cand = intArrayOf(1, 2)
        val expected = listOf(listOf(1))
        val actual = combinationSum(cand, target)
        assertArrayEquals(expected.toTypedArray(), actual.toTypedArray())
    }

    @Test
    fun `non_trivialCase_emptyArray`() {

        val target = 1
        val cand = intArrayOf()
        val expected = listOf<Int>()
        val actual = combinationSum(cand, target)
        assertArrayEquals(expected.toTypedArray(), actual.toTypedArray())
    }

    @Test
    fun `targetZero`() {
        val candidates = intArrayOf(2, 3, 6, 7)
        val target = 0
        val expected = listOf(emptyList<Int>())
        val actual = combinationSum(candidates, target)
        assertEquals(expected, actual)
    }

    @Test
    fun `targetNegative`() {
        val candidates = intArrayOf(2, 3, 6, 7)
        val target = -1
        val expected = emptyList<List<Int>>()
        val actual = combinationSum(candidates, target)
        assertEquals(expected, actual)
    }


}