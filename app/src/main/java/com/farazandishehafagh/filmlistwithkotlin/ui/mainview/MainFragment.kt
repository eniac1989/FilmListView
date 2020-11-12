package com.farazandishehafagh.filmlistwithkotlin.ui.mainview


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.farazandishehafagh.filmlistwithkotlin.R
import com.farazandishehafagh.filmlistwithkotlin.ui.extensionfragment.ExtensionFragment
import com.farazandishehafagh.filmlistwithkotlin.ui.viewfilmlist.view.FilmListFragment
import kotlinx.android.synthetic.main.fragment_main.*


/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnFilmListView.setOnClickListener {
            activity!!.supportFragmentManager
                .beginTransaction()
                .addToBackStack(null)
                .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .replace(R.id.fragment_container, FilmListFragment.newInstance())
                .commit()
        }

        btnLambda.setOnClickListener {
            activity!!.supportFragmentManager
                .beginTransaction()
                .addToBackStack(null)
                .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .replace(R.id.fragment_container, ExtensionFragment.newInstance())
                .commit()

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    companion object {

        @JvmStatic
        fun newInstance() =
            MainFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
