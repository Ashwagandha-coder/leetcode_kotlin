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

/**
 * 1518. Water Bottles
 * Prod Variant
 * Recursion Approach
 */

fun numWaterBottles(numBottles: Int, numExchange: Int, reminder: Int = 0): Int = when {
    numBottles < numExchange -> numBottles
    numBottles % numExchange == 0 -> numBottles + numWaterBottles(
        (numBottles / numExchange) + reminder,
        numExchange
    )

    else -> numWaterBottles(numBottles - 1, numExchange, reminder + 1)
}

/**
 * 62. Unique Paths
 * Prod Variant
 */

fun uniquePaths(m: Int, n: Int): Int = List(m) {
    MutableList(n) { _ -> 1 }
}.apply {
    (1 until m).forEach { row ->
        (1 until n).forEach { col ->
            this[row][col] = this[row - 1][col] + this[row][col - 1]
        }
    }
}.last().last()


/**
 * 728. Self Dividing Numbers
 * Prod Variant
 */

fun selfDividingNumbersProdVariant(left: Int, right: Int): List<Int> = buildList {
    (left..right).forEach {
        if (isSelfDividing(it)) add(it)
    }
}
