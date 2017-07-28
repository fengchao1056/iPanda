package com.example.a123.pandatv.app;


import android.app.Application;

import com.example.a123.pandatv.base.BaseActivity;
import com.example.a123.pandatv.net.IHttp;

public class App extends Application {
    public  static BaseActivity context=null;
    public static IHttp iHttp;
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
