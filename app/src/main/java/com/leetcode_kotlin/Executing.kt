package com.leetcode_kotlin


/**
 * Executing
 */


fun main() {

    val head = intArrayOf(1, 4, 3, 2, 5, 2).toListNode()
    val x = 3
    partition(head, x).also { it?.printListNode() }
}






