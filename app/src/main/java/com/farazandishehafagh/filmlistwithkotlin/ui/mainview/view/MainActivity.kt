package com.farazandishehafagh.filmlistwithkotlin.ui.mainview.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.farazandishehafagh.filmlistwithkotlin.R
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(true)

    }


}
