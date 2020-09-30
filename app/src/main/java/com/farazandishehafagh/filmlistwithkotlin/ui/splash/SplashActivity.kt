package com.farazandishehafagh.filmlistwithkotlin.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.farazandishehafagh.filmlistwithkotlin.R
import com.farazandishehafagh.filmlistwithkotlin.ui.mainview.MainActivity

class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var splashTread = object : Thread() {
            override fun run() {
                try {
                    var waited = 0
                    // Splash screen pause time
                    while (waited < 3000) {
                        sleep(100)
                        waited += 100
                    }

                    openMainActivity()

                } catch (e: InterruptedException) {
                    // do nothing
                }

            }
        }
        splashTread.start()
    }

    fun openMainActivity() {
        //why MainActivity::class.java???
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
