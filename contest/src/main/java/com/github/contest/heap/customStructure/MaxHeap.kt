package com.github.contest.heap.customStructure

class MaxHeap<T : Comparable<T>> {

    private val heap = mutableListOf<T>()
    val size get() = heap.size

    fun isEmpty() = heap.isEmpty()

    fun isNotEmpty() = heap.isNotEmpty()

    fun offer(item: T) {
        heap.add(item)
        siftUp(heap.size - 1)
    }

    fun poll(): T? {
        if (isEmpty()) throw IndexOutOfBoundsException()
        heap.swap(0, heap.size - 1)
        val element = heap.removeLast()
        siftDown(0)
        return element
    }


    private fun siftUp(index: Int) {
        var currentIndex = index
        var parentIndex = parentIndex(currentIndex)
        while (currentIndex > 0 && heap[currentIndex] > heap[parentIndex]) {
            heap.swap(currentIndex, parentIndex)
            currentIndex = parentIndex
            parentIndex = parentIndex(currentIndex)
        }
    }


    private fun siftDown(index: Int) {
        var currentIndex = index
        while (hasLeftChild(currentIndex)) {
            var smallestIndex = leftChildIndex(currentIndex)
            if (hasRightChild(currentIndex) && heap[rightChildIndex(currentIndex)] > heap[smallestIndex]) {
                smallestIndex = rightChildIndex(currentIndex)
            }
            if (heap[currentIndex] > heap[smallestIndex]) break
            heap.swap(currentIndex, smallestIndex)
            currentIndex = smallestIndex
        }
    }

    private fun MutableList<T>.swap(from: Int, to: Int) {
        val temp = this[from]
        this[from] = this[to]
        this[to] = temp
    }

    private fun hasLeftChild(index: Int): Boolean = leftChildIndex(index) < heap.size

    private fun hasRightChild(index: Int): Boolean = rightChildIndex(index) < heap.size

    private fun leftChildIndex(index: Int) = (index * 2) + 1

    private fun rightChildIndex(index: Int) = (index * 2) + 2

    private fun parentIndex(index: Int) = (index - 1) / 2

}