package com.example.cnwlc.algorithm.naver

import kotlin.math.abs

object Naver210418 {
    @JvmStatic
    fun main(args: Array<String>) {
        println(test05(4, "1B 2C,2D 4D", "2B 2D 3D 4D 4A")) // 1.1
//        println(test05(3, "1A 1B, 2C 2C", "1B")) // 0.1
//        println(test05(12, "1A 2A, 12A 12A", "12A")) // 1.0


//        println(test04(intArrayOf(2, 6, 8, 5))) // 3
//        println(test04(intArrayOf(1, 5, 5, 2, 6))) // 4
//        println(test04(intArrayOf(1, 1))) // 2


//        println(test03(intArrayOf(1, 4, 1), intArrayOf(1, 5, 1))) // 2 -> 0번째 차에 타고 있는 1사람이 1번쨰 차로 이동해 2개의 차로 이동
//        println(test03(intArrayOf(4, 4, 2, 4), intArrayOf(5, 5, 2, 5))) // 3 -> 2번째 차에 타고 있는 2 사람이 0번째와 3번째로 이동해 이동
//        println(test03(intArrayOf(2, 3, 4, 2), intArrayOf(2, 5, 7, 2))) // 2


//        println(test02("FooBar123!"))   // true
//        println(test02("foobar123!"))   // false
//        println(test02("FooBar123"))    // false
//        println(test02("F0bar! F0bar!"))// false
//        println(test02("Fo0*"))         // false


//        println(test01("acb"))
//        println(test01("hot"))
//        println(test01("codility"))
//        println(test01("aaaa"))


//        println(test00(intArrayOf(1, 3, 6, 4, 1, 2)))
//        println(test00(intArrayOf(1, 2, 3)))
//        println(test00(intArrayOf(-1, -3)))
    }

    /**
     * N : 행렬의 수(N = 3 -> 3x3)
     * S : 사각형의 좌측상단 - 우측 하단의 점(1B 2C, 2D, 4D)
     * T : 행렬의 수 타격된 지점 :
     *
     * result : 침몰한 함수의 수.침몰되지 않았지만 타격받은 수
     */
    fun test05(N: Int, S: String, T: String): String {
        val columnList = (65 until 65+N).toList().map { it.toChar().toString() }
        val rowList = (1..N).toList()

        val recList = mutableListOf<MutableList<String>>()
        val rectangles = S.split(",")
        rectangles.forEach { rectanglePosition ->
            val inRecList = mutableListOf<String>()
            val inRowList = mutableListOf<Int>()
            val inColList = mutableListOf<String>()
            val positionStr = rectanglePosition.split(" ")
            positionStr.forEach { str ->
                val a = str.split("").filter { it.isNotBlank() }
                inRowList.add(a[0].toInt())
                inColList.add(a[1])
            }

            inRowList.distinct().forEach { row ->
                inColList.distinct().forEach { col ->
                    inRecList.add("$row$col")
                }
            }

            recList.add(inRecList)
        }

        val result = recList
        val attacks = T.split(" ")

        for (i in attacks.indices) {
            recList.forEach { list ->
                if (list.toString().contains(attacks[i])) {
                    list.remove(attacks[i])
                }
            }
        }
        var att = 0
        var emp = 0
        result.forEachIndexed { index, list ->
            if (list.isEmpty()) {
                emp++
            } else {
                att = list.size - recList[index].size
            }
        }

        return "$att,$emp"
    }

    // 개구리 두마리가 서로 멀어져야 한다.
    // 블럭 단위로 0, 1, 2, 3... 이동하는데, 이동 블럭은 뛰기 전 블록보다 높이가 같거나 커야만 한다.
    // 가장 멀리 떨어진 거리를 구하자.
    fun test04(blocks: IntArray): Int {
        val firstFrog = jumpFirstFrog(blocks)
        val secondFrog = jumpSecondFrog(blocks)
        val result = mutableListOf<Int>()
        for (i in blocks.indices) {
            result.add(firstFrog[i]+secondFrog[i])
        }
        return result.max()?.plus(1) ?: 0
    }
    // 뒤로만 가능
    private fun jumpFirstFrog(blocks: IntArray): MutableList<Int> {
        val list = mutableListOf(0)
        for (i in 1 until blocks.size) {
            var jumpCount = 0
            var block = blocks[i]
            for (j in i-1 downTo 0) {
                if (block <= blocks[j]) {
                    jumpCount++
                    block = blocks[j]
                } else {
                    break
                }
            }
            list.add(jumpCount)
        }
        return list
    }
    // 앞으로만 가능
    private fun jumpSecondFrog(blocks: IntArray): MutableList<Int> {
        val list = mutableListOf<Int>()
        for (i in 0 until blocks.size-1) {
            var jumpCount = 0
            var block = blocks[i]
            for (j in i+1 until blocks.size) {
                if (block <= blocks[j]) {
                    jumpCount++
                    block = blocks[j]
                } else break
            }
            list.add(jumpCount)
        }
        list.add(0)
        return list
    }


    // S[k]만큼의 좌석에 P[k]만큼의 사람이 타 있으니, 옮겨 타서 최소 차량으로 이동하자.
    fun test03(P: IntArray, S: IntArray): Int {
        var carNumber = P.size

        val emptyPersonInCar = arrayOfNulls<Int>(S.size)
        for (i in S.indices) {
            emptyPersonInCar[i] = S[i]-P[i]
        }

        var sum = 0
        emptyPersonInCar.forEach {
            if (it != null) {
                sum += it
            }
        }

        P.sorted().forEach {
            if (it <= sum) {
                sum -= it
                carNumber--
            }
        }


        return carNumber
    }

    // 공간 없고 적어도 6개의 문자, 적어도 1개의 글씨를 포함한. 대무자 하나, 소문자 하나 이상, 특수문자도 포함
    private fun test02(S: String): Boolean {
        if (S.length < 6) return false
        val isValidArr = booleanArrayOf(false, false, true, false, false)
        S.forEach {
            if (!isValidArr[0]) {
                isValidArr[0] = it.isUpperCase()
            }

            if (!isValidArr[1]) {
                isValidArr[1] = it.isLowerCase()
            }

            if (isValidArr[2]) {
                isValidArr[2] = !it.isBlank()
            }

            if (!isValidArr[3]) {
                isValidArr[3] = it.isInt()
            }

            if (!isValidArr[4]) {
                isValidArr[4] = it.isSpecial()
            }
        }

        val a = isValidArr.filter { !it }
        return a.isEmpty()
    }
    private fun Char.isBlank(): Boolean = this.toString() == " "
    private fun Char.isInt(): Boolean = this.toInt() in 48..57
    private fun Char.isSpecial(): Boolean {
        val special = "!@#$%^&*()_"
        for (i in special.indices) {
            if (this == special[i]) {
                return true
            }
        }
        return false
    }

    // 알파벳 순으로 가장 작은 문자열 출력
    private fun test01(S: String): String {
        var resultDiffChar = ""
        var resultDiffInt = Int.MIN_VALUE
        for (i in 0 until S.length-1) {
            val diff = S[i+1]-S[i]
            if (diff < 0) {
                if (resultDiffInt < Math.abs(diff)) {
                    resultDiffChar = S[i].toString()
                    resultDiffInt = Math.abs(diff)
                }
            }
        }

        val result = if (resultDiffInt == Int.MIN_VALUE) {
            S.removeRange(S.length-1, S.length)
        } else {
            S.replace(resultDiffChar, "")
        }

        return result
    }

    private fun test00(arr: IntArray): Int {
        val list = arr.sortedArray().distinct()
        if (list.last() < 1) {
            return 1
        }
        if (list[0] != 1) {
            return 1
        }
        for (i in 0 until list.size-1) {
            if (list[i]+1 != list[i+1]) {
                return list[i]+1
            }
        }

        return list.last()+1
    }
}