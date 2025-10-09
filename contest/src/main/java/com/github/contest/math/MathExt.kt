package com.github.contest.math

fun abs(number: Int): Int = when {
    number < 0 -> number * -1
    else -> number
}