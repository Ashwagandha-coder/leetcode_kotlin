package com.leetcode_kotlin


/**
 * Executing
 */


fun main() {

    val arr = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)

    Repeat.value.selectionSortFinalOctember(arr).also {
        it.forEach { num -> print("$num ") }
    }

}

