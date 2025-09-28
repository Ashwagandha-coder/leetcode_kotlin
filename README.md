# LeetCode Kotlin Project

![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![Android Studio](https://img.shields.io/badge/Android%20Studio-3DDC84.svg?style=for-the-badge&logo=android-studio&logoColor=white)

This project is a curated collection of solutions to a wide variety of LeetCode problems, all
implemented in modern, idiomatic Kotlin. It's designed to be a valuable resource for anyone
preparing for technical interviews, learning Kotlin, or exploring different algorithmic approaches
to common problems.

## Key Features

* **Comprehensive Problem Coverage:** The project includes solutions for a diverse set of problems,
  covering many important data structures and algorithms.
* **Organized by Topic:** Solutions are neatly organized into packages based on the primary data
  structure or algorithm used, making it easy to find examples and study specific topics.
* **Idiomatic Kotlin:** The code is written in a clean, readable, and idiomatic Kotlin style,
  demonstrating best practices and modern language features.
* **Educational Resource:** By studying the solutions, you can learn how to approach different types
  of algorithmic problems and how to implement them effectively in Kotlin.

## Why Use This Project?

There are several great reasons to use this project:

* **Accelerate Your Learning:** If you're learning algorithms and data structures, this project
  provides a rich library of examples that you can study and learn from.
* **Prepare for Interviews:** The problems in this collection are representative of what you might
  encounter in a technical interview. You can use these solutions to practice and prepare.
* **Discover Kotlin Best Practices:** The code in this project demonstrates how to write clean,
  efficient, and expressive Kotlin. It's a great way to see how the language is used in a practical
  context.

## Getting Started: How to Use the Solutions

The solutions in this project are organized into functions. To use a solution, you can simply call
the function with the required input.

Here is an example of how you could call the `getCommon` function from the `HashTableLeetcode.kt`
file within a `main` function:

```kotlin

fun main() {
    // Example usage of the getCommon function
    val nums1 = intArrayOf(1, 2, 3)
    val nums2 = intArrayOf(2, 4)
    val common = getCommon(nums1, nums2)

    if (common != -1) {
        println("The minimum common value is: $common")
    } else {
        println("No common value was found.")
    }
}
```

## Table of Contents by Topic

Here is a list of the topics covered in this project, with a reference to the corresponding package:

| Topic                | Package                              |
|----------------------|--------------------------------------|
| **Array**            | `com.github.contest.array`           |
| **Backtracking**     | `com.github.contest.backtracking`    |
| **Binary Search**    | `com.github.contest.binarySearch`    |
| **Binary Tree**      | `com.github.contest.binaryTree`      |
| **Bit Manipulation** | `com.github.contest.bitManipulation` |
| **Design**           | `com.github.contest.design`          |
| **Dynamic Prog.**    | `com.github.contest.dp`              |
| **Graph**            | `com.github.contest.graph`           |
| **Hash Table**       | `com.github.contest.hashTable`       |
| **Heap**             | `com.github.contest.heap`            |
| **Linked List**      | `com.github.contest.linkedList`      |
| **Math**             | `com.github.contest.math`            |
| **Priority Queue**   | `com.github.contest.priorityqueue`   |
| **Queue**            | `com.github.contest.queue`           |
| **Recursion**        | `com.github.contest.recursion`       |
| **Sliding Window**   | `com.github.contest.slidingWindow`   |
| **Sorting**          | `com.github.contest.sorting`         |
| **Stack**            | `com.github.contest.stack`           |
| **Strings**          | `com.github.contest.strings`         |
| **Two Pointer**      | `com.github.contest.twoPointer`      |

``

