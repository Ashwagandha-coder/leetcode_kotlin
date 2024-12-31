package com.leetcode_kotlin


/**
 * Executing
 */


fun main() {


    val matrix = arrayOf(
        intArrayOf(1, 5, 9),
        intArrayOf(10, 11, 13),
        intArrayOf(12, 13, 15)
    )
    val k = 8


    val arr = intArrayOf(4, 5, 6, 7, 0, 1, 2)

    val target = 0

    search(arr, target).also { println(it) }

    //kthSmallestAltSolution(matrix, k).also { println(it) }
}






