package com.leetcode_kotlin


/**
 * Executing
 */


fun main() {

    val root = Node.node()

    Repeat.value.bfs(root).also {
        print(it)
    }

}

