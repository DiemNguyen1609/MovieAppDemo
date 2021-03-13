package com.example.repository

import com.example.api.entities.*
import io.reactivex.Flowable

interface MovieDataStore {
    fun requestDiscover(): Flowable<DiscoverResult>
}