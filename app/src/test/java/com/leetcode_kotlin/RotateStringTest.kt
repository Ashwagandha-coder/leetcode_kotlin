package com.leetcode_kotlin

import org.junit.Assert.assertEquals
import org.junit.Test

class RotateStringTest {


    @Test
    fun testRotateString_example1() {
        val s = "abcde"
        val goal = "cdeab"
        assertEquals(true, rotateString(s, goal))
    }

    @Test
    fun testRotateString_example2() {
        val s = "abcde"
        val goal = "abced"
        assertEquals(false, rotateString(s, goal))
    }

    @Test
    fun testRotateString_emptyStrings() {
        val s = ""
        val goal = ""
        assertEquals(true, rotateString(s, goal))
    }

    @Test
    fun testRotateString_sameString() {
        val s = "abc"
        val goal = "abc"
        assertEquals(true, rotateString(s, goal))
    }

    @Test
    fun testRotateString_singleCharacter() {
        val s = "a"
        val goal = "a"
        assertEquals(true, rotateString(s, goal))
    }
}