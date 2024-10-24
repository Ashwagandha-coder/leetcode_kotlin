package com.leetcode_kotlin


/**
 * Executing
 */

fun main() {


    val board = arrayOf(
        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )

    wrapSudoku(board)
    board.let {
        it.forEach { elem ->
            elem.forEach { char ->
                print("$char ")
            }
        }
    }
    TODO("Write custom ext function with generics and add rem note for repeat")
}


fun executeListNode() {
    val head = intArrayOf(1, 2, 3, 4, 5).toListNode()
    val arr = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9).filterIsInstance<Int>()
    reverseList(head).let { it?.printListNode() }
}
