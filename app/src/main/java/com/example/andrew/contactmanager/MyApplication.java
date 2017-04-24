package com.example.andrew.contactmanager;

import android.app.Application;
import android.content.Context;

/**
 * MYAPPLICATION
 * Singleton of the application context *
 *
 * Created by Andrew on 11/4/2016.
 */

public class MyApplication extends Application {

    private static final ThreadLocal<Context> context = new ThreadLocal<>();

    public void onCreate() {
        super.onCreate();
        MyApplication.context.set(getApplicationContext());
    }

    public static Context getAppContext() {
        return MyApplication.context.get();
    }
}
