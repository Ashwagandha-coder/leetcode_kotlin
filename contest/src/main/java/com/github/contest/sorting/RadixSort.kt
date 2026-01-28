package com.github.contest.sorting


/**
 * Base Implementation of Sort
 * LSD (Least significant digit)
 */

fun radixSort(arr: IntArray) {
    // Find maximum number to know number of digits
    val max = arr.max()

    // Do counting sort for every digit
    // exp = 1 (units), 10 (tens), 100 (hundreds), ...
    var exp = 1
    while (max / exp > 0) {
        countingSortByDigit(arr, exp)
        exp *= 10
    }
}

fun countingSortByDigit(arr: IntArray, exp: Int) {
    val output = IntArray(arr.size)
    val count = IntArray(10)  // 10 possible digits (0-9)

    // 1. Count occurrences of each digit
    for (i in arr.indices) {
        val digit = (arr[i] / exp) % 10
        count[digit]++
    }

    // 2. Convert count to cumulative positions
    for (i in 1..9) {
        count[i] += count[i - 1]
    }

    // 3. Build output array (backward for stability)
    for (i in arr.size - 1 downTo 0) {
        val digit = (arr[i] / exp) % 10
        output[count[digit] - 1] = arr[i]
        count[digit]--
    }

    // 4. Copy output back to original array
    for (i in arr.indices) {
        arr[i] = output[i]
    }
}