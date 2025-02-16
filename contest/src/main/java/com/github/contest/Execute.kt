package com.github.contest

import com.github.contest.dp.countVowels
import com.github.contest.graph.findJudge
import com.github.contest.heap.customStructure.CustomMinHeap
import com.github.contest.heap.findXSum


/**
 * Stand
 */

fun main() {

    findXSum(intArrayOf(1, 2, 3, 4, 5, 6), 6, 1)
}

fun findJudgeData() {
    findJudge(
        5,
        arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 3),
            intArrayOf(4, 3),
            intArrayOf(4, 1),
            intArrayOf(5, 3),
            intArrayOf(5, 1),
            intArrayOf(5, 4)
        )
    )
}

fun vowels() {

    /**
     * a a a
     * aa
     * aa
     * aaa
     * count - 10
     */

    countVowels("aaa")

}


fun heapWork() {

    val heap = CustomMinHeap<Int>()
    heap.offer(3)
    heap.offer(1)
    heap.offer(2)
    heap.offer(5)


    println(heap.poll())

}
