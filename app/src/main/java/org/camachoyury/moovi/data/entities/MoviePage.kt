package org.camachoyury.moovi

import org.camachoyury.moovi.domain.model.Movie

data class MoviePage (
        val results: List<Movie>?
)