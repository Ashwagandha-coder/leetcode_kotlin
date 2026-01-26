package com.github.contest.sorting

import java.util.PriorityQueue
import kotlin.math.abs
import kotlin.random.Random

/**
 * The BogoSort
 */

class BogoSort {
    fun bogoSort(list: MutableList<Int>) {
        while (!isSorted(list)) {
            shuffle(list)
        }
    }

    private fun isSorted(list: List<Int>): Boolean {
        for (i in 0 until list.size - 1) {
            if (list[i] > list[i + 1]) {
                return false
            }
        }
        return true
    }

    private fun shuffle(list: MutableList<Int>) {
        for (i in list.indices) {
            val j = Random.nextInt(list.size)
            list.swap(i, j)
        }
    }

    private fun MutableList<Int>.swap(from: Int, to: Int) {
        val temp = this[from]
        this[from] = this[to]
        this[to] = temp
    }
}


/**
 * 3169. Count Days Without Meetings
 */

fun countDays(days: Int, meetings: Array<IntArray>): Int {
    if (days <= 0) return 0

    val sortedMeetings = meetings.sortedBy { it[0] }
    var freeDays = 0
    var lastBusyDay = 0

    for (meeting in sortedMeetings) {
        val start = meeting[0]
        val end = meeting[1]

        if (start > days) break

        val actualStart = maxOf(1, start)
        val actualEnd = minOf(days, end)

        if (actualStart > lastBusyDay) {
            freeDays += actualStart - lastBusyDay - 1
        }
        lastBusyDay = maxOf(lastBusyDay, actualEnd)
    }
    freeDays += days - lastBusyDay

    return freeDays
}

/**
 * 1200. Minimum Absolute Difference
 * Priority Queue + Sorting
 */

fun minimumAbsDifference(arr: IntArray): List<List<Int>> {
    if (arr.size == 2) return listOf(listOf(arr.min(), arr.max()))

    arr.sort()
    val pq = PriorityQueue { a: Pair<Int, Pair<Int, Int>>, b: Pair<Int, Pair<Int, Int>> ->
        if (a.first != b.first) a.first - b.first
        else a.second.first - b.second.first
    }
    val result = mutableListOf<List<Int>>()

    for (i in 1 until arr.size) {
        val diff = abs(arr[i] - arr[i - 1])
        pq.offer(Pair(diff, Pair(arr[i - 1], arr[i])))
    }

    val minDiff = pq.first().first

    while (pq.isNotEmpty()) {
        val (diff, pair) = pq.poll()
        if (diff != minDiff) break
        result.add(listOf(pair.first, pair.second))
    }

    return result

}


