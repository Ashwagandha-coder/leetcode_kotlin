package com.github.contest.hashTable


/**
 * 1790. Check if One String Swap Can Make Strings Equal
 * Prod Variant
 */


fun areAlmostEqualProdVariant(s1: String, s2: String): Boolean =
    when {
        s1 == s2 -> true
        s1.length != s2.length -> false
        else -> s1.zip(s2).withIndex().filter { it.value.first != it.value.second }.map { it.index }
            .let { diff ->
                diff.size == 2 && s1[diff[0]] == s2[diff[1]] && s1[diff[1]] == s2[diff[0]]
            }
    }