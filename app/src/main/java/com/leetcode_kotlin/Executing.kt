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

    Repeat.value.wrapQuickSort2(MyArrays.quickSortData()).forEach {
        print("$it ")
    }

}