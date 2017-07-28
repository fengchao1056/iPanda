package com.example.a123.pandatv.model.biz;


import com.example.a123.pandatv.net.HttpFactory;
import com.example.a123.pandatv.net.IHttp;

public interface BaseModel {
    public static IHttp iHttp = HttpFactory.create();
}
