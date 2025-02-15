package com.github.contest.heap.customStructure

class CustomMinHeap<T : Comparable<T>> {

    private val heap: MutableList<T> = mutableListOf()

    val size
        get() = heap.size


    fun isEmpty() = heap.isEmpty()

    fun isNotEmpty() = heap.isNotEmpty()


    fun offer(element: T) {

    }


//    fun poll(): T? {
//
//    }

    private fun heapifyUp(index: Int) {

    }


    private fun heapifyDown(index: Int) {

    }

    private fun getIndexParent(index: Int) = (index - 1) / 2

    private fun getIndexLeftChild(index: Int) = (2 * index) + 1

    private fun getIndexRightChild(index: Int) = (2 * index) + 2

    private fun hasLeftChild(index: Int) = getIndexLeftChild(index) < heap.size

    private fun hasRightChild(index: Int) = getIndexRightChild(index) < heap.size


}