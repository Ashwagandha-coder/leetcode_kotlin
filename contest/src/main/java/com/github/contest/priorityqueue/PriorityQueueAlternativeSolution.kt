package com.github.contest.priorityqueue

/**
 * 2182. Construct String With Repeat Limit
 * Alternative Solution
 */

fun repeatLimitedStringAltSolution(s: String, repeatLimit: Int): String {
    val freq = s.eachCountLetter()
    val res = StringBuilder()
    var i = 25

    while (i >= 0) {
        if (freq[i] == 0) {
            i--
            continue
        }

        val letter = Char(i + 'a'.code)
        val count = minOf(freq[i], repeatLimit)

        repeat(count) {
            res.append(letter)
        }

        freq[i] -= count

        if (freq[i] > 0) {
            var foundSeparator = false
            var j = i - 1
            while (j >= 0) {
                if (freq[j] > 0) {
                    res.append('a' + j)
                    freq[j]--
                    foundSeparator = true
                    break
                }
                j--
            }
            if (!foundSeparator) break
        } else i--
    }

    return res.toString()
}

private fun String.eachCountLetter(): IntArray {
    if (isEmpty()) return intArrayOf()

    val freq = IntArray(26)
    for (char in this) freq[char - 'a']++
    return freq
}