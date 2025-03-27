package com.github.contest


import com.github.contest.hashTable.findAllRecipes
import java.util.TreeMap


/**
 * Stand
 */

fun main() {

    val recipes = arrayOf("ju", "fzjnm", "x", "e", "zpmcz", "h", "q")
    val ingredients =
        listOf(
            "d",
            "hveml", "f", "cpivl",
            "cpivl", "zpmcz", "h", "e", "fzjnm", "ju",
            "cpivl", "hveml", "zpmcz", "ju", "h",
            "h", "fzjnm", "e", "q", "x",
            "d", "hveml", "cpivl", "q", "zpmcz", "ju", "e", "x",
            "f", "hveml", "cpivl"
        ).chunked(1)

    val supplies = arrayOf("f", "hveml", "cpivl", "d")


    findAllRecipes(recipes, ingredients, supplies)

}

fun generateTesting() {
    val sequence = sequenceOf(3, 5, 6, 7, 7, 8, 8, 8, 9, 3)
    sequence.map { it * 2 }
        .filter { it > 3 }
        .filter { it > 2 }
        .constrainOnce()


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




