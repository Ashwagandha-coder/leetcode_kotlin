package com.leetcode_kotlin

import java.util.LinkedList

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
    arr.count { it == 3 }
    val linked = LinkedList<Int>(arr.toList())

}

/**
 * Algo:
 * 1. how to add array elements to linked list for cycle
 */

/**
 *  1. custom ext fun for collection (filter, map, forEach, indexed, etc...
 *  2. lambda function - mental and repeat
 *  3. return@forEach - What is?
 *  4. operators inline crossinline, noinline
 *  5. compile kotlin - object, companion object, extension fun
 *  6. UInt, ULong - what is?
 *  7. Standart library, what is ?
 *  8. Search new features to kotlin API
 */