package com.leetcode_kotlin


class ProdVariant {

    companion object {
        val value = ProdVariant()
    }
}

/**
 * 121. Best Time to Buy and Sell Stock
 * Prod Variant
 */

fun maxProfitIProdVariant(nums: IntArray): Int {
    var maxProfit = Int.MIN_VALUE
    var minPrice = Int.MAX_VALUE
    nums.forEach { price ->
        minPrice = minOf(minPrice, price)
        maxProfit = maxOf(maxProfit, price - minPrice)
    }
    return maxProfit
}


fun maxProfitIProdVariantWithFold(prices: IntArray): Int {
    return prices.fold(Pair(Int.MAX_VALUE, 0)) { (minPrice, maxProfit), price ->
        val currentMinPrice = minOf(minPrice, price)
        val currentMaxProfit = maxOf(maxProfit, price - minPrice)
        Pair(currentMinPrice, currentMaxProfit)
    }.second
}


/**
 * 123. Best Time to Buy and Sell Stock III
 * Prod Variant
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
 * Prod Variant
 */


fun ProdVariant.missingNumber(nums: IntArray): Int {
    var res = nums.size
    nums.forEachIndexed { index, _ ->
        res += index
    }
    return res - nums.sum()
}

/**
 * 188.Best Time to Buy and Sell Stock IV
 * Prod Variant
 */


fun maxProfitIV(prices: IntArray, k: Int): Int {
    val n = prices.size
    if (n == 0 || k == 0) {
        return 0
    }

    // Если k достаточно большое, используемупрощенный подход
    if (k >= n / 2) {
        return prices.asSequence().zipWithNext() // Соединяем элементы последовательно
            .filter { (prev, curr) -> curr > prev } // Фильтруем пары, где текущий элемент больше предыдущего
            .sumOf { (prev, curr) -> curr - prev } // Суммируем разницы
    }

    // Функциональный DP с использованием fold
    return (1..k).fold(Pair(IntArray(n) { Int.MIN_VALUE }, IntArray(n) { 0 })) { (buy, sell), i ->
        val newBuy = prices.indices.drop(1).map { j ->
            maxOf(buy[j - 1], sell[j - 1] - prices[j - 1])
        }.toIntArray()

        val newSell = prices.indices.drop(1).map { j ->
            maxOf(sell[j - 1], newBuy[j - 1] + prices[j - 1])
        }.toIntArray()

        Pair(newBuy, newSell)
    }.second.last() // Возвращаем последний элемент массива sell
}

/**
 * 122. Best Time to Buy and Sell Stock II
 * Prod Variant
 */

fun maxProfitIIProdVariant(prices: IntArray): Int = prices
    .asSequence()
    .zipWithNext()
    .filter { (prev, curr) -> curr > prev }
    .sumOf { (prev, curr) -> curr - prev }


/**
 * 100.Same Tree
 * Prod Variant
 */

fun isSameTreeProdVariant(p: TreeNode?, q: TreeNode?): Boolean {
    return when {
        p == null && q == null -> true
        p == null || q == null -> false
        p.`val` != q.`val` -> false
        else -> isSameTreeProdVariant(p.left, q.left) && isSameTreeProdVariant(p.right, q.right)
    }
}

/**
 * 2415.Reverse Odd Level of al Binary Tree
 * Prod Variant
 */

fun reverseOddLevelBinaryTree(root: TreeNode?): TreeNode? {
    dfsProdVariant(root?.left, root?.right, 1)
    return root
}

fun dfsProdVariant(left: TreeNode?, right: TreeNode?, level: Int) {
    when {
        left == null && right == null -> return
        level % 2 != 0 -> {
            val temp = left?.`val`
            left?.`val` = right?.`val`!!
            right?.`val` = temp!!
        }

        else -> {
            dfsProdVariant(left?.left, right?.right, level + 1)
            dfsProdVariant(left?.right, right?.left, level + 1)
        }

    }
}

/**
 * 322. Coin Change
 * Prod Variant
 */

fun coinChangeProdVariant(coins: IntArray, amount: Int): Int {
    val dp = IntArray(amount + 1) { Int.MAX_VALUE }.apply {
        this[0] = 0
    }

    coins.forEach { coin ->
        (coin..amount).forEach { i ->
            if (dp[i - coin] != Int.MAX_VALUE) {
                dp[i] = minOf(dp[i], 1 + dp[i - coin])
            }
        }
    }
    return dp[amount].takeIf { it != Int.MAX_VALUE } ?: -1
}