package com.leetcode_kotlin.Task.twoSum.TwoSum.AddTwoNumbers

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

    val result = ListNode(0)
    var reference: ListNode? = l1
    var reference2: ListNode? = l2
    val listReference = mutableListOf<ListNode>()
    val listReference2 = mutableListOf<ListNode>()

    while (reference?.next != null) {

        listReference.add(reference)
        reference = reference.next

        if (reference2 != null) {
            listReference2.add(reference2)
        }
        reference2 = reference2?.next


    }
    listReference.reverse()
    listReference2.reverse()

    for (i in 0..listReference.size - 1) {




    }


    return null
}


class ListNode(private val value: Int) {

    var next: ListNode? = null

}




