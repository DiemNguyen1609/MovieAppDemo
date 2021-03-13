package com.example.repository

import com.example.api.entities.*
import com.example.api.repositores.MovieRepository
import io.reactivex.Flowable

class MovieRepositoryImpl (private val remote : MovieRemoteImpl): MovieRepository {
    override fun requestDiscover(mapRequest: Map<String, String>): Flowable<DiscoverResult> {
        return remote.requestDiscover()
    }

}