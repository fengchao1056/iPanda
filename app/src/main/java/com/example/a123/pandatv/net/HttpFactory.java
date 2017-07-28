package com.example.a123.pandatv.net;

/**
 * Created by Administrator on 2017/7/11.
 */

public class HttpFactory {
    public static IHttp create(){

        return OkhttpUtils.getInstance();
    }
}
