package com.github.contest.heap.customStructure

class MinHeap<T : Comparable<T>> {

    private val heap: MutableList<T> = mutableListOf()

    val size: Int
        get() = heap.size

    fun isEmpty(): Boolean = heap.isEmpty()

    fun peek(): T? = heap.firstOrNull()

    fun offer(element: T) {
        heap.add(element)
        heapifyUp(heap.size - 1)
    }

    fun poll(): T? {
        if (isEmpty()) throw NoSuchElementException("No Elements")
        swap(0, heap.size - 1)
        val element = heap.removeLast()
        heapifyDown(0)
        return element
    }


    private fun heapifyUp(index: Int) {
        var currentIndex = index
        var parentIndex = getParentIndex(currentIndex)
        while (currentIndex > 0 && heap[currentIndex] < heap[parentIndex]) {
            swap(currentIndex, parentIndex)
            currentIndex = parentIndex
            parentIndex = getParentIndex(currentIndex)
        }
    }

    private fun heapifyDown(index: Int) {
        var currentIndex = index
        while (hasLeftChild(currentIndex)) {
            var smallerChildIndex = getLeftChildIndex(currentIndex)
            if (hasRightChild(currentIndex) && heap[getRightChildIndex(currentIndex)] < heap[smallerChildIndex]) {
                smallerChildIndex = getRightChildIndex(currentIndex)
            }
            if (heap[currentIndex] < heap[smallerChildIndex]) {
                break
            } else {
                swap(currentIndex, smallerChildIndex)
            }
            currentIndex = smallerChildIndex
        }
    }


    private fun getParentIndex(index: Int): Int = (index - 1) / 2
    private fun getLeftChildIndex(index: Int): Int = 2 * index + 1
    private fun getRightChildIndex(index: Int): Int = 2 * index + 2
    private fun hasLeftChild(index: Int): Boolean = getLeftChildIndex(index) < heap.size
    private fun hasRightChild(index: Int): Boolean = getRightChildIndex(index) < heap.size

    private fun swap(index1: Int, index2: Int) {
        val temp = heap[index1]
        heap[index1] = heap[index2]
        heap[index2] = temp
    }
}




