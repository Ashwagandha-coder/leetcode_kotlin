package com.github.contest


import com.github.contest.strings.shiftingLetters

import java.util.TreeMap


/**
 * Stand
 */

fun main() {

    shiftingLetters(
        "mkgfzkkuxownxvfvxasy",
        intArrayOf(
            505870226,
            437526072,
            266740649,
            224336793,
            532917782,
            311122363,
            567754492,
            595798950,
            81520022,
            684110326,
            137742843,
            275267355,
            856903962,
            148291585,
            919054234,
            467541837,
            622939912,
            116899933,
            983296461,
            536563513
        )
    ).also { println(it) }
}

fun testing() {
    val list = listOf(1, 2, 3)
    list.reduceRight { i, acc ->
        println("$i, $acc")
        acc - i
    }.also { println(it) }
}

fun generateTesting() {
    val sequence = sequenceOf(3, 5, 6, 7, 7, 8, 8, 8, 9, 3)
    sequence.map { it * 2 }.filter { it > 3 }.filter { it > 2 }.constrainOnce()


}

fun generateSequence() {
    var counter = 0
    val numbers = generateSequence {
        if (counter < 5) {
            counter++
            counter
        } else null
    }

    println(numbers.toList())
}

fun doing() {
    val collection = mutableListOf(listOf(5), listOf(2), listOf(4))
    val other = mutableListOf(3, 5, 10)
    val res = collection.flatMap {
        it.asReversed()
    }

    println(res)
}


fun workWithTreeMap() {
    val treeMapOne = TreeMap<String, Int>()
    treeMapOne["apple"] = 1
    treeMapOne["banana"] = 2
    treeMapOne["cherry"] = 3

    println("TreeMap with natural ordering:")
    treeMapOne.forEach { (key, value) -> println("$key: $value") }
}


fun IntArray.printArray() {
    var s = when (this.size) {
        0 -> "[]"
        1 -> "[${this[0]}]"
        2 -> "[${this[0]}, ${this[1]}]"
        else -> {
            var temp = "[${this[0]}, "
            for (i in 1 until this.size - 1) temp += "${this[i]}, "
            temp += "${this[this.size - 1]}]"
            temp
        }
    }
    println(s)
}




