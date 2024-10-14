package com.leetcode_kotlin

fun IntArray.forEach(lambda: (Int) -> Unit) {
    for (elem in this) {
        lambda.invoke(elem)
    }
}


fun sample() {
    val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 4, 5, 6, 7)
    arr.forEach {
        if (it == 1) return@forEach
    }
}