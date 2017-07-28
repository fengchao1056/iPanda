package com.example.a123.pandatv.base;


public interface BaseView<T> {
    void showProgress();
    void dimissProgress();
    void showMessage(String msg);
    void setPresenter(T t);
}
