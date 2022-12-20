package com.leetcode_kotlin.LongestCommonPrefix



fun longestCommonPrefix(strs: Array<String>): String {

    if (strs == null || strs.size == 0)
        return ""


    var pre = strs[0]
    var i = 1



    while (i < strs.size)
        while (strs[i].indexOf(pre) != 0) {

        }

    return ""

}

fun peredacha(strs: Array<String>): Int {

    var pre = strs[0]

    return strs[1].indexOf(pre)

}


fun stub(strs: Array<String>): String {

    return strs[0].substring(0,strs[0].length - 1)

}