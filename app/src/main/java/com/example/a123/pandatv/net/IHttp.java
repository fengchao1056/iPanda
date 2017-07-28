package com.example.a123.pandatv.net;


import com.example.a123.pandatv.net.callback.MyCallback;

import java.util.Map;

public interface IHttp {
    <T> void get(String url, MyCallback<T> callback);
    <T> void get(String url, Map<String,String> params, MyCallback<T> callback);
    void upload();
    void downLoad();
    void loadImage();
}
