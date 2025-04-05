package com.github.contest.strings

/**
 * 848. Shifting Letters
 * Prod Variant
 */

fun shiftingLetterProdVariant(str: String, shifts: IntArray): String {
    var sum = shifts.toLongArray().sum()
    return buildString {
        str.forEachIndexed { index, letter ->
            val new = letter.shiftLetter(sum)
            append(new)
            sum -= shifts[index]
        }
    }
}

private fun IntArray.toLongArray(): LongArray {
    val new = LongArray(this.size)
    for (i in indices) {
        new[i] = this[i].toLong()
    }

    return new
}

private fun Char.shiftLetter(shift: Long): Char = when {
    this in 'a'..'z' -> {
        val base = 'a'.code
        val offset = this.code - base
        val shifted = (offset + shift) % 26
        (base + shifted).toChar()
    }

    else -> this
}