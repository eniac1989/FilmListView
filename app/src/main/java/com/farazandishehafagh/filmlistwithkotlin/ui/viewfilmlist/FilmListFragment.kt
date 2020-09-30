package com.farazandishehafagh.filmlistwithkotlin.ui.viewfilmlist


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.farazandishehafagh.filmlistwithkotlin.R

/**
 * @author Paniz Alipour 99.07.07
 */
class FilmListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_film_list, container, false)
    }


}
