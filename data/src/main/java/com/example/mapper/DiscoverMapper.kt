package com.example.mapper

import com.example.domain.entities.DiscoverResult
import com.example.entities.DiscoverEntity

class DiscoverMapper {

    fun mapToModel(data:DiscoverEntity): DiscoverResult {
        val disResult = DiscoverResult()

        return disResult
    }
}