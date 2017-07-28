package com.example.a123.pandatv.app;


import android.app.Application;

import com.example.a123.pandatv.base.BaseActivity;

public class App extends Application {
    public  static BaseActivity context=null;

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
