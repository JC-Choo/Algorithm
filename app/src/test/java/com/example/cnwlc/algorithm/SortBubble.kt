package com.example.cnwlc.algorithm

import com.example.cnwlc.algorithm.Utils.Companion.swapValue
import org.junit.Test

import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat

class SortBubble {
    @Test
    fun test() {
        val arr = intArrayOf(6, 4, 1, 8, 9, 2, 7, 5, 3)

        arr.forEach { print("$it") }
        println("")

        sort(arr)

//        arr.forEach { print("$it") }
//        println("")
    }

    private fun sort(arr: IntArray): IntArray {
        for(i in 0 until arr.size-1) {
            for(j in i+1 until arr.size) {
                println("i = $i, j = $j, arr[$i] = ${arr[i]}, arr[$j] = ${arr[j]}")
                if(arr[i] > arr[j]) {
                    swapValue(arr, i, j)
                    arr.forEach { print(it) }
                    println("\n---------------")
                }
            }
        }

        return arr
    }
}