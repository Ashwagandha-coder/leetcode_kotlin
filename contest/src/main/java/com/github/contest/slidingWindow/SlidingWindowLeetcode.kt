package com.github.contest.slidingWindow

/**
 * 76. Minimum Window Substring
 */

fun minWindow(s: String, t: String): String {
    if (t.length > s.length) return ""
    val store = mutableMapOf<Char, Int>()

    store.fillMapFromString(t)

    for (k in t.length..s.length) {
        val cache = mutableMapOf<Char, Int>()
        var left = 0
        for (right in s.indices) {
            val key = s[right]
            cache[key] = cache.getOrDefault(key, 0) + 1
            if ((right - left) == (k - 1)) {
                val isUnique = checkUniqueAnswer(store, cache)
                if (isUnique) return s.substring(left, right + 1)
                cache.reduceOrRemove(s[left])
                left++
            }
        }
    }

    return ""
}

private fun MutableMap<Char, Int>.fillMapFromString(str: String) {
    for (char in str) this[char] = this.getOrDefault(char, 0) + 1
}

private fun MutableMap<Char, Int>.reduceOrRemove(key: Char) {
    this[key] = this.getOrDefault(key, 0) - 1
    if (this[key] == 0) this.remove(key)
}

private fun checkUniqueAnswer(store: MutableMap<Char, Int>, cache: MutableMap<Char, Int>): Boolean {
    var isUnique = true
    for ((char, count) in store) {
        if (cache.contains(char)) {
            val cacheCount = cache.getOrDefault(char, 0)
            if (cacheCount < count) {
                isUnique = false
                break
            }
        } else {
            isUnique = false
            break
        }
    }

    return isUnique
}