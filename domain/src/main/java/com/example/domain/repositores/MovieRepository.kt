package com.example.domain.repositores

import com.example.domain.entities.DiscoverResult
import io.reactivex.Flowable

interface MovieRepository {
    fun requestDiscover(mapRequest : Map<String,String>):Flowable<DiscoverResult>
}