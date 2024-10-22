package com.leetcode_kotlin


/**
 * Executing
 */

fun main() {

    var head = LinkedList.makeLinkedList(intArrayOf(1, 3, 4, 7, 1, 2, 6))

    deleteMiddleAlt(head).let { it?.printListNode() }


}
