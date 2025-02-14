package com.github.contest

import com.github.contest.heap.customStructure.MinHeap
import java.util.PriorityQueue


/**
 * Stand
 */

fun main() {

    val heap = MinHeap<Int>()
    heap.offer(3)
    heap.offer(1)
    heap.offer(2)
    heap.offer(5)


    println(heap.poll())


//    halveArrayTest(intArrayOf(3, 8, 20))

}


fun halveArrayTest(nums: IntArray): Int {
    val heap = PriorityQueue<Double>(reverseOrder())
    nums.forEach { heap.offer(it.toDouble()) }
    val sum = nums.sum().toDouble()

    val halve = sum / 2
    var halvest = 0.0
    var operations = 0
    while (halvest < halve) {
        val element = heap.poll() / 2
        heap.offer(element)
        halvest += element
        operations++
    }

    return operations
}