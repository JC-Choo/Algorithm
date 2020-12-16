@file:Suppress("RedundantVisibilityModifier")

package com.example.cnwlc.algorithm.architecture.strategy

interface SearchStrategy {
    public fun search()
}

class SearchStrategyAll : SearchStrategy {
    override fun search() {
        println("Search All")
        // 전체 검색하는 코드
    }
}

class SearchStrategyImage : SearchStrategy {
    override fun search() {
        println("Search Image")
        // 이미지 검색하는 코드
    }
}

class SearchStrategyNews : SearchStrategy {
    override fun search() {
        println("Search News")
        // 뉴스 검색하는 코드
    }
}

class SearchStrategyMap : SearchStrategy {
    override fun search() {
        println("Search Map")
        // 지도 검색하는 코드
    }
}