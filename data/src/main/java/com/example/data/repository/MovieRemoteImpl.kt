package com.example.data.repository

import android.util.Log
import com.example.data.api.MovieApi
import com.example.domain.entities.DiscoverResult
import com.example.data.entities.DiscoverEntity
import com.example.data.mapper.DiscoverMapper
import com.google.gson.Gson
import io.reactivex.Flowable

class MovieRemoteImpl constructor(private val api: MovieApi) :
    MovieDataStore {

    private val discoverMapper = DiscoverMapper()

    override fun requestDiscover(): Flowable<DiscoverResult> {

        return api.getDiscover().map { tokenResponse ->
            Log.e("TESTAPI", "$tokenResponse")
            var map: Map<String, Any> = HashMap()
            map = Gson().fromJson(tokenResponse, map.javaClass)

            val discoverEntity = DiscoverEntity.create(map)
            val model = discoverMapper.mapToModel(discoverEntity)
            model
        }
    }
}