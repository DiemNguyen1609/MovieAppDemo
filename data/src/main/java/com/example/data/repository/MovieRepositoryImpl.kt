package com.example.data.repository

import com.example.domain.repositores.MovieRepository
import com.example.domain.entities.DiscoverResult
import io.reactivex.Flowable

class MovieRepositoryImpl (private val remote : MovieRemoteImpl): MovieRepository {
    override fun requestDiscover(mapRequest: Map<String, String>): Flowable<DiscoverResult> {
        return remote.requestDiscover()
    }

}