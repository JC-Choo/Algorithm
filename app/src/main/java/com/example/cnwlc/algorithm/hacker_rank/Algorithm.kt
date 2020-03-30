package com.example.cnwlc.algorithm.hacker_rank

import java.util.*

class Algorithm {
    fun main(args: Array<String>) {
        val scan = Scanner(System.`in`)

        val arCount = scan.nextLine().trim().toInt()

        val ar = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

        val result = simpleArraySum(ar)

        println(result)
    }

    private fun simpleArraySum(ar: Array<Int>): Int {
        var result = 0
        ar.forEach { result += it }
        return result
    }
}