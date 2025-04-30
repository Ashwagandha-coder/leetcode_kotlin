package com.github.contest


import com.github.contest.hashTable.countGoodAlternativeSolution
import com.github.contest.math.numberOfPowerfulInt
import com.github.contest.slidingWindow.countSubArrayWithMaxElement
import com.github.contest.slidingWindow.countSubArrays
import com.github.contest.strings.fullJustify
import com.github.contest.strings.subStrHash
import java.util.TreeMap


/**
 * Stand
 */

fun main() {

    countSubArrayWithMaxElement(
        intArrayOf(1, 3, 2, 3, 3), 2
    ).also { println(it) }


}

fun countGoodData() {
    countGoodAlternativeSolution(intArrayOf(3, 1, 4, 3, 2, 2, 4), 2).also { println(it) }
}

fun fullJustifyData() {
    fullJustify(
        arrayOf(
            "Science",
            "is",
            "what",
            "we",
            "understand",
            "well",
            "enough",
            "to",
            "explain",
            "to",
            "a",
            "computer.",
            "Art",
            "is",
            "everything",
            "else",
            "we",
            "do"
        ), 20
    ).also {
        println(
            it
        )
    }
}

fun subStrHashData() {
    subStrHash("xxterzixjqrghqyeketqeynekvqhc", 15, 94, 4, 16).also { println(it) }
}

fun numberOfPowerfulIntData() {
    val start = 141L
    val finish = 148L
    val limit = 9
    val s = "9"

    numberOfPowerfulInt(start, finish, limit, s).also { println(it) }
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




