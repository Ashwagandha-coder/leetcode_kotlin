package com.github.contest.backtracking

/**
 * 1718. Construct the Lexicographically Largest Valid Sequence
 * Alternative Solution -
 */

data class State(
    val index: Int,
    val num: Int,
    val arr: IntArray,
    val used: BooleanArray
)

fun constructDistancedSequenceIterativeSolution(n: Int): IntArray {
    val result = IntArray(2 * n - 1) { 0 }
    val used = BooleanArray(n + 1) { false }
    val stack = ArrayDeque<State>()

    stack.addLast(State(0, n, result, used))

    while (stack.isNotEmpty()) {
        val currentState = stack.removeLast()
        val (index, num, arr, used) = currentState

        if (index == arr.size) {
            return arr
        }

        if (arr[index] != 0) {
            stack.addLast(State(index + 1, n, arr, used))
            continue
        }

        for (currentNum in n downTo 1) {
            if (!used[currentNum] && isValid(currentNum, index, arr)) {
                val arrCopy = arr.copyOf()
                val usedCopy = used.copyOf()

                usedCopy[currentNum] = true
                arrCopy[index] = currentNum
                if (currentNum != 1) {
                    arrCopy[index + currentNum + 1] = currentNum
                }

                stack.addLast(State(index + 1, n, arrCopy, usedCopy))
            }
        }
    }

    return intArrayOf()
}


private fun isValid(num: Int, pos: Int, arr: IntArray): Boolean {
    if (arr[pos] != 0) return false
    if (num == 1) return true
    if (pos + num + 1 >= arr.size) return false
    if (arr[pos + num + 1] != 0) return false
    return true
}

/**
 * 1415. The k-th Lexicographical String of All Happy Strings of Length n
 * Alternative Solution
 */

fun getHappyStringAltSolution(n: Int, k: Int): String {
    val count = intArrayOf(0)
    val result = StringBuilder()
    val chars = charArrayOf('a', 'b', 'c')

    fun backtrack(current: StringBuilder) {
        if (current.length == n) {
            count[0]++
            if (count[0] == k) {
                result.append(current.toString())
            }
            return
        }

        if (count[0] >= k) return

        for (char in chars) {
            if (current.isEmpty() || current.last() != char) {
                current.append(char)
                backtrack(current)
                current.deleteCharAt(current.length - 1)
            }
        }
    }

    backtrack(StringBuilder())
    return result.toString()
}