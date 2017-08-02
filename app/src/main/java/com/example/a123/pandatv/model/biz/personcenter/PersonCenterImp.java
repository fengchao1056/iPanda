package com.example.a123.pandatv.model.biz.personcenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.example.a123.pandatv.app.App;
import com.example.a123.pandatv.config.Urls;
import com.example.a123.pandatv.model.entity.LoginEntity;
import com.example.a123.pandatv.net.callback.MyCallback;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/31.
 */

public class PersonCenterImp implements IPersonCenter {
    /**
     * 用户登录
     * @param userName
     * @param pwd
     * @param callback
     */
    @Override
    public void userLogin(String userName,String pwd,MyCallback<LoginEntity> callback) {
        Map<String,String> map=new HashMap<>();
        map.put("from","https://reg.cntv.cn/login/login.action");
        map.put("service","client_transaction");
        map.put("username",userName);
        map.put("password",pwd);
        iHttp.getLogin(Urls.LOGIN,map,callback);
    }

    /**
     * 获取手机图片验证码
     * @param callback
     */
    @Override
    public void userPhoneImg(MyCallback<Drawable> callback) {
        iHttp.getUserImg(Urls.FROM,callback);
    }
    public String  getCoockID(){
        SharedPreferences sharedPreferences = App.context.getSharedPreferences("Cookie", Context.MODE_PRIVATE);
        String string = sharedPreferences.getString("Set-Cookie", "");
        return string;
    }

    /**
     * 用户手机注册
     * @param userName
     * @param pwd
     * @param callback
     */
    @Override
    public void userPhoneRegister(String userName,String phoneYZM, String pwd, MyCallback<String> callback) {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("method", "saveMobileRegisterM");
        params.put("mobile", userName);
        params.put("verfiCode", phoneYZM);
        try {
            params.put("passWd",URLEncoder.encode(pwd, "UTF-8"));
            params.put("addons",URLEncoder.encode("http://cbox_mobile.regclientuser.cntv.cn", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        HashMap<String, String> tHeaders = new HashMap<String, String>();
        try {
            tHeaders.put("Referer", URLEncoder.encode("http://cbox_mobile.regclientuser.cntv.cn", "UTF-8"));
            tHeaders.put("User-Agent", URLEncoder.encode("CNTV_APP_CLIENT_CBOX_MOBILE", "UTF-8"));
        } catch (Exception e) {
        }
        iHttp.getRegister(Urls.PHONEREGISTER,params,tHeaders,callback);
    }

    /**
     * 获取手机验证码
     * @param phoneNumber
     * @param imgYZM
     * @param callback
     */
    @Override
    public void userPhoneYZM(String phoneNumber,String imgYZM,MyCallback<String> callback) {

        Map<String,String> params=new HashMap<>();
        params.put("method","getRequestVerifiCodeM");
        params.put("mobile",phoneNumber);
        params.put("verfiCodeType","1");
        params.put("verificationCode",imgYZM);

        Map<String,String> heards=new HashMap<>();
        try {
            heards.put("Referer",URLEncoder.encode("http://cbox_mobile.regclientuser.cntv.cn", "UTF-8"));
            heards.put("User-Agent",URLEncoder.encode("CNTV_APP_CLIENT_CBOX_MOBILE", "UTF-8"));
            heards.put("Cookie",getCoockID());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        iHttp.getYZM(Urls.FROM,params,heards,callback);
    }

    /**
     * 获取邮箱图片验证码
     * @param callback
     */
    @Override
    public void userEmailImg(MyCallback<Drawable> callback) {
        iHttp.getUserImg(Urls.EMILEYANZHENG,callback);
    }

    /**
     *  邮箱注册
     * @param email
     * @param pwd
     * @param img
     * @param callback
     */
    @Override
    public void userEmailRegister(String email, String pwd, String img, MyCallback<String> callback) {
        Map<String,String> params = new HashMap<>();
        params.put("mailAdd",email);
        params.put("passWd",pwd);
        params.put("verificationCode",img);
        Map<String,String> hears = new HashMap<>();
        try {
            hears.put("Referer", URLEncoder.encode("iPanda.Android", "UTF-8"));
            hears.put("User-Agent",URLEncoder.encode("CNTV_APP_CLIENT_CNTV_MOBILE", "UTF-8"));
            hears.put("Cookie",getCoockID());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        iHttp.getRegister(Urls.EMILEREGIS,params,hears,callback);
    }
}
