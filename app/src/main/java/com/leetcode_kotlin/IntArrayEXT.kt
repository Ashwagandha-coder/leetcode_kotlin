package com.leetcode_kotlin

fun IntArray.toListNode(): ListNode {
    if (this.isEmpty()) return ListNode(0)
    var stub = ListNode(this[0])
    val head = stub
    for (i in 1 until this.size) {
        val temp = ListNode(this[i])
        stub.next = temp
        stub = stub.next!!
    }
    return head
}

fun IntArray.sumOfRange(from: Int, to: Int): Int {
    var sum = 0
    for (i in from..to) sum += this[i]
    return sum
}