package com.leetcode_kotlin

import android.os.Build
import android.support.annotation.RequiresApi


fun sample() {

    val mutableList = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)

    mutableList.fold(0) { acc, num ->
        acc * 2
    }
    val list = listOf(listOf(1, 2, 3, 4), listOf(2, 5, 7, 8))
    val res = list.flatMap { listOf(it) }

    mutableList.last { it == 3 }

}

/**
 * Sample of fold function
 */

fun sampleFold() {
    val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 5, 6, 2, 4, 4, 6, 7, 8, 8, 4, 5, 7, 6)
    val ans = arr.fold(0) { acc, num ->
        num + acc
    }
}

/**
 * Sample of zip
 */


fun sampleZip() {
    val list = mutableListOf(12, 465, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
    val otherList =
        mutableListOf(12, 657, 67, 98, 32, 22, 54, 12, 76, 43, 33, 13, 14, 15, 16, 17, 18, 19, 20)
    val newList = list.zip(otherList)
    val newPair = list.zip(otherList) { a, b -> a + b }
    newPair.forEach {
        println(it)
    }
    val map = list.zip(otherList).toMap()
    map.forEach { (k, v) -> println("$k : $v") }
}

/**
 * Sample of zipWithNext
 */

fun sampleZipWithNext() {
    val listing = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 2342, 123, 4, 6, 7, 8, 9)
    val oth = listing.zipWithNext()
    oth.forEach {
        println(it)
    }
}

/**
 * Sample of Mutable List
 */

fun sampleMutableList() {
    val mutableList = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
    mutableList.hashCode()
    mutableList.reverse()
    mutableList.shuffle()
    mutableList.fill(2)
    mutableList.ifEmpty {
        mutableList.add(1)
    }
    mutableList.takeIf { it.size == 1 }?.let {
        it.forEach { elem ->
            println("$elem ")
        }
    }
    val num = 1
    num.takeIf { true }.let {

    }
    val newList = mutableList.takeWhile { it < 10 }
    newList.forEach { println(it) }
    mutableList.all { it == 1 }
    mutableList.any { it == 2 }
    mutableList.zipWithNext { a, b ->
        a + b
    }.let { println(it) }
    mutableList.map { it * 2 }
    mutableList.onEach {
        it
    }
    // fold
    mutableList.single { it == 1 }
    mutableList.distinct()
    mutableList.drop(2)
}

/**
 * Sample of immutable iterator
 */

fun sampleImmutableIterator() {
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 10, 11, 34, 55, 67, 235, 678, 11)
    val iterator = list.listIterator()
    // iterative through list
    while (iterator.hasNext()) {
        println(iterator.next())
    }
    // iterative back through list
    while (iterator.hasPrevious()) {
        println(iterator.previous())
    }
}

/**
 * Sample of mutable iterator
 */

fun sampleMutableIterator() {
    val mutableList = mutableListOf(1, 3, 4, 5, 6, 7, 8, 9)
    val iterator = mutableList.listIterator()
    while (iterator.hasNext()) {
        val num = iterator.next()
        if (num % 2 == 0) {
            iterator.set(0)
        }
    }
}

/**
 * Sample Using MutableIterator in Production Variants
 */


fun processLogFile(logLines: MutableList<String>) {
    val iterator = logLines.listIterator()
    while (iterator.hasNext()) {
        val line = iterator.next()
        if (line.contains("SEVERE")) {
            iterator.run {
                previous()
                add("WARNING: Context Before Error")
                next()
                next()
                add("Context After Error")
            }
        }
    }
}

/**
 * Sample Using Spliterator
 */

@RequiresApi(Build.VERSION_CODES.N)
fun sampleSpliterator() {
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
    val spliterator = list.spliterator()
    // sample using stream
    list.stream().parallel().forEach {
        println(it)
    }
    // sample using spliterator
    while (spliterator.tryAdvance { println(it) }) {
    }
}


/**
 * Algo:
 * 1. how to add array elements to linked list for cycle
 */

/**
 *  1. custom ext fun for collection (filter, map, forEach, indexed, etc...
 *  2. lambda function - mental and repeat
 *  3. return@forEach - What is?
 *  4. operators inline crossinline, noinline
 *  5. compile kotlin - object, companion object, extension fun
 *  6. UInt, ULong - what is?
 *  7. Standart library, what is ?
 *  8. Search new features to kotlin API
 */

/**
 * Sample Using Comparable
 */

data class Task(val name: String, val priority: Int) : Comparable<Task> {
    override fun compareTo(other: Task): Int {
        return this.priority.compareTo(other.priority) // Сравнение по приоритету
    }
}

data class Polet(val time: Int, val priority: Int) : Comparable<Polet> {
    override fun compareTo(other: Polet): Int = this.priority.compareTo(other.priority)

}


fun usingComparable() {
    val polets = listOf(Polet(23, 1), Polet(34, 2), Polet(45, 1))
    val sorter = polets.sorted()
    println(sorter)
}

