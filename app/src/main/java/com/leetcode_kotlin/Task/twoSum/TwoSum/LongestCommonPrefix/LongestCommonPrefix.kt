package com.leetcode_kotlin.Task.twoSum.TwoSum.LongestCommonPrefix


fun longestCommonPrefix(strs: Array<String>): String {

    if (strs.isEmpty())
        return ""

    var minLength = strs[0].length

    var longestPrefix = StringBuilder()

    for (i in 0 until strs.size) {

        minLength = Math.min(minLength, strs[i].length)


    }

    for (i in 0 until minLength) {

        val current = strs[0][i]

        for (str in strs) {
            if (str[i] != current)
                return longestPrefix.toString()

        }
        longestPrefix.append(current)


    }

    return longestPrefix.toString()
}

