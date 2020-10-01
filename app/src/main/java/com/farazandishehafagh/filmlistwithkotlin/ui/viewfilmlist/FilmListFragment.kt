package com.farazandishehafagh.filmlistwithkotlin.ui.viewfilmlist


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.farazandishehafagh.filmlistwithkotlin.R
import com.farazandishehafagh.filmlistwithkotlin.data.Movie
import kotlinx.android.synthetic.main.fragment_film_list.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [FilmListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FilmListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_film_list, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FilmListFragment.
         */

        @JvmStatic
        fun newInstance() =
            FilmListFragment().apply {

            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    fun setUp() {

        film_container.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        val adapter = FilmListAdapter(Movie.populateList())
        film_container.adapter = adapter

    }
}
