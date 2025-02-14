package com.github.contest.heap.customStructure

class OtherCustomMinHeap<T : Comparable<T>> {

    private val heap: MutableList<T> = mutableListOf()

    fun isEmpty() = heap.isEmpty()

    fun isNotEmpty() = heap.isNotEmpty()

    fun offer(element: T) {
        heap.add(element)
        heapifyUp(heap.size - 1)
    }


    fun poll(): T? {
        if (isEmpty()) throw NoSuchElementException("No Element's")
        swap(0, heap.size - 1)
        val element = heap.removeLast()
        heapifyDown(0)
        return element
    }


    private fun heapifyUp(index: Int) {
        var currentIndex = index
        var parentIndex = getParentIndex(index)
        while (currentIndex > 0 && heap[parentIndex] > heap[currentIndex]) {
            swap(currentIndex, parentIndex)
            currentIndex = parentIndex
            parentIndex = getParentIndex(currentIndex)
        }
    }

    private fun heapifyDown(index: Int) {
        var currentIndex = index
        while (hasLeftChild(currentIndex)) {
            val leftChild = getLeftChild(currentIndex)
            if (heap[currentIndex] > heap[leftChild]) {
                swap(currentIndex, leftChild)
            }
            if (hasRightChild(currentIndex)) {
                val rightChild = getRightChild(currentIndex)
                if (heap[currentIndex] > heap[rightChild]) {
                    swap(currentIndex, rightChild)
                }
            }
            currentIndex = leftChild
        }
    }

    private fun swap(from: Int, to: Int) {
        val temp = heap[from]
        heap[from] = heap[to]
        heap[to] = temp
    }


    private fun hasLeftChild(index: Int): Boolean = getLeftChild(index) < heap.size

    private fun hasRightChild(index: Int): Boolean = getRightChild(index) < heap.size

    private fun getLeftChild(index: Int) = (2 * index) + 1

    private fun getRightChild(index: Int) = (2 * index) + 2

    private fun getParentIndex(index: Int) = (index - 1) / 2


}