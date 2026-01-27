package com.github.contest.fromInterview

fun isOneEditDistance(first: String, second: String): Boolean {
    val len1 = first.length
    val len2 = second.length

    // Quick checks
    if (Math.abs(len1 - len2) > 1) return false
    if (first == second) return true // Zero edits

    // Ensure first is the longer or equal string for simplicity
    return if (len1 < len2) {
        isOneEdit(second, first)
    } else {
        isOneEdit(first, second)
    }
}

private fun isOneEdit(longer: String, shorter: String): Boolean {
    var i = 0
    var j = 0
    var foundDifference = false

    while (i < longer.length && j < shorter.length) {
        if (longer[i] != shorter[j]) {
            if (foundDifference) return false
            foundDifference = true

            if (longer.length == shorter.length) {
                // Replace operation - move both pointers
                i++
                j++
            } else {
                // Delete from longer (or add to shorter) - move only longer pointer
                i++
            }
        } else {
            i++
            j++
        }
    }

    return true
}