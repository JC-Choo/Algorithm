package com.example.cnwlc.algorithm.hacker_rank

import org.junit.Test
import java.util.*

class HackerRankDataStructuresKotlin {

    private fun hourglassSum(arr: Array<Array<Int>>): Int {
//        arr.forEachIndexed { index, arr2 ->
//            arr2.forEachIndexed { index2, i ->
//                print(" ${arr[index][index2]} ")
//            }
//            println()
//        }

        val newArray: MutableList<Int> = mutableListOf()
        for(index in 0 until 16) {
            val arrI = index/4
            val arrJ = index%4
            newArray.add((arr[arrI][arrJ] + arr[arrI][arrJ+1] + arr[arrI][arrJ+2]) +
                    arr[arrI+1][arrJ+1] +
                    (arr[arrI+2][arrJ] + arr[arrI+2][arrJ+1] + arr[arrI+2][arrJ+2]))
        }
        newArray.sortDescending()
        return newArray[0]
    }

    @Test
    fun dataStructures_2DArrayDS() {
//        val scan = Scanner(System.`in`)

        val arr = Array<Array<Int>>(6, { Array<Int>(6, { 0 }) })

        for (i in 0 until 6) {
//            arr[i] = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
            arr[i] = arrayOf((Math.random()* 10).toInt(), (Math.random()* 10).toInt(), (Math.random()* 10).toInt(), (Math.random()* 10).toInt(), (Math.random()* 10).toInt(), (Math.random()* 10).toInt())
        }

        val result = hourglassSum(arr)

        println(result)
    }

    private fun reverseArray(a: Array<Int>): Array<Int> {
        return a.reversedArray()
    }

    @Test
    fun dataStructures_ArraysDs() {
        val scan = Scanner(System.`in`)

        val arrCount = scan.nextLine().trim().toInt()

        val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

        val res = reverseArray(arr)

        println(res.joinToString(" "))
    }
}