package com.example.movieappdemo.home.model

import retrofit2.http.Url

data class MovieItemModel(
    val id: String,
    val imgRes: String
)

data class MovieListModel(
    val id: String,
    val title: String,
    val movieList: List<MovieItemModel>
)