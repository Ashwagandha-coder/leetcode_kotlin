package com.github.contest

fun MutableMap<Int, Int>.removeIfEmptyBucket(key: Int) {
    this[key] = this.getOrDefault(key, 0) - 1
    if (this[key] == 0) this.remove(key)
}


fun Any.printData(label: String) {
    println("$label $this")
}


inline fun abs(number: Int): Int = when {
    number < 0 -> number * -1
    else -> number
}