package com.farazandishehafagh.filmlistwithkotlin.di

import com.farazandishehafagh.filmlistwithkotlin.data.Movie
import com.farazandishehafagh.filmlistwithkotlin.ui.viewfilmlist.FilmListAdapter
import com.farazandishehafagh.filmlistwithkotlin.ui.viewfilmlist.FilmListFragment
import org.koin.dsl.module

/**
 * @author Paniz 99.08.14
 */


val classModule = module {
    factory { FilmListAdapter(Movie.populateList(), FilmListFragment()) }


}
