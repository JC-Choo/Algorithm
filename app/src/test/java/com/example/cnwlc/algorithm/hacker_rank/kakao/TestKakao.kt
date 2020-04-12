package com.example.cnwlc.algorithm.hacker_rank.kakao

import org.junit.Test
import java.lang.IndexOutOfBoundsException
import java.util.ConcurrentModificationException

class TestKakao {
    @Test
    fun test03() {
//        println(segment(2, arrayOf(1, 2, 3, 1, 2)))    // 3
//        println(segment(2, arrayOf(1, 1, 1)))  // 1
        println(segment(2, arrayOf(2, 5, 4, 6, 8))) // 4
    }

    private fun segment(x: Int, arr: Array<Int>): Int {
        if (x == 1) {
            return arr.max()!!
        }

        var min = 0
        var max = 0
        var i = 0
        while (i < arr.size + 1 - x) {
            val subArray = arr.copyOfRange(i, (i+1)+x-1)
            min = subArray.min()!!
            if(max < min)
                max = min
            i++
        }

        return max
    }

    @Test
    fun test02() {
//        println("test02 result = " + requestsServed(arrayOf(0, 1, 1, 2, 4, 5), arrayOf(5))) // 5
//        println("test02 result = " + requestsServed(arrayOf(1, 2, 2, 3, 4, 5, 6, 6, 13, 16), arrayOf(10, 15))) // 9
//        println("test02 result = " + requestsServed(arrayOf(2, 2, 4, 8, 11, 28, 30), arrayOf(0, 5, 5, 15)))   // 5
        println("test02 result = " + requestsServed(arrayOf(0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1), arrayOf(6, 6, 6, 6)))  // 17

//        println("test02 result = " + requestsServed(arrayOf(0, 1, 1, 2, 4, 5), arrayOf(5))) // 5
    }
    private fun requestsServed(timestamp: Array<Int>, top: Array<Int>): Int {
        var result = 0
        top.forEachIndexed { topIndex, t ->
            if(t != 0) {
                timestamp.filter { it > -1 }.forEachIndexed { index, s ->
                    // 값을 비교하고, 없으면 시간을 비교해
                    if(s >= t) {
                        if (index >= 5) {
                            for (j in index - 5 until index) {
                                result++
                                timestamp[j] = -1
                            }
//                        timestamp.forEach {
//                            println("if it = $it")
//                        }
                        } else if (index == 0) {
                            if (s < t) {
                                result++
                                timestamp[index] = -1
                            }

//                        timestamp.forEach {
//                            println("else if it = $it")
//                        }
                        } else {
                            for (j in 0 until index) {
                                result++
                                timestamp[j] = -1
                            }
//                        timestamp.forEach {
//                            println("else it = $it")
//                        }
                        }
                    }
                }
            }
        }

        return result
    }

//    private fun requestsServed(timestamp: Array<Int>, top: Array<Int>): Int {
//        var result = 0
//
//        top.forEachIndexed { topIndex, t ->
//            println("t = $t")
//            var isOk = false
//            var isAll = false
//
//            timestamp.filter { it > -1 }.forEachIndexed { index, s ->
//                println("s = $s")
//
//                if (!isOk && s >= t) {
//                    println("index = $index")
//                    if (index >= 5) {
//                        for (j in index - 5 until index) {
//                            result++
//                            timestamp[j] = -1
//                        }
////                        timestamp.forEach {
////                            println("if it = $it")
////                        }
//                    } else if (index == 0) {
//                        if (s < t) {
//                            result++
//                            timestamp[index] = -1
//                        }
//
////                        timestamp.forEach {
////                            println("else if it = $it")
////                        }
//                    } else {
//                        for (j in 0 until index) {
//                            result++
//                            timestamp[j] = -1
//                        }
////                        timestamp.forEach {
////                            println("else it = $it")
////                        }
//                    }
//                    isOk = !isOk
//                    isAll = true
////                    println("result = $result, isOk = $isOk")
//                }
//            }
//
//            if (!isAll) {
//                result = timestamp.size
//            }
//        }
//
//        return result
//    }

    @Test
    fun test01() {
        println(splitIntoTwo(arrayOf(10, -5, 6)))
        println(splitIntoTwo(arrayOf(-3, -2, 10, 20, -30)))
    }

    fun splitIntoTwo(arr: Array<Int>): Int {
        var result: Int = 0

        var leftSum = 0
        var rightSum = arr.sum()
        var i = 0
        while (i < arr.size - 1) {
            leftSum += arr[i]
            rightSum -= arr[i]

            if (leftSum > rightSum) {
                result++
            }

            i++
        }

        return result
    }
}