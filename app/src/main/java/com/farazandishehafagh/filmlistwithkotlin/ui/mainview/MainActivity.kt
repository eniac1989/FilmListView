package com.farazandishehafagh.filmlistwithkotlin.ui.mainview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.farazandishehafagh.filmlistwithkotlin.R
import com.farazandishehafagh.filmlistwithkotlin.ui.viewfilmlist.FilmListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
            .replace(R.id.fragment_container, FilmListFragment.newInstance())
            .commit()


    }


}
