package com.github.contest.stack

/**
 * 3174. Clear Digits
 */

fun clearDigits(s: String): String {
    val stack = ArrayDeque<Char>()
    for (char in s) {
        if (isDigit(char)) {
            if (stack.isNotEmpty()) stack.removeLast()
        } else stack.addLast(char)
    }
    return if (stack.isEmpty()) "" else buildString {
        while (stack.isNotEmpty()) {
            val temp = stack.removeFirst()
            append(temp)
        }
    }
}

private fun isDigit(char: Char) = char in "0123456789"


/**
 * 1910. Remove All Occurrences of a Substring
 */

fun removeOccurrences(s: String, part: String): String {
    val res = StringBuilder()
    val m = part.length

    for (c in s.toCharArray()) {
        res.append(c)
        if (res.length >= m && res.substring(res.length - m) == part) {
            res.delete(res.length - m, res.length)
        }
    }
    return res.toString()
}


