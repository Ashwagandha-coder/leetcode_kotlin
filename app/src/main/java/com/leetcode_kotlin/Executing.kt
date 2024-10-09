package com.leetcode_kotlin

/**
 * Executing
 */

fun main() {

    Node.also {
        val root = it.reverseOddLevelsOfBinaryTreeData()
        reverseOddLevels(root).let { tree ->
            println("$tree ")
        }
    }


}