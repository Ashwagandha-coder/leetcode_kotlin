package com.github.contest

import com.github.contest.design.ProductOfNumbersProdVariant


/**
 * Stand
 */

fun main() {

    val productOfNumbers = ProductOfNumbersProdVariant()
    productOfNumbers.add(3)
    productOfNumbers.add(0)
    productOfNumbers.add(2)
    productOfNumbers.add(5)
    productOfNumbers.add(4)
    println(productOfNumbers.getProduct(2)) // Output: 20
    println(productOfNumbers.getProduct(3)) // Output: 40
    println(productOfNumbers.getProduct(4)) // Output: 0
    productOfNumbers.add(0)
    println(productOfNumbers.getProduct(2)) // Output: 0
    productOfNumbers.add(3)
    productOfNumbers.add(2)
    productOfNumbers.add(5)
    productOfNumbers.add(4)
    println(productOfNumbers.getProduct(2)) // Output: 20
    println(productOfNumbers.getProduct(3)) // Output: 40
    println(productOfNumbers.getProduct(4)) // Output: 120
    println(productOfNumbers.getProduct(5))


}