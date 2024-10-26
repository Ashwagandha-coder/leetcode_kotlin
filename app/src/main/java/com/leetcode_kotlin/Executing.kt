package com.leetcode_kotlin


/**
 * Executing
 */

fun main() {

    generateTrees(3).also {
        it.forEach { tree ->
            print("${tree!!?.`val`} ")
        }
    }

}

