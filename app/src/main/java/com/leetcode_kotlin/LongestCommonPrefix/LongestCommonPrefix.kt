package com.leetcode_kotlin.LongestCommonPrefix



fun longestCommonPrefix(strs: Array<String>) {

    if (strs == null || strs.size == 0) {
    }

    var pre = strs[0]
    var i = 1



    while (i < strs.size)
        while (strs[i].indexOf(pre) != 0) {

        }

    TODO("Сделать")


}

fun peredacha(strs: Array<String>): Int {

    var pre = strs[0]

    return strs[1].indexOf(pre)

}