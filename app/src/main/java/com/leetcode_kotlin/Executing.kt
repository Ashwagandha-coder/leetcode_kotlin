package com.leetcode_kotlin


/**
 * Executing
 */


fun main() {


    val head = intArrayOf(1, 2, 3, 4, 5).toListNode()
    val k = 2
    reverseKGroup(head, k).also { it?.printListNode() }
}






