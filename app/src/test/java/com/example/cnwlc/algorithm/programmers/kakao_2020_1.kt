package com.example.cnwlc.algorithm.programmers

import org.junit.Test

class Solution {
    /**
     * 제한사항
     * s의 길이는 1 이상 1,000 이하입니다.
     * s는 알파벳 소문자로만 이루어져 있습니다.
     *
     * 입출력 예에 대한 설명
     * 입출력 예 #1 문자열을 1개 단위로 잘라 압축했을 때 가장 짧습니다.
     * 입출력 예 #2 문자열을 8개 단위로 잘라 압축했을 때 가장 짧습니다.
     * 입출력 예 #3 문자열을 3개 단위로 잘라 압축했을 때 가장 짧습니다.
     * 입출력 예 #4 문자열을 2개 단위로 자르면 “abcabcabcabc6de” 가 됩니다. 문자열을 3개 단위로 자르면 “4abcdededededede” 가 됩니다. 문자열을 4개 단위로 자르면 “abcabcabcabc3dede” 가 됩니다. 문자열을 6개 단위로 자를 경우 “2abcabc2dedede”가 되며, 이때의 길이가 14로 가장 짧습니다.
     * 입출력 예 #5 문자열은 제일 앞부터 정해진 길이만큼 잘라야 합니다. 따라서 주어진 문자열을 x / ababcdcd / ababcdcd 로 자르는 것은 불가능 합니다. 이 경우 어떻게 문자열을 잘라도 압축되지 않으므로 가장 짧은 길이는 17이 됩니다.
     *
     * 출제 의도
     * 문자열을 다룰 수 있고, 아래 예시와 같이 문자열과 관련된 다양한 작업을 할 수 있는지 파악
     * 문자열 자르기
     * 부분 문자열 얻기
     * 문자열 비교하기
     * 문자열 길이 얻기
     *
     * 문제 풀이
     * 첫 번째로 배치된, 가장 쉬운 문제입니다.
     * 문자열 길이가 최대 1,000으로 제한이 크지 않기 때문에, 가능한 모든 방법을 탐색하면 됩니다.
     * 문자열 길이가 N일 때, 길이가 N/2 보다 크게 잘랐을 때는 길이가 줄지 않습니다.
     * 따라서 1 ~ N/2 길이로 자르는 방법을 모두 탐색한 후 그중 가장 짧은 방법을 선택하면 됩니다.
     */
    @Test
    fun test() {
        println(solution("aabbaccc"))   // 7
        println(solution("ababcdcdababcdcd"))   // 9
        println(solution("abcabcdede")) // 8
        println(solution("abcabcabcabcdededededede"))   //14
        println(solution("xababcdcdababcdcd"))  //17
    }

    private fun solution(s: String): Int {
        var answer = s.length

        for(i in 1 .. s.length/2) {
            var count = 1
            var first = s.substring(0, i)
            var result = ""

            var j = i
            while (j+i <= s.length) {
                var second = s.substring(j,j+i)

                if(first == second) {
                    count++
                } else {
                    if(count == 1) {
                        result += first
                    } else {
                        result += "$count"+first
                    }
                    first = second
                    count = 1
                }

                if(j+i >= s.length) {
                    if(count == 1) {
                        result += first
                    } else {
                        result += "$count"+second
                    }
                    break
                }

                j += i
                if(s.length-j in 1 until i) {
                    result += if(count == 1) {
                        second + s.substring(j)
                    } else {
                        "$count"+second + s.substring(j)
                    }
                    break
                }
            }

            answer = if(answer > result.length) result.length else answer
        }

        return answer
    }
}