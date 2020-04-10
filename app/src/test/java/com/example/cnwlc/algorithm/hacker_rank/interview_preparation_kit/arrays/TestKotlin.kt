package com.example.cnwlc.algorithm.hacker_rank.interview_preparation_kit.arrays

import org.junit.Test
import kotlin.math.max

class TestKotlin {
    // region minimum swap 2
    @Test
    fun mainMinimumSwaps2() {
//        val scan = Scanner(System.`in`)
//        val n = scan.nextLine().trim().toInt()
//        val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
//        val res = minimumSwaps(arrayOf(1, 3, 5, 2, 4, 6, 7))
        println(""+minimumSwaps(arrayOf(2, 3, 4, 1, 5)))
        println(""+minimumSwaps(arrayOf(1, 3, 5, 2, 4, 6, 7)))
    }

    private fun minimumSwaps(arr: Array<Int>): Int {
        var count = 0

        var number = 1
        var i = 0
        while(i < arr.size-1) {
            if(number != arr[i]) {
                var j = i+1
                while (j < arr.size) {
                    if (number == arr[j]) {
                        val temp = arr[j]
                        arr[j] = arr[i]
                        arr[i] = temp
                        count++
                        break
                    }
                    j++
                }
            }
            i++
            number++
        }

        return count
    }
    // endregion

    // region new year chaos
    // TODO : 모르겠음.....
    @Test
    fun mainNewYearChaos() {
//        val scan = Scanner(System.`in`)
//        val t = scan.nextLine().trim().toInt()

//        for (tItr in 1..t) {
//            val n = scan.nextLine().trim().toInt()
//            val q = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

        val q = arrayOf(2, 1, 5, 3, 4)
//            minimumBribes(q)
//        }

        minimumBribes(arrayOf(5, 1, 2, 3, 7, 8, 6, 4))
    }

    private fun minimumBribes(q: Array<Int>) {
        var result = 0

        for(i in q.size-1 downTo 0) {
            if(q[i] - (i+1) > 2) {
                println("Too chaotic")
                return
            }
            for(j in max(0, q[i]-2) until i) {
                if(q[j] > q[i])
                    result++
            }
        }

        println(result)
    }
    // endregion

    // region left rotation
    @Test
    fun mainArrays_LeftRotation() {
//        val scan = Scanner(System.`in`)
//        val nd = scan.nextLine().split(" ")
//        val n = nd[0].trim().toInt()
//        val d = nd[1].trim().toInt()
//        val a = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

        val a = arrayOf(1, 2, 3, 4, 5)
        val d = 4
        val result = rotLeft(a, d)

        println(result.joinToString(" "))
    }

    /**
     * 몇번을 왼쪽으로 이동해 나오는 어레이를 구하는 문제
     * 예를 들어, size = 5의 array를 4번 왼쪽 이동하면, index = 0은 index가 0 -> 4 -> 3 -> 2 -> 1로 변경된다.
     * 즉, array[0]은 array[1]로 값이 이동하고, array[1] -> array[2]로 이동한다.
     * 다시 size = 5의 array를 3번 왼쪽 이동하면, index = 0 은 0 -> 4 -> 3 -> 2로 변경
     * 즉, (5-3+index 값)에 size를 나눈 "몫"의 index에 현재 index의 value가 들어간다고 생각하면 된다.
     * (5-3+0)%5 = 2이니 [0]의 값은 [2]로, (5-3+1)%5 = 3이니 [1]의 값은 [3]으로 ... (5-3+4)%5 = 1이니 [4]의 값은 [1]로 이동.
     */
    private fun rotLeft(a: Array<Int>, d: Int): Array<Int> {
        val result: Array<Int> = a.copyOf()

        a.forEachIndexed { index, i ->
            result[(a.size-d+index)%a.size] = i
        }

        return result
    }
    // endregion
}