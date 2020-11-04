package com.farazandishehafagh.filmlistwithkotlin.ui.viewfilmlist


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.farazandishehafagh.filmlistwithkotlin.R
import kotlinx.android.synthetic.main.fragment_film_list.*
import org.koin.android.ext.android.inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [FilmListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FilmListFragment : Fragment() {

    val adapter: FilmListAdapter by inject()

    val lambdaOnClickListener1: (View.OnClickListener) -> Unit = {
        Toast.makeText(context, "title", Toast.LENGTH_LONG).show()
    }

    val lambdaOnClickListener: (View, String) -> Unit = { x, y ->

        Toast.makeText(context, y, Toast.LENGTH_LONG).show()
    }

    fun cardOnClickListener(x: View, title: String, op: (View, String) -> Unit): Unit {

        op(x, title)
    }

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
//        val adapter = FilmListAdapter(Movie.populateList(), this)

        film_container.adapter = adapter

    }


}
