package com.leetcode_kotlin


/**
 * Executing
 */

fun main() {

    val head = intArrayOf(1, 2, 3, 4, 5).toListNode()

    val arr = mutableListOf(1,2,3,4,5,6,7,8,9).filterIsInstance<Int>()

    TODO("Write custom ext function with generics and add rem note for repeat")

    reverseList(head).let { it?.printListNode() }


}
