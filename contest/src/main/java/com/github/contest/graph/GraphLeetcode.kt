package com.github.contest.graph

import java.util.LinkedList

/**
 * 997. Find the Town Judge
 */

fun findJudge(n: Int, trust: Array<IntArray>): Int {
    if (trust.isEmpty() && n == 1) return 1
    val inEdges = IntArray(n + 1)
    for (person in trust) {
        inEdges[person[0]]--
        inEdges[person[1]]++
    }

    for (person in inEdges.indices) {
        if (inEdges[person] == n - 1) return person
    }
    return -1
}

/**
 * 1971. Find if Path Exists in Graph
 */

fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
    if (source == destination) return true
    val adj = Array(n) { mutableListOf<Int>() }

    for (edge in edges) {
        adj[edge[0]].add(edge[1])
        adj[edge[1]].add(edge[0])
    }
    val visited = BooleanArray(n) { false }
    val queue = LinkedList<Int>()
    queue.offer(source)
    visited[source] = true

    while (queue.isNotEmpty()) {
        val vertex = queue.poll()
        if (vertex == destination) return true

        for (v in adj[vertex]) {
            if (!visited[v]) {
                visited[v] = true
                queue.offer(v)
            }
        }
    }

    return false
}

/**
 * 1791. Find Center of Star Graph
 */

fun findCenter(edges: Array<IntArray>): Int {
    val (a, b) = edges[0]
    val (c, d) = edges[1]

    return when {
        a == c || a == d -> a
        else -> b
    }
}