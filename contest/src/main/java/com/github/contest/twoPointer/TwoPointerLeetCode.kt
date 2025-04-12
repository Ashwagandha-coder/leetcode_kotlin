package com.github.contest.twoPointer

/**
 * 165. Compare Version Numbers
 */

fun compareVersion(version1: String, version2: String): Int {
    val firstNumber = version1.split(".").map { it.toInt() }
    val secondNumber = version2.split(".").map { it.toInt() }

    for (i in 0 until maxOf(firstNumber.size, secondNumber.size)) {
        val p1 = if (i < firstNumber.size) firstNumber[i] else 0
        val p2 = if (i < secondNumber.size) secondNumber[i] else 0

        when {
            p1 != p2 -> {
                return if (p1 > p2) 1 else -1
            }
        }
    }
    return 0
}