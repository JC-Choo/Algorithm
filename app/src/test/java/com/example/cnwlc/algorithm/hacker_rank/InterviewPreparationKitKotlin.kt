package com.example.cnwlc.algorithm.hacker_rank

import org.junit.Test
import java.util.*
import kotlin.math.max
import kotlin.math.min

class InterviewPreparationKitKotlin {

    @Test
    fun arrays_minimumSwaps2() {
//        val scan = Scanner(System.`in`)
//        val n = scan.nextLine().trim().toInt()
//        val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
//        val res = minimumSwaps(arrayOf(1, 3, 5, 2, 4, 6, 7))
        println(""+minimumSwaps(arrayOf(2, 3, 4, 1, 5)))
        println(""+minimumSwaps(arrayOf(1, 3, 5, 2, 4, 6, 7)))
    }

    private fun minimumSwaps(arr: Array<Int>): Int {
        var count = 0

        var number = 1
        var i = 0
        while(i < arr.size-1) {
            if(number != arr[i]) {
                var j = i+1
                while (j < arr.size) {
                    if (number == arr[j]) {
                        val temp = arr[j]
                        arr[j] = arr[i]
                        arr[i] = temp
                        count++
                        break
                    }
                    j++
                }
            }
            i++
            number++
        }

        return count
    }

    // TODO : 모르겠음.....
    @Test
    fun arrays_newYearChaos() {
//        val scan = Scanner(System.`in`)
//        val t = scan.nextLine().trim().toInt()

//        for (tItr in 1..t) {
//            val n = scan.nextLine().trim().toInt()
//            val q = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

        val q = arrayOf(2, 1, 5, 3, 4)
//            minimumBribes(q)
//        }

        minimumBribes(arrayOf(5, 1, 2, 3, 7, 8, 6, 4))
    }

    private fun minimumBribes(q: Array<Int>) {
        var result = 0

        for(i in q.size-1 downTo 0) {
            if(q[i] - (i+1) > 2) {
                println("Too chaotic")
                return
            }
            for(j in max(0, q[i]-2) until i) {
                if(q[j] > q[i])
                    result++
            }
        }

        println(result)
    }


    @Test
    fun arrays_leftRotation() {
//        val scan = Scanner(System.`in`)
//        val nd = scan.nextLine().split(" ")
//        val n = nd[0].trim().toInt()
//        val d = nd[1].trim().toInt()
//        val a = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

        val a = arrayOf(1, 2, 3, 4, 5)
        val d = 4
        val result = rotLeft(a, d)

        println(result.joinToString(" "))
    }

    private fun rotLeft(a: Array<Int>, d: Int): Array<Int> {
        val result: Array<Int> = a.copyOf()

        a.forEachIndexed { index, i ->
            result[(a.size-d+index)%a.size] = i
        }

        return result
    }

    @Test
    fun warmUpChallenge_repeatedString() {
//        val scan = Scanner(System.`in`)
//
//        val s = scan.nextLine()
//
//        val n = scan.nextLine().trim().toLong()

        val result = repeatedString("aab", 13)

        println(result)
        println(repeatedString("abcad", 11))
    }

    private fun repeatedString(s: String, n: Long): Long {
        var result = 0L

        if(s == "a") result = n
        else {
            val share = n/s.length
            val remainder = n%s.length
            println("share = $share, remainder = $remainder")

            s.toCharArray().forEach {
                if(it.toString() == "a") result++
            }
            result *= share
            (0 until remainder.toInt()).forEach {
                if(s.toCharArray()[it].toString() == "a") result++
            }
        }

        return result
    }

    @Test
    fun warmUpChallenge_jumpingOnTheClouds01() {
//        val scan = Scanner(System.`in`)
//
//        val n = scan.nextLine().trim().toInt()
//
//        val c = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

        val c = arrayOf(0, 0, 1, 0, 0, 1, 0)
//        val result = jumpingOnClouds(c, 0, 0)

        println(result)
        println(jumpingOnClouds(arrayOf(0, 0, 0, 1, 0, 0), 0, 0))

    }

    var result = 0
    private fun jumpingOnClouds(c: Array<Int>, i: Int, r: Int): Int {
        result = r
        var index = i

        if (index == c.size-1) {
            return 0
        } else {
            if (index+2 <= c.size-1 &&
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

    @Test
    fun warmUpChallenge_jumpingOnTheClouds02() {
//        val n = readLine()?.toInt()!!
//        val clouds = readLine()?.split(" ")?.map { it.toInt() }!!
        val n = 6
        val arr: List<Int> = arrayOf(0, 0, 1, 0, 1, 0).toList()

        var pos = 0
        var moves = 0

        while(pos < n - 1){
            if(pos == n - 2)
                pos += 1
            else if(arr[pos + 2] == 0)
                pos += 2
            else
                pos += 1
            ++moves
        }
        println(moves)
    }

    @Test
    fun warmUpChallenge_jumpingOnTheClouds03() {
//        val n = readLine()?.toInt()!!
//        val clouds = readLine()?.split(" ")?.map { it.toInt() }!!
        val n = 6
        val clouds: List<Int> = arrayOf(0, 0, 1, 0, 1, 0).toList()

        var count = 0
        var i = 0
        while (i != n-1) {
            count++
            if(i+2 < n && clouds[i+2] != 1) {
                i += 2
            } else {
                i += 1
            }
        }
        println(count)
    }

    @Test
    fun warmUpChallenge_countingValleys() {
//        val scan = Scanner(System.`in`)
//
//        val n = scan.nextLine().trim().toInt()
//
//        val s = scan.nextLine()

        val result = countingValleys(8, "UDDDUDUU")

        println(result)
        println(countingValleys(8, "DUDUUUDDDU"))
    }

    private fun countingValleys(n: Int, s: String?): Any {
        var result = 0

        var count = 0
        var isValley = false
        s?.toCharArray()?.forEach {
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
}