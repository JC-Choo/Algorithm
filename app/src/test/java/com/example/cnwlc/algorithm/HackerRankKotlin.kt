package com.example.cnwlc.algorithm

import org.junit.Test
import java.util.*
import kotlin.math.roundToInt

class HackerRankKotlin {
    // Complete the compareTriplets function below.
    fun compareTriplets(a: Array<Int>, b: Array<Int>): Array<Int> {
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
    fun main() {
        val a = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
        val b = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

        val result = compareTriplets(a, b)

        println(result.joinToString(" "))
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