package com.farazandishehafagh.filmlistwithkotlin

import android.app.Application
import android.content.Context
import android.content.res.Resources
import com.farazandishehafagh.filmlistwithkotlin.di.classModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * @author Paniz 99.08.14
 */
class KotlinBaseApplication : Application() {

    override fun getApplicationContext(): Context {
        return super.getApplicationContext()
    }


    companion object {

        private lateinit var kotlinBaseApplication: KotlinBaseApplication

        fun getKotlinResource(): Resources {
            return getKotlinBaseApplication().getResources()
        }

        @Synchronized
        fun getKotlinBaseApplication(): KotlinBaseApplication {
            return kotlinBaseApplication
        }
    }

    override fun onCreate() {

        super.onCreate()

        kotlinBaseApplication = this

        startKoin{
            androidContext(this@KotlinBaseApplication)
            modules(classModule)
        }

    }





}