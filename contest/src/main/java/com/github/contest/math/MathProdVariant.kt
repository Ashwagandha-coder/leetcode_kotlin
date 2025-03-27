package com.github.contest.math

import kotlin.math.abs

/**
 * 2033. Minimum Operations to Make a Uni-Value Grid
 * Prod Variant
 */

fun minOperationsProdVariant(grid: Array<IntArray>, x: Int): Int {
    val elements = mutableListOf<Int>()
    grid.forEach { row ->
        row.forEach {
            elements.add(it)
        }
    }
    elements.sort()
    val median = elements[elements.size / 2]
    return if (elements.any { abs(elements.first() - it) % x != 0 }) -1 else elements.sumOf {
        val diff = abs(median - it)
        diff / x
    }
}