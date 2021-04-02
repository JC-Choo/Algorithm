package com.example.cnwlc.algorithm.hacker_rank

import org.junit.Test
import java.util.*

class HackerRankAlgorithmKotlin {
    @Test
    fun strings_palindromeIndex() {
//        val scan = Scanner(System.`in`)
//        val q = scan.nextLine().trim().toInt()
//        for (qItr in 1..q) {
//            val s = scan.nextLine()
//            val result = palindromeIndex(s)
//            println(result)
//        }
//        println(palindromeIndex("aaab"))
//        println(palindromeIndex("baa"))
//        println(palindromeIndex("aaa"))
        println(palindromeIndex("quyjjdcgsvvsgcdjjyq"))
    }

    fun palindromeIndex(s: String): Int {
        var result = -1
        var isNext = false

        for (i in s.indices) {
            if (s[i] != s[s.length - i - 1]) {
                val strFromFront = s.substring(i + 1, s.length - i)
                result = i
                for (index in strFromFront.indices) {
                    if (strFromFront[index] != strFromFront[strFromFront.length - index - 1]) {
                        isNext = true
                        break
                    }
                }

                if (isNext) {
                    val strFromBack = s.substring(i, s.length - i - 1)
                    result = s.length - i - 1
                    for (index in strFromBack.indices) {
                        if (strFromBack[index] != strFromBack[strFromBack.length - index - 1]) {
                            result = -2
                            break
                        }
                    }
                }
                break
            }
        }


        return result
    }

    private fun diagonalDifference(arr: Array<Array<Int>>): Int {
        var resultFromLeftToLeft = 0
        var resultFromRightToRight = 0
        arr.forEachIndexed { index, arr2 ->
            arr2.forEachIndexed { index2, i ->
                if (index == index2) {
                    resultFromLeftToLeft += arr[index][index2]
                }
                if (arr.size - (index + 1) == index2) {
                    resultFromRightToRight += arr[index][index2]
                }
            }
        }

        return Math.abs(resultFromLeftToLeft - resultFromRightToRight)
    }

    @Test
    fun algorithmsWarmUp_DialogDeference() {
        val n = readLine()!!.trim().toInt()
        val arr = Array<Array<Int>>(n, { Array<Int>(n, { 0 }) })

        for (i in 0 until n) {
            arr[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
        }

        val result = diagonalDifference(arr)

        println(result)
    }

    private fun compareTriplets(a: Array<Int>, b: Array<Int>): Array<Int> {
        var resultAlice = 0
        var resultBob = 0
        a.forEachIndexed { index, i ->
            if (i > b[index]) {
                resultAlice++
            } else if (i < b[index]) {
                resultBob++
            }
        }

        return arrayOf(resultAlice, resultBob)
    }

    @Test
    fun algorithmsWarmUp_CompareTheTriplets() {
        val a = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
        val b = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

        val result = compareTriplets(a, b)

        println(result.joinToString(" "))
    }

    private fun simpleArraySum(ar: Array<Int>): Int = ar.sum()

    @Test
    fun algorithmsWarmUp_SimpleArraySum() {
        val scan = Scanner(System.`in`)

        val arCount = scan.nextLine().trim().toInt()

        val ar = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

        val result = simpleArraySum(ar)

        println(result)
    }
}