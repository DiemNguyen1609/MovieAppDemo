package com.example.repository

import android.util.Log
import com.example.api.MovieApi
import com.example.domain.entities.DiscoverResult
import com.example.entities.DiscoverEntity
import com.example.mapper.DiscoverMapper
import io.reactivex.Flowable

class MovieRemoteImpl constructor(private val api : MovieApi):MovieDataStore {

    private val discoverMapper = DiscoverMapper()

    override fun requestDiscover(): Flowable<DiscoverResult> {
        val discoverEntity = DiscoverEntity()
        return api.getDiscover().map {tokenResponse->
            Log.e("TESTAPI", "$tokenResponse")
            val model = discoverMapper.mapToModel(discoverEntity)
            model
        }
    }
}