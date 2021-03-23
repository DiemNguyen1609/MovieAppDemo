package com.example.movieappdemo.home.model


data class MovieItemModel(
    val id: String,
    val imgRes: String,
    val title: String
)

data class MovieListModel(
    val id: String,
    val title: String,
    val movieList: List<MovieItemModel>
)