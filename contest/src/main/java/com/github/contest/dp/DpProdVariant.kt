package com.github.contest.dp


/**
 * 70. Climbing Stairs
 * Prod Variant
 */

fun climbStairsProdVariant(n: Int): Int =
    (n <= 2).takeIf { it }?.let { n } ?: (3..n).fold(1 to 2) { (prev1, prev2), _ ->
        prev2 to prev1 + prev2
    }.second

private fun prodVariant(n: Int): Int = when {
    n <= 2 -> n
    else -> (3..n).fold(1 to 2) { (prev1, prev2), _ ->
        prev2 to prev1 + prev2
    }.second
}