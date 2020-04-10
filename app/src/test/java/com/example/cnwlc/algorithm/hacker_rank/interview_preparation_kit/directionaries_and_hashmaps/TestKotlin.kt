package com.example.cnwlc.algorithm.hacker_rank.interview_preparation_kit.directionaries_and_hashmaps

import org.junit.Test
import java.lang.Exception
import java.util.*
import java.util.concurrent.CopyOnWriteArraySet
import kotlin.collections.HashMap
import kotlin.collections.LinkedHashMap

class TestKotlin {

    // region count triplets
    @Test
    fun mainCountTriplets() {
//        val nr = readLine()!!.trimEnd().split(" ")
//        val n = nr[0].toInt()
//        val r = nr[1].toLong()
//        val arr = readLine()!!.trimEnd().split(" ").map{ it.toLong() }.toTypedArray()
//        val ans = countTriplets(arr, n, r)
//        println(ans)


        println(countTriplets(arrayOf(100, 100, 100, 100, 100
                , 100, 100, 100, 100, 100
                , 100, 100, 100, 100, 100
                , 100, 100, 100, 100, 100
                , 100, 100, 100, 100, 100
                , 100, 100, 100, 100, 100
                , 100, 100, 100, 100, 100
                , 100, 100, 100, 100, 100
                , 100, 100, 100, 100, 100
                , 100, 100, 100, 100, 100
                , 100, 100, 100, 100, 100
                , 100, 100, 100, 100, 100
                , 100, 100, 100, 100, 100
                , 100, 100, 100, 100, 100
                , 100, 100, 100, 100, 100
                , 100, 100, 100, 100, 100
                , 100, 100, 100, 100, 100
                , 100, 100, 100, 100, 100
                , 100, 100, 100, 100, 100
                , 100, 100, 100, 100, 100), 1))

        val n = 100000
        val r = 1L
        val arr: MutableList<Long> = mutableListOf()
        for (i in 0 until n) {
            arr.add(1237 * r)
        }
        println(countTriplets(arr.toTypedArray(), r))
        println(countTriplets(arrayOf(1, 2, 2, 4), 2))
        println(countTriplets(arrayOf(1, 3, 9, 9, 27, 81), 3))
        println(countTriplets(arrayOf(1, 5, 5, 25, 125), 5))
    }

    private fun countTriplets(arr: Array<Long>, r: Long): Long {
        // Geometric progression : a, ar, ar2, ar3, ar4...

        var result = 0L

        var i = 0
        while (i < arr.size - 2) {
            if (arr[0] == arr[1]) {
                result = (arr.size.toLong() * (arr.size - 1) * (arr.size - 2) / (3 * 2 * 1))
                break
            } else {
                var j = i + 1
                while (j < arr.size - 1) {
                    if (arr[i] * r == arr[j]) {
                        var k = j + 1
                        while (k < arr.size) {
                            if (arr[j] * r == arr[k]) {
                                result++
                            }
                            k++
                        }
                    }
                    j++
                }
            }
            i++
            if (result == 0L) break
        }

        return result

    }
    // endregion

    // region SherlockAndAnagrams
    // TODO : 모르겠음
    @Test
    fun mainSherlockAndAnagrams() {
//        val scan = Scanner(System.`in`)
//        val q = scan.nextLine().trim().toInt()
//
//        for (qItr in 1..q) {
//            val s = scan.nextLine()
//            val result = sherlockAndAnagrams(s)
//            println(result)
//        }

        println(sherlockAndAnagrams("abba"))
        println(sherlockAndAnagrams("abcd"))
        println(sherlockAndAnagrams("ifailuhkqq"))
        println(sherlockAndAnagrams("kkkk"))
        println(sherlockAndAnagrams("cdcd"))
        println(sherlockAndAnagrams("ifailuhkqqhucpoltgtyovarjsnrbfpvmupwjjjfiwwhrlkpekxxnebfrwibylcvkfealgonjkzwlyfhhkefuvgndgdnbelgruel"))
    }

    private fun sherlockAndAnagrams(s: String): Int {
        var result = 0

        val map: LinkedHashMap<String, String> = LinkedHashMap()
        for (i in 0 until s.length - 1) {
            for (j in i + 1 until s.length) {
                val first = s.substring(i, j)
                map["$i$j"] = first

                for (k in j + 1..s.length) {
                    val second = if (k == s.length) s.substring(j) else s.substring(j, k)
                    map["$j$k"] = second
                }
            }
        }

        val linkedList: MutableList<String> = mutableListOf()
        for ((key, value) in map.entries) {
            linkedList.add(value)
        }

        // list의 0부터 size-1까지의 값들을 비교하기 위한 for문
        for(i in 0 until linkedList.size-1) {
            var first = linkedList[i]

            // list의 i+1 부터  size 까지의 값들을 비교하기 위한 for문
            for(j in i+1 until linkedList.size) {
                var isNotContains = false
                val second = linkedList[j]
                if(first.length == second.length) {
                    if(first != second) {
                        var third = first
                        for (k in second.indices) {
                            if (!third.contains(second.toCharArray()[k])) {
                                isNotContains = true
                                break
                            } else {
                                third = third.replaceFirst(second.toCharArray()[k].toString(), "", false)
                            }
                        }
                    }

                    if(!isNotContains) {
                        result++
                    }
                }
            }
        }


//        val iterator = map.entries.iterator()
//        try {
//            while (iterator.hasNext()) {
//                val iteratorFirst = iterator.next()
//                println("1 key = ${iteratorFirst.key}, value = ${iteratorFirst.value}")
//                val firstValue = iteratorFirst.value
////                val iterator2 = map.iterator()
//
//                while (iterator.hasNext()) {
//                    val iteratorNext = iterator.next()
//                    println("2 key = ${iteratorNext.key}, value = ${iteratorNext.value}")
//                    if (iteratorFirst.value == iteratorNext.value.reversed()) {
//                        result++
//                    }
//                }
//            }
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }




        return result
    }

    private fun removeMap(map: LinkedHashMap<String, String>, result: Int): Int {
//        var count = result
//        println("count = $result, map = ${map.isEmpty()}")
        if (map.isEmpty()) {
            return result
        } else {
            val iterator = map.entries.iterator()
            try {
                while (iterator.hasNext()) {
//                for(key in map.keys) {
                    val iteratorNext = iterator.next()
//                    println("key = ${iteratorNext.key}, value = ${iteratorNext.value}")
                    var isRemove = false
                    var isBreak = false
                    val firstValue = iteratorNext.value
                    map.remove(iteratorNext.key)


                    val iterator2 = map.iterator()
                    while (iterator2.hasNext()) {
                        val iteratorNext2 = iterator2.next()

//                    for(key2 in map.keys) {
//                        println("key2 = ${iteratorNext2.key}, value = ${iteratorNext2.value}")

                        if (firstValue == iteratorNext2.value.reversed()) {
                            isRemove = true
                            isBreak = true
//                            println("if isRemove = $isRemove")
//                            result++
                            map.remove(iteratorNext2.key)
//                            removeMap(map, count)
                            break
                        }
//                    }

                    }

                    if (isBreak) {
                        isBreak = false
                        return result + removeMap(map, result + 1)
                    }
//                    println("isRemove = $isRemove")
                    if (!isRemove)
                        removeMap(map, result)
//                }
                }

                return result
            } catch (e: ConcurrentModificationException) {
                return result
            }
        }
    }
    // endregion

    // region two strings
    @Test
    fun mainTwoStrings() {
//        val scan = Scanner(System.`in`)
//        val q = scan.nextLine().trim().toInt()
//        for (qItr in 1..q) {
//            val s1 = scan.nextLine()
//            val s2 = scan.nextLine()
//            val result = twoStrings(s1, s2)
//            println(result)
//        }

        println(twoStrings("hello", "world"))
        println(twoStrings("hi", "world"))
    }

    private fun twoStrings(s1: String, s2: String): String {
//        s1.map {
//            if(s2.contains(it)) return "YES"
//        }

        val map: HashMap<String, Int> = HashMap()
        for (i in s1.indices) {
            map[s1[i].toString()] = map.getOrDefault(s1[i].toString(), 1)
        }

        for (key in map.keys) {
            if (s2.contains(key))
                return "YES"
        }

        return "NO"
    }
    // endregion

    // region HashTables_RansomNote
    @Test
    fun mainHashTables_RansomNote() {
//        val scan = Scanner(System.`in`)
//        val mn = scan.nextLine().split(" ")
//        val m = mn[0].trim().toInt()
//        val n = mn[1].trim().toInt()
//
//        val magazine = scan.nextLine().split(" ").toTypedArray()
//        val note = scan.nextLine().split(" ").toTypedArray()

//        checkMagazine(magazine, note)
        checkMagazine(arrayOf("give", "me", "one", "grand", "today", "night"), arrayOf("give", "one", "grand", "today"))
        checkMagazine(arrayOf("two", "times", "three", "is", "not", "four"), arrayOf("two", "times", "two", "is", "four"))
        checkMagazine(arrayOf("two", "times", "two", "is", "four", "!!"), arrayOf("two", "times", "two", "is", "four"))
    }

    private fun checkMagazine(magazine: Array<String>, note: Array<String>): Unit {
        val magazineMap: HashMap<String, Int> = HashMap()
        magazine.forEach {
            magazineMap[it] = magazineMap.getOrDefault(it, 0) + 1
        }

        for (str in note) {
            magazineMap.getOrElse(str) {
                println("No")
                return
            }

            val count = magazineMap[str]?.minus(1)!!
            if (count == 0) {
                magazineMap.remove(str)
            } else {
                magazineMap[str] = count
            }
        }

        println("Yes")
    }
    // endregion
}