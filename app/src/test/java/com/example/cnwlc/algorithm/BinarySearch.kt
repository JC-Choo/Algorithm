package com.example.cnwlc.algorithm

import org.junit.Test

class BinarySearch {
    @Test
    fun test() {
        // 정렬되어있을 경우
        val arr = intArrayOf(17, 28, 43, 67, 88, 92, 100)
        val result = binarySearch(arr, 92)
        println("result = $result")

        // 정렬되어있지 않을 경우(arr 결과)
        val arr2 = intArrayOf(6, 4, 1, 8, 9, 2, 7, 5, 3)
        val result2 = binarySearch(arr2, 5)
        println("result2 = $result2")

        // 정렬되어있지 않을 경우(정렬 후 x 대한 sort arr 결과)
        val result3 = binarySearch(sort(arr2), 5)
        println("result3 = $result3")
    }

    private fun binarySearch(arr: IntArray, x: Int): Int {
        arr.forEach { print(it) }
        println("")
        var low = 0
        var high = arr.size

        while (low <= high) {
            val mid = (low+high)/2
            if(arr[mid] == x) return mid

            if(arr[mid] > x) high = mid - 1
            else low = mid + 1
        }

        return -1
    }

    private fun sort(arr: IntArray): IntArray {
        for(i in 0 until arr.size-1) {
            for(j in i+1 until arr.size) {
                if(arr[i] > arr[j]) {
                    val temp = arr[i]
                    arr[i] = arr[j]
                    arr[j] = temp
                }
            }
        }

        return arr
    }
}