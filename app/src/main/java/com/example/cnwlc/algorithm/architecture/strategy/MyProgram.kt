package com.example.cnwlc.algorithm.architecture.strategy

@Suppress("RedundantVisibilityModifier")
class MyProgram {
    private val searchButton: SearchButton = SearchButton(this)

    public fun setModeAll() {
        searchButton.setSearchStrategy(SearchStrategyAll())
    }

    public fun setModeImage() {
        searchButton.setSearchStrategy(SearchStrategyImage())
    }

    public fun setModeNews() {
        searchButton.setSearchStrategy(SearchStrategyNews())
    }

    public fun setModeMap() {
        searchButton.setSearchStrategy(SearchStrategyMap())
    }
    ​
    public fun testProgram() {
        searchButton.onClick()   // "SEARCH ALL" 출력
        setModeImage()           // 이미지검색 모드로
        searchButton.onClick()   // "SEARCH IMAGE" 출력
        setModeNews()            // 뉴스검색 모드로
        searchButton.onClick()   // "SEARCH NEWS" 출력
        setModeMap()             // 지도검색 모드로
        searchButton.onClick()   // "SEARCH MAP" 출력
    }
}