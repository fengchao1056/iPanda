package com.example.a123.pandatv.module.personcenter.fragment;

import android.graphics.drawable.Drawable;

import com.example.a123.pandatv.base.BasePresenter;
import com.example.a123.pandatv.base.BaseView;
import com.example.a123.pandatv.net.callback.MyCallback;

/**
 * Created by Administrator on 2017/8/1.
 */

public interface PhoneRegisterContract {
    interface Presenter extends BasePresenter{
        void sendYZM(String phoneNumber, String imgNum);
    }
    interface View extends BaseView<Presenter>{
        void setImg(Drawable drawable);
        void phoneNum(String isSucces);
    }
}
