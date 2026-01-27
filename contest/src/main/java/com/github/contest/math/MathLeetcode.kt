package com.github.contest.math


import kotlin.math.abs
import kotlin.math.sqrt

/**
 * 1025. Divisor Game
 */

fun divisorGame(n: Int): Boolean = n % 2 == 0

/**
 * 1780. Check if Number is a Sum of Powers of Three
 */

fun checkPowersOfThree(n: Int): Boolean {
    var num = n
    while (num > 0) {
        if (num % 3 == 2) {
            return false
        }
        num /= 3
    }
    return true
}

/**
 * 2579. Count Total Number of Colored Cells
 */


fun coloredCells(n: Int): Long = when {
    n == 1 -> 1L
    else -> coloredCells(n - 1) + 4L * (n - 1).toLong()
}

/**
 * 2523. Closest Prime Numbers in Range
 */


fun closestPrimes(left: Int, right: Int): IntArray {
    val primes = mutableListOf<Int>()
    val isPrime = BooleanArray(right + 1) { true }
    isPrime[0] = false
    isPrime[1] = false

    for (p in 2..sqrt(right.toDouble()).toInt()) {
        if (isPrime[p]) {
            for (i in p * p..right step p) {
                isPrime[i] = false
            }
        }
    }

    for (p in left..right) {
        if (isPrime[p]) {
            primes.add(p)
        }
    }

    if (primes.size < 2) return intArrayOf(-1, -1)

    var minDiff = Int.MAX_VALUE
    var result = intArrayOf(-1, -1)
    for (i in 0 until primes.size - 1) {
        val diff = primes[i + 1] - primes[i]
        if (diff < minDiff) {
            minDiff = diff
            result[0] = primes[i]
            result[1] = primes[i + 1]
        }
    }

    return result
}

/**
 * 2033. Minimum Operations to Make a Uni-Value Grid
 */

fun minOperations(grid: Array<IntArray>, x: Int): Int {
    val nums = mutableListOf<Int>()
    for (row in grid) {
        for (num in row) {
            nums.add(num)
        }
    }
    nums.sort()
    val n = nums.size
    val median = nums[n / 2]
    var ans = 0
    for (num in nums) {
        val diff = abs(num - median)
        if (diff % x != 0) {
            return -1
        }
        ans += diff / x
    }
    return ans
}

/**
 * 2843. Count Symmetric Integers
 */

fun countSymmetricIntegers(low: Int, high: Int): Int {
    var count = 0

    for (num in low..high) {
        val digits = num.toString().length
        when (digits) {
            2 -> {
                val first = num / 10
                val second = num % 10
                if (first == second) count++
            }

            4 -> {
                val onePart = num / 100
                val twoPart = num % 100
                val first = onePart / 10 + onePart % 10
                val second = twoPart / 10 + twoPart % 10
                if (first == second) count++
            }

            else -> continue
        }
    }

    return count
}

/**
 * 1399. Count Largest Group
 */

fun countLargestGroup(n: Int): Int {
    val freq = IntArray(40)
    var maxCount = 0

    for (i in 1..n) {
        var sum = 0
        var x = i
        while (x > 0) {
            sum += x % 10
            x /= 10
        }
        freq[sum]++
        maxCount = maxOf(maxCount, freq[sum])
    }

    var groupCount = 0
    for (count in freq) if (count == maxCount) groupCount++

    return groupCount
}

/**
 *
 */

fun numberOfPowerfulInt(start: Long, finish: Long, limit: Int, s: String): Long {
    var num = s.toLong()
    var counter = 0L
    var powerful = num
    var factor = 10

    if (num > finish || "$limit$num".toLong() < start) return 0L
    if (start == finish || num == finish) return 1L

    while (num < finish) {
        var count = limit
        powerful = "$count$powerful".toLong()
        while (powerful > finish && count != 0) {
            count--
            powerful = "$count$num".toLong()
        }
        if (count == 0) {

        }
        if (counter == 0L) counter += count
        else {
            val temp = count * factor
            counter += temp
            factor *= 10
        }
        num = powerful
    }

    return if (s.toLong() in start..finish) counter + 1L else counter
}

/**
 * 1295. Find Numbers with Even Number of Digits
 */

val POW = intArrayOf(100_000, 10_000, 1_000, 100, 10, 1)

fun findNumbers(nums: IntArray): Int = nums.filter {
    isEven(it)
}.count()

private fun isEven(num: Int): Boolean {
    var even = true

    for (p in POW) {
        if (num >= p) break
        even = !even
    }

    return even
}

/**
 * 3024. Type of Triangle
 */

fun triangleType(nums: IntArray): String {
    nums.sort()
    val first = nums.first()
    val mid = nums[nums.size / 2]
    val last = nums.last()

    return when {
        first + mid <= last -> "none"
        first == mid && mid == last -> "equilateral"
        first == mid || mid == last -> "isosceles"
        else -> "scalene"
    }
}

/**
 * 2197. Replace Non-Coprime Numbers in Array
 */

fun replaceNonCoPrimes(nums: IntArray): List<Int> {
    if (nums.hasSingle()) return listOf(nums[0])

    val res = mutableListOf<Int>()

    for (num in nums) {
        var currentNum = num
        while (res.isNotEmpty() && isNonCoprime(res.last(), currentNum)) {
            val last = res.removeLast()
            currentNum = lcm(last, currentNum)
        }
        res.add(currentNum)
    }

    return res
}

fun isNonCoprime(first: Int, second: Int) = gcd(first, second) > 1

fun IntArray.hasSingle() = when {
    this.size == 1 -> true
    else -> false
}

fun gcd(first: Int, second: Int): Int {
    if (first == 1 || second == 1) return 1
    if (first == second) return first

    val maxValue = maxOf(first, second)
    val minValue = minOf(first, second)

    if (maxValue % minValue == 0) return minValue

    return gcd(minValue, maxValue % minValue)
}

fun lcm(first: Int, second: Int): Int {
    if (first == second) return first
    val product = (first.toLong() / gcd(first, second)) * second
    return abs(product).toInt()
}

/**
 * 3516. Find Closest Person
 */

fun findClosest(x: Int, y: Int, z: Int): Int {
    val diff1 = abs(x - z)
    val diff2 = abs(y - z)

    return when {
        diff1 < diff2 -> 1
        diff1 > diff2 -> 2
        else -> 0
    }
}

/**
 * 1518. Water Bottles
 */

fun numWaterBottles(numBottles: Int, numExchange: Int): Int {
    var exchanger = numBottles
    var reminder = 0
    var res = numBottles

    while (exchanger != 0) {
        if (exchanger < numExchange) break
        if (exchanger % numExchange == 0) {
            exchanger /= numExchange
            res += exchanger
            exchanger += reminder
            reminder = 0
        } else {
            exchanger--
            reminder++
        }
    }

    return res
}

/**
 * 3100. Water Bottles II
 */

fun maxBottlesDrunk(numBottles: Int, numExchange: Int): Int {
    if (numBottles == numExchange) return numBottles + 1
    if (numBottles < numExchange) return numBottles

    var full = 0
    var empty = numBottles
    var exchange = numExchange
    var drunk = numBottles

    while (empty >= exchange || (empty + full) >= exchange) {
        if (empty >= exchange) {
            empty -= exchange
            exchange++
            full++
        } else {
            drunk += full
            empty += full
            full = 0
        }
    }

    return if (full != 0) drunk + full else drunk

}

/**
 * 168. Excel Sheet Column Title
 */

fun convertToTitle(columnNumber: Int): String = buildString {
    var n = columnNumber

    while (n > 0) {
        n--
        val reminder = n and 26 + 1
        append(Char('A'.code + reminder))
        n /= 26
    }
}.toCharArray().reverse()

fun CharArray.reverse(): String {
    var i = 0
    var j = this.size - 1

    while (i < j) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
        i++
        j--
    }

    return String(this)
}

/**
 * 171. Excel Sheet Column Number
 */

fun titleToNumber(columnTitle: String): Int {
    var sum = 0
    var base = 0

    for (i in columnTitle.length - 1 downTo 0) {
        var value = (columnTitle[i] - 'A' + 1)
        repeat(base) {
            value *= 26
        }
        sum += value
        base++
    }

    return sum
}

/**
 * 43. Multiply Strings
 */


fun multiply(num1: String, num2: String): String {
    if (num1 == "0" || num2 == "0") return "0"

    val n = num1.length
    val m = num2.length
    val res = IntArray(n + m)

    for (i in n - 1 downTo 0) {
        for (j in m - 1 downTo 0) {
            val product = (num1[i] - '0') * (num2[j] - '0')
            val sum = product + res[i + j + 1]

            res[i + j + 1] = sum % 10
            res[i + j] += sum / 10
        }
    }

    return buildString {
        for (digit in res) {
            if (isNotEmpty() || digit != 0) append(digit)
        }
    }
}

/**
 * 507. Perfect Number
 */

fun checkPerfectNumber(num: Int): Boolean {
    if (num == 1) return false

    var sum = 1
    var i = 2

    while (i * i <= num) {
        if (num % i == 0) {
            sum += i

            if (i != num / i) sum += (num / i)
        }
        i++
    }

    return sum == num
}

/**
 * 728. Self Dividing Numbers
 */


fun selfDividingNumbers(left: Int, right: Int): List<Int> {
    val res = mutableListOf<Int>()

    for (num in left..right) {
        if (isSelfDividing(num)) res.add(num)
    }

    return res
}

fun isSelfDividing(number: Int): Boolean {
    var num = number

    while (num != 0) {
        val possible = num % 10
        if (possible == 0 || number % possible != 0) return false
        num /= 10
    }

    return true
}

/**
 * 504. Base 7
 */

fun convertToBase7(num: Int): String = when {
    num < 0 -> "-" + convertToBase7(abs(num))
    num < 7 -> num.toString()
    else -> convertToBase7(num / 7) + convertToBase7(num % 7)
}

/**
 * 3783. Mirror Distance of an Integer
 */

fun mirrorDistance(n: Int): Int = absMirrorDistance(n - reverse(n))

private fun reverse(number: Int): Int {
    var num = number.toLong()
    var res = 0L

    while (num != 0L) {
        res += num % 10
        res *= 10
        num /= 10
    }

    return (res / 10).toInt()
}

private fun absMirrorDistance(number: Int) = when {
    number < 0 -> number * -1
    else -> number
}

/**
 * 371. Sum of Two Integers
 */

fun getSum(a: Int, b: Int): Int {
    var x = a
    var y = b

    while (y != 0) {
        val carry = x and y
        x = x xor y
        y = carry shl 1
    }

    return x
}

/**
 * 89. Gray Code
 */

fun grayCode(n: Int): List<Int> = buildList {
    val size = 1 shl n
    for (num in 0 until size) {
        add(num xor (num shr 1))
    }
}

/**
 * 717. 1-bit and 2-bit Characters
 */

fun isOneBitCharacter(bits: IntArray): Boolean {
    var i = 0

    while (i < bits.size) {
        if (i == bits.size - 1) return true
        when {
            bits[i] == 1 -> i += 2
            else -> i++
        }
    }

    return false
}

/**
 * 908. Smallest Range I
 */

fun smallestRangeI(nums: IntArray, k: Int): Int {
    if (nums.size == 1) return 0

    var max = Int.MIN_VALUE
    var min = Int.MAX_VALUE

    for (num in nums) {
        max = maxOf(max, num)
        min = minOf(min, num)
    }

    min += k
    max -= k
    if (max < min) max = min

    return max - min
}

/**
 * 762. Prime Number of Set Bits in Binary Representation
 */


fun countPrimeSetBits(left: Int, right: Int): Int {
    var count = 0

    for (num in left..right) {
        val countOfBits = countOfBits(num)
        if (isPrime(countOfBits)) count++
    }

    return count
}


private fun isPrime(number: Int): Boolean {
    if (number < 2) return false

    for (num in 2 until number) {
        if (number % num == 0) return false
    }

    return true
}

private fun countOfBits(number: Int): Int {
    var count = 0
    var num = number

    while (num != 0) {
        if (num and 1 == 1) count++
        num = num shr 1
    }

    return count
}






