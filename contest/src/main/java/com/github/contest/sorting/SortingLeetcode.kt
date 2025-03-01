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


