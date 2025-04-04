package com.github.contest.strings

/**
 * 848. Shifting Letters
 */

fun shiftingLetters(str: String, shifts: IntArray): String {
    val shifting = IntArray(shifts.size)
    var sum = shifts.sum()
    var res = ""

    for (i in shifting.indices) {
        shifting[i] = sum
        sum -= shifts[i]
    }

    for (i in str.indices) {
        val newCharValue = shiftLetter(str[i], shifting[i])
        res += newCharValue

    }

    return res
}

private fun shiftLetter(char: Char, shift: Int): Char = when {
    char in 'a'..'z' -> {
        val base = 'a'.code
        val offset = char.code - base
        val shifted = (offset + shift) % 26
        (base + shifted).toChar()
    }
    else -> char
}

