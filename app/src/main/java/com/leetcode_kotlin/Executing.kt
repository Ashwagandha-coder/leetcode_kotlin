package com.leetcode_kotlin

/**
 * Executing
 */

fun main() {

    MyArrays.also {
        val arr = intArrayOf(1, 5, 9, 1, 5, 9)
        it.containsDuplicateIndexDiffValueDiffData().let { el ->
            val indexDiff = el.first
            val valueDiff = el.second

            containsNearbyAlmostDuplicate(arr, indexDiff, valueDiff).apply {
                println(this)
            }
        }
    }


}