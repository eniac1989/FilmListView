package com.farazandishehafagh.filmlistwithkotlin.ui.filmDetail.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.farazandishehafagh.filmlistwithkotlin.R
import com.farazandishehafagh.filmlistwithkotlin.data.api.Datum
import com.farazandishehafagh.filmlistwithkotlin.ui.filmDetail.viewmodel.MovieDetailViewModel
import com.farazandishehafagh.filmlistwithkotlin.utils.isConnected
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_movie_detail.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * @author Paniz Alipour 99.09.05
 */
class MovieDetailFragment : Fragment() {

    val args: MovieDetailFragmentArgs by navArgs()
    private val movieDetailViewModel: MovieDetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setHasOptionsMenu(false)
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setup(args)
        movieDetailViewModel.movieDetailLiveData.observe(viewLifecycleOwner, Observer {
            grdDetail.visibility = View.VISIBLE
            txtYear.text = it.year
            txtDirector.text = it.director
            ratingBar.stepSize = 0.01f
            ratingBar.max = 5
            ratingBar.rating = it.imdbRating.toFloat()
            txtCountry.text = it.country
        })

        btnMoreDetail.setOnClickListener {
            movieDetailViewModel.getMovieDetail(args.id)
        }
        fabAdd.setOnClickListener {
            try {

                movieDetailViewModel.insertMovie(
                    Datum(
                        args.id, args.title, args.poster,
                        listOf(args.genre), listOf(args.image)
                    )
                )
                Toast.makeText(context, "Insertion was successful!", Toast.LENGTH_LONG).show()
                val actionFilmDetailToListMovie =
                    MovieDetailFragmentDirections.actionFilmDetailToListMovie()
                findNavController().navigate(actionFilmDetailToListMovie)
            } catch (ex: Exception) {
                Toast.makeText(context, "Error has been occurred!", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setup(args: MovieDetailFragmentArgs) {
        txtMovieGenre.text = args.genre
        txtMovieTitle.text = args.title
        Picasso.with(context)?.load(args.poster)?.into(imgfilmDetail)
        grdDetail.visibility = View.GONE
        if(!requireContext().isConnected())
        {
            lblMoreDetail.visibility=View.GONE
            btnMoreDetail.visibility=View.GONE
        }
    }
}