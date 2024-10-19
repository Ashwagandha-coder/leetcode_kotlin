package com.leetcode_kotlin

class ProdVariant {

    companion object {
        val value = ProdVariant()
    }
}


/**
 * 123. Best Time to Buy and Sell Stock III
 */


fun ProdVariant.maxProfitIII(prices: IntArray): Int {
    var buy1 = Int.MAX_VALUE
    var buy2 = Int.MAX_VALUE
    var sell1 = Int.MIN_VALUE
    var sell2 = Int.MIN_VALUE
    prices.forEach {
        buy1 = minOf(buy1, it)
        sell1 = maxOf(sell1, it - buy1)
        buy2 = minOf(buy2, it - sell1)
        sell2 = maxOf(sell2, it - buy2)
    }
    return sell2
}

/**
 * 268. Missing Number
 */


fun ProdVariant.missingNumber(nums: IntArray): Int {
    var res = nums.size
    nums.forEachIndexed { index, i ->
        res += index
    }
    return res - nums.sum()
}



