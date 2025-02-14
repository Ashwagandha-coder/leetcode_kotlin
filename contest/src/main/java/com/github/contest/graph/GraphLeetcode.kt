package com.github.contest.graph

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