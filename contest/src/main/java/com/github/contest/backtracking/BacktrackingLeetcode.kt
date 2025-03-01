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

/**
 * 1415. The k-th Lexicographical String of All Happy Strings of Length n
 */


fun getHappyString(n: Int, k: Int): String {
    val res = mutableListOf<String>()
    val set = "abc"
    val subset = StringBuilder()
    generateHappyString(0, n, set, subset, res)
    return if (k > res.size) "" else res[k - 1]
}

private fun generateHappyString(
    index: Int,
    n: Int,
    set: String,
    subset: StringBuilder,
    res: MutableList<String>
) {
    if (index == n) {
        res.add(subset.toString())
        return
    }

    for (s in set) {
        if (subset.isEmpty() || subset[subset.length - 1] != s) {
            subset.append(s)
            generateHappyString(index + 1, n, set, subset, res)
            subset.deleteCharAt(subset.length - 1)
        }
    }
}

/**
 * 1980. Find Unique Binary String
 */


fun findDifferentBinaryString(nums: Array<String>): String {
    val set = mutableSetOf<String>()
    for (num in nums) set.add(num)
    return generateBinaryString(set, 0, nums[0].length, StringBuilder())
}

private fun generateBinaryString(set: Set<String>, index: Int, n: Int, str: StringBuilder): String {
    if (index == n) {
        return if (!set.contains(str.toString())) str.toString() else ""
    }
    repeat(2) {
        str.append(it.toString())
        val ans = generateBinaryString(set, index + 1, n, str)
        if (ans.isNotEmpty()) return ans
        str.deleteLast()
    }
    return ""
}

private fun StringBuilder.deleteLast() {
    if (isNotEmpty()) this.deleteCharAt(this.length - 1)
}