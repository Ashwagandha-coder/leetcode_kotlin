package com.github.contest

import com.github.contest.array.printArray


/**
 * Stand
 */

fun main() {

    val baseNums = arrayOf(
        "102", "473", "251", "814"
    )

    val baseQueries = arrayOf(
        intArrayOf(1, 1),
        intArrayOf(2, 3),
        intArrayOf(4, 2),
        intArrayOf(1, 2)
    )

    testMySolution(baseNums, baseQueries).printArray()


}


fun smallestTrimmedNumbersTrieApproach(nums: Array<String>, queries: Array<IntArray>): IntArray {
    val maxLength = nums.maxOf { it.length }
    val result = IntArray(queries.size)

    // Build tries for each possible trim length
    val tries = Array(maxLength + 1) { Trie() }

    // Insert each number into all possible trim lengths
    for ((idx, num) in nums.withIndex()) {
        // For each possible trim length (1 to num.length)
        for (trim in 1..num.length) {
            val trimmed = num.takeLast(trim)
            tries[trim].insert(trimmed, idx)
        }
    }

    // Answer queries
    for ((i, query) in queries.withIndex()) {
        val k = query[0]
        val trim = query[1]
        result[i] = tries[trim].findKth(k)
    }

    return result
}

class TrieNode {
    val children = Array<TrieNode?>(10) { null }
    var count = 0
    val indices = mutableListOf<Int>()
}

class Trie {
    private val root = TrieNode()

    fun insert(num: String, originalIndex: Int) {
        var node = root
        node.count++

        for (char in num) {
            val digit = char - '0'
            if (node.children[digit] == null) {
                node.children[digit] = TrieNode()
            }
            node = node.children[digit]!!
            node.count++
        }

        node.indices.add(originalIndex)
    }

    fun findKth(k: Int): Int {
        var node = root
        var remainingK = k

        // Navigate to find k-th smallest
        while (node.indices.isEmpty()) {  // Not at leaf yet
            var total = 0
            for (digit in 0..9) {
                val child = node.children[digit]
                if (child != null) {
                    if (total + child.count >= remainingK) {
                        node = child
                        remainingK -= total
                        break
                    }
                    total += child.count
                }
            }
        }

        // At leaf node, return k-th index
        return node.indices.sorted()[remainingK - 1]
    }
}








