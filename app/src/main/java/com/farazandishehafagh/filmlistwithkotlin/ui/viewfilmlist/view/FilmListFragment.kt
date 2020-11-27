package com.farazandishehafagh.filmlistwithkotlin.ui.viewfilmlist.view


import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.farazandishehafagh.filmlistwithkotlin.R
import com.farazandishehafagh.filmlistwithkotlin.data.api.Datum
import com.farazandishehafagh.filmlistwithkotlin.ui.viewfilmlist.adapter.FilmListAdapter
import com.farazandishehafagh.filmlistwithkotlin.ui.viewfilmlist.viewmodel.FilmListViewModel
import com.farazandishehafagh.filmlistwithkotlin.utils.isConnected
import com.farazandishehafagh.filmlistwithkotlin.utils.mapList
import kotlinx.android.synthetic.main.fragment_film_list.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * @author Paniz Alipour 99.09.05
 */
class FilmListFragment : Fragment() {

    private val movies = arrayListOf<Datum>()
    private var page = 1

    val adapter: FilmListAdapter by inject()
    private val movieViewModel: FilmListViewModel by viewModel()

    val lambdaOnClickListener: (View, Datum) -> Unit = { x, y ->
        Navigation.findNavController(x).navigate(
            FilmListFragmentDirections
                .actionFilmListFragmentToDetailFragment(
                    y.title,
                    y.poster,
                    y.genres.get(0),
                    y.id,
                    y.images!!.get(0)
                )
        )
    }

    fun cardOnClickListener(x: View, movie: Datum, op: (View, Datum) -> Unit): Unit {
        op(x, movie)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        // Inflate the layout for this fragment
        handleIntent(activity?.intent)
        return inflater.inflate(R.layout.fragment_film_list, container, false)
    }

    private fun handleIntent(intent: Intent?) {
        if (Intent.ACTION_SEARCH == intent?.action) {
            val query = intent.getStringExtra(SearchManager.QUERY)
            //use the query to search your data somehow
            if (requireContext().isConnected())
                movieViewModel.searchMoviesByTitleService(query, page)
            else {

                movieViewModel.getSelectedMovies(query).observe(viewLifecycleOwner, Observer {
                    val moviList = mapList(it)
                    movies.addAll(moviList)
                    adapter.submitList(movies.toMutableList())
                })
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.options_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onPrepareOptionsMenu(menu: Menu) {
        val searchManager = activity?.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu.findItem(R.id.search).actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(activity?.componentName))
        }
        super.onPrepareOptionsMenu(menu)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUp()

        movieViewModel.movieLiveData.observe(viewLifecycleOwner, Observer {
            movies.addAll(it)
            adapter.submitList(movies.toMutableList())
        })
        if (savedInstanceState == null) {
            if (requireContext().isConnected()) {
                if (activity?.intent?.action != Intent.ACTION_SEARCH)
                    movieViewModel.getMovie(page)

            } else {
                Toast.makeText(
                    context,
                    "Network is disconnected! you can see offline data",
                    Toast.LENGTH_LONG
                ).show()
                if (activity?.intent?.action != Intent.ACTION_SEARCH)
                    movieViewModel.getAllMovie().observe(viewLifecycleOwner, Observer {
                        val moviList = mapList(it)
                        movies.addAll(moviList)
                        adapter.submitList(movies.toMutableList())
                    })
//                else{
//
//                }
            }
        }
        fabNext.setOnClickListener {
            if (requireContext().isConnected()) {
                page += 1
                movieViewModel.getMovie(page)
            } else {

                Toast.makeText(context, "Network is disconnected!", Toast.LENGTH_LONG).show()
            }
        }


    }

    private fun setUp() {
        film_container.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        film_container.adapter = adapter
    }
}
