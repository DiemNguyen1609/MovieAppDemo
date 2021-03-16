package com.example.repository

import com.example.domain.entities.DiscoverResult
import io.reactivex.Flowable

interface MovieDataStore {
    fun requestDiscover(): Flowable<DiscoverResult>
}