package com.github.contest.design

/**
 * 1352. Product of the Last K Numbers
 */

class ProductOfNumbers() {

    private val numbers = mutableListOf<Int>()

    fun add(num: Int) {
        numbers.add(num)
    }

    fun getProduct(k: Int): Int {
        return when {
            k == 1 -> numbers.last()
            else -> calculateProduct(k)
        }
    }

    private fun calculateProduct(k: Int): Int {
        var res = 1
        var k = k
        while (k != 0) {
            res *= numbers[numbers.size - k]
            k--
        }
        return res
    }

}

/**
 * 211. Design Add and Search Words Data Structure
 */

class WordDictionary() {

    data class TrieNode(
        val children: MutableMap<Char, TrieNode> = mutableMapOf(),
        var isEndOfWord: Boolean = false
    )

    private val root = TrieNode()

    fun addWord(word: String) {
        var current = root
        for (char in word) {
            current = current.children.getOrPut(char) { TrieNode() }
        }
        current.isEndOfWord = true
    }

    fun search(word: String): Boolean {
        return searchInNode(word, 0, root)
    }

    private fun searchInNode(word: String, index: Int, node: TrieNode): Boolean {
        if (index == word.length) {
            return node.isEndOfWord
        }

        val char = word[index]
        if (char == '.') {
            for (child in node.children.values) {
                if (searchInNode(word, index + 1, child)) {
                    return true
                }
            }
            return false
        } else {
            val child = node.children[char]
            return child?.let { searchInNode(word, index + 1, it) } ?: false
        }
    }

}

/**
 * 208. Implement Trie (Prefix Tree)
 */

class Trie() {

    class TrieNode {
        val children = mutableMapOf<Char, TrieNode>()
        var isEndOfWord = false
    }

    private val root = TrieNode()

    fun insert(word: String) {
        var curr = root
        for (char in word) {
            curr = curr.children.getOrPut(char) { TrieNode() }
        }
        curr.isEndOfWord = true
    }

    fun search(word: String): Boolean {
        val res = find(word)
        return when {
            res != null && res.isEndOfWord -> true
            else -> false
        }
    }

    fun startsWith(prefix: String): Boolean = find(prefix) != null

    private fun find(word: String): TrieNode? {
        var curr = root
        for (char in word) {
            curr = curr.children[char] ?: return null
        }

        return curr
    }

}

/**
 * 981. Time Based Key-Value Store
 */

class TimeMap() {

    private val store = mutableMapOf<String, MutableList<Pair<Int, String>>>()

    fun set(key: String, value: String, timestamp: Int) {
        store.getOrPut(key) { mutableListOf(Pair(timestamp, value)) }.add(Pair(timestamp, value))
    }

    fun get(key: String, timestamp: Int): String {
        val list = store[key] ?: return emptyString()
        var left = 0
        var right = list.size - 1
        var res = emptyString()

        while (left <= right) {
            val mid = (left + right) / 2
            val (currentTimeStamp, currentValue) = list[mid]
            if (currentTimeStamp == timestamp) return currentValue
            if (currentTimeStamp < timestamp) {
                left = mid + 1
                res = currentValue
            } else right = mid
        }

        return res
    }

    private fun emptyString() = ""

}

/**
 * 380. Insert Delete GetRandom O(1)
 */

class RandomizedSet() {

    private val store = mutableMapOf<Int, Int>()

    fun insert(`val`: Int): Boolean = when {
        store.contains(`val`) -> false
        else -> {
            store[`val`] = store.getOrDefault(`val`, 0) + 1
            true
        }
    }

    fun remove(`val`: Int): Boolean = when {
        !store.contains(`val`) -> false
        else -> {
            store.remove(`val`)
            true
        }
    }

    fun getRandom(): Int = store.keys.random()

}

/**
 * 284. Peeking Iterator
 */

class PeekingIterator(iterator: Iterator<Int>) : Iterator<Int> {

    private val store = mutableListOf<Int>()

    init {
        while (iterator.hasNext()) store.add(iterator.next())
    }

    fun peek(): Int {
        return store.first()
    }

    override fun next(): Int {
        return store.removeFirst()
    }

    override fun hasNext(): Boolean {
        return store.isNotEmpty()
    }
}

/**
 * 1286. Iterator for Combination
 */

class CombinationIterator(characters: String, combinationLength: Int) {

    private val store = mutableListOf<String>()

    init {
        combine(0, characters, StringBuilder(), store, combinationLength)
    }

    fun next(): String = store.removeFirst()

    fun hasNext(): Boolean = store.isNotEmpty()

    private fun combine(
        index: Int,
        str: String,
        subset: StringBuilder,
        store: MutableList<String>,
        limit: Int
    ) {

        if (subset.length == limit) {
            store.add(subset.toString())
            return
        }

        if (index == str.length) return

        subset.append(str[index])
        combine(index + 1, str, subset, store, limit)

        subset.deleteAt(subset.length - 1)
        combine(index + 1, str, subset, store, limit)
    }

}

/**
 * 341. Flatten Nested List Iterator
 */

class NestedInteger {
    fun getInteger(): Int? {
        return null
    }

    fun getList(): List<NestedInteger>? {
        return null
    }
}

class NestedIterator(nestedList: List<NestedInteger>) {

    private val store = mutableListOf<Int>()

    init {
        nestedList.forEach {
            dfs(it)
        }
    }

    private fun dfs(obj: NestedInteger) {
        val action = obj.getInteger()
        if (action != null) {
            store.add(action)
            return
        }

        obj.getList()?.forEach {
            dfs(it)
        }
    }


    fun next(): Int = store.removeFirst()

    fun hasNext(): Boolean = store.isNotEmpty()
}