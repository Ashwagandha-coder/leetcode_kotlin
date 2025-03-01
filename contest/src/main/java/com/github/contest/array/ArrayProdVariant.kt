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


/**
 * 2460. Apply Operations to an Array
 * Prod Variant
 */

fun applyOperationsProdVariant(nums: IntArray): IntArray {
    (0 until nums.size - 1).forEach { index ->
        if (nums[index] == nums[index + 1]) {
            nums[index] *= 2
            nums[index + 1] = 0
        }
    }

    var insertIndex = 0
    nums.indices.forEach {
        if (it != 0) {
            nums[insertIndex] = it
            insertIndex++
        }
    }

    (insertIndex until nums.size).forEach {
        nums[it] = 0
    }

    return nums
}