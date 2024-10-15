package com.leetcode_kotlin


fun IntArray.forEach(lambda: (Int) -> Unit) {
    for (elem in this) {
        lambda.invoke(elem)
    }
}


fun sample() {

    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val iterator = list.listIterator()
    while (iterator.hasNext()) {
        println(iterator.next())
    }
    iterator

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