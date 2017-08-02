package com.example.a123.pandatv.module.personcenter.fragment;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder;
import com.example.a123.pandatv.base.BasePresenter;
import com.example.a123.pandatv.base.BaseView;

/**
 * Created by Administrator on 2017/8/1.
 */

public interface EmailRegisterContract {
    interface Presenter extends BasePresenter{

        void registerManager(String Email,String pwd,String yzm);
    }
    interface View extends BaseView<Presenter>{
        void getImg(Drawable Img);
        void getResult(String succes);
        void getManager(String error);
    }
}
