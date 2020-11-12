package com.farazandishehafagh.filmlistwithkotlin.ui.viewfilmlist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farazandishehafagh.filmlistwithkotlin.data.Movie
import kotlinx.coroutines.launch

/**
 * @author Paniz Alipour 99.08.22
 */
class FilmListViewModel(private val movieModel: Movie) : ViewModel() {

    val movieLiveData = MutableLiveData<ArrayList<Movie>>()

    fun getMovie() {
        viewModelScope.launch {
            val data = movieModel.getMovieList()
            movieLiveData.postValue(data)
        }
    }


}