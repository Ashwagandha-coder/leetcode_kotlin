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

/**
 * 1718. Construct the Lexicographically Largest Valid Sequence
 */


fun constructDistancedSequence(n: Int): IntArray {
    val result = IntArray(2 * n - 1)
    val used = BooleanArray(n + 1)

    fun backtrack(index: Int): Boolean {
        if (index == result.size) {
            return true
        }
        if (result[index] != 0) {
            return backtrack(index + 1)
        }

        for (num in n downTo 1) {
            if (!used[num]) {
                if (num == 1) {
                    result[index] = num
                    used[num] = true
                    if (backtrack(index + 1)) {
                        return true
                    }
                    used[num] = false
                    result[index] = 0
                } else if (index + num < result.size && result[index + num] == 0) {
                    result[index] = num
                    result[index + num] = num
                    used[num] = true
                    if (backtrack(index + 1)) {
                        return true
                    }
                    used[num] = false
                    result[index] = 0
                    result[index + num] = 0
                }
            }
        }
        return false
    }

    backtrack(0)
    return result
}

/**
 * 1079. Letter Tile Possibilities
 */

fun numTilePossibilities(tiles: String): Int {
    val count = IntArray(26)
    for (c in tiles) {
        count[c - 'A']++
    }
    return dfs(count)
}

private fun dfs(count: IntArray): Int {
    var sum = 0
    for (i in 0 until 26) {
        if (count[i] == 0) continue
        sum++
        count[i]--
        sum += dfs(count)
        count[i]++
    }
    return sum
}
