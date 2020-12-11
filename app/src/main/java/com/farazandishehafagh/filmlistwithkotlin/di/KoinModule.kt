package com.farazandishehafagh.filmlistwithkotlin.di


import com.farazandishehafagh.filmlistwithkotlin.data.api.MovieService
import com.farazandishehafagh.filmlistwithkotlin.data.db.database.MovieDatabase
import com.farazandishehafagh.filmlistwithkotlin.data.repository.MovieRepository
import com.farazandishehafagh.filmlistwithkotlin.ui.filmDetail.viewmodel.MovieDetailViewModel
import com.farazandishehafagh.filmlistwithkotlin.ui.mainview.view.MainActivity
import com.farazandishehafagh.filmlistwithkotlin.ui.viewfilmlist.adapter.FilmListAdapter
import com.farazandishehafagh.filmlistwithkotlin.ui.viewfilmlist.view.FilmListFragment
import com.farazandishehafagh.filmlistwithkotlin.ui.viewfilmlist.viewmodel.FilmListViewModel
import com.farazandishehafagh.filmlistwithkotlin.utils.BASE_URL
import com.google.gson.GsonBuilder
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * @author Paniz 99.08.14
 */


val classModule = module {
    factory {
        FilmListAdapter(
            MainActivity(),
            FilmListFragment()
        )

    }
}

val networkModule = module {
    single { GsonBuilder().create() }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(get()))
            .build()
    }

    factory { get<Retrofit>().create(MovieService::class.java) }
}

val movieListModule = module {
    viewModel { FilmListViewModel(get()) }
}

val movieDetailViewModel = module {
    viewModel { MovieDetailViewModel(get()) }
}

val repositoryModule = module {
    factory { MovieRepository(get(), get()) }//
}

val dataModule = module {
    single {
        MovieDatabase.getInstance(get())
    }
    single {
        get<MovieDatabase>().getMovieDao()
    }
}