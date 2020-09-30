package com.farazandishehafagh.filmlistwithkotlin.ui.viewfilmlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.farazandishehafagh.filmlistwithkotlin.R
import com.farazandishehafagh.filmlistwithkotlin.data.Movie

/**
 * @author Paniz Alipour 99.07.06
 */


class FilmListAdapter(private val myDataset: ArrayList<Movie>) :
    RecyclerView.Adapter<FilmListAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.film_card_layout, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return myDataset.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindItems(myDataset[position])
    }


    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(movie: Movie) {

            val txtFilmTitle = itemView.findViewById(R.id.txtFilmTitle) as TextView
            val imgFilm = itemView.findViewById(R.id.imgfilm) as ImageView
            val txtDirector = itemView.findViewById(R.id.txtFilmDirector) as TextView
            val txtYear = itemView.findViewById(R.id.txtYear) as TextView
            val txtRating = itemView.findViewById(R.id.txtRating) as TextView

            txtFilmTitle.text = movie.title
            txtDirector.text = movie.director
            txtYear.text = movie.year.toString()
            txtRating.text = movie.rating.toString()

            imgFilm.setImageResource(movie.image)
        }
    }


}