package com.farazandishehafagh.filmlistwithkotlin.ui.filmDetail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farazandishehafagh.filmlistwithkotlin.data.api.Datum
import com.farazandishehafagh.filmlistwithkotlin.data.db.entity.MovieEntity
import com.farazandishehafagh.filmlistwithkotlin.data.repository.MovieRepository
import kotlinx.coroutines.launch

/**
 * @author Paniz Alipour 99.09.05
 */
class MovieDetailViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    val movieLiveData = MutableLiveData<List<MovieEntity>>()

    fun insertMovie(movie: Datum)=viewModelScope.launch{
        movieRepository.insert(MovieEntity(movie.title, movie.poster, movie.genres.get(0),movie.images.get(0)))
    }

    fun getAllMovie(): LiveData<List<MovieEntity>> {
        return movieRepository.getAllMovies()
    }

    fun getSelectedMovies(movie: String): LiveData<List<MovieEntity>> {
        return movieRepository.getSelectedMovies(movie)
    }
}