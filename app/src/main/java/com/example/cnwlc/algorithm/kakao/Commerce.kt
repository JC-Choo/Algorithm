package com.example.cnwlc.algorithm.kakao

object Commerce {
    @JvmStatic
    fun main(args: Array<String>) {
//        println(problem01(intArrayOf(4, 5, 3, 2, 1), intArrayOf(2, 4, 4, 5, 1))) // 1
//        println(problem01(intArrayOf(5, 4, 5, 4, 5), intArrayOf(1, 2, 3, 5, 4))) // 3

        problem02(arrayOf(intArrayOf(1, 0, 0),
                intArrayOf(1, 1, 0),
                intArrayOf(1, 1, 0),
                intArrayOf(1, 0, 1),
                intArrayOf(1, 1, 0),
                intArrayOf(0, 1, 1)), 2)    // 4
    }

    /**
     * 문제 설명
    로봇을 이용하여 여러 종류의 완제품을 만드는 공장을 운영하려고 합니다. 로봇 한 대는 부품 한 종류만 처리할 수 있으며, 완제품의 종류에 따라 필요한 부품이 다를 수 있습니다. 이때, 로봇 r대로 최대한 다양한 완제품을 만들려 합니다.

    예를 들어, 각 완제품을 만들 때 다음과 같은 부품이 필요하고, 살 수 있는 로봇은 최대 두 대라고 가정하겠습니다(번호는 0번부터 시작합니다).

    제한사항
    needs의 세로(행) 길이는 1 이상 1,000 이하입니다.
    세로(행) 길이는 만들 수 있는 완제품의 개수를 나타냅니다.
    행 번호는 완제품의 번호를 의미하며, 0번부터 시작합니다(0행 → 0번 완제품, 1행 → 1번 완제품 ...).
    needs의 가로(열) 길이는 1 이상 15 이하입니다.
    열 번호는 부품 번호를 의미하며, 0번부터 시작합니다.
    needs의 모든 원소는 0 또는 1 입니다.
    needs[x][y] 값이 1이면 x번 물건을 만드는데 y번 부품이 필요하다 의미입니다.
    needs[x][y] 값이 0이면 x번 물건을 만드는데 y번 부품이 필요 없다는 의미입니다.
    번호가 가로(열) 길이 이상인 부품은 모두 필요 없는 것으로 가정하면 됩니다.
    예를 들어, 가로(열) 길이가 3인 경우 0번 ~ 2번 부품에 대한 정보가 주어지며, 3보다 큰 번호의 부품은 모두 필요 없는 것으로 가정하면 됩니다.
    r은 1 이상 needs의 가로(열) 길이 이하인 자연수입니다.
     */
    fun problem02(needs: Array<IntArray>, r: Int): Int {
        var answer = 0

        return answer
    }

    /**
     * 문제 설명
    받을 수 있는 상품 번호가 적혀있는 상품권을 사람들이 각자 하나씩 가지고 있습니다. 사람들은 각자 받고 싶은 상품이 있는데, 자신이 가지고 있는 상품권의 번호가 자신이 받고 싶은 상품의 번호가 아니라면 다른 사람과 교환할 수 있습니다. 이때, 원하지 않는 상품을 받는 사람 수를 최소로 해야 합니다.

    예를 들어 상품권을 가진 사람이 5명이고, 첫 번째 사람부터 가지고 있는 상품권에 적힌 번호가 [4, 5, 3, 2, 1], 각 사람이 받고 싶어 하는 상품 번호가 순서대로 [2, 4, 4, 5, 1]라고 하겠습니다.

    이 경우 다섯 번째 사람은 가지고 있는 상품권에 적힌 번호(1번)가 받고 싶은 상품 번호(1번)와 일치하기 때문에 다른 사람과 교환하지 않아도 됩니다.

    또, 첫 번째, 두 번째, 네 번째 사람의 경우 아래와 같이 상품권을 교환하면 각자 받고 싶은 상품의 번호가 적힌 상품권을 가질 수 있습니다.

    첫 번째 사람과 네 번째 사람의 번호를 교환합니다. (4번 ↔ 2번)
    다시, 두 번째 사람과 네 번째 사람의 번호를 교환합니다. (5번 ↔ 4번)
    이제 각 사람이 가지고 있는 상품권에 적힌 번호는 아래와 같습니다.

    [2, 4, 3, 5, 1]
    세 번째 사람은 4번 상품을 받고 싶지만, 더 교환할 사람이 없습니다. 따라서 원하는 상품을 받을 수 없는 사람은 최소 1명이 됩니다.

    사람들이 가지고 있는 상품권에 적힌 번호가 순서대로 들어있는 배열 gift_cards와 각 사람이 받고 싶어 하는 상품 번호가 순서대로 들어있는 배열 wants가 매개변수로 주어질 때, 원하는 상품을 받지 못하는 사람의 최솟값을 return 하도록 solution 함수를 완성해주세요.



    제한 사항
    gift_cards와 wants의 길이는 1 이상 100,000 이하이며, 두 배열의 길이는 항상 같습니다.
    gift_cards와 wants의 원소는 1 이상 100,000 이하인 자연수입니다.
    모든 상품은 여분없이 각 번호가 적힌 상품권 개수만큼 준비되어 있다고 가정합니다.
     */
    fun problem01(gift_cards: IntArray, wants: IntArray): Int {
        var answer = 0
        swap(gift_cards, wants)
        for (i in gift_cards.indices) {
            if (gift_cards[i] != wants[i]) {
                answer++
            }
        }

        return answer
    }
    fun swap(gift_cards: IntArray, wants: IntArray) {
        for (i in gift_cards.indices) {
            for (j in wants.indices) {
                if (gift_cards[i] == wants[j]) {
                    val temp = gift_cards[j]
                    gift_cards[j] = gift_cards[i]
                    gift_cards[i] = temp
                }
            }
        }
    }
}