package com.example.zane.demo;

import android.app.Application;

/**
 * Created by Zane on 16/4/10.
 */
public class App extends Application{

    private static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public static App getInstance(){
        return app;
    }
}
