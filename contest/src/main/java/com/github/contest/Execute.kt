package com.github.contest


import com.github.contest.dp.minPathSum


/**
 * Stand
 */

fun main() {

    minPathSum(
        arrayOf(
            intArrayOf(1, 3, 1),
            intArrayOf(1, 5, 1),
            intArrayOf(4, 2, 1)
        )
    ).also { println(it) }

}