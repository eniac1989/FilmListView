package com.farazandishehafagh.filmlistwithkotlin.ui.viewfilmlist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.farazandishehafagh.filmlistwithkotlin.R
import com.farazandishehafagh.filmlistwithkotlin.data.api.Datum
import com.farazandishehafagh.filmlistwithkotlin.ui.viewfilmlist.view.FilmListFragment
import com.farazandishehafagh.filmlistwithkotlin.utils.Utils
import com.farazandishehafagh.filmlistwithkotlin.utils.Utils.Companion.getColor
import com.squareup.picasso.Picasso

/**
 * @author Paniz Alipour 99.07.06
 */


class FilmListAdapter(private val context: Context, private val fragment: FilmListFragment) :
    ListAdapter<Datum, FilmListAdapter.MovieViewHolder>(MovieDiffUtils()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.film_card_layout, parent, false)
        return MovieViewHolder(
            view
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindItems(getItem(position), fragment)
    }


    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(movie: Datum, fragment: FilmListFragment) {

            val txtFilmTitle = itemView.findViewById(R.id.txtFilmTitle) as TextView
            val imgFilm = itemView.findViewById(R.id.imgfilm) as ImageView
            val color = getColor(R.color.cyan_light, Utils.lambdaColor)
            val txtFilmGenre = itemView.findViewById(R.id.txtFilmGenre) as TextView
            itemView.setOnClickListener {

                fragment.cardOnClickListener(itemView, movie, fragment.lambdaOnClickListener)
            }

            txtFilmTitle.setBackgroundColor(color)
            txtFilmTitle.text = movie.title
            txtFilmGenre.text=movie.genres.get(0)
            Picasso.with(itemView.context)?.load(movie.poster)?.into(imgFilm)
        }
    }
}

class MovieDiffUtils : DiffUtil.ItemCallback<Datum>() {
    override fun areItemsTheSame(oldItem: Datum, newItem: Datum): Boolean {
        return oldItem.title == newItem.title && oldItem.genres.get(0) == newItem.genres.get(0)
    }

    override fun areContentsTheSame(oldItem: Datum, newItem: Datum): Boolean {
        return oldItem.title == newItem.title && oldItem.genres.get(0) == newItem.genres.get(0)
    }

}