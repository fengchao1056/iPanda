package com.example.a123.pandatv.widget.manager;

import android.widget.Toast;

import com.example.a123.pandatv.app.App;

/**
 * Created by xingge on 2017/7/26.
 */

public class ToastManager {

    public static void show(String msg){
        Toast.makeText(App.context,msg,Toast.LENGTH_LONG).show();
    }
}
