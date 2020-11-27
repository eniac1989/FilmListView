package com.farazandishehafagh.filmlistwithkotlin.data.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.farazandishehafagh.filmlistwithkotlin.data.api.Datum
import com.farazandishehafagh.filmlistwithkotlin.data.api.MovieDetailModel

import com.farazandishehafagh.filmlistwithkotlin.data.api.MovieService
import com.farazandishehafagh.filmlistwithkotlin.data.db.dao.MovieDao
import com.farazandishehafagh.filmlistwithkotlin.data.db.entity.MovieEntity

/**
 * @author Paniz Alipour 99.09.05
 */
class MovieRepository(private val movieDao: MovieDao, private val movieService: MovieService) {

    suspend fun searchMoviesByService(page: Int): List<Datum> {
        return movieService.getAllMovies(page).data
    }

    suspend fun searchMoviesByNameService(name: String, page: Int): List<Datum> {
        return movieService.getMoviesByName(name, page).data
    }

    suspend fun searchMovieDetail(id: Int): MovieDetailModel {
        return movieService.getMovieDetail(id)
    }

    fun getAllMovies(): LiveData<List<MovieEntity>> {
        return movieDao.getAllMovies()
    }

    fun getSelectedMovies(movieTitle: String): LiveData<List<MovieEntity>> {
        return movieDao.getSelectedMovie("%$movieTitle%")
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(movieEntity: MovieEntity) {
        movieDao.insert(movieEntity)
    }

}