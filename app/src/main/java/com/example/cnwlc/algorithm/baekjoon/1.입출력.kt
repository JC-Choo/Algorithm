package com.example.cnwlc.algorithm.baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * https://steady-coding.tistory.com/260
 */
object 입출력 {
    @JvmStatic
    fun main(args: Array<String>) {
        p10818()
    }

    fun p2557() {
        print("Hello World!")
    }

    fun p1000() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val token = StringTokenizer(br.readLine())
        println(Integer.parseInt(token.nextToken()) + Integer.parseInt(token.nextToken()))
        br.close()
    }

    fun p2558() {
        val sc = Scanner(System.`in`)
        val a = sc.nextInt()
        val b = sc.nextInt()
        println(a + b)
    }

    fun p10950() {
        val sc = Scanner(System.`in`)
        val testCase = sc.nextInt()

        val list = mutableListOf<Pair<Int, Int>>()
        for (i in 0 until testCase) {
            val a = sc.nextInt()
            val b = sc.nextInt()
            list.add(Pair(a, b))
        }

        list.forEach { println(it.first + it.second) }
    }

    fun p10951() {
        val sc = Scanner(System.`in`)
        while (sc.hasNextInt()) {
            val a = sc.nextInt()
            val b = sc.nextInt()
            println(a+b)
        }
    }

    fun p10952() {
        val sc = Scanner(System.`in`)
        while (sc.hasNextInt()) {
            val a = sc.nextInt()
            val b = sc.nextInt()

            if (a == 0 && b == 0)
                break
            println(a+b)
        }
    }

    fun p10953() {
        val sc = Scanner(System.`in`)
        val testCase = sc.nextLine()
        for (i in 0 until testCase.toInt()) {
            val line = sc.nextLine()
            val number = line.split(",")
            println(number[0].toInt()+number[1].toInt())
        }
    }

    fun p11021() {
        val sc = Scanner(System.`in`)
        val testCase = sc.nextLine()
        for (i in 0 until testCase.toInt()) {
            val number = sc.nextLine().split(" ")
            println("Case #${i+1}: ${number[0].toInt()+number[1].toInt()}")
        }
    }

    fun p11022() {
        val sc = Scanner(System.`in`)
        val testCase = sc.nextLine()
        for (i in 0 until testCase.toInt()) {
            val number = sc.nextLine().split(" ")
            val a = number[0].toInt()
            val b = number[1].toInt()
            println("Case #${i+1}: $a + $b = ${a+b}")
        }
    }

    fun p11718() {
        val sc = Scanner(System.`in`)
        while (sc.hasNext()) {
            val text = sc.nextLine()
            println(text)
        }
        sc.close()
    }

    fun p11719() {
        val sc = Scanner(System.`in`)
        while (sc.hasNext()) {
            val text = sc.nextLine()
            println(text)
        }
        sc.close()
    }

    fun p11720() {
        val sc = Scanner(System.`in`)
        val N = sc.nextInt()
        val s = sc.next()
        var sum = 0
        for (i in 0 until N) {
            sum += s[i].toString().toInt()
        }
        println(sum)
        sc.close()
    }

    fun p11721() {
        val sc = Scanner(System.`in`)
        val text = sc.nextLine()
        var str10 = ""
        for (i in text.indices) {
            str10 += text[i].toString()
            if (str10.length == 10) {
                println(str10)
                str10 = ""
            }
        }
        println(str10)
        sc.close()
    }

    fun p2741() {
        val sc = Scanner(System.`in`)
        val data = sc.nextInt()
        for (i in 1 .. data) {
            println(i)
        }
    }

    fun p2742() {
        val sc = Scanner(System.`in`)
        val data = sc.nextInt()
        for (i in data downTo 1) {
            println(i)
        }
    }

    fun p2739() {
        val sc = Scanner(System.`in`)
        val data = sc.nextInt()
        for (i in 1 .. 9) {
            println("$data * $i = ${data*i}")
        }
    }

    fun p1924() {
        val months = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
        val daysOfMonth = intArrayOf(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
        val days = arrayOf("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT")

        val sc = Scanner(System.`in`)
        val month = sc.nextInt()
        val day = sc.nextInt()

        var sum = 0
        for (i in 0 until month) {
            sum += daysOfMonth[i]
        }
        sum += day

        println(days[sum%7])
    }

    fun p8393() {
        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        var sum = 0
        for (i in 1..n) {
            sum += i
        }
        println(sum)
    }

    fun p10818() {
        val sc = Scanner(System.`in`)
        val n = sc.nextInt()

        val list = mutableListOf<Int>()

        for (i in 0 until n) {
            list.add(sc.nextInt())
        }

        val result = list.sorted()

        println(""+result[0]+" "+result[result.size-1])
    }
}