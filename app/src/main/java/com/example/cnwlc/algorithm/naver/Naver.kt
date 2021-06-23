package com.example.cnwlc.algorithm.naver

object Naver {
    @JvmStatic
    fun main(args: Array<String>) {
        println(test(intArrayOf(1, 3, 6, 4, 1, 2))) // 5
        println(test(intArrayOf(1, 2, 3)))      // 4
        println(test(intArrayOf(-1, -3)))       // 1
        println(test(intArrayOf(-1, -3, 1)))       // 2

//        println(problem3("aabbb"))  // true
//        println(problem3("ba"))     // false
//        println(problem3("aaa"))    // true
//        println(problem3("b"))      // true
//        println(problem3("abba"))   // false
//
//        println(problem4(6, 1, 1))  // aabaacaa or aacaabaa
//        println(problem4(1, 3, 1))  // abbcb or bcbab or bacbb
//        println(problem4(0, 1, 8))  // ccbcc
    }

    fun problem4(A: Int, B: Int, C: Int): String {
        val a = "a".repeat(A)
        val b = "b".repeat(B)
        val c = "c".repeat(C)
        val text = a+b+c

        val aa = setText(a)
        println("aa = $aa")

        var count = 1
        var str = text[0]
        for (i in 1 until text.length) {
            if (str == text[i]) {
                count++
            }

            println("1 text[$i] = ${text[i]}")
            if (count > 2) {
                swap(text, i)
            }

            println("2 text[$i] = ${text[i]}")
            str = text[i]
        }

        return a
    }

    fun setText(s: String): String {
        val list = s.map { it.toString() }.toMutableList()
        val intList = mutableListOf<Int>()
        if(s.length > 2) {
            for (i in s.indices) {
                if (i != 0 && i%2 == 0) {
                    intList.add(i)
                    list.add(" ")
                }
            }
        }

        var result = ""
        for (i in intList.indices) {
            val temp = list[i]
            list[i]
        }

        list.forEach {
//            result += it
            print("$it ")
        }
        println()

        return result
    }

    fun swap(s: String, i: Int) {
        s.replace(s[i].toString(), s[i-1].toString())
    }

    fun problem3(S: String): Boolean {
        var isCheck = true
        var str = ""
        for (i in 0 until S.length-1) {
            str = S[i].toString()
            for (j in i+1 until S.length) {
                if (str != S[j].toString() && S[j].toString() == "a") {
                    isCheck = false
                }
            }

            if (!isCheck) {
                break
            }
        }
        return isCheck
    }

    /**
     * 없는 것 중 가장 작은 양수 구하기
     */
    fun test(A: IntArray): Int {
        var num = 0
        val a = A.sorted().distinct().filter {
            it > 0
        }
        if (a.isEmpty())
            return 1

        for (i in 0..a.size) {
            if (i >= a.size)
                break

            num++

            if (num != a[i])
                return num
        }
        num++
        return num
    }
}