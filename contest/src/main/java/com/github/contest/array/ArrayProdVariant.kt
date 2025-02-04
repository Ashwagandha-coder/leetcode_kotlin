package com.github.contest.array

/**
 * 2540. Minimum Common Value
 * Prod Variant
 */

fun getCommonProdVariant(nums1: IntArray, nums2: IntArray): Int {
    return nums1.asSequence()
        .map { num1 ->
            nums2.asSequence()
                .filter { num2 -> num2 == num1 }
                .firstOrNull()
        }
        .filterNotNull()
        .firstOrNull() ?: -1
}