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

/**
 * 2278. Percentage of Letter in String
 */

fun percentageLetter(s: String, letter: Char): Int {
    var count = 0
    for (char in s) if (char == letter) count++
    return if (count == 0) 0 else (count * 100) / s.length
}


/**
 * 1309. Decrypt String from Alphabet to Integer Mapping
 */

fun freqAlphabets(s: String): String {
    val result = StringBuilder()
    var i = s.length - 1

    while (i >= 0) {
        if (s[i] == '#') {
            val twoDigit = s.substring(i - 2, i).toInt()
            result.append(getLetterFromIndex(twoDigit - 1))
            i -= 3
        } else {
            result.append(getLetterFromIndex(s[i].digitToInt() - 1))
            i -= 1
        }
    }

    return result.reverse().toString()
}

fun getLetterFromIndex(index: Int): Char {
    require(index in 0..25) { "Index must be between 0 and 25 (inclusive)" }
    return 'a' + index
}


/**
 *
 */

fun isNumber(s: String): Boolean = when {
    isOnlyNumbers(s) -> true
    hasLetter(s) -> false
    isValidNumberSign(s) && !hasExponential(s) -> true
    isNotValidNumberSign(s) -> false
    else -> hasNumberExponential(s)
}

private fun hasNumberExponential(str: String): Boolean {
    var indexExp = 0
    var isNotDigits = true
    for (i in str.indices) {
        if (isExponential(str[i])) {
            indexExp = i
            break
        }
    }

    for (i in 0 until indexExp) {
        if (isDigit(str[i])) isNotDigits = false
    }

    if (isNotDigits) return false
    isNotDigits = true
    for (i in indexExp until str.length) {
        if (str[i] == '.') return false
        if (isDigit(str[i])) isNotDigits = false
    }

    return !isNotDigits
}

private fun isValidNumberSign(str: String): Boolean {
    var isPlusOrMinus = false
    var isOneDot = false
    for (char in str) {
        if (isSign(char)) {
            if (isPlusOrMinus) return false
            else isPlusOrMinus = true
        }
        if (isDot(char) && !isOneDot) {
            isOneDot = true
            continue
        }
        if (isDot(char) && isOneDot) return false
    }
    return true
}

private fun hasExponential(str: String): Boolean {
    for (char in str) if (isExponential(char)) return true
    return false
}

private fun isNotValidNumberSign(str: String): Boolean {
    var isPlusOrMinus = false
    var isOneDot = false
    for (char in str) {
        if (isSign(char)) {
            if (isPlusOrMinus) return true
            else isPlusOrMinus = true
        }
        if (isDot(char) && !isOneDot) {
            isOneDot = true
            continue
        }
        if (isOneDot) return true
    }
    return false
}

private fun hasLetter(str: String): Boolean {
    for (char in str) {
        if (isLetter(char)) return true
    }
    return false
}

private fun isOnlyNumbers(str: String): Boolean {
    for (char in str) {
        if (isLetter(char) || isExponential(char) || isSign(char) || isDot(char)) return false
    }
    return true
}

fun isDigit(char: Char): Boolean = when {
    char in '0'..'9' -> true
    else -> false
}

fun isLetter(char: Char): Boolean = when {
    (char != 'e' && char != 'E') && (char in 'a'..'z' || char in 'A'..'Z') -> true
    else -> false
}

fun isExponential(char: Char): Boolean = when {
    char == 'e' || char == 'E' -> true
    else -> false
}

fun isDot(char: Char) = when {
    char == '.' -> true
    else -> false
}

fun isSign(char: Char): Boolean {
    return when {
        char == '+' || char == '-' -> true
        else -> false
    }
}



