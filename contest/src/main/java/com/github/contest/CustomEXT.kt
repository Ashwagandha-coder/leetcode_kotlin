package com.github.contest


fun <K, V> MutableMap<K, V>.removeIfEmptyBucket(key: K) {
    if (this[key] == 0) this.remove(key)
}

fun <K> MutableMap<K, Int>.reduceCount(key: K) {
    this[key] = this.getOrDefault(key, 0) - 1
    removeIfEmptyBucket(key)
}


fun abs(number: Int): Int = when {
    number < 0 -> number * -1
    else -> number
}