package com.example.a123.pandatv.net.callback;


public interface MyCallback<T> {
    void onSuccess(T t);
    void onError(int errorCode,String errorMsg);
}
