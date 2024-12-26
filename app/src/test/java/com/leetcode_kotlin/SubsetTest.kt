package com.leetcode_kotlin

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class SubsetTest {

    @Test
    fun testSubsets_emptyInput() {
        val nums = intArrayOf()
        val expected = listOf(emptyList<Int>())
        val actual = subsets(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun testSubsets_singleElement() {
        val nums = intArrayOf(1)
        val expected = listOf(listOf(1), emptyList())
        val actual = subsets(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun testSubsets_multipleElements() {
        val nums = intArrayOf(1, 2, 3)
        val expected = listOf(
            emptyList<Int>(),
            listOf(1),
            listOf(2),
            listOf(1, 2),
            listOf(3),
            listOf(1, 3),
            listOf(2, 3),
            listOf(1, 2, 3)
        )
        val actual = subsets(nums)
        assertContentEquals(expected, actual)
    }

    private fun <T> assertContentEquals(expected: List<List<T>>, actual: List<List<T>>) {
        assertEquals(expected.size, actual.size)

        for (expectedSubset in expected) {
            assertTrue(actual.any { it.containsAll(expectedSubset) && expectedSubset.containsAll(it) })
        }
    }

    fun <T> List<T>.contentEquals(set: List<T>): Boolean {
        for (i in indices) {
            if (this[i] != set[i]) return false
        }
        return true
    }


}