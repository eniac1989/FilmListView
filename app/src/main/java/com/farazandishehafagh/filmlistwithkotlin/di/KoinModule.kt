package com.farazandishehafagh.filmlistwithkotlin.di

import com.farazandishehafagh.filmlistwithkotlin.data.Movie
import com.farazandishehafagh.filmlistwithkotlin.ui.viewfilmlist.adapter.FilmListAdapter
import com.farazandishehafagh.filmlistwithkotlin.ui.viewfilmlist.view.FilmListFragment
import com.farazandishehafagh.filmlistwithkotlin.ui.viewfilmlist.viewmodel.FilmListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


/**
 * @author Paniz 99.08.14
 */


val classModule = module {
    factory {
        FilmListAdapter(
            ArrayList<Movie>(),
            FilmListFragment()
        )

    }


}

val movieListModule = module {
    viewModel { FilmListViewModel(get()) }
    single { Movie() }
}
