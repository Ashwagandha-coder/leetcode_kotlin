package com.github.contest.array

/**
 * 2540. Minimum Common Value
 * Prod Variant
 * Could down with TLE
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

/**
 * 3151. Special Array I
 * Prod Variant
 */

fun isArraySpecialProdVariant(nums: IntArray): Boolean =
    nums.isEmpty() || nums.toList().windowed(2).all { (a, b) -> a % 2 != b % 2 }
