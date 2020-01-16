package com.example.cnwlc.algorithm

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class SortSelection {
    @Test
    fun test() {
//        val arr1 = intArrayOf()
//        val sortedArr1 = intArrayOf()
//        assertThat(solution(arr1), `is`(sortedArr1))

        val arr2 = intArrayOf(6, 4, 1, 8, 9, 2, 7, 5, 3)
        val sortedArr2 = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        assertThat(solution(arr2), `is`(sortedArr2))

//        val arr3 = intArrayOf(1)
//        val sortedArr3 = intArrayOf(1)
//        assertThat(solution(arr3), `is`(sortedArr3))
    }

    fun solution(arr: IntArray?): IntArray? {
        if (arr == null)
            return null

        var result: IntArray = arr
        var maxPos: Int

        result.forEach { print(it) }
        println("\n----------")

        for (i in 0 until result.size - 1) {
            maxPos = i
            println("1 maxPos = $maxPos")
            for (k in i + 1 until result.size) {
                println("k = $k, ${result[maxPos]}, ${result[k]}")
                if (result[maxPos] > result[k]) {
                    maxPos = k
                    println("2 maxPos = $maxPos. k = $k")
                }
            }
            result = Utils.swapValue(result, i, maxPos)

            println("3 maxPos = $maxPos, i = $i")
            result.forEach { print(it) }
            println("\n----------")
        }
        return result
    }
}