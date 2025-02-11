package com.github.contest

import com.github.contest.stack.removeOccurrencesProdVariant


/**
 * Stand
 */

fun main() {

    removeOccurrencesProdVariant("daabcbaabcbc", "abc").also { println(it) }

}