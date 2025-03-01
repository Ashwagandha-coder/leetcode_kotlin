package com.github.contest.design

/**
 * 1352. Product of the Last K Numbers
 * Prod Variant
 */

class ProductOfNumbersProdVariant() {

    private val products = mutableListOf<Int>()

    fun add(num: Int) {
        if (num == 0) {
            products.clear()
        } else {
            if (products.isEmpty()) {
                products.add(num)
            } else {
                products.add(products.last() * num)
            }
        }
    }

    fun getProduct(k: Int): Int {
        if (k > products.size) {
            return 0
        }
        if (k == products.size) {
            return products.last()
        }
        return products.last() / products[products.size - k - 1]
    }
}