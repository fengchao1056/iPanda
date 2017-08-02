package com.example.a123.pandatv.model.biz.personcenter;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.example.a123.pandatv.model.biz.BaseModel;
import com.example.a123.pandatv.model.entity.LoginEntity;
import com.example.a123.pandatv.net.callback.MyCallback;

/**
 * Created by Administrator on 2017/7/31.
 */

public interface IPersonCenter extends BaseModel {
    void userLogin(String userName,String pwd,MyCallback<LoginEntity> callback);
    void userPhoneImg(MyCallback<Drawable> callback);
    void userPhoneRegister(String userName,String phoneYZM, String pwd,MyCallback<String> callback);
    void userPhoneYZM(String phoneNumber,String imgYZM,MyCallback<String> callback);
    void userEmailImg(MyCallback<Drawable> callback);
    void userEmailRegister(String email,String pwd,String img,MyCallback<String> callback);

}
