package com.github.contest.array

/**
 * 2540. Minimum Common Value
 * Alternative Solution
 * Time - O(n)
 * Space - O(1)
 */

fun getCommonAlternativeSolution(nums1: IntArray, nums2: IntArray): Int {
    var p1 = 0
    var p2 = 0

    while (p1 < nums1.size && p2 < nums2.size) {
        when {
            nums1[p1] == nums2[p2] -> return nums1[p1]
            nums1[p1] < nums2[p2] -> p1++
            else -> p2++
        }
    }

    return -1
}

/**
 * 922. Sort Array By Parity II
 * Alternative Solution
 */

fun sortArrayByParityIIAlternativeSolution(nums: IntArray): IntArray {
    var evenIndex = 0
    var oddIndex = 1
    while (evenIndex < nums.size && oddIndex < nums.size) {
        while (evenIndex < nums.size && nums[evenIndex] % 2 == 0) evenIndex += 2
        while (oddIndex < nums.size && nums[oddIndex] % 2 != 0) oddIndex += 2
        if (evenIndex < nums.size && oddIndex < nums.size) {
            nums[evenIndex] = nums[oddIndex].also { nums[oddIndex] = nums[evenIndex] }
        }
    }

    return nums
}

/**
 * 2460. Apply Operations to an Array
 * Alternative Solution
 */

fun applyOperationsAlternativeSolution(nums: IntArray): IntArray {
    for (i in 0 until nums.size - 1) {
        if (nums[i] == nums[i + 1]) {
            nums[i] *= 2
            nums[i + 1] = 0
        }
    }

    var insertPosition = 0
    for (i in nums.indices) {
        if (nums[i] != 0) {
            nums[insertPosition] = nums[i]
            insertPosition++
        }
    }

    while (insertPosition < nums.size) {
        nums[insertPosition] = 0
        insertPosition++
    }

    return nums

}

/**
 * 2570. Merge Two 2D Arrays by Summing Values
 * Alternative Solution
 */

fun mergeArraysAlternativeSolution(
    nums1: Array<IntArray>, nums2: Array<IntArray>
): Array<IntArray> {
    val result = mutableListOf<IntArray>()
    var i = 0
    var j = 0

    while (i < nums1.size || j < nums2.size) {
        when {
            i == nums1.size -> {
                result.add(nums2[j])
                j++
            }

            j == nums2.size -> {
                result.add(nums1[i])
                i++
            }

            nums1[i][0] == nums2[j][0] -> {
                result.add(intArrayOf(nums1[i][0], nums1[i][1] + nums2[j][1]))
                i++
                j++
            }

            nums1[i][0] < nums2[j][0] -> {
                result.add(nums1[i])
                i++
            }

            else -> {
                result.add(nums2[j])
                j++
            }
        }
    }

    return result.toTypedArray()
}

/**
 * 2161. Partition Array According to Given Pivot
 * Alternative Solution
 */


fun pivotArrayAlternativeSolution(nums: IntArray, pivot: Int): IntArray {
    val n = nums.size
    val result = IntArray(n)
    var lessIndex = 0
    var greaterIndex = n - 1
    var equalCount = 0

    for (num in nums) {
        when {
            num < pivot -> {
                result[lessIndex] = num
                lessIndex++
            }

            num > pivot -> {
                result[greaterIndex] = num
                greaterIndex--
            }

            else -> equalCount++
        }
    }

    while (equalCount > 0) {
        result[lessIndex] = pivot
        lessIndex++
        equalCount--
    }


    var start = lessIndex
    var end = n - 1
    while (start < end) {
        val temp = result[start]
        result[start] = result[end]
        result[end] = temp
        start++
        end--
    }

    return result
}


/**
 * 73. Set Matrix Zeroes
 * Alternative Solution
 */

fun setZeroesAltSolution(matrix: Array<IntArray>) {
    val m = matrix.size
    val n = matrix[0].size
    var firstRowZero = false
    var firstColZero = false


    for (i in 0 until m) {
        for (j in 0 until n) {
            if (matrix[i][j] == 0) {
                if (i == 0) firstRowZero = true
                if (j == 0) firstColZero = true
                matrix[i][0] = 0
                matrix[0][j] = 0
            }
        }
    }


    for (i in 1 until m) {
        for (j in 1 until n) {
            if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                matrix[i][j] = 0
            }
        }
    }


    if (firstRowZero) {
        for (j in 0 until n) {
            matrix[0][j] = 0
        }
    }
    if (firstColZero) {
        for (i in 0 until m) {
            matrix[i][0] = 0
        }
    }
}

/**
 * 2016. Maximum Difference Between Increasing Elements
 * Alternative Solution
 */

fun maximumDifferenceAlternativeSolution(nums: IntArray): Int {
    var diff = -1
    var minVal = Int.MAX_VALUE

    for (i in nums.indices) {
        when {
            nums[i] < minVal -> minVal = minOf(minVal, nums[i])
            else -> if (nums[i] > minVal) diff = maxOf(diff, nums[i] - minVal) else continue
        }
    }

    return diff
}


