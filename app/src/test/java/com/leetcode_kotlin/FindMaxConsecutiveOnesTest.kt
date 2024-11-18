package com.leetcode_kotlin

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

class FindMaxConsecutiveOnesTest {


    @Test
    fun trivialFirst() {
        val nums = intArrayOf(1, 1, 0, 1, 1, 1)
        val call = findMaxConsecutiveOnes(nums)
        assertEquals(3, call)
    }
}


