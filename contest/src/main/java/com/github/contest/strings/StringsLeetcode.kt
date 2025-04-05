package com.github.contest.strings

/**
 * 848. Shifting Letters
 */

fun shiftingLetters(str: String, shifts: IntArray): String {
    val shifting = LongArray(shifts.size)
    var sum = 0L
    var res = ""

    for (element in shifts) {
        val num = element.toLong()
        sum += num
    }

    for (i in shifting.indices) {
        shifting[i] = sum
        sum -= shifts[i].toLong()
    }

    for (i in str.indices) {
        val newCharValue = shiftLetter(str[i], shifting[i])
        res += newCharValue

    }

    return res
}

private fun shiftLetter(char: Char, shift: Long): Char = when {
    char in 'a'..'z' -> {
        val base = 'a'.code
        val offset = char.code - base
        val shifted = (offset + shift) % 26
        (base + shifted).toChar()
    }

    else -> char
}

/**
 * 2734. Lexicographically Smallest String After Substring Operation
 */

fun smallestString(s: String): String {
    if (s.hasSingle()) return when {
        s[0] == 'a' -> 'z'.toString()
        else -> Char(s[0].code - 1).toString()
    }
    val chars = s.toCharArray()
    val n = chars.size
    var start = -1

    for (i in 0 until n) {
        if (chars[i] != 'a') {
            start = i
            break
        }
    }

    if (start == -1) {
        chars[n - 1] = 'z'
        return String(chars)
    }

    for (i in start until n) {
        if (chars[i] != 'a') chars[i]--
        else break
    }

    return String(chars)

}

fun String.hasSingle(): Boolean = when {
    this.length == 1 -> true
    else -> false
}



