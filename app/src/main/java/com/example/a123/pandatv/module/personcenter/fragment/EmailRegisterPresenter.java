package com.example.a123.pandatv.module.personcenter.fragment;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.example.a123.pandatv.model.biz.personcenter.IPersonCenter;
import com.example.a123.pandatv.model.biz.personcenter.PersonCenterImp;
import com.example.a123.pandatv.net.callback.MyCallback;

/**
 * Created by Administrator on 2017/8/1.
 */

public class EmailRegisterPresenter implements EmailRegisterContract.Presenter {
    private EmailRegisterContract.View view;
    private IPersonCenter personCenter;
    public EmailRegisterPresenter(EmailRegisterContract.View view) {
        this.view=view;
        this.view.setPresenter(this);
        personCenter=new PersonCenterImp();
    }

    @Override
    public void start() {
        personCenter.userEmailImg(new MyCallback<Drawable>() {
            @Override
            public void onSuccess(Drawable drawable) {
                view.getImg(drawable);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                view.getManager(errorMsg);
            }
        });
    }

    @Override
    public void registerManager(String Email, String pwd, String yzm) {
        personCenter.userEmailRegister(Email, pwd, yzm, new MyCallback<String>() {
            @Override
            public void onSuccess(String s) {
                view.getResult(s);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                view.getManager(errorMsg);
            }
        });
    }
}
