package com.leetcode_kotlin

import kotlin.math.max

/**
 * Executing
 */

fun main() {


}


/**
 * 3190. Find Minimum Operations to Make All Elements Divisible by Three
 */

fun minimumOperations(nums: IntArray): Int {
    var res = 0

    for (n in nums) {
        if (n % 3 > 0) res++
    }

    return res
}


/**
 * 2011. Final Value of Variable After Performing Operations
 */


fun finalValueAfterOperations(opr: Array<String>): Int {
    var res = 0
    for (i in opr) {
        if (i.contains("-")) res -= 1
        else res += 1
    }
    return res
}

/**
 * 1512. Number of Good Pairs
 */

fun numIdenticalPairs(nums: IntArray): Int {
    val counts = mutableMapOf<Int, Int>()
    var ans = 0
    for (num in nums) {
        if (counts.contains(num)) ans += counts[num]!!
        counts[num] = (counts[num] ?: 0) + 1
    }
    return ans
}


/**
 * 217. Contains Duplicate
 */

fun containsDuplicate(nums: IntArray): Boolean {
    var count = 1
    val map = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
        if (map.contains(nums[i])) return true
        else {
            map.put(nums[i], 1)
        }
    }
    return false
}

/**
 * 268. Missing Number
 */


fun missingNumber(nums: IntArray): Int {
    val length = nums.size
    var sum = 0
    for (i in nums) {
        sum += i
    }
    return length * (length + 1) / 2 - sum
}

/**
 * 448. Find All Numbers Disappeared in an Array
 */

fun findDisappearedNumbers(nums: IntArray): List<Int> {
    val arr = mutableListOf<Int>()
    val set = mutableSetOf<Int>()
    for (i in nums) set.add(i)
    for (i in 1..nums.size) {
        if (!set.contains(i)) {
            arr.add(i)
        }
    }
    return arr
}

/**
 * 136. Single Number
 */

fun singleNumber(nums: IntArray): Int {
    var res = 0
    for (i in nums) res = res xor i
    return res
}

/**
 * 121. Best Time to Buy and Sell Stock
 */


fun maxProfit(prices: IntArray): Int {
    var profit = Int.MIN_VALUE
    var min = Int.MAX_VALUE
    for (i in prices.indices) {
        if (prices[i] < min) min = prices[i]
        if (prices[i] - min > profit) profit = prices[i] - min
    }
    return profit
}

/**
 * Selection Sort
 */

fun selectionSort(array: IntArray): IntArray {
    var min = Int.MAX_VALUE
    var ind = 0
    var temp = 0
    var j = 0
    while (j <= array.size - 1) {
        for (i in j until array.size) {
            if (array[i] < min) {
                min = array[i]
                ind = i
            }
        }
        temp = array[j]
        array[j] = min
        array[ind] = temp
        j++
        min = Int.MAX_VALUE
    }
    return array
}

/**
 *  Insertion Sort
 */

fun insertionSort(array: IntArray): IntArray {
    for (i in 1 until array.size) {
        var sorted = i - 1
        while (sorted > -1 && array[sorted] > array[sorted + 1]) {
            var temp = array[sorted]
            array[sorted] = array[sorted + 1]
            array[sorted + 1] = temp
            sorted--
        }
    }
    return array
}


/**
 * Fibonaci
 */


fun tabulation(param: Int): Int? {
    val cache: Array<Int?> = arrayOfNulls(param + 1)
    cache[0] = 0
    cache[1] = 1
    for (i in 2..param) {
        cache[i] = cache[i - 2]!! + cache[i - 1]!!
    }
    return cache[param]
}


fun memoization(param: Int): Int {
    val cache = IntArray(param + 1)
    return fib(param, cache)
}

fun fib(param: Int, array: IntArray): Int {
    if (param == 0) return 0
    if (param == 1) return 1
    if (array[param] == 0) {
        var a = fib(param - 2, array)
        var b = fib(param - 1, array)
        array[param] = a + b
    }
    return array[param]
}


/**
 * 303. Range Sum Query - Immutable
 */


class NumArray(val nums: IntArray) {

    fun sumRange(left: Int, right: Int): Int {
        var sum = 0
        var l = left
        var r = right
        while (l <= r) {
            sum += nums[l]
            l++
        }
        return sum
    }

}


/**
 * 338. Counting Bits
 */

fun countBits(n: Int): IntArray {
    val nums = IntArray(n + 1)
    if (n == 0) return nums
    if (n == 1) {
        nums[1] = 1
        return nums
    }
    nums[1] = 1
    var res = 0
    for (i in 2..nums.size - 1) {
        var ind = i
        while (ind > 0) {
            res += ind and 1
            ind /= 2
        }
        nums[i] = res
        res = 0
    }
    return nums
}

/**
 * 141. Linked List Cycle
 */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


fun hasCycle(head: ListNode?): Boolean {
    var slow = head
    var fast = head?.next
    while (slow != null && fast != null) {
        slow = slow?.next
        fast = fast?.next?.next
        if (slow === fast) {
            return true
        }
    }
    return false
}

/**
 *  876. Middle of the Linked List
 */

fun middleNode(head: ListNode?): ListNode? {
    var slow = head
    var fast = head?.next
    while (fast != null) {
        slow = slow?.next
        fast = fast?.next?.next
    }
    return slow
}

/**
 * 206. Reverse Linked List
 */

fun reverseList(head: ListNode?): ListNode? {
    var curr: ListNode? = head
    var next: ListNode? = null
    var prev: ListNode? = null

    while (curr != null) {
        next = curr?.next

        curr?.next = prev

        prev = curr
        curr = next
    }
    return prev
}


/**
 * 234. Palindrome Linked List
 */

fun isPalindrome(head: ListNode?): Boolean {
    if (head == null) return true

    var slow = head
    var fast = head?.next
    var count = 0
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast?.next?.next
        count++
    }
    var temp: ListNode? = null
    temp = reverse(slow?.next)
    var res = head
    while (temp != null) {
        if (res?.`val` != temp?.`val`) {
            return false
        }
        temp = temp?.next
        res = res?.next
    }
    return true
}

fun reverse(head: ListNode?): ListNode? {
    var curr: ListNode? = head
    var next: ListNode? = null
    var prev: ListNode? = null
    while (curr != null) {
        next = curr?.next
        curr?.next = prev

        prev = curr
        curr = next
    }
    return prev
}


/**
 * 83. Remove Duplicates from Sorted List
 */


fun deleteDuplicates(head: ListNode?): ListNode? {
    // 1 1 1 2 2 2 3 4 -> 1 2 3 4
    var temp: ListNode? = ListNode(101)
    var curr = temp
    temp?.next = head
    while (curr?.next != null) {
        if (curr?.`val` == curr?.next?.`val`) {
            curr?.next = curr?.next?.next
        } else curr = curr?.next
    }
    return temp?.next
}

/**
 * 21. Merge Two Sorted Lists
 */

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    val result = ListNode(0)
    var l1 = list1
    var l2 = list2
    var current = result

    while (l1 != null && l2 != null) {
        if (l1.`val` < l2.`val`) {
            current.next = l1
            l1 = l1.next
        } else {
            current.next = l2
            l2 = l2.next
        }
        current = current.next!!
    }

    if (l1 != null) current.next = l1
    if (l2 != null) current.next = l2

    return result.next
}

/**
 * 744. Find Smallest Letter Greater Than Target
 */


fun nextGreatestLetter(letters: CharArray, target: Char): Char {
    var tar = target - '0'
    for (i in 0..letters.size - 1) {
        if (tar < (letters[i] - '0')) return letters[i]
    }
    return letters[0]
}


/**
 * O(log n)
 */


fun nextGreatestLetterLogN(letters: CharArray, target: Char): Char {
    val len = letters.size
    var middle = 0
    var left = 0
    var right = len - 1
    while (left != right) {
        middle = (left + right) / 2
        if (letters[middle] <= target) {
            left = middle + 1
        } else {
            right = middle
        }
    }
    if (letters[left] <= target) return letters[0]
    return letters[left]
}

/**
 * BFS - Breath First Search
 * Time - O(n)  Space - O(n)
 */


class TreeNode(val value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun bfs(root: TreeNode?): Int {
    if (root == null) return 0
    var maxLeftTree = bfs(root?.left)
    var maxRightTree = bfs(root?.right)

    return max(maxLeftTree, maxRightTree) + root.value
}



var ans = 0

fun dfs(root: TreeNode?): Int {
    if (root == null) return 0

    var minPathSum = max(dfs(root.left), 0)
    var maxPathSum = max(dfs(root.right), 0)

    ans = max(ans, maxPathSum + minPathSum + root.value)

    return max(minPathSum, maxPathSum) + root.value
}













