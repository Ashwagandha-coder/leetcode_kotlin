package com.github.contest

import com.github.contest.binarySearch.maxIncreasingSubarrays


/**
 * Stand
 */

fun main() {

    maxIncreasingSubarrays(listOf(2, 5, 7, 8, 9, 2, 3, 4, 3, 1)).also { println(it) }
    maxIncreasingSubarrays(listOf(1, 2)).also { println(it) }
    maxIncreasingSubarrays(listOf(9, 8, 7, 6, 5, 4, 3, 2, 1)).also { println(it) }

}




