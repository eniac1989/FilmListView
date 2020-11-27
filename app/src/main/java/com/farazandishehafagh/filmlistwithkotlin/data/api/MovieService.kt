package com.farazandishehafagh.filmlistwithkotlin.data.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author Paniz Alipour 99.09.05
 */

interface MovieService {

    //api/v1/movies?page={page}
    @GET("movies")
    suspend fun getAllMovies(@Query("page") page: Int): MovieModel

    //api/v1/movies?q={name}&page={page}
    @GET("movies")
    suspend fun getMoviesByName(@Query("q") name: String, @Query("page") page: Int): MovieModel

    //api/v1/movies/{movie_id}
    @GET("movies/{id}")
    suspend fun getMovieDetail(@Path("id") movieId:Int):MovieDetailModel
}