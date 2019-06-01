package org.camachoyury.moovi.domain.model

enum class VideoTypes {
    Trailer, Teaser, Clip, Featurette
}

data class Video(
        val key: String? = null,
        val type: String? = null,
        val site: String? = null
)