package com.github.contest.array

fun IntArray.printArray() {
    val s = when (this.size) {
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

fun IntArray.maxAndMin(): Pair<Int, Int> {
    if (this.isEmpty()) return Pair(0, 0)

    var max = Int.MIN_VALUE
    var min = Int.MAX_VALUE

    for (elem in this) {
        max = maxOf(max, elem)
        min = minOf(min, elem)
    }

    return Pair(max, min)
}