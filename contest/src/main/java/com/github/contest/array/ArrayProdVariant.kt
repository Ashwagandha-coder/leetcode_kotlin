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


fun applyOperationsProdVariantII(nums: IntArray): IntArray {
    nums.indices.drop(1).forEach { i ->
        if (nums[i - 1] == nums[i]) {
            nums[i - 1] *= 2
            nums[i] = 0
        }
    }

    var insertPos = 0
    nums.forEach { num ->
        if (num != 0) {
            nums[insertPos++] = num
        }
    }
    nums.fill(0, insertPos)

    return nums
}

/**
 * 1920. Build Array from Permutation
 */

fun buildArrayProdVariant(nums: IntArray): IntArray {
    nums.forEachIndexed { index, _ ->
        val new = nums[nums[index]] % nums.size
        val prev = nums[index]
        nums[index] = (new * nums.size) + prev
    }
    nums.forEachIndexed { index, _ ->
        nums[index] /= nums.size
    }

    return nums
}

/**
 * 56. Merge Intervals
 * Prod Variant
 */

fun mergeProdVariantStage(intervals: Array<IntArray>): Array<IntArray> {
    if (intervals.size == 1) return intervals

    intervals.sortBy { it[0] }
    val merged = mutableListOf<IntArray>()
    var current = intervals[0]

    intervals.drop(1).forEach {
        if (current[1] in it[0]..it[1]) current[1] = maxOf(current[1], it[1])
        else {
            merged.add(current)
            current = it
        }
    }

    return merged.toTypedArray()
}

fun mergeProdVariantII(intervals: Array<IntArray>): Array<IntArray> =
    intervals.sortedBy { it[0] }.fold(mutableListOf<IntArray>()) { merged, interval ->
        merged.lastOrNull()?.takeIf { it[1] >= interval[0] }?.let {
            it[1] = maxOf(it[1], interval[1])
        } ?: merged.add(interval)
        merged
    }.toTypedArray()

/**
 * 1550. Three Consecutive Odds
 * Prod Variants
 */

fun threeConsecutiveOddsProdVariantI(arr: IntArray): Boolean =
    arr.toList()
        .windowed(3)
        .filter {
            val one = it[0]
            val two = it[1]
            val three = it[2]
            isOdd(one) && isOdd(two) && isOdd(three)
        }.isNotEmpty()

fun threeConsecutiveOddsProdVariantII(arr: IntArray): Boolean =
    arr.toList()
        .windowed(3)
        .any { isOdd(it.first()) && isOdd(it.middle()) && isOdd(it.last()) }

private fun List<Int>.middle(): Int = this[this.size / 2]

fun threeConsecutiveOddsProdVariantIII(arr: IntArray): Boolean =
    arr.toList()
        .windowed(3)
        .any { window -> window.all { it % 2 != 0 } }


/**
 * 73. Set Matrix Zeroes
 * Prod Variant
 */

fun setZeroesProdVariant(matrix: Array<IntArray>): Unit {
    val rowIndexed = BooleanArray(matrix.size)
    val columnIndexed = BooleanArray(matrix[0].size)

    matrix.forEachIndexed { indexRow, row ->
        row.forEachIndexed { indexCol, _ ->
            if (row[indexCol] == 0) {
                rowIndexed[indexRow] = true
                columnIndexed[indexCol] = true
            }
        }
    }

    matrix.forEachIndexed { index, row ->
        row.forEachIndexed { indexCol, _ ->
            if (rowIndexed[index] || columnIndexed[indexCol]) matrix[index][indexCol] = 0
        }
    }

}

/**
 * 2016. Maximum Difference Between Increasing Elements
 * Prod Variant
 */

fun maximumDifferenceProdVariant(nums: IntArray): Int {
    var minVal = Int.MAX_VALUE
    return nums.maxOf {
        when {
            it < minVal -> {
                minVal = minOf(minVal, it)
                0
            }

            else -> if (it > minVal) it - minVal else 0
        }
    }
}