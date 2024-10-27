package com.leetcode_kotlin


/**
 * Executing
 */


fun main() {

    val matrix = Matrix.createMatrix()

    NumMatrixProdVariant(matrix).sumRegion(2, 1, 4, 3).also {
        println(it)
    }
}

