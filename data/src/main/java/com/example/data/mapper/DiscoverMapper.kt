package com.example.data.mapper

import com.example.domain.entities.DiscoverResult
import com.example.data.entities.DiscoverEntity
import com.example.data.entities.DiscoverItemEntity
import com.example.domain.entities.DiscoverItemResult

class DiscoverMapper {

    fun mapToModel(discoverEntity: DiscoverEntity): DiscoverResult {
        return DiscoverResult().apply {
            discoverEntity.let {
                page = it.page ?: ""
                results = it.results?.map {
                    mapToDiscoverItemResult(it)
                } ?: emptyList()
            }
        }
    }

    private fun mapToDiscoverItemResult(discoverItemEntity: DiscoverItemEntity): DiscoverItemResult {
        return DiscoverItemResult().apply {
            discoverItemEntity.let {
                backdropPath = it.backdropPath ?: ""
                id = it.id ?: ""
                title = it.title ?: ""
                posterPath = it.posterPath ?: ""
                voteAverage = it.voteAverage ?: ""
            }
        }
    }
}