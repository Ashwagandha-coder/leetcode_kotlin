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

/**
 * 981. Time Based Key-Value Store
 * Prod Variant
 */

class TimeMapProdVariant {

    private val store = mutableMapOf<String, MutableList<Pair<Int, String>>>()

    fun set(key: String, value: String, timestamp: Int) {
        store.getOrPut(key) { mutableListOf(Pair(timestamp, value)) }.also {
            it.add(Pair(timestamp, value))
        }
    }

    fun get(key: String, timestamp: Int): String = when {
        store[key] == null -> ""
        else -> getFromList(store.getOrDefault(key, listOf()), timestamp)
    }

    private fun getFromList(list: List<Pair<Int, String>>, timestamp: Int): String =
        list.binarySearch {
            when {
                it.first == timestamp -> 0
                it.first < timestamp -> -1
                else -> 1
            }
        }.let { index ->
            when {
                index >= 0 -> list[index].second
                else -> {
                    val insertionPoint = -index - 1
                    if (insertionPoint == 0) "" else list[insertionPoint - 1].second
                }
            }
        }

}