package com.example.domain.entities

data class DiscoverResult(
    var results: List<DiscoverItemResult> = emptyList(),
    var page: String = ""
)

data class DiscoverItemResult(
    var backdropPath: String = "",
    var id: String = "",
    var title: String = "",
    var posterPath: String = "",
    var voteAverage: String = ""
)