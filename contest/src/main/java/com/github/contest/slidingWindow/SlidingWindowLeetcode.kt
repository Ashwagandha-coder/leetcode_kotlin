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

/**
 * 3392. Count Subarrays of Length Three With a Condition
 */

fun countSubArrays(nums: IntArray): Int {
    var count = 0
    val k = 3
    var left = 0

    for (right in nums.indices) {
        if (right - left == k - 1) {
            val sum = (nums[left] + nums[right]).toDouble()
            val middle = nums[left + 1].toDouble() / 2.0
            if (sum == middle) count++
            left++
        }
    }

    return count
}

/**
 * 30. Substring with Concatenation of All Words
 */

fun findSubstring(s: String, words: Array<String>): List<Int> {
    val res = mutableListOf<Int>()
    val totalLen = words[0].length * words.size
    val wordLen = words[0].length
    val store = mutableMapOf<String, Int>()

    if (totalLen > s.length) return res

    for (word in words) store[word] = store.getOrDefault(word, 0) + 1

    var left = 0

    for (right in s.indices) {
        if (right - left == totalLen - 1) {
            val str = s.substring(left, right + 1)
            if (isValidWord(str, store, wordLen)) res.add(left)
            left++
        }
    }

    return res
}

private fun isValidWord(s: String, map: Map<String, Int>, window: Int): Boolean {
    val seen = mutableMapOf<String, Int>()
    var left = 0

    for (right in s.indices) {
        if (right - left == window - 1) {
            val str = s.substring(left, right + 1)
            seen[str] = seen.getOrDefault(str, 0) + 1
            left = right + 1
        }
    }

    return when {
        equalsMap(seen, map) -> true
        else -> false
    }
}

private fun equalsMap(comparable: Map<String, Int>, base: Map<String, Int>): Boolean {

    for ((str, count) in comparable) {
        if (!base.contains(str)) return false
        else {
            val amount = base[str]
            if (amount != count) return false
        }
    }

    return true
}

/**
 * 2962. Count Subarrays Where Max Element Appears at Least K Times
 */

fun countSubArrayWithMaxElement(nums: IntArray, k: Int): Long {
    val maxNum = nums.maxOrNull() ?: return 0
    var count = 0L
    var left = 0
    var maxCount = 0

    for (right in nums.indices) {
        if (nums[right] == maxNum) {
            maxCount++
        }


        while (maxCount >= k) {
            count += nums.size - right
            if (nums[left] == maxNum) {
                maxCount--
            }
            left++
        }
    }

    return count
}

/**
 * 209. Minimum Size Subarray Sum
 */

fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var minLen = Int.MAX_VALUE
    var sum = 0
    var left = 0
    var currentLen = 0

    for (element in nums) {
        sum += element
        currentLen++
        if (sum >= target) {
            minLen = minOf(minLen, currentLen)
            var localLen = minLen
            while (sum >= target) {
                if (sum == target) break
                if (localLen == 1) return 1
                if (sum - nums[left] < target) break
                else {
                    sum -= nums[left]
                    localLen--
                    left++
                }
            }
            minLen = minOf(minLen, localLen)
            currentLen = minOf(currentLen, localLen)
        }


        if (currentLen == minLen) {
            sum -= nums[left]
            left++
            currentLen--
        }
    }

    return when {
        minLen == Int.MAX_VALUE -> 0
        else -> minLen
    }
}

/**
 * 992. Subarrays with K Different Integers
 */

fun subArraysWithKDistinct(nums: IntArray, k: Int): Int {
    return atMostK(nums, k) - atMostK(nums, k - 1)
}

private fun atMostK(nums: IntArray, k: Int): Int {
    var count = 0
    val freq = mutableMapOf<Int, Int>()
    var left = 0

    for (right in nums.indices) {
        val num = nums[right]
        freq[num] = freq.getOrDefault(num, 0) + 1

        while (freq.size > k) {
            val leftNum = nums[left]
            freq[leftNum] = freq[leftNum]!! - 1
            if (freq[leftNum] == 0) {
                freq.remove(leftNum)
            }
            left++
        }

        count += right - left + 1
    }

    return count
}

/**
 * 2062. Count Vowel Substrings of a String
 */

fun countVowelSubstrings(word: String): Int {
    if (word.length < 5) return 0

    var count = 0
    val k = 5
    val vowels = "aeiou"

    for (window in k..word.length) {
        var left = 0
        val freq = mutableMapOf<Char, Int>()

        for (right in 0 until word.length) {
            freq[word[right]] = freq.getOrDefault(word[right], 0) + 1

            if (right - left == window - 1) {
                var isValid = true

                for ((key, _) in freq) {
                    if (!isVowel(key)) {
                        isValid = false
                        break
                    }
                }

                for (vowel in vowels) {
                    if (!freq.contains(vowel)) {
                        isValid = false
                        break
                    }
                }

                if (isValid) count++

                freq[word[left]] = freq.getOrDefault(word[left], 0) - 1
                if (freq[word[left]] == 0) freq.remove(word[left])
                left++
            }
        }
    }

    return count
}

private fun isVowel(char: Char) = when {
    char in "aeiou" -> true
    else -> false
}

/**
 * 3364. Minimum Positive Sum Subarray
 */

fun minimumSumSubarray(nums: List<Int>, l: Int, r: Int): Int = buildList {
    (l..r).forEach { window ->
        nums.windowed(window).map { it.sum() }.filter { it > 0 }.forEach { add(it) }
    }
}.min()

