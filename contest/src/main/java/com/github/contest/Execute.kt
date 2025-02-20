package com.github.contest


import com.github.contest.heap.findDiagonalOrderAlternativeSolution


/**
 * Stand
 */

fun main() {

    findDiagonalOrderAlternativeSolution(
        listOf(
            listOf(1, 2, 3, 4, 5),
            listOf(6, 7),
            listOf(8)
        )
    ).also { println(it.printArray()) }

}


fun IntArray.printArray() {
    var s = when (this.size) {
        0 -> "[]"
        1 -> "[${this[0]}]"
        2 -> "[${this[0]}, ${this[1]}]"
        else -> {
            var temp = "[${this[0]}, "
            for (i in 1 until this.size - 1) temp += "${this[i]}, "
            temp += "${this[this.size - 1]}]"
            temp
        }
    }
    println(s)
}




