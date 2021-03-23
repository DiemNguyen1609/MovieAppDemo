package com.example.data.entities

data class DiscoverEntity(
    var results: List<DiscoverItemEntity>? = null,
    var page: String? = null
) {
    companion object {
        fun create(map: Map<String, Any?>): DiscoverEntity {
            val model = DiscoverEntity()
            map.forEach {
                val value = it.value?.toString()
                when (it.key) {
                    "page" -> model.page = value
                    "results" -> {
                        val dataResult = it.value as List<Map<String, Any?>>?
                        val dataListEntity: List<DiscoverItemEntity>? = dataResult?.map {
                            DiscoverItemEntity.create(
                                it
                            )
                        }
                        model.results = dataListEntity
                    }
                }
            }
            return model
        }
    }
}

data class DiscoverItemEntity(
    var backdropPath: String? = null,
    var id: String? = null,
    var title: String? = null,
    var posterPath: String? = null,
    var voteAverage: String? = null
) {
    companion object {
        fun create(map: Map<String, Any?>): DiscoverItemEntity {
            val model = DiscoverItemEntity()
            map.forEach {
                val value = it.value?.toString()
                when (it.key) {
                    "backdrop_path" -> model.backdropPath = value
                    "id" -> model.id = value
                    "title" -> model.title = value
                    "poster_path" -> model.posterPath = value
                    "vote_average" -> model.voteAverage = value
                }
            }
            return model
        }
    }
}