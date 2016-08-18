package com.example.dllo.openeyes.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by dllo on 16/8/15.
 */
public class App extends Application {
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext=this;
    }

    public static Context getContext() {
        return sContext;
    }
}