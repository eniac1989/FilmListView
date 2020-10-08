package com.farazandishehafagh.filmlistwithkotlin.ui.viewfilmlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.farazandishehafagh.filmlistwithkotlin.R
import com.farazandishehafagh.filmlistwithkotlin.data.Movie
import com.farazandishehafagh.filmlistwithkotlin.utils.Utils
import com.farazandishehafagh.filmlistwithkotlin.utils.Utils.Companion.formatDate
import com.farazandishehafagh.filmlistwithkotlin.utils.Utils.Companion.getColor
import com.farazandishehafagh.filmlistwithkotlin.utils.Utils.Companion.getTranslationOfString
import com.farazandishehafagh.filmlistwithkotlin.utils.Utils.Companion.lambdaFormatDate
import com.farazandishehafagh.filmlistwithkotlin.utils.Utils.Companion.lambdaTranslation

/**
 * @author Paniz Alipour 99.07.06
 */


class FilmListAdapter(private val myDataset: ArrayList<Movie>,private val fragment: FilmListFragment) :
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
        holder.bindItems(myDataset[position],fragment)
      }


    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(movie: Movie,fragment: FilmListFragment) {

            val txtFilmTitle = itemView.findViewById(R.id.txtFilmTitle) as TextView
            val imgFilm = itemView.findViewById(R.id.imgfilm) as ImageView
            val txtDirector = itemView.findViewById(R.id.txtFilmDirector) as TextView
            val txtYear = itemView.findViewById(R.id.txtYear) as TextView

            val ratingBar = itemView.findViewById(R.id.ratingBar) as RatingBar


            val translationOfString = getTranslationOfString(R.string.mr, lambdaTranslation)
            val color = getColor(R.color.cyan_light, Utils.lambdaColor)

            itemView.setOnClickListener{
                fragment.cardOnClickListener(itemView,movie.title,fragment.lambdaOnClickListener)
            }

//            itemView.onLambdaCall(fragment,movie.title)

            txtFilmTitle.setBackgroundColor(color)
            txtFilmTitle.text = movie.title
            txtDirector.text = translationOfString + " " + movie.director
            txtYear.text = formatDate(movie.year, lambdaFormatDate)
            ratingBar.numStars = movie.rating

            imgFilm.setImageResource(movie.image)
        }

        fun View.onLambdaCall(fragment:FilmListFragment,title:String):Unit{
            fragment.cardOnClickListener(itemView,title,fragment.lambdaOnClickListener)
        }

    }


}