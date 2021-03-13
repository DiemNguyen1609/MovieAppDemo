package com.example.api.usecases

import com.example.api.common.BaseFlowableUseCase
import com.example.api.common.FlowableRxTransformer
import com.example.api.entities.DiscoverResult
import com.example.api.repositores.MovieRepository
import io.reactivex.Flowable

class DiscoverUseCase(
    private val transformer : FlowableRxTransformer<DiscoverResult>,
    private val repositories: MovieRepository
) :BaseFlowableUseCase<DiscoverResult>(transformer){
    override fun createFlowable(data: Map<String, Any>?): Flowable<DiscoverResult> {
        val map = mutableMapOf<String, String>()
        return if (data !== null) {
            data.forEach { map[it.key] = it.value.toString() }
            repositories.requestDiscover(map)
        } else
            repositories.requestDiscover(map)
    }

fun requestDiscover():Flowable<DiscoverResult>{
    return single()
}
}