package com.example.a123.pandatv.widget.view;

import android.util.Log;

/**
 * Created by xingge on 2017/7/13.
 */

public class MyLog {
    private static boolean isOpen = true;
    public static void d(String tag,String msg){
        if(isOpen)
            Log.d(tag,msg);
    }
}
