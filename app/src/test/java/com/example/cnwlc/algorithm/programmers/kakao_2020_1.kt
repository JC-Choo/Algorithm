package com.example.cnwlc.algorithm.programmers

import org.junit.Test

class Solution {
    @Test
    fun test() {
        println(solution("aabbaccc"))
        println(solution("ababcdcdababcdcd"))
        println(solution("abcabcdede"))
        println(solution("abcabcabcabcdededededede"))
        println(solution("xababcdcdababcdcd"))
    }

    private fun solution(s: String): Int {
        var answer = s.length
//        println("answer = $answer")

        if(answer == 1) return 1

        for(i in 1 .. s.length/2) {
            var count = 1
            var first = s.substring(0, i)
            var result = ""
            var j = i
//            println("first = $first")

            while (j+i <= s.length) {
//                println("i = $i, j = $j, ")
                val comparisonStr = s.substring(j, j+i)
//                println("comparisonStr = $comparisonStr")
//                j += i

                if(first == comparisonStr) {
                    count++
                } else {
                    if(count == 1) {
                        result += first
                        first = comparisonStr
//                        println("else if result = $result, first = $first")
                    } else {
                        result += "${count}${first}"
                        first = comparisonStr
                        count = 1
//                        println("else else result = $result, first = $first, count = $count")
                    }
                }

//                println("result = $result, count = $count. s.substring($j) = ${s.substring(j)}")
                if(j+i >= s.length) {
                    if(count != 1) {
                        result += "$count"+first
                        break
                    } else {
                        result += s.substring(j)
                        break
                    }
                }

                if(s.length-(j+i) == s.length%i) {
                    result += s.substring(j)
                    break
                }
                j += i
            }

            answer = if(answer > result.length) result.length else answer
//            println("answer = $answer, result = $result")
//            println()
        }

        return answer
    }
}