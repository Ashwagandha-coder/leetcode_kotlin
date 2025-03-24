package com.github.contest.sorting

/**
 * 3169. Count Days Without Meeting
 * Prod Variant
 */

fun countDaysProdVariant(days: Int, meetings: Array<IntArray>): Int =
    meetings.sortedBy { it[0] }.fold(0 to 0) { (freeDays, lastBusyDays), (start, end) ->
        if (start > days) return@fold Pair(freeDays, lastBusyDays)

        val actualStart = maxOf(1, start)
        val actualEnd = minOf(days, end)

        val newFreeDays = freeDays + actualStart - lastBusyDays - 1
        Pair(newFreeDays, maxOf(lastBusyDays, actualEnd))
    }.let { (freeEnd, lastDays) ->
        freeEnd + days - lastDays
    }



