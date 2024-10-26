package com.leetcode_kotlin


/**
 * Executing
 */


fun main() {

    val arr = intArrayOf(-10, -3, 0, 5, 9)

    sortedArrayToBST(arr).also {
        println(it?.`val`)
    }

}

