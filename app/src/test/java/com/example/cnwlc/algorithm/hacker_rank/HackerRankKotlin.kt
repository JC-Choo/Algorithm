package com.example.cnwlc.algorithm.hacker_rank

import org.junit.Test
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.LinkedHashMap

class HackerRankKotlin {

    @Test
    fun implementation_equalizeTheArray() {
//        val scan = Scanner(System.`in`)
//        val n = scan.nextLine().trim().toInt()
//        val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
//        val result = equalizeArray(arr)
//        println(result)
        println(equalizeArray(arrayOf(3, 3, 2, 1, 3)))
        println(equalizeArray(arrayOf(1, 2, 3, 1, 2, 3, 3, 3)))
    }

    private fun equalizeArray(arr: Array<Int>): Int {
        val map: HashMap<Int, Int> = LinkedHashMap()
        arr.sortedArrayDescending().forEachIndexed { index, i ->
//            println("index = $index, i = $i")
            map[i] = map.getOrDefault(i, 0)+1
        }

        var maxValue = 0
        for((key, value) in map.entries) {
//            println("key = $key value = $value")
            if(maxValue < value) {
                maxValue = value
            }
        }

        return arr.size - maxValue
    }

    private val day11_2d_arrays: MutableList<Int> = mutableListOf()

    @Test
    fun day11_2d_arrays() {
        val scan = Scanner(System.`in`)

        val arr = Array<Array<Int>>(6, { Array<Int>(6, { 0 }) })

        for (i in 0 until 6) {
//            arr[i] = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
            arr[i] = arrayOf((Math.random() * 10).toInt(), (Math.random() * 10).toInt(), (Math.random() * 10).toInt(), (Math.random() * 10).toInt(), (Math.random() * 10).toInt(), (Math.random() * 10).toInt())
        }

        arr.forEachIndexed { index1, ints ->
            ints.forEachIndexed { index2, i ->
                print("$i ")
            }
            println()
        }
        println()

        val a = catchMaxValue(arr, 0, 0)
//        a.sortedDescending().forEach { println("it = $it") }
        println(a.sortedDescending()[0])
    }

    private fun catchMaxValue(arr: Array<Array<Int>>, inputRow: Int, inputColumn: Int): MutableList<Int> {
        var result = 0

        if (inputRow == 4 && inputColumn == 0) {
            return mutableListOf()
        } else if(inputColumn == 4) {
            catchMaxValue(arr, inputRow + 1, 0)
            return mutableListOf()
        } else {
            for (column in inputColumn..inputColumn + 2) {
                result += arr[inputRow][column]

                if (column == (inputColumn + inputColumn + 2) / 2) {
                    result += arr[inputRow + 1][column]
                }

                result += arr[inputRow + 2][column]

                if(column == inputColumn+2) {
                    day11_2d_arrays.add(result)
                    catchMaxValue(arr, inputRow, inputColumn+1)
                    break
                }
            }

            return day11_2d_arrays
        }
    }

    @Test
    fun day10_binary_numbers() {
//        val scan = Scanner(System.`in`)
//        val n = scan.nextLine().trim().toInt()
        val binaryCharArray = setBinary(524283).toCharArray()
        var result = 1
        var countOfOne = 1
        for (i in 0 until binaryCharArray.size - 1) {
            if (binaryCharArray[i].toString() == "1") {
                if (binaryCharArray[i].toString() == binaryCharArray[i + 1].toString()) {
                    countOfOne++
                    if (countOfOne > result)
                        result = countOfOne
                } else {
                    countOfOne = 1
                }
            } else {
                countOfOne = 1
            }
        }

        println("$result")
    }

    private fun setBinary(n: Int): String {
        var result = ""
        var lastBinary = n

        while (true) {
            result = (lastBinary % 2).toString() + result
            lastBinary /= 2

            if (lastBinary == 1) {
                result = "1$result"
                break
            }
        }

        return result
    }

    @Test
    fun day9_recursion3() {
//        val scan = Scanner(System.`in`)
//
//        val n = scan.nextLine().trim().toInt()
//
        val result = factorial(4)

        println(result)
    }

    private fun factorial(n: Int): Int {
        var result = 1

        for (i in 1..n) {
            result *= i
        }

//        1.rangeTo(n).forEach {
//            result *= it
//        }

        return result
    }

    @Test
    fun day8_dictionaries_and_maps() {
        val scan = Scanner(System.`in`)
        val n = scan.nextLine().trim().toInt()

        val map = HashMap<String, Int>()
//        val comparisonDataList: MutableList<String> = mutableListOf()

        for (i in 0 until 5) {
            val key = scan.next()
            val value = scan.nextInt()
            map[key] = value
//            map["sam_$i"] = (Math.random()*100000000).toInt()
        }

        while (scan.hasNext()) {
            val s = scan.next()
            try {
                val number: Int = map[s]!!
                println("$s=${number}")
            } catch (e: NullPointerException) {
                println("Not found")
            }
        }
    }

    @Test
    fun day7_arrays() {
//        val scan = Scanner(System.`in`)
//
//        val n = scan.nextLine().trim().toInt()
//
//        val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

        val arr = arrayOf(1, 4, 3, 2)
        arr.reversedArray().forEach { print("$it ") }
    }

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

        for (i in 0 until count) {
            val testCase = scan.nextLine().trim()
            println(indexString(testCase))
        }
    }

    private fun indexString(str: String): String {
        var resultOfIndexEven = ""
        var resultOfIndexOdd = ""
        str.forEachIndexed { index, c ->
            if (index % 2 == 0) resultOfIndexEven += c
            else resultOfIndexOdd += c
        }

        return "$resultOfIndexEven $resultOfIndexOdd"
    }

    @Test
    fun day5_loops() {
        val scan = Scanner(System.`in`)

        val n = scan.nextLine().trim().toInt()
        for (i in 1..10) {
            println("$n x $i = ${n * i}")
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

        if (N % 2 == 1) {
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
        val tip = meal_cost * (tip_percent / 100.0)
        val tax = meal_cost * (tax_percent / 100.0)
        val totalCost = Math.round(meal_cost + tip + tax)
        println("tip = $tip, tax = $tax, totalCost = $totalCost")
    }
}