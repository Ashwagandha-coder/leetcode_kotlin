package com.leetcode_kotlin

/**
 * Executing
 */

fun main() {

//    permute(MyArrays.permutationsData()).let {
//        it.forEach { num ->
//            print("${num.toString()} ")
//        }
//    }

    subsets(MyArrays.subsetData()).forEach {
        print("$it ")
    }

}