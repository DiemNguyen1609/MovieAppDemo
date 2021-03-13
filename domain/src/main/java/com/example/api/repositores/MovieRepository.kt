package com.example.api.repositores

import com.example.api.entities.*
import io.reactivex.Flowable

interface MovieRepository {
    fun requestDiscover(mapRequest : Map<String,String>):Flowable<DiscoverResult>
}