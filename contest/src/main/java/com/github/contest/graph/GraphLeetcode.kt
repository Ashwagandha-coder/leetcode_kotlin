package com.github.contest.graph

import java.util.Arrays
import java.util.LinkedList
import kotlin.math.max


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

/**
 * 2467. Most Profitable Path in a Tree
 */


fun mostProfitablePath(edges: Array<IntArray>, bob: Int, amount: IntArray): Int {
    val graph = Array(amount.size) { mutableListOf<Int>() }
    for (edge in edges) {
        graph[edge[0]].add(edge[1])
        graph[edge[1]].add(edge[0])
    }

    val bobPath = IntArray(amount.size)
    Arrays.fill(bobPath, -1)
    val path = ArrayList<Int>()
    fillBobPath(bob, -1, path, graph)

    for (i in path.indices) {
        bobPath[path[i]] = i
    }

    return getAliceMaxScore(0, -1, 0, bobPath, graph, 0, amount)
}

private fun fillBobPath(
    node: Int,
    parentNode: Int,
    path: ArrayList<Int>,
    graph: Array<MutableList<Int>>
): Boolean {
    if (node == 0) return true
    for (neighborNode in graph[node]) {
        if (neighborNode != parentNode) {
            path.add(node)
            if (fillBobPath(neighborNode, node, path, graph)) return true
            path.removeAt(path.size - 1)
        }
    }
    return false
}

private fun getAliceMaxScore(
    node: Int,
    parentNode: Int,
    currScore: Int,
    bobPath: IntArray,
    graph: Array<MutableList<Int>>,
    timestamp: Int,
    amount: IntArray
): Int {
    var currScore = currScore
    if (bobPath[node] == -1 || bobPath[node] > timestamp) {
        currScore += amount[node]
    } else if (bobPath[node] == timestamp) {
        currScore += amount[node] / 2
    }
    if (graph[node].size == 1 && node != 0) return currScore
    var maxScore = Int.MIN_VALUE
    for (neighborNode in graph[node]) {
        if (neighborNode != parentNode) {
            maxScore = max(
                maxScore.toDouble(),
                getAliceMaxScore(
                    neighborNode,
                    node,
                    currScore,
                    bobPath,
                    graph,
                    timestamp + 1,
                    amount
                ).toDouble()
            )
                .toInt()
        }
    }
    return maxScore
}



