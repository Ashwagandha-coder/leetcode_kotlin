package com.github.contest.heap.customStructure

class CustomMinHeap<T : Comparable<T>> {

    private val heap: MutableList<T> = mutableListOf()

    val size
        get() = heap.size


    fun isEmpty() = heap.isEmpty()

    fun isNotEmpty() = heap.isNotEmpty()


    fun offer(element: T) {
        heap.add(element)
        siftUp(heap.size - 1)
    }


    fun poll(): T? {
        if (isEmpty()) throw NoSuchElementException("No Element's")
        swap(0, heap.size - 1)
        val element = heap.removeLast()
        siftDown(0)
        return element
    }

    private fun siftUp(index: Int) {
        var currentIndex = index
        var parentIndex = getIndexParent(currentIndex)
        while (currentIndex > 0 && heap[parentIndex] > heap[currentIndex]) {
            swap(currentIndex, parentIndex)
            currentIndex = parentIndex
            parentIndex = getIndexParent(currentIndex)
        }
    }


    private fun siftDown(index: Int) {
        var currentIndex = index
        while (hasLeftChild(currentIndex)) {
            var smallestIndex = getIndexLeftChild(currentIndex)
            if (hasRightChild(currentIndex) && heap[getIndexRightChild(currentIndex)] < heap[smallestIndex]) {
                smallestIndex = getIndexRightChild(currentIndex)
            }
            if (heap[currentIndex] < heap[smallestIndex]) break
            else swap(currentIndex, smallestIndex)
            currentIndex = smallestIndex
        }
    }

    private fun getIndexParent(index: Int) = (index - 1) / 2

    private fun getIndexLeftChild(index: Int) = (2 * index) + 1

    private fun getIndexRightChild(index: Int) = (2 * index) + 2

    private fun hasLeftChild(index: Int) = getIndexLeftChild(index) < heap.size

    private fun hasRightChild(index: Int) = getIndexRightChild(index) < heap.size


    private fun swap(from: Int, to: Int) {
        val temp = heap[from]
        heap[from] = heap[to]
        heap[to] = temp
    }


}