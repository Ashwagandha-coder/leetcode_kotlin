package com.leetcode_kotlin.PalindromeNumber


fun palindromeNumber(x: Int): Boolean {

    var x = x


   if (x < 0 || (x != 0 && x % 10 == 0))
       return false

    var rev = 0

    while (x > rev) {

        rev = rev * 10 + x % 10
        x = x / 10

    }

    return (x == rev || x == rev / 10)




}