package com.example.api

import io.reactivex.Flowable
import retrofit2.http.*

interface MovieApi {
   // https://api.themoviedb.org/3/discover/movie?api_key=1f5b86b5d2ec241ec5863bc7941fad12&language=en-US&sort_by=popularity.desc&page=1
    @GET("movie?api_key=1f5b86b5d2ec241ec5863bc7941fad12&language=en-US&sort_by=popularity.desc&page=1")
    fun getDiscover(): Flowable<String>

}