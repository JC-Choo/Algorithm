package com.example.cnwlc.algorithm.hacker_rank

import org.junit.Test
import java.util.*

class HackerRankKotlin {

    @Test
    fun day6_lets_review() {
        val test01 = "Hacker"
        val test02 = "Rank"
        val test03 = "ivvkxq"
        val test04 = "ivvkx"

        println(indexString(test01))
        println(indexString(test02))
        println(indexString(test03))
        println(indexString(test04))

        val scan = Scanner(System.`in`)
        val count = scan.nextLine().trim().toInt()

        for(i in 0 until count) {
            val testCase = scan.nextLine().trim()
            println(indexString(testCase))
        }
    }

    private fun indexString(str: String): String {
        var resultOfIndexEven = ""
        var resultOfIndexOdd = ""
        str.forEachIndexed { index, c ->
            if(index%2 == 0) resultOfIndexEven += c
            else resultOfIndexOdd += c
        }

        return "$resultOfIndexEven $resultOfIndexOdd"
    }

    @Test
    fun day5_loops() {
        val scan = Scanner(System.`in`)

        val n = scan.nextLine().trim().toInt()
        for(i in 1..10) {
            println("$n x $i = ${n*i}")
        }
    }

    @Test
    fun day3_intro_to_conditional_statements() {
        //If  is odd, print Weird
        //If  is even and in the inclusive range of 2 to 5, print Not Weird
        //If  is even and in the inclusive range of 6 to 20, print Weird
        //If  is even and greater than 20, print Not Weird

        val scan = Scanner(System.`in`)
        val N = scan.nextLine().trim().toInt()

        if(N%2 == 1) {
            print("Weird")
        } else {
            when (N) {
                in 2..5 -> {
                    print("Not Weird")
                }
                in 6..20 -> {
                    print("Weird")
                }
                else -> {
                    print("Not Weird")
                }
            }
        }
    }

    @Test
    fun day2_operators() {
//        val scan = Scanner(System.`in`)
//        val meal_cost = scan.nextLine().trim().toDouble()
//        val tip_percent = scan.nextLine().trim().toInt()
//        val tax_percent = scan.nextLine().trim().toInt()
        solve(12.00, 20, 8)
    }

    private fun solve(meal_cost: Double, tip_percent: Int, tax_percent: Int): Unit {
        val tip = meal_cost*(tip_percent/100.0)
        val tax = meal_cost*(tax_percent/100.0)
        val totalCost = Math.round(meal_cost + tip + tax)
        println("tip = $tip, tax = $tax, totalCost = $totalCost")
    }
}