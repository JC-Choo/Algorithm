package com.example.cnwlc.algorithm.hacker_rank.interview_preparation_kit.warm_up_challenge

import org.junit.Test
import java.io.IOException
import java.util.*
import kotlin.collections.HashMap

class TestKotlin {
    // region repeated string
    @Test
    fun mainRepeatedString() {
//        val scan = Scanner(System.`in`)
//        val s = scan.nextLine()
//        val n = scan.nextLine().trim().toLong()
//        val result = repeatedString(s, n)
//        println(result)

        println(repeatedString("aab", 13))
        println(repeatedString("abcad", 11))
    }

    private fun repeatedString(s: String, n: Long): Long {
        var result = 0L

        if(s == "a") result = n
        else {
            val share = n/s.length
            val remainder = (n%s.length).toInt()

            s.forEach {
                if(it.toString() == "a") result++
            }

            result *= share

            (0 until remainder).forEach { index ->
                if(s[index].toString() == "a") result++
            }
        }

        return result
    }
    // endregion

    // region jumping on the clouds
    @Test
    fun mainJumpingOnTheClouds() {
//        val scan = Scanner(System.`in`)
//        val n = scan.nextLine().trim().toInt()
//        val c = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
//        val result = jumpingOnClouds(c, 0, 0)
//        println(result)

        println(jumpingOnClouds(arrayOf(0, 0, 1, 0, 0, 0, 0, 0), 8))
        println(jumpingOnClouds(arrayOf(0, 0, 1, 0, 0, 1, 0), 7))
        println(jumpingOnClouds(arrayOf(0, 0, 0, 1, 0, 0), 6))
        println(jumpingOnClouds(arrayOf(0, 0, 0, 0, 1, 0), 6))
    }

    private fun jumpingOnClouds(c: Array<Int>, n: Int): Int {
        var position = 0
        var count = 0

        while(position < n-1) {
            position +=
                    if(position + 2 < n && c[position+2] != 1) 2
                    else 1
            count++
        }

        return count
    }

    var result = 0
    private fun jumpingOnClouds(c: Array<Int>, i: Int, r: Int): Int {
        result = r
        var index = i

        if (index == c.size - 1) {
            return 0
        } else {
            if (index + 2 <= c.size - 1 &&
                    c[index] == 0 &&
                    c[index] == c[index + 1] &&
                    c[index] == c[index + 2]) {
                result += 1
                index += 2
                jumpingOnClouds(c, index, result)
            } else if (c[index] == 0 &&
                    c[index] == c[index + 1]) {
                result += 1
                index += 1
                jumpingOnClouds(c, index, result)
            } else if (c[index] == 0 &&
                    c[index + 1] == 1) {
                index += 1
                jumpingOnClouds(c, index, result)
            } else if (c[index] == 1 &&
                    c[index + 1] == 0) {
                result += 1
                index += 1
                jumpingOnClouds(c, index, result)
            }

            return result
        }
    }

    // endregion

    // region counting valleys
    @Test
    fun mainCountingValleys() {
//        val scan = Scanner(System.`in`)
//        val n = scan.nextLine().trim().toInt()
//        val s = scan.nextLine()

        val result = countingValleys(8, "UDDDUDUU")

        println(result)
        println(countingValleys(8, "DUDUUUDDDU"))
    }

    private fun countingValleys(n: Int, s: String): Int {
        var result = 0

        var count = 0
        var isValley = false
        s.forEach {
            if (count < 0) {
                isValley = true
            }

            if (it.toString() == "U") count++
            else count--


            if (count == 0 && isValley) {
                result++
                isValley = false
            }
        }

        return result
    }
    // endregion

    // region sockMerchant
    private val scanner = Scanner(System.`in`)

    @Test
    @Throws(IOException::class)
    fun mainSockMerchant() {
        val scan = Scanner(System.`in`)
        val n = scan.nextLine().trim().toInt()
//        val ar = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
//        val result = sockMerchant(n, ar)


        val ar = intArrayOf(10, 20, 20, 10, 10, 30, 50, 10, 20)
        val result = sockMerchant(9, ar)


        println(result)
    }

    // Complete the sockMerchant function below.
    private fun sockMerchant(n: Int, ar: IntArray): Int {
        var result = 0
        val map: HashMap<Int, Int> = HashMap()
        for (value in ar) {
            map[value] = map.getOrDefault(value, 0) + 1
        }
        for (key in map.keys) {
            if (map[key]!! / 2 != 0) result += map[key]!! / 2
        }
        return result
    }
    // endregion
}