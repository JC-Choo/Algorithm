package com.example.cnwlc.algorithm

import org.junit.Test

class Recursion {
    @Test
    fun test() {
//        println("결과 = ${add(1)}")
//        println("결과 = ${add(3)}")
//        println("결과 = ${add(5)}")
        printChars("abcde")
        println("\n---------------")
        printCharsReverse("abcde")
        println("\n---------------")
    }

    private fun add(num: Int): Int = if(num == 1) {
            1
        } else {
            num+add(num-1)
        }

    // 문자열을 하나씩 출력
    private fun printChars(str: String) {
        if(str.isEmpty()) return
        else {
            print(str[0])
            printChars(str.substring(1))
        }
    }
    // 문자열을 거꾸로(Reverse) 출력
    private fun printCharsReverse(str: String) {
        if(str.isEmpty())
            return
        else {
            printCharsReverse(str.substring(1))
            print(str[0])
        }
    }
}