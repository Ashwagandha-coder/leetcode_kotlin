package com.github.contest

import java.util.PriorityQueue



fun minOperations(nums: IntArray): Int {
    val n = nums.size
    if (n <= 1) return 0

    // We'll use a doubly linked list to represent the array
    // This allows O(1) removal of elements after merging
    class Node(
        val originalIndex: Int,  // Original index for tie-breaking
        var value: Int,
        var prev: Node? = null,
        var next: Node? = null
    )

    // Create nodes from the array
    val nodes = Array<Node?>(n) { null }
    for (i in nums.indices) {
        nodes[i] = Node(i, nums[i])
    }

    // Link nodes together
    for (i in 0 until n - 1) {
        nodes[i]!!.next = nodes[i + 1]
        nodes[i + 1]!!.prev = nodes[i]
    }

    val head = nodes[0]!!

    // Priority queue to store (sum, leftIndex, leftNode)
    // Priority: first by sum (ascending), then by leftIndex (ascending for leftmost tie)
    val minHeap = PriorityQueue<Triple<Int, Int, Node>> { a, b ->
        if (a.first != b.first) {
            a.first - b.first  // Compare by sum
        } else {
            a.second - b.second  // Compare by leftIndex for tie-breaking
        }
    }

    // Initialize the heap with all adjacent pairs
    var currentNode: Node? = head
    while (currentNode != null && currentNode.next != null) {
        val sum = currentNode.value + currentNode.next!!.value
        minHeap.add(Triple(sum, currentNode.originalIndex, currentNode))
        currentNode = currentNode.next
    }

    // Track which original indices have been removed
    val removed = BooleanArray(n) { false }
    var operations = 0

    // Helper function to check if the current linked list is non-decreasing
    fun isNonDecreasing(): Boolean {
        var node: Node? = head
        while (node != null && node.next != null) {
            // Since we can't smart cast, we need to use safe calls and null checks
            val nextNode = node.next
            if (nextNode != null && node.value > nextNode.value) {
                return false
            }
            node = nextNode
        }
        return true
    }

    // Process until the array is non-decreasing
    while (!isNonDecreasing() && minHeap.isNotEmpty()) {
        // Get the pair with minimum sum (leftmost in case of tie)
        val (sum, leftOriginalIndex, leftNode) = minHeap.poll()

        // Skip if this entry is stale (nodes were modified or removed)
        // Check 1: Has left node been removed?
        if (removed[leftOriginalIndex]) {
            continue
        }

        // Check 2: Does left node still have a right neighbor?
        val rightNode = leftNode.next
        if (rightNode == null) {
            continue
        }

        // Check 3: Has right node been removed?
        if (removed[rightNode.originalIndex]) {
            continue
        }

        // Check 4: Is the sum still correct? (values might have changed from previous merges)
        if (leftNode.value + rightNode.value != sum) {
            continue
        }

        // At this point, we have a valid pair to merge
        // Merge leftNode and rightNode into leftNode
        leftNode.value = sum  // Replace left node's value with the sum
        removed[rightNode.originalIndex] = true  // Mark right node as removed
        operations++

        // Update the linked list connections
        leftNode.next = rightNode.next
        if (rightNode.next != null) {
            rightNode.next!!.prev = leftNode
        }

        // Now we need to update the heap with new pairs
        // 1. Pair with left neighbor (if exists and not removed)
        val leftNeighbor = leftNode.prev
        if (leftNeighbor != null && !removed[leftNeighbor.originalIndex]) {
            val newSum = leftNeighbor.value + leftNode.value
            minHeap.add(Triple(newSum, leftNeighbor.originalIndex, leftNeighbor))
        }

        // 2. Pair with right neighbor (if exists and not removed)
        val newRightNeighbor = leftNode.next
        if (newRightNeighbor != null && !removed[newRightNeighbor.originalIndex]) {
            val newSum = leftNode.value + newRightNeighbor.value
            minHeap.add(Triple(newSum, leftNode.originalIndex, leftNode))
        }
    }

    return operations
}


fun minBitwiseArray(nums: IntArray): IntArray {
    val answer = IntArray(nums.size)

    for (i in nums.indices) {
        val n = nums[i]
        var minAns = -1

        // Check each bit position k
        for (k in 0 until 31) { // 31 bits for positive int
            val bitK = 1 shl k  // 2^k
            val res = n and bitK
            // Check if bit k is set in n
            if (res != 0) {
                // Create mask for bits 0..k-1
                val lowerMask = bitK - 1

                // Check if all bits 0..k-1 are 1
                if ((n and lowerMask) == lowerMask) {
                    // Valid: x = n - 2^k
                    val candidate = n - bitK

                    // Take the smallest
                    if (minAns == -1 || candidate < minAns) {
                        minAns = candidate
                    }
                }
            }
        }

        answer[i] = minAns
    }

    return answer
}