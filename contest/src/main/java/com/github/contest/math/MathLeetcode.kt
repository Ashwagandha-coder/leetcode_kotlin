package com.github.contest.math

/**
 * 1025. Divisor Game
 */

fun divisorGame(n: Int): Boolean = n % 2 == 0

/**
 * 1780. Check if Number is a Sum of Powers of Three
 */

fun checkPowersOfThree(n: Int): Boolean {
    var num = n
    while (num > 0) {
        if (num % 3 == 2) {
            return false
        }
        num /= 3
    }
    return true
}