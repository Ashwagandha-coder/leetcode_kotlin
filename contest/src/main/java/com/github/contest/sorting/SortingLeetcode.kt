package com.github.contest.sorting

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


