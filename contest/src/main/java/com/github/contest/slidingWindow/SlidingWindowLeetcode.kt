package com.github.contest.slidingWindow

import java.util.TreeSet


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

fun minimumSumSubarray(nums: List<Int>, l: Int, r: Int): Int {
    val minSums = mutableListOf<Int>()
    return TODO("Make this method")
}

/**
 * 187. Repeated DNA Sequences
 */

fun findRepeatedDnaSequences(s: String): List<String> {
    if (s.length < 10) return listOf()

    val dnas = s.windowed(10).map { it }.groupingBy { it }.eachCount()
    val res = mutableListOf<String>()

    for ((key, value) in dnas) {
        if (value > 1) res.add(key)
    }


    return res
}

/**
 * 1044. Longest Duplicate Substring
 */

fun longestDupSubstring(s: String): String {
    if (s.length == 2 && s[0] == s[1]) return "${s[0]}"

    var left = 1
    var right = s.length
    var maxLen = 0
    var res = ""

    while (left < right) {

        val window = (left + right) / 2

        if (window == maxLen) return res

        val check = findDuplicate(s, window)

        if (check != null) {
            left = window
            maxLen = window
            res = check
        } else right = window
    }

    return res
}


private fun findDuplicate(s: String, length: Int): String? {
    val base = 26
    val mod = 1_000_000_007
    var hash = 0L
    var power = 1L
    val seen = HashMap<Long, MutableList<Int>>()


    for (i in 0 until length - 1) {
        power = (power * base) % mod
    }


    for (i in 0 until length) {
        hash = (hash * base + (s[i] - 'a')) % mod
    }
    seen.getOrPut(hash) { mutableListOf() }.add(0)


    for (i in 1..s.length - length) {

        hash = (hash - (s[i - 1] - 'a') * power % mod + mod) % mod

        hash = (hash * base + (s[i + length - 1] - 'a')) % mod


        if (seen.containsKey(hash)) {
            val currentSub = s.substring(i, i + length)
            for (start in seen[hash]!!) {
                if (s.substring(start, start + length) == currentSub) {
                    return currentSub
                }
            }
            seen[hash]!!.add(i)
        } else {
            seen[hash] = mutableListOf(i)
        }
    }

    return null
}

/**
 * 1763. Longest Nice Substring
 */

fun longestNiceSubstring(s: String): String {
    if (s.hasSingle()) return ""


    (s.length downTo 2).forEach { window ->
        s.windowed(window).forEach {
            if (it.isNice()) return it
        }

    }

    return emptyString()
}

private fun String.isNice(): Boolean {
    val set = mutableSetOf<Char>()

    for (char in this) {
        set.add(char)
    }

    for (char in this) {
        if (char !in 'A'..'Z') {
            if (!set.contains(char.uppercaseChar())) return false
        } else {
            if (!set.contains(char.lowercaseChar())) return false
        }
    }

    return true
}

private fun emptyString() = ""

private fun String.hasSingle() = when {
    length == 1 -> true
    else -> false
}

/**
 * 2653. Sliding SubArray Beauty
 */

fun getSubArrayBeauty(nums: IntArray, k: Int, x: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    val res = IntArray(nums.size - k + 1)
    var left = 0
    val window = TreeSet<Int>()

    for (right in nums.indices) {
        map[nums[right]] = map.getOrDefault(nums[right], 0) + 1
        window.add(nums[right])

        if (right - left == k - 1) {
            var cnt = 0
            var beauty = 0

            for (num in window) {
                cnt += map[num]!!
                if (cnt >= x) {
                    beauty = if (num < 0) num else 0
                    break
                }
            }

            res[left] = beauty
            map[nums[left]] = map.getOrDefault(nums[left], 0) - 1
            if (map[nums[left]] == 0) {
                map.remove(nums[left])
                window.remove(nums[left])
            }
            left++
        }
    }

    return res
}

/**
 * 2760. Longest Even Odd Subarray With Threshold
 */

fun longestAlternatingSubarray(nums: IntArray, threshold: Int): Int {
    var longest = 0

    (nums.size downTo 1).forEach { window ->
        nums.toList().windowed(window) {
            if (isValid(it, threshold)) {
                longest = window
                return@windowed
            }
        }
        if (longest > 0) return longest
    }

    return longest
}

private fun isValid(window: List<Int>, threshold: Int): Boolean {
    return when {
        window.isEmpty() -> false
        window.first() % 2 != 0 -> false
        else -> {

            for (i in 0..window.size - 2) {
                if (window[i] % 2 == window[i + 1] % 2) {
                    return false
                }
            }

            for (element in window) {
                if (element > threshold) {
                    return false
                }
            }

            return true
        }
    }
}

/**
 * 1052. Grumpy Bookstore Owner
 */

fun maxSatisfied(customers: IntArray, grumpy: IntArray, minutes: Int): Int {
    var notGrumpy = 0
    var maxCustomers = 0
    var left = 0
    var sum = 0

    for (i in customers.indices) {
        if (grumpy[i] == 0) notGrumpy += customers[i]
    }


    for (right in customers.indices) {
        if (grumpy[right] == 1) sum += customers[right]

        if (right - left == minutes - 1) {
            maxCustomers = maxOf(maxCustomers, notGrumpy + sum)
            if (grumpy[left] == 1) sum -= customers[left]
            left++
        }
    }

    return maxCustomers
}

/**
 * 3090. Maximum Length Substring With Two Occurrences
 */

fun maximumLengthSubstring(s: String): Int {
    if (s.length == 2) return 2

    var maxLen = 0
    var left = 0
    val freq = mutableMapOf<Char, Int>()

    for (right in s.indices) {

        val char = s[right]
        freq[char] = freq.getOrDefault(char, 0) + 1

        if (!isValidSubString(freq)) {
            freq[s[left]] = freq.getOrDefault(s[left], 0) - 1
            if (freq[s[left]] == 0) freq.remove(s[left])
            left++
        }

        maxLen = maxOf(maxLen, right - left + 1)
    }

    return maxLen
}

private fun isValidSubString(map: Map<Char, Int>): Boolean {

    for ((_, value) in map) {
        if (value > 2) return false
    }

    return true
}

/**
 * 2398. Maximum Number of Robots Within Budget
 */

fun maximumRobots(chargeTimes: IntArray, runningCosts: IntArray, budget: Long): Int {
    var maxRobots = 0
    var left = 0
    var sum = 0L
    val window = mutableListOf<Long>()

    for (right in chargeTimes.indices) {
        window.add(chargeTimes[right].toLong())
        sum += runningCosts[right].toLong()
        var max = window.maxOrNull() ?: 0L
        var k = (right - left + 1).toLong()
        var cost = max + (k * sum)

        while (cost > budget) {
            sum -= runningCosts[left]
            window.removeFirst()
            left++
            max = window.maxOrNull() ?: 0L
            k = (right - left + 1).toLong()
            cost = max + (k * sum)
        }

        maxRobots = maxOf(maxRobots, right - left + 1)
    }

    return maxRobots
}

/**
 * 413. Arithmetic Slices
 */

fun numberOfArithmeticSlices(nums: IntArray): Int {
    if (nums.size < 3) return 0

    var count = 0

    (3..nums.size).forEach { window ->
        nums.toList().windowed(window) {
            var isValid = true
            val diff = it[1] - it[0]

            for (i in 2 until it.size) {
                if (it[i] - it[i - 1] != diff) {
                    isValid = false
                    break
                }
            }

            if (isValid) count++
        }
    }

    return count
}

/**
 * 3206. Alternating Groups I
 */

fun numberOfAlternatingGroups(colors: IntArray): Int {
    var groups = 0
    var left = 0
    val k = 3
    var prevColor = colors[0]


    for (right in 1 until colors.size + 2) {
        val curr = when {
            right >= colors.size -> colors[right - colors.size]
            else -> colors[right]
        }

        if (prevColor == curr) {
            left = right
        }

        prevColor = curr

        if (right - left == k - 1) {
            groups++
            left++
        }
    }

    return groups
}

/**
 * 1652. Defuse the Bomb
 */

fun decrypt(code: IntArray, k: Int): IntArray = when {
    k == 0 -> IntArray(code.size)
    k > 0 -> {
        val res = IntArray(code.size)
        for (i in code.indices) {
            var sum = 0
            var right = i + 1
            var k = k

            while (k != 0) {
                sum += when {
                    right >= code.size -> code[right - code.size]
                    else -> code[right]
                }
                right++
                k--
            }

            res[i] = sum
        }
        res
    }

    else -> {
        val res = IntArray(code.size)
        for (i in code.indices) {
            var sum = 0
            var right = i - 1
            var k = k

            while (k < 0) {
                sum += when {
                    right < 0 -> code[code.size + right]
                    else -> code[right]
                }
                right--
                k++
            }

            res[i] = sum
        }
        res
    }
}

/**
 * 438. Find All Anagrams in a String
 */

fun findAnagrams(s: String, p: String): List<Int> {
    if (p.length > s.length) return listOf()

    val pattern = p.eachCount()
    val store = mutableMapOf<Char, Int>()
    var left = 0
    val k = p.length
    val ind = mutableListOf<Int>()

    for (right in s.indices) {
        val char = s[right]
        store[char] = store.getOrDefault(char, 0) + 1

        if (right - left == k - 1) {
            if (equalMaps(store, pattern)) ind.add(left)
            store[s[left]] = store.getOrDefault(s[left], 0) - 1
            if (store[s[left]] == 0) store.remove(s[left])
            left++
        }

    }

    return ind
}

private fun <K, V : Comparable<V>> equalMaps(first: Map<K, V>, second: Map<K, V>): Boolean {

    for ((char, count) in first) {
        if (!second.contains(char) || second[char] != count) return false
    }

    return true
}

private fun String.eachCount(): MutableMap<Char, Int> {
    val count = mutableMapOf<Char, Int>()
    for (char in this) count[char] = count.getOrDefault(char, 0) + 1
    return count
}

/**
 * 713. Subarray Product Less Than K
 */

fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int = atMostKProduct(nums, k - 1)

private fun atMostKProduct(nums: IntArray, k: Int): Int {
    var left = 0
    var product = 1
    var count = 0

    for (right in nums.indices) {
        product *= nums[right]

        while (left <= right && product > k) {
            product /= nums[left]
            left++
        }

        count += (right - left + 1)
    }

    return count
}





