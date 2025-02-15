package com.github.contest.backtracking

/**
 * 2698. Find the Punishment Number of an Integer
 */


fun punishmentNumber(n: Int): Int {
    var sum = 0
    for (i in 1..n) {
        if (isPunishmentNumber(i)) {
            sum += i * i
        }
    }
    return sum
}


private fun isPunishmentNumber(n: Int): Boolean {
    val square = n * n
    val squareStr = square.toString()
    return canSplit(squareStr, 0, n, 0)
}


private fun canSplit(squareStr: String, index: Int, target: Int, currentSum: Int): Boolean {
    if (index == squareStr.length) {
        return currentSum == target
    }

    var currentNum = 0
    for (i in index until squareStr.length) {
        currentNum = currentNum * 10 + (squareStr[i] - '0')
        if (canSplit(squareStr, i + 1, target, currentSum + currentNum)) {
            return true
        }
    }
    return false
}