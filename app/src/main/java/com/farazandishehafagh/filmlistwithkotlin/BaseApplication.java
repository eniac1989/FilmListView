package com.farazandishehafagh.filmlistwithkotlin;


import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

/**
 * @author Paniz 97.08.12
 */
public class BaseApplication extends Application {


    private static BaseApplication baseApplication;

    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override
    public void onCreate() {

        super.onCreate();

        baseApplication = this;


    }

    public static synchronized BaseApplication getBaseApplication() {
        return baseApplication;
    }

    public static Resources getResource() {
        return getBaseApplication().getResources();
    }
}
