package com.example.cnwlc.algorithm.hacker_rank.kakao2

import org.junit.Test
import java.util.*
import kotlin.Comparator
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class TestKotlin {

    @Test
    fun ifKakao() {
        val startTime00 = arrayOf(1, 3, 5)
        val runningTime00 = arrayOf(2, 2, 2)    // 3
        val startTime01 = arrayOf(1)
        val runningTime01 = arrayOf(1)  // 1
        val startTime02 = arrayOf(1, 1, 1, 1, 4)
        val runningTime02 = arrayOf(10, 3, 6, 4, 2) // 2
//        val startTime03 = arrayOf(978,409,229,934,299,982,636,14,866,815,64,537,426,670,116,95,630)
//        val runningTime03 = arrayOf(502,518,196,106,405,452,299,189,124,506,883,753,567,717,338,439,145) // 4

        println(q3(startTime00, runningTime00))
        println(q3(startTime01, runningTime01))
        println(q3(startTime02, runningTime02))
//        println(q3(startTime03, runningTime03))
    }

    fun q3(start_time: Array<Int>, running_time: Array<Int>): Int {
        // Write your code here
        var count = 1

        if (start_time.size == 1) return count

        sort(start_time, running_time)

        start_time.forEach {
            print("$it ")
        }
        println()
        running_time.forEach {
            print("$it ")
        }
        println()

        val result = mutableListOf<Int>()
        for (i in 0 until start_time.size-1) {
            result.add(start_time[i]+running_time[i])

            if (start_time[i+1] != start_time[i]) {
                result.forEach {
                    if (it <= start_time[i+1]) {
                        count++
                    }
                }
                result.clear()
            }
        }

        return count
    }

    private fun sort(arr: Array<Int>, running_time: Array<Int>) {
        for (i in 0 until arr.size-1) {
            for (j in i+1 until arr.size) {
                if (arr[i] > arr[j]) {
                    val temp = arr[j]
                    arr[j] = arr[i]
                    arr[i] = temp

                    val temp2 = running_time[j]
                    running_time[j] = running_time[i]
                    running_time[i] = temp2
                }
            }
        }
    }

    @Test
    fun 카카오_페이징() {
        val test00 = arrayOf(arrayOf("p1","1","2"), arrayOf("p2", "2", "1"))
        val test01 = arrayOf(arrayOf("owjevtkuyv","58584272","62930912"),
                arrayOf("rpaqgbjxik","9425650","96088250"),
                arrayOf("dfbkasyqcn","37469674","46363902"),
                arrayOf("vjrrisdfxe","18666489","88046739"))
        val test02 = arrayOf(arrayOf("owjevtkuyv","58584272","62930912"),
                arrayOf("rpaqgbjxik","9425650","96088250"),
                arrayOf("dfbkasyqcn","37469674","46363902"))

//        println(q2(test00, 0, 0, 1, 0))
//        println(q2(test01, 0, 1, 2, 0))
//        println(q2(test01, 1, 1, 2, 1))
//        println(q2(test01, 2, 1, 2, 0))
        println(q2(test02, 2, 1, 2, 1))
    }
    /*
 * Complete the 'solution' function below.
 *
 * The function is expected to return a STRING_ARRAY.
 * The function accepts following parameters:
 *  1. 2D_STRING_ARRAY items
 *  2. INTEGER orderBy
 *  3. INTEGER orderDirection
 *  4. INTEGER pageSize
 *  5. INTEGER pageNumber
 */

    fun q2(items: Array<Array<String>>, orderBy: Int,
                 orderDirection: Int, pageSize: Int, pageNumber: Int): Array<String> {
        // Write your code here
        println("orderBy = $orderBy")
        items.forEach { array ->
            array.forEach {
                print("it = $it ")
            }
            println()
        }
        println("-----------")
        if (orderBy >= 1) {
            items.sortWith(Comparator { o1, o2 ->
                if (orderDirection == 0) {
                    o1[orderBy].toInt() - o2[orderBy].toInt()
                } else {
                    o2[orderBy].toInt() - o1[orderBy].toInt()
                }
            })
        } else {
            if (orderDirection == 0) {
                items.sortBy {
                    it[orderBy]
                }
            } else {
                items.sortByDescending {
                    it[orderBy]
                }
            }
        }
        items.forEach { array ->
            array.forEach {
                print("it = $it ")
            }
            println()
        }
        println()
        println("-----------")
        println("items.size = ${items.size}, ${(pageNumber+1)*pageSize-1}")

        val start = pageNumber*pageSize
        val end = if (items.size > (pageNumber+1)*pageSize-1) (pageNumber+1)*pageSize-1 else items.size-1
        println("start = $start, end = $end")
        val arr = items.slice(IntRange(start, end))
        val result = mutableListOf<String>()
        arr.forEach { array ->
            result.add(array[0])
        }
        result.forEach {
            println("it = $it")
        }
        return result.toTypedArray()
    }



    @Test
    fun test() {
        val test00 = arrayOf(arrayOf("Apeach","Frodo", "5"), arrayOf("Frodo","Apeach","3"),
        arrayOf("Tube","Apeach","7"), arrayOf("Tube","Apeach","4"), arrayOf("Tube", "Apeach","2"))
        val test01 = arrayOf(arrayOf("Frodo","Apeach","7"), arrayOf("Frodo","Apeach","3"),
        arrayOf("Apeach","Frodo","4"), arrayOf("Frodo","Apeach","1"), arrayOf("Apeach","Frodo","7"))


        println("=====")
        q1(test00).forEach {
            print("it = $it")
        }
        println("")
        println("--------------")
        q1(test01).forEach {
            print("it = $it")
        }
    }

    fun q1(arr: Array<Array<String>>): Array<String> {
        val result = mutableListOf<String>()

        val test: MutableMap<String, Int> = HashMap()
        // 빌려준 사람
        arr.forEach {
            test[it[1]] = test.getOrDefault(it[1], 0)+it[2].toInt()
        }
        // 빌린 사람
        arr.forEach {
            test[it[0]] = test.getOrDefault(it[0], 0)-it[2].toInt()
        }

        var min = Int.MAX_VALUE
        test.map {
            min = Math.min(min, it.value)
        }

        if (min >= 0) {
            return arrayOf("None")
        }

        test.map {
            if (it.value == min) {
                result.add(it.key)
            }
        }

        return result.toTypedArray().sortedArray()
    }
}