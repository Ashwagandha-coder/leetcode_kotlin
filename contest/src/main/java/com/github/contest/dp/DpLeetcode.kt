package com.github.contest.dp

import com.github.contest.abs


/**
 * 1137. N-th Tribonacci Number
 */

fun tribonacci(n: Int): Int {
    if (n == 0 || n == 1) return n
    if (n == 2) return 1
    val dp = IntArray(n + 1)
    dp[0] = 0
    dp[1] = 1
    dp[2] = 1
    for (i in 3..n) {
        dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1]
    }
    return dp[n]
}

/**
 * 1668. Maximum Repeating Substring
 */

fun maxRepeating(sequence: String, word: String): Int {
    var ans = 1
    while (sequence.contains(word.repeat(ans))) ans++
    return ans - 1
}


/**
 * 118. Pascal's Triangle
 */

fun generate(numRows: Int): List<List<Int>> {
    if (numRows == 1) return listOf(listOf(1))
    if (numRows == 2) return listOf(listOf(1), listOf(1, 1))
    val dp = fill(numRows)
    var cells = 1
    for (i in 2 until numRows) {
        var prev = 0
        var curr = 1
        repeat(cells) {
            dp[i][it + 1] = dp[i - 1][prev] + dp[i - 1][curr]
            prev++
            curr++
        }
        cells++
    }
    return dp
}


private fun fill(rows: Int): List<MutableList<Int>> {
    val res = mutableListOf<MutableList<Int>>()
    for (i in 0 until rows) {
        val new = mutableListOf<Int>()
        repeat(i + 1) {
            new.add(1)
        }
        res.add(new)
    }
    return res
}

/**
 * 119. Pascal's Triangle II
 */

fun getRow(rowIndex: Int): List<Int> {
    if (rowIndex == 0) return listOf(1)
    if (rowIndex == 1) return listOf(1, 1)
    var row = 1
    var prev = mutableListOf(1, 1)
    var curr = mutableListOf<Int>()
    for (i in 2 until rowIndex + 1) {
        curr = mutableListOf()
        repeat(i + 1) {
            curr.add(1)
        }
        repeat(row) {
            curr[it + 1] = prev[it] + prev[it + 1]
        }
        prev = curr
        row++
    }
    return curr
}

/**
 * 70. Climbing Stairs
 */

fun climbStairs(n: Int): Int {
    if (n <= 2) return n
    val dp = IntArray(n)
    dp[0] = 1
    dp[1] = 2
    for (i in 2 until n) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }
    return dp[n - 1]
}

/**
 * 516. Longest Palindromic Subsequence
 */


fun longestPalindromeSubseq(s: String): Int {
    if (s.hasSingle()) return 1
    val n = s.length
    val dp = Array(n) { IntArray(n) }

    for (i in s.indices) dp[i][i] = 1

    for (len in 2..n) {
        for (i in 0..n - len) {
            var j = (len - 1) + i
            if (s[i] == s[j]) dp[i][j] = dp[i + 1][j - 1] + 2
            else dp[i][j] = maxOf(dp[i][j - 1], dp[i + 1][j])
        }
    }
    return dp[0][n - 1]
}

private fun String.hasSingle(): Boolean = when {
    this.length == 1 -> true
    else -> false
}

/**
 * 647. Palindromic Substrings
 */


fun countSubstrings(s: String): Int {
    if (s.hasSingle()) return 1
    val n = s.length
    var counter = s.length
    val dp = Array(n) { BooleanArray(n) }
    for (i in 0 until n) dp[i][i] = true

    for (len in 2..n) {
        for (i in 0..n - len) {
            val j = i + len - 1
            when {
                len == 2 -> {
                    if (s[i] == s[j]) {
                        counter++
                        dp[i][j] = true
                    }
                }

                else -> {
                    if (s[i] == s[j] && dp[i + 1][j - 1]) {
                        counter++
                        dp[i][j] = true
                    }
                }
            }
        }
    }

    return counter
}

/**
 * 2370. Longest Ideal Subsequence
 */

fun longestIdealString(s: String, k: Int): Int {
    val dp = IntArray(26) { 0 }

    for (c in s) {
        val currIndex = c - 'a'
        var maxLength = 0
        for (prevIndex in 0..25) {
            if (abs(currIndex - prevIndex) <= k) {
                maxLength = maxOf(maxLength, dp[prevIndex])
            }
        }
        dp[currIndex] = maxOf(dp[currIndex], maxLength + 1)
    }

    return dp.maxOrNull() ?: 0
}

/**
 * 1025. Divisor Game
 * Dp Approach
 */

fun divisorGameDp(n: Int): Boolean {
    if (n <= 1) return false
    val dp = BooleanArray(n + 1)
    dp[1] = false

    for (i in 2..n) {
        for (x in 1 until i) {
            if (i % x == 0 && !dp[i - x]) {
                dp[i] = true
                break
            }
        }
    }

    return dp[n]
}

/**
 * 2900. Longest Unequal Adjacent Groups Subsequence I
 */

fun getLongestSubsequence(words: Array<String>, groups: IntArray): List<String> {
    val dp = BooleanArray(words.size) { false }
    dp[0] = true
    var j = 0
    for (i in 1 until groups.size) {
        if (groups[i] != groups[j]) {
            dp[i] = true
            j = i
        }
    }
    var res = mutableListOf<String>()
    for (i in words.indices) {
        if (dp[i]) res.add(words[i])
    }

    return res
}

/**
 * 64. Minimum Path Sum
 */

fun minPathSum(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    val dp = Array(m) { IntArray(n) }


    dp[0][0] = grid[0][0]


    for (j in 1 until n) {
        dp[0][j] = dp[0][j - 1] + grid[0][j]
    }


    for (i in 1 until m) {
        dp[i][0] = dp[i - 1][0] + grid[i][0]
    }


    for (i in 1 until m) {
        for (j in 1 until n) {
            dp[i][j] = minOf(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
        }
    }

    return dp[m - 1][n - 1]
}

/**
 * 1981. Minimize the Difference Between Target and Chosen Elements
 */

fun minimizeTheDifference(mat: Array<IntArray>, target: Int): Int {
    val m = mat.size
    val n = mat[0].size

    var possibleSums = mutableSetOf<Int>()
    for (num in mat[0]) {
        possibleSums.add(num)
    }

    for (i in 1 until m) {
        val nextPossibleSums = mutableSetOf<Int>()
        for (sum in possibleSums) {
            for (num in mat[i]) {
                nextPossibleSums.add(sum + num)
            }
        }
        possibleSums = nextPossibleSums
    }

    var minDiff = Int.MAX_VALUE
    for (sum in possibleSums) {
        minDiff = minOf(minDiff, abs(sum - target))
    }

    return minDiff
}

/**
 * 2063. Vowels of All Substrings
 */

fun countVowels(word: String): Long {
    val n = word.length
    val dp = LongArray(n)
    val vowels = setOf('a', 'e', 'i', 'o', 'u')
    var totalVowels = 0L

    if (word[0] in vowels) {
        dp[0] = 1
    }

    totalVowels += dp[0]

    for (i in 1 until n) {
        dp[i] = dp[i - 1]
        if (word[i] in vowels) {
            dp[i] += (i + 1).toLong()
        }
        totalVowels += dp[i]
    }

    return totalVowels
}


/**
 * 1749. Maximum Absolute Sum of Any Subarray
 */

fun maxAbsoluteSum(nums: IntArray): Int {
    var maxSoFar = 0
    var minSoFar = 0
    var currentMax = 0
    var currentMin = 0

    for (num in nums) {
        currentMax += num
        currentMin += num

        maxSoFar = maxOf(maxSoFar, currentMax)
        minSoFar = minOf(minSoFar, currentMin)

        if (currentMax < 0) {
            currentMax = 0
        }
        if (currentMin > 0) {
            currentMin = 0
        }
    }

    return maxOf(maxSoFar, abs(minSoFar))
}

/**
 * 1143. Longest Common Subsequence
 */

fun longestCommonSubsequence(text1: String, text2: String): Int {
    val n = text1.length
    val m = text2.length
    val dp = Array(n + 1) { IntArray(m + 1) }

    for (i in 1..n) {
        for (j in 1..m) {
            if (text1[i - 1] == text2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
            } else {
                dp[i][j] = maxOf(dp[i][j - 1], dp[i - 1][j])
            }
        }
    }

    return dp[n][m]
}

/**
 * 1048. Longest String Chain
 */

fun longestStrChain(words: Array<String>): Int {
    val sortedWords = words.sortedBy { it.length }
    val dp = mutableMapOf<String, Int>()
    var longestChain = 0

    for (word in sortedWords) {
        var currentChain = 1
        for (i in word.indices) {
            val predecessor = word.removeRange(i, i + 1)
            currentChain = maxOf(currentChain, dp.getOrDefault(predecessor, 0) + 1)
        }
        dp[word] = currentChain
        longestChain = maxOf(longestChain, currentChain)
    }

    return longestChain
}

/**
 * 1027. Longest Arithmetic Subsequence
 */

fun longestArithSeqLength(nums: IntArray): Int {
    val n = nums.size

    val dp = Array(n) { mutableMapOf<Int, Int>() }
    var longest = 2

    for (i in 1 until n) {
        for (j in 0 until i) {
            val diff = nums[i] - nums[j]
            val length = dp[j].getOrDefault(diff, 1) + 1
            dp[i][diff] = length
            longest = maxOf(longest, length)
        }
    }

    return longest
}

/**
 * 845. Longest Mountain in Array
 */

fun longestMountain(arr: IntArray): Int {
    val n = arr.size
    if (n < 3) return 0

    var longestMountain = 0
    var i = 1

    while (i < n - 1) {

        if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {

            var left = i - 1
            while (left > 0 && arr[left - 1] < arr[left]) {
                left--
            }


            var right = i + 1
            while (right < n - 1 && arr[right] > arr[right + 1]) {
                right++
            }


            longestMountain = maxOf(longestMountain, right - left + 1)
            i = right
        }
        i++
    }

    return longestMountain
}

/**
 * 1493. Longest Subarray of 1's After Deleting One Element
 */

fun longestSubArray(nums: IntArray): Int {
    var left = 0
    var zeroCount = 0
    var maxLen = 0

    for (right in nums.indices) {
        if (nums[right] == 0) {
            zeroCount++
        }

        while (zeroCount > 1) {
            if (nums[left] == 0) {
                zeroCount--
            }
            left++
        }

        maxLen = maxOf(maxLen, right - left)
    }

    return maxLen
}

/**
 * 2771. Longest Non-decreasing Subarray From Two Arrays
 */


fun maxNonDecreasingLength(nums1: IntArray, nums2: IntArray): Int {
    val n = nums1.size
    // dp1[i]: Length of the longest non-decreasing subarray ending at index i, choosing nums1[i]
    // dp2[i]: Length of the longest non-decreasing subarray ending at index i, choosing nums2[i]
    val dp1 = IntArray(n) { 1 }
    val dp2 = IntArray(n) { 1 }
    var maxLen = 1

    for (i in 1 until n) {
        // Case 1: Extending from nums1[i-1] to nums1[i]
        if (nums1[i] >= nums1[i - 1]) {
            dp1[i] = dp1[i - 1] + 1
        }

        // Case 2: Extending from nums2[i-1] to nums1[i]
        if (nums1[i] >= nums2[i - 1]) {
            dp1[i] = maxOf(dp1[i], dp2[i - 1] + 1)
        }

        // Case 3: Extending from nums2[i-1] to nums2[i]
        if (nums2[i] >= nums2[i - 1]) {
            dp2[i] = dp2[i - 1] + 1
        }

        // Case 4: Extending from nums1[i-1] to nums2[i]
        if (nums2[i] >= nums1[i - 1]) {
            dp2[i] = maxOf(dp2[i], dp1[i - 1] + 1)
        }

        // Update the overall maximum length
        maxLen = maxOf(maxLen, maxOf(dp1[i], dp2[i]))
    }

    return maxLen
}

/**
 * 1218. Longest Arithmetic Subsequence of Given Difference
 */


fun longestSubsequence(arr: IntArray, difference: Int): Int {
    val dp = mutableMapOf<Int, Int>()
    var maxLen = 0

    for (num in arr) {
        val prev = num - difference
        val len = dp.getOrDefault(prev, 0) + 1
        dp[num] = len
        maxLen = maxOf(maxLen, len)
    }

    return maxLen
}

/**
 * 2140. Solving Questions With Brainpower
 */

fun mostPoints(questions: Array<IntArray>): Long {
    return solve(questions, 0)
}

private fun solve(questions: Array<IntArray>, index: Int): Long {
    if (index >= questions.size) {
        return 0
    }

    val points = questions[index][0]
    val brainpower = questions[index][1]
    val take = points.toLong() + solve(questions, index + brainpower + 1)


    val skip = solve(questions, index + 1)

    return maxOf(take, skip)
}





