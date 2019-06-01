package org.camachoyury.moovi.data.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import io.reactivex.Observable
import io.reactivex.Single
import org.camachoyury.moovi.domain.model.Movie
import org.camachoyury.moovi.MoviePage

interface MooviApi {

    @GET("movie/popular")
    fun getPopularMovies(): Single<MoviePage>

    @GET("movie/{movie_id}/recommendations")
    fun getRecommendationsForMovie(@Path(value = "movie_id") movieId: Long): Observable<MoviePage>

    @GET("movie/{movie_id}?append_to_response=credits,videos")
    fun getMovieDetails(@Path(value = "movie_id")movieId: Long): Observable<Movie>

    @GET("search/movie")
    fun searchMovie(@Query("query") query: String): Single<MoviePage>

    @GET("movie/upcoming")
    fun getUpcomming(): Observable<MoviePage>
}