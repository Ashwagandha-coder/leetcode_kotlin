package com.github.contest

fun testLongestDecrease() {
    val case1 = TestData(emptyList(), 2, 2) // -> null
    val case2 = TestData(listOf(10, 20, 30), 4, 3) // -> null
    val case3 = TestData(listOf(10, 9, 8, 7, 6, 5), 2, 1) // -> (0,5)
    val case4 = TestData(listOf(11, 10, 9, 10, 8, 6, 4), 2, 2) // -> (3,6)
    val case5 = TestData(listOf(-1, -2, -3, -4), 1, 1) // -> (0,3)

    listOf(case1, case2, case3, case4, case5).forEach { (degrees, k, delta) ->
        longestDecreasingTempPeriod(degrees, k, delta).also {
            println(it)
        }
    }
}

private data class TestData(val degrees: List<Int>, val k: Int, val delta: Int)


fun longestDecreasingTempPeriod(degrees: List<Int>, k: Int, delta: Int): Pair<Int, Int>? {
    if (degrees.isEmpty() || k > degrees.size) return null

    var left = 0
    var right = 0
    var bound = 0
    var prevIndex = 0

    for (i in 1 until degrees.size) {
        val curr = degrees[i]
        val prevValue = degrees[prevIndex]

        if (curr + delta <= prevValue) {

            if (i - bound + 1 > k) {

                if (left == right || (right - left + 1 < i - bound + 1)) {
                    left = bound
                    right = i
                }

            }
        } else bound = i

        prevIndex++
    }

    return if (left == right) null else left to right
}