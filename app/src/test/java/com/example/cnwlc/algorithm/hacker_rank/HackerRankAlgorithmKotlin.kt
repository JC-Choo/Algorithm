package com.example.cnwlc.algorithm.hacker_rank

import org.junit.Test
import java.util.*

class HackerRankAlgorithmKotlin {
    private fun diagonalDifference(arr: Array<Array<Int>>): Int {
        var resultFromLeftToLeft = 0
        var resultFromRightToRight = 0
        arr.forEachIndexed { index, arr2 ->
            arr2.forEachIndexed { index2, i ->
                if(index == index2) {
                    resultFromLeftToLeft += arr[index][index2]
                }
                if(arr.size-(index+1) == index2) {
                    resultFromRightToRight += arr[index][index2]
                }
            }
        }

        return Math.abs(resultFromLeftToLeft-resultFromRightToRight)
    }

    @Test
    fun algorithmsWarmUp_DialogDeference() {
        val n = readLine()!!.trim().toInt()
        val arr = Array<Array<Int>>(n, { Array<Int>(n, { 0 }) })

        for (i in 0 until n) {
            arr[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
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
        val a = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
        val b = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

        val result = compareTriplets(a, b)

        println(result.joinToString(" "))
    }

    private fun simpleArraySum(ar: Array<Int>): Int = ar.sum()

    @Test
    fun algorithmsWarmUp_SimpleArraySum() {
        val scan = Scanner(System.`in`)

        val arCount = scan.nextLine().trim().toInt()

        val ar = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

        val result = simpleArraySum(ar)

        println(result)
    }
}