package org.camachoyury.moovi

import org.camachoyury.moovi.domain.model.Video
import org.camachoyury.moovi.domain.model.VideoTypes


data class VideosPage(
        val results: List<Video>? = null
) {

    fun getYoutubeTrailer(): Video? {
        results?.forEach {video ->
            if (video.type.equals(VideoTypes.Trailer.name) && video.site.equals("YouTube")) {
                return video
            }
        }
        return null
    }

}