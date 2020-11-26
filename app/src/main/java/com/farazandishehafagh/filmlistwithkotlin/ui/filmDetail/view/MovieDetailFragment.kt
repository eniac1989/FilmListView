package com.farazandishehafagh.filmlistwithkotlin.ui.filmDetail.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.farazandishehafagh.filmlistwithkotlin.R
import com.farazandishehafagh.filmlistwithkotlin.data.api.Datum
import com.farazandishehafagh.filmlistwithkotlin.ui.filmDetail.viewmodel.MovieDetailViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_movie_detail.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * @author Paniz Alipour 99.09.05
 */
class MovieDetailFragment : Fragment() {

    val args: MovieDetailFragmentArgs by navArgs()
    private val movieDetailViewModel: MovieDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setup(args)
        movieDetailViewModel.movieLiveData.observe(viewLifecycleOwner, Observer {
            Toast.makeText(context, "Insertion was successful!", Toast.LENGTH_LONG).show()
        })
        fabAdd.setOnClickListener {

            movieDetailViewModel.insertMovie(Datum(args.id,args.title,args.poster,
                listOf(args.genre), listOf(args.image)))

        }
    }

    private fun setup(args: MovieDetailFragmentArgs) {
        txtMovieGenre.text = args.genre
        txtMovieTitle.text = args.title
        Picasso.with(context)?.load(args.poster)?.into(imgfilmDetail)
    }
}