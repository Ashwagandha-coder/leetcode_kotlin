package com.leetcode_kotlin

/**
 * Executing
 */

fun main() {

    val can = intArrayOf(10, 1, 2, 7, 6, 1, 5)
    val tar = 8

    combinationSum2(can, tar).forEach {
        print("$it ")
    }

}