package com.example.a123.pandatv.net;


import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.example.a123.pandatv.model.entity.LoginEntity;
import com.example.a123.pandatv.net.callback.MyCallback;

import java.io.File;
import java.util.Map;

public interface IHttp {
    <T> void get(String url, MyCallback<T> callback);
    <T> void get(String url, Map<String,String> params, MyCallback<T> callback);
    void getRegister(String url,Map<String,String> params,Map<String,String> hears,MyCallback<String> callback);
    void getUserImg(String url, MyCallback<Drawable> callback);
    void getYZM(String url,Map<String,String> params,Map<String,String> heards,MyCallback<String> callback);
    <T> void getLogin(String url, Map<String,String> params, MyCallback<T> callback);
    void upload();
    void downLoad(String url,MyCallback<File> callback);
    void loadImage();
}
