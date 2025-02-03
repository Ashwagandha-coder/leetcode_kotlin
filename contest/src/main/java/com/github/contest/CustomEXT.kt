package com.github.contest

fun MutableMap<Int, Int>.removeIfEmptyBucket(key: Int) {
    this[key] = this.getOrDefault(key, 0) - 1
    if (this[key] == 0) this.remove(key)
}