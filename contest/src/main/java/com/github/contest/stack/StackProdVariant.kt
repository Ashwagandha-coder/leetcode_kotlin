package com.github.contest.stack

/**
 * 1910. Remove All Occurrences of a Substring
 * Prod Variant
 */


fun removeOccurrencesProdVariant(s: String, part: String): String {
    return buildString {
        s.forEach {
            append(it)
            if (this.length >= part.length && this.substring(this.length - part.length) == part) this.delete(
                this.length - part.length,
                this.length
            )
        }
    }
}