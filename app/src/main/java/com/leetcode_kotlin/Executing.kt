package com.leetcode_kotlin

import kotlin.random.Random

/**
 * Executing
 */

fun main() {

    val root = TreeNodeParametrized(1)
    root.children.add(TreeNodeParametrized(2))
    root.children.add(TreeNodeParametrized(3))
    root.children[0].children.add(TreeNodeParametrized(4))
    root.children[0].children.add(TreeNodeParametrized(5))

    val bfsTraversal = bfs(root)
    bfsTraversal.let {
        println("$it ")
    }
}


fun generateSudokuTestCase(difficulty: Difficulty = Difficulty.EASY): Array<CharArray> {
    val board = Array(9) { CharArray(9) { '.' } }

    fun isValid(row: Int, col: Int, num: Char): Boolean {
        for (i in 0..8) {
            if (board[row][i] == num || board[i][col] == num ||
                board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num
            ) {
                return false
            }
        }
        return true
    }

    fun solve(): Boolean {
        for (row in 0..8) {
            for (col in 0..8) {
                if (board[row][col] == '.') {
                    for (num in '1'..'9') {
                        if (isValid(row, col, num)) {
                            board[row][col] = num
                            if (solve()) {
                                return true
                            } else {
                                board[row][col] = '.'
                            }
                        }
                    }
                    return false
                }
            }
        }
        return true
    }

    // Fill the diagonal 3x3 subgrids to ensure uniqueness
    for (i in 0..2) {
        for (j in 0..2) {
            var num: Char
            do {
                num = Random.nextInt(1, 10).digitToChar()
            } while (!isValid(3 * i + i / 3, 3 * j + j / 3, num))
            board[3 * i + i / 3][3 * j + j / 3] = num
        }
    }

    solve() // Solve the partially filled board

    // Remove numbers based on difficulty
    val removals = when (difficulty) {
        Difficulty.EASY -> 35 // Example: Removeabout 35 numbers for easy
        Difficulty.MEDIUM -> 45 // Example: Remove about 45 numbers for medium
        Difficulty.HARD -> 55 // Example: Remove about 55 numbers for hard
    }

    repeat(removals) {
        var row: Int
        var col: Int
        do {
            row = Random.nextInt(0, 9)
            col = Random.nextInt(0, 9)
        } while (board[row][col] == '.')
        board[row][col] = '.'
    }

    return board
}

enum class Difficulty {
    EASY, MEDIUM, HARD
}