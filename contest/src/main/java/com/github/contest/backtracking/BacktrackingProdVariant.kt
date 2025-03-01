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

/**
 * 1415. The k-th Lexicographical String of All Happy Strings of Length n
 * Prod Variant
 */


fun getHappyStringProdVariant(n: Int, k: Int): String {
    val result = StringBuilder()
    val chars = setOf('a', 'b', 'c')
    var count = 0
    fun generateHappyString(current: StringBuilder) {
        if (current.length == n) {
            count++
            if (count == k) result.append(current.toString())
            return
        }

        if (count >= k) return

        chars.filter { current.isEmpty() || current.last() != it }.forEach {
            current.append(it)
            generateHappyString(current)
            current.deleteLast()
        }
    }

    generateHappyString(StringBuilder())
    return result.toString()
}

private fun StringBuilder.deleteLast() {
    if (isNotEmpty()) deleteCharAt(this.length - 1)
}