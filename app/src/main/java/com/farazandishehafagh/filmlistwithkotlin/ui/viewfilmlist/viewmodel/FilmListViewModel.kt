package com.farazandishehafagh.filmlistwithkotlin.ui.viewfilmlist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farazandishehafagh.filmlistwithkotlin.data.api.Datum
import com.farazandishehafagh.filmlistwithkotlin.data.db.entity.MovieEntity
import com.farazandishehafagh.filmlistwithkotlin.data.repository.MovieRepository
import kotlinx.coroutines.launch

/**
 * @author Paniz Alipour 99.08.22
 */
class FilmListViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    val movieLiveData = MutableLiveData<List<Datum>>()

    fun getAllMovie(): LiveData<List<MovieEntity>> {
        val allMovies = movieRepository.getAllMovies()
        return allMovies
    }

    fun getSelectedMovies(movie: String): LiveData<List<MovieEntity>> {
        return movieRepository.getSelectedMovies(movie)
    }

    fun getMovie(page: Int) {
        viewModelScope.launch {
            val data = movieRepository.searchMoviesByService(page)
            movieLiveData.postValue(data)
        }
    }

    fun searchMoviesByTitleService(name: String, page: Int) {
        viewModelScope.launch {
            val data = movieRepository.searchMoviesByNameService(name, page)
            movieLiveData.postValue(data)
        }
    }


}