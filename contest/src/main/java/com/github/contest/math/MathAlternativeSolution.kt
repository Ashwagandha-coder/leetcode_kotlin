package com.github.contest.math

/**
 * 171. Excel Sheet Column Number
 * Recursion Approach
 */

fun titleToNumberAltSol(columnTitle: String, base: Int = columnTitle.length - 1): Int = when {
    columnTitle.length == 1 -> columnTitle.first() - 'A' + 1
    else -> {
        val value = columnTitle.first() - 'A' + 1
        var pow = 1
        repeat(base) { pow *= 26 }
        (value * pow) + titleToNumberAltSol(columnTitle.substring(1, columnTitle.length), base - 1)
    }
}