package com.leetcode_kotlin

/**
 * Executing
 */

fun main() {
    memoization(6).let {
        println(it)
    }
}


/**
 * 3190. Find Minimum Operations to Make All Elements Divisible by Three
 */

fun minimumOperations(nums: IntArray): Int {
    var res = 0

    for (n in nums) {
        if (n % 3 > 0) res++
    }

    return res
}


/**
 * 2011. Final Value of Variable After Performing Operations
 */


fun finalValueAfterOperations(opr: Array<String>): Int {
    var res = 0
    for (i in opr) {
        if (i.contains("-")) res -= 1
        else res += 1
    }
    return res
}

/**
 * 1512. Number of Good Pairs
 */

fun numIdenticalPairs(nums: IntArray): Int {
    val counts = mutableMapOf<Int, Int>()
    var ans = 0
    for (num in nums) {
        if (counts.contains(num)) ans += counts[num]!!
        counts[num] = (counts[num] ?: 0) + 1
    }
    return ans
}


/**
 * 217. Contains Duplicate
 */

fun containsDuplicate(nums: IntArray): Boolean {
    var count = 1
    val map = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
        if (map.contains(nums[i])) return true
        else {
            map.put(nums[i], 1)
        }
    }
    return false
}

/**
 * 268. Missing Number
 */


fun missingNumber(nums: IntArray): Int {
    val length = nums.size
    var sum = 0
    for (i in nums) {
        sum += i
    }
    return length * (length + 1) / 2 - sum
}

/**
 * 448. Find All Numbers Disappeared in an Array
 */

fun findDisappearedNumbers(nums: IntArray): List<Int> {
    val arr = mutableListOf<Int>()
    val set = mutableSetOf<Int>()
    for (i in nums) set.add(i)
    for (i in 1..nums.size) {
        if (!set.contains(i)) {
            arr.add(i)
        }
    }
    return arr
}

/**
 * 136. Single Number
 */

fun singleNumber(nums: IntArray): Int {
    var res = 0
    for (i in nums) res = res xor i
    return res
}

/**
 * 121. Best Time to Buy and Sell Stock
 */


fun maxProfit(prices: IntArray): Int {
    var profit = Int.MIN_VALUE
    var min = Int.MAX_VALUE
    for (i in prices.indices) {
        if (prices[i] < min) min = prices[i]
        if (prices[i] - min > profit) profit = prices[i] - min
    }
    return profit
}

/**
 * Selection Sort
 */

fun selectionSort(array: IntArray): IntArray {
    var min = Int.MAX_VALUE
    var ind = 0
    var temp = 0
    var j = 0
    while (j <= array.size - 1) {
        for (i in j until array.size) {
            if (array[i] < min) {
                min = array[i]
                ind = i
            }
        }
        temp = array[j]
        array[j] = min
        array[ind] = temp
        j++
        min = Int.MAX_VALUE
    }
    return array
}

/**
 *  Insertion Sort
 */

fun insertionSort(array: IntArray): IntArray {
    for (i in 1 until array.size) {
        var sorted = i - 1
        while (sorted > -1 && array[sorted] > array[sorted + 1]) {
            var temp = array[sorted]
            array[sorted] = array[sorted + 1]
            array[sorted + 1] = temp
            sorted--
        }
    }
    return array
}


/**
 * Fibonaci
 */


fun tabulation(param: Int): Int? {
    val cache: Array<Int?> = arrayOfNulls(param + 1)
    cache[0] = 0
    cache[1] = 1
    for (i in 2..param) {
        cache[i] = cache[i - 2]!! + cache[i - 1]!!
    }
    return cache[param]
}


fun memoization(param: Int): Int {
    val cache = IntArray(param + 1)
    return fib(param, cache)
}

fun fib(param: Int, array: IntArray): Int {
    if (param == 0) return 0
    if (param == 1) return 1
    if (array[param] == 0) {
        var a = fib(param - 2, array)
        var b = fib(param - 1, array)
        array[param] = a + b
    }
    return array[param]
}










