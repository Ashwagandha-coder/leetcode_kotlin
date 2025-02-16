package com.github.contest.backtracking

/**
 * 2698. Find the Punishment Number of an Integer
 * Prod Variant
 */


fun punishmentNumberProdVariant(n: Int): Int {
    return (1..n).filter { isPunishment(it) }.sumOf { it * it }
}

private fun isPunishment(num: Int): Boolean {
    val squareStr = (num * num).toString()

    fun backtrack(index: Int, currentSum: Int): Boolean = when {
        index == squareStr.length -> currentSum == num
        else -> (index until squareStr.length).any { i ->
            val subNum = squareStr.substring(index, i + 1).toInt()
            backtrack(i + 1, currentSum + subNum)
        }
    }

    return backtrack(0, 0)
}