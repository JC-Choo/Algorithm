package com.example.cnwlc.algorithm.sk

object Test {
    @JvmStatic
    fun main(args: Array<String>) {
        println(problem02("4 5 6 - 7 +"))   // 8
        println(problem02("13 DUP 4 POP 5 DUP + DUP + -"))  // 7
        println(problem02("5 6 + -")) // -1
        println(problem02("3 DUP 5 - -")) // -1

        println(problem01("Codility We test coders", 14)) // Codility We
        println(problem01("Why not", 100)) // Why not
        println(problem01("To crop or not to crop", 21)) // To crop or not to

        println(test01(intArrayOf(1, 3, 6, 4, 1, 2)))
        println(test01(intArrayOf(1, 2, 3)))
        println(test01(intArrayOf(-1, -3)))
    }

    private fun problem03() {
        val test = TestJava()
        test.main()
    }

    private fun problem02(S: String): Int {
        val list = mutableListOf<String>()

        S.split(" ").forEach {
            stack(it, list)
            if (list[0] == "-1") {
                return -1
            }
        }

        return list.last().toInt()
    }

    private fun stack(txt: String, list: MutableList<String>) {
        when (txt) {
            "-" -> {
                if (list.size == 1) {
                    list.clear()
                    list.add("-1")
                } else {
                    val answer = list[list.size-1].toInt() - list[list.size-2].toInt()
                    list.removeAt(list.size-2)
                    list.removeAt(list.size-1)
                    list.add(answer.toString())
                }
            }
            "+" -> {
                if (list.size == 1) {
                    list.clear()
                    list.add("-1")
                } else {
                    val answer = list[list.size - 1].toInt() + list[list.size - 2].toInt()
                    list.removeAt(list.size - 2)
                    list.removeAt(list.size - 1)
                    list.add(answer.toString())
                }
            }
            "DUP" -> {
                if (list.size > 0) {
                    val answer = list[list.size-1]
                    list.add(answer)
                } else {
                    list.clear()
                    list.add("-1")
                }
            }
            "POP" -> {
                if (list.size > 0) {
                    list.removeAt(list.size-1)
                } else {
                    list.clear()
                    list.add("-1")
                }
            }
            else -> {
                list.add(txt)
            }
        }
    }

    private fun problem01(message: String, K: Int): String {
        val words = message.split(" ")

        var result = ""

        val cropMessage: String = if (message.length < K) {
            return message
        } else {
            message.substring(0 until K)
        }

        cropMessage.split(" ").forEachIndexed { index, s ->
            if (words[index] == s) result += "$s "
        }

        return result.substring(0 until result.length-1)
    }

    private fun test01(A: IntArray): Int {
        var count = 0
        A.distinct().sorted().filter { it > 0 }.forEach {
            count ++
            if (count != it) {
                return count
            }
        }

        return count + 1
    }
}