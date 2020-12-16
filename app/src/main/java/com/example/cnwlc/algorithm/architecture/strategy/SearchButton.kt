package com.example.cnwlc.algorithm.architecture.strategy

@Suppress("RedundantVisibilityModifier")
class SearchButton(private val myProgram: MyProgram) {

    private var searchStrategy: SearchStrategy = SearchStrategyAll()

    public fun setSearchStrategy(_searchStrategy: SearchStrategy) {
        searchStrategy = _searchStrategy
    }

    public fun onClick() {
        searchStrategy.search()
    }
}   