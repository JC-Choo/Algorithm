package com.example.cnwlc.algorithm

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class Utils {
    /*
        TASK
        swap util 분리
     */
    @Test
    fun test() {
        val arr = intArrayOf(1, 2, 3)
        val chagedArr = intArrayOf(1, 3, 2)
        assertThat(swapValue(arr, 1, 2), `is`(chagedArr))
    }

    companion object {
        fun swapValue(arr: IntArray, a: Int, b: Int): IntArray {
            val temp = arr[a]
            arr[a] = arr[b]
            arr[b] = temp
            return arr
        }

        fun swapValue(arr: CharArray, a: Int, b: Int): CharArray {
            val temp = arr[a]
            arr[a] = arr[b]
            arr[b] = temp
            return arr
        }
    }
}