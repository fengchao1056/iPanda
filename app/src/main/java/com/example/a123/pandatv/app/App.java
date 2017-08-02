package com.example.a123.pandatv.app;


import android.app.Application;

import com.example.a123.pandatv.base.BaseActivity;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

public class App extends Application {
    public  static BaseActivity context=null;
    {
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("2878289246", "ccd2e6467dd65e6c521b7a0feb702453", "http://sns.whalecloud.com");
    }    @Override
    public void onCreate() {
        super.onCreate();
        UMShareAPI.get(this);
    }
}
