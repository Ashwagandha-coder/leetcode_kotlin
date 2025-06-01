package com.github.contest.design

/**
 * 341. Flatten Nested List Iterator
 * Alternative Solution
 */

class NestedIteratorAlternativeSolution(nestedList: List<NestedInteger>) {

    private val stack = ArrayDeque<NestedInteger>().apply {
        nestedList.reversed().forEach { addFirst(it) }
    }

    fun next(): Int {
        if (!hasNext()) throw NoSuchElementException()
        return stack.removeFirst().getInteger()!!
    }

    fun hasNext(): Boolean {
        while (stack.isNotEmpty()) {
            val top = stack.first()
            if (top.isInteger()) {
                return true
            }
            stack.removeFirst().getList()?.reversed()?.forEach { stack.addFirst(it) }
        }
        return false
    }
}