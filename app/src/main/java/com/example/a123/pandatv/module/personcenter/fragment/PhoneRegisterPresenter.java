package com.example.a123.pandatv.module.personcenter.fragment;

import android.graphics.drawable.Drawable;

import com.example.a123.pandatv.model.biz.personcenter.IPersonCenter;
import com.example.a123.pandatv.model.biz.personcenter.PersonCenterImp;
import com.example.a123.pandatv.net.callback.MyCallback;

/**
 * Created by Administrator on 2017/8/1.
 */

public class PhoneRegisterPresenter implements PhoneRegisterContract.Presenter {
    private PhoneRegisterContract.View view;
    private IPersonCenter personCenter;
    public PhoneRegisterPresenter(PhoneRegisterContract.View view) {
        this.view=view;
        this.view.setPresenter(this);
        personCenter=new PersonCenterImp();
    }

    @Override
    public void start() {
        personCenter.userPhoneImg(new MyCallback<Drawable>() {
            @Override
            public void onSuccess(Drawable drawable) {
                view.setImg(drawable);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }

    @Override
    public void sendYZM(String phoneNumber, String imgNum) {
        personCenter.userPhoneYZM(phoneNumber, imgNum, new MyCallback<String>() {
            @Override
            public void onSuccess(String s) {
                view.phoneNum(s);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }
}
