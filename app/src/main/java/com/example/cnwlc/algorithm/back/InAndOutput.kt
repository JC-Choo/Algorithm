package com.example.cnwlc.algorithm.back

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * https://steady-coding.tistory.com/260
 */
object InAndOutput {
    @JvmStatic
    fun main(args: Array<String>) {
        p11021()
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
}