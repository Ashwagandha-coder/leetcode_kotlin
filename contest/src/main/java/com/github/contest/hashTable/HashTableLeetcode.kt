package com.github.contest.hashTable

import com.github.contest.removeIfEmptyBucket

/**
 * 2540. Minimum Common Value
 */

fun getCommon(nums1: IntArray, nums2: IntArray): Int {
    var minCommonValue = Int.MAX_VALUE
    val set = mutableSetOf<Int>()
    for (num in nums1) set.add(num)
    var i = 0
    while (i < nums2.size && !set.contains(nums2[i])) {
        i++
    }
    if (i < nums2.size && set.contains(nums2[i])) minCommonValue = nums2[i]
    return if (minCommonValue == Int.MAX_VALUE) -1 else minCommonValue
}

/**
 * 350. Intersection of Two Arrays II
 */

fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val res = mutableListOf<Int>()
    val map = mutableMapOf<Int, Int>()
    for (num in nums1) map[num] = map.getOrDefault(num, 0) + 1
    for (num in nums2) {
        if (map.contains(num)) {
            res.add(num)
            map.removeIfEmptyBucket(num)
        }
    }
    return res.toIntArray()
}

/**
 * 1002. Find Common Characters
 */


fun commonChars(words: Array<String>): List<String> {
    val minFreq = IntArray(26) { Int.MAX_VALUE }

    for (word in words) {
        val charFreq = IntArray(26)
        for (c in word) {
            charFreq[c - 'a']++
        }

        for (i in 0 until 26) {
            minFreq[i] = minOf(minFreq[i], charFreq[i])
        }
    }

    val result = mutableListOf<String>()
    for (i in 0 until 26) {
        repeat(minFreq[i]) {
            result.add((i + 'a'.code).toChar().toString())
        }
    }

    return result
}

/**
 * 1790. Check if One String Swap Can Make Strings Equal
 */

fun areAlmostEqual(s1: String, s2: String): Boolean {
    if (s1 == s2) return true

    for (i in s1.indices) {
        for (j in i + 1 until s1.length) {
            var temp = s2.swap(i, j)
            if (temp == s1) return true
        }
    }

    for (i in s2.indices) {
        for (j in i + 1 until s2.length) {
            var temp = s2.swap(i, j)
            if (temp == s1) return true
        }
    }

    return false
}

private fun String.swap(from: Int, to: Int): String {
    var arr = this.toCharArray()
    var temp = arr[from]
    arr[from] = arr[to]
    arr[to] = temp
    return String(arr)
}

/**
 * 1726. Tuple with Same Product
 */

fun tupleSameProduct(nums: IntArray): Int {
    if (nums.size < 4) return 0
    val productCounts = mutableMapOf<Int, Int>()

    for (i in 0 until nums.size) {
        for (j in i + 1 until nums.size) {
            val product = nums[i] * nums[j]
            productCounts[product] = productCounts.getOrDefault(product, 0) + 1
        }
    }

    var tuples = 0
    for (count in productCounts.values) {
        if (count > 1) tuples += count * (count - 1) * 4
    }
    return tuples
}

/**
 * 1796. Second Largest Digit in a String
 */

fun secondHighest(s: String): Int {
    if (s.hasSingle()) return -1
    val map = mutableMapOf<Int, Int>()
    for (char in s) {
        if (isDigit(char)) {
            val value = char.digitToInt()
            map[value] = map.getOrDefault(value, 0) + 1
        }
    }
    var keyMax = 0
    for (key in map.keys) {
        keyMax = maxOf(keyMax, key)
    }
    if (map.contains(keyMax)) map.remove(keyMax)

    return map.keys.maxOrNull() ?: -1
}

private fun String.hasSingle(): Boolean = when {
    this.length == 1 -> true
    else -> false
}

private fun isDigit(s: Char): Boolean {
    return s in "0123456789"
}

/**
 * 2364. Count Number of Bad Pairs
 */


fun countBadPairs(nums: IntArray): Long {
    val n = nums.size
    val diffCounts = mutableMapOf<Int, Long>()
    var goodPairs = 0L

    for (j in 0 until n) {
        val diff = nums[j] - j
        goodPairs += diffCounts.getOrDefault(diff, 0L)
        diffCounts[diff] = diffCounts.getOrDefault(diff, 0L) + 1
    }

    val totalPairs = n.toLong() * (n - 1) / 2
    return totalPairs - goodPairs
}

/**
 *
 */

fun findPairs(nums: IntArray, k: Int): Int {
    if (k < 0) return 0

    val numCounts = mutableMapOf<Int, Int>()
    for (num in nums) {
        numCounts[num] = numCounts.getOrDefault(num, 0) + 1
    }

    if (k == 0) {
        return numCounts.count { it.value >= 2 }
    }

    val uniquePairs = mutableSetOf<Pair<Int, Int>>()
    for (num in nums) {
        if (numCounts.containsKey(num + k)) {
            uniquePairs.add(Pair(minOf(num, num + k), maxOf(num, num + k)))
        }
    }

    return uniquePairs.size
}

/**
 * 2342. Max Sum of a Pair With Equal Sum of Digits
 */

fun maximumSum(nums: IntArray): Int {
    var maxSum = -1
    val map = mutableMapOf<Int, Int>()

    for (i in 0 until nums.size) {
        val sum = sumOfDigit(nums[i])
        if (map.contains(sum)) {
            val first = map.getOrDefault(sum, -1)
            maxSum = maxOf(maxSum, nums[first] + nums[i])
            map[sum] = when {
                nums[i] > nums[first] -> i
                else -> first
            }
        } else map[sum] = map.getOrDefault(sum, i)
    }

    return maxSum
}

private fun sumOfDigit(num: Int): Int {
    var num = num
    var res = 0
    while (num != 0) {
        res += num % 10
        num /= 10
    }

    return res
}

/**
 * 2965. Find Missing and Repeated Values
 */

fun findMissingAndRepeatedValues(grid: Array<IntArray>): IntArray {
    val map = mutableMapOf<Int, Int>()
    val res = IntArray(2)
    val n = grid.size
    for (arr in grid) {
        for (num in arr) {
            map[num] = map.getOrDefault(num, 0) + 1
        }
    }
    for (key in map.keys) {
        if (map[key] == 2) {
            res[0] = key
            break
        }
    }
    for (i in 1..(n * n)) {
        if (!map.contains(i)) {
            res[1] = i
            break
        }
    }

    return res
}

/**
 * 2351. First Letter to Appear Twice
 */

fun repeatedCharacter(s: String): Char {
    val alphabet = IntArray(26)
    for (char in s) {
        val index = char - 'a'
        if (alphabet[index] == 0) alphabet[index] += 1
        else return char
    }

    return 'a'
}

/**
 * 3396. Minimum Number of Operations to Make Elements in Array Distinct
 */

fun minimumOperations(nums: IntArray): Int {
    val map = mutableMapOf<Int, Int>()
    var operations = 0

    for (num in nums) map[num] = map.getOrDefault(num, 0) + 1

    if (map.size == nums.size) return 0

    for (i in nums.indices step 3) {
        if (i + 2 < nums.size) {
            val one = nums[i]
            val two = nums[i + 1]
            val three = nums[i + 2]
            map.reduceOrRemove(one)
            map.reduceOrRemove(two)
            map.reduceOrRemove(three)
            var isUnique = true
            for (value in map.values) {
                if (value > 1) {
                    isUnique = false
                    break
                }
            }
            if (isUnique) return operations + 1
            operations++
        }
    }

    return if (map.isNotEmpty()) operations + 1 else operations

}

private fun MutableMap<Int, Int>.reduceOrRemove(key: Int) {
    this[key] = this.getOrDefault(key, 0) - 1
    if (this.getOrDefault(key, 0) == 0) this.remove(key)
}

/**
 * 242. Valid Anagram
 */

fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false
    val first = IntArray(26)
    val second = IntArray(26)

    for (char in s) first[char - 'a']++
    for (char in t) second[char - 'a']++

    for (char in t) {
        if (first[char - 'a'] == 0 || first[char - 'a'] != second[char - 'a']) return false
    }

    return true
}

/**
 * 2537. Count the Number of Good Subarrays
 * TLE Approach
 */

fun countGood(nums: IntArray, k: Int): Long {
    if (nums.hasSingle()) return 0L

    var count = 0L
    var left = 0

    while (left < nums.size) {
        var right = left + 1
        while (right < nums.size) {
            var localCounter = 0
            for (i in left..right) {
                for (j in i + 1..right) {
                    if (nums[i] == nums[j]) localCounter++
                }
            }
            if (localCounter >= k) count++
            right++
        }
        left++
    }

    return count
}

private fun IntArray.hasSingle() = when {
    this.size == 1 -> true
    else -> false
}


/**
 * 169. Majority Element
 */

fun majorityElement(nums: IntArray): Int {
    var majority = 0
    var res = 0
    val target = nums.size / 2

    nums.forEach {
        if (majority == 0) res = it
        majority += when {
            it == res -> 1
            else -> -1
        }
    }

    return res
}

/**
 * 2176. Count Equal and Divisible Pairs in an Array
 */

fun countPairs(nums: IntArray, k: Int): Int {
    if (nums.size < 2) return 0

    val store = mutableMapOf<Int, MutableList<Int>>()
    var count = 0

    for (i in nums.indices) {
        val num = nums[i]
        if (store.contains(num)) {
            val indexed = store.getOrDefault(num, mutableListOf())
            for (index in indexed) {
                if ((index * i) % k == 0) count++
            }
            indexed.add(i)
            store[num] = indexed
        } else store[num] = mutableListOf(i)
    }

    return count
}

/**
 * 2799. Count Complete SubArrays in an Array
 */

fun countCompleteSubArrays(nums: IntArray): Int {
    if (nums.size == 1) return 1

    var count = 0
    val distinct = distinctElementsOfArray(nums)
    var lastIndex = nums.size - 1

    for (i in nums.indices) {
        var j = i
        val set = mutableSetOf<Int>()

        while (j < nums.size && set.size != distinct) {
            set.add(nums[j])
            j++
        }
        j--
        if (set.size == distinct) count += (lastIndex - j) + 1
    }

    return count

}

private fun distinctElementsOfArray(nums: IntArray): Int {
    val set = mutableSetOf<Int>()
    for (num in nums) set.add(num)
    return set.size
}

/**
 * 12. Integer to Roman
 */

fun intToRoman(num: Int): String {
    val values = listOf(
        1000 to "M",
        900 to "CM",
        500 to "D",
        400 to "CD",
        100 to "C",
        90 to "XC",
        50 to "L",
        40 to "XL",
        10 to "X",
        9 to "IX",
        5 to "V",
        4 to "IV",
        1 to "I"
    )
    var n = num
    val result = StringBuilder()
    for ((value, symbol) in values) {
        while (n >= value) {
            result.append(symbol)
            n -= value
        }
    }
    return result.toString()
}

/**
 * 1128. Number of Equivalent Domino Pairs
 */

fun numEquivDominoPairs(dominoes: Array<IntArray>): Int {
    var count = 0
    val pairs = mutableMapOf<Pair<Int, Int>, Int>()

    for (domino in dominoes) {
        val base = Pair(domino[0], domino[1])
        val reversed = Pair(domino[1], domino[0])

        when {
            !pairs.contains(base) && !pairs.contains(reversed) -> pairs[base] =
                pairs.getOrDefault(base, 0) + 1

            pairs.contains(base) -> {
                count += pairs.getOrDefault(base, 0)
                pairs[base] = pairs.getOrDefault(base, 0) + 1
            }

            else -> {
                count += pairs.getOrDefault(reversed, 0)
                pairs[reversed] = pairs.getOrDefault(reversed, 0) + 1
            }
        }
    }

    return count
}

/**
 * 2062. Count Vowel Substrings of a String
 */

fun countVowelSubstrings(word: String): Int {
    var count = 0
    val vowels = setOf('a', 'e', 'i', 'o', 'u')

    for (i in word.indices) {
        val seen = mutableSetOf<Char>()
        for (j in i until word.length) {
            val char = word[j]
            if (char !in vowels) break
            seen.add(char)
            if (seen.size == 5) count++
        }
    }

    return count
}

/**
 * 2094. Finding 3-Digit Even Numbers
 */


fun findEvenNumbers(digits: IntArray): IntArray {
    val result = mutableSetOf<Int>()
    val n = digits.size

    for (i in 0 until n) {
        if (digits[i] == 0) continue

        for (j in 0 until n) {
            if (j == i) continue

            for (k in 0 until n) {

                if (k == i || k == j || digits[k] % 2 != 0) continue

                val num = digits[i] * 100 + digits[j] * 10 + digits[k]
                result.add(num)
            }
        }
    }

    return result.sorted().toIntArray()
}

/**
 * 2131. Longest Palindrome by Concatenating Two Letter Words
 */

fun longestPalindrome(words: Array<String>): Int {
    var len = 0
    val freq = mutableMapOf<String, Int>()

    for (origin in words) {
        val reverse = "${origin[1]}${origin[0]}"

        when {
            origin == reverse -> {
                if (freq.contains(origin)) {
                    len += 4
                    freq.remove(origin)
                } else freq[origin] = freq.getOrDefault(origin, 0) + 1
            }

            freq.contains(reverse) -> {
                freq[reverse] = freq.getOrDefault(reverse, 0) - 1
                len += 4
                if (freq[reverse] == 0) freq.remove(reverse)
            }

            else -> freq[origin] = freq.getOrDefault(origin, 0) + 1
        }
    }

    for ((key, value) in freq) {
        if ((key[0] == key[1]) && value == 1) {
            len += 2
            break
        }
    }

    return len
}

/**
 * 594. Longest Harmonious Subsequence
 */

fun findLHS(nums: IntArray): Int {
    val freq = nums.toList().groupingBy { it }.eachCount()
    var longest = 0

    for ((key, value) in freq) {
        val more = key + 1
        if (freq.contains(more)) {
            longest = maxOf(longest, freq.getOrDefault(more, 0) + value)
        }
    }

    return longest
}

/**
 * 3442. Maximum Difference Between Even and Odd Frequency I
 */

fun maxDifference(s: String): Int {
    var odd = 0
    var even = Int.MAX_VALUE
    val alpha = IntArray(26)

    for (char in s) {
        alpha[char - 'a']++
    }

    for (i in 0 until 26) {
        if (alpha[i] % 2 != 0) odd = maxOf(odd, alpha[i])
        else if (alpha[i] != 0) even = minOf(even, alpha[i])
    }

    return odd - even
}

/**
 * 3541. Find Most Frequent Vowel and Consonant
 */

fun maxFreqSum(s: String): Int {
    val freq = IntArray(26)
    var maxVowel = 0
    var maxConsonant = 0

    for (char in s) {
        val index = char - 'a'
        freq[index]++
    }

    for (i in 0 until 26) {
        val letter = (i + 'a'.code).toChar()
        if (isVowel(letter)) maxVowel = maxOf(maxVowel, freq[i])
        else maxConsonant = maxOf(maxConsonant, freq[i])
    }

    return maxVowel + maxConsonant
}

fun isVowel(char: Char) = when {
    char in "aeiou" -> true
    else -> false
}
