package com.example.a123.pandatv.utils;

import android.content.Context;
import android.widget.Toast;

import com.example.a123.pandatv.app.App;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareConfig;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

/**
 * Created by Administrator on 2017/8/2.
 */

public class SharedUtils {
    private static SharedUtils sharedUtils;
    public static SharedUtils getInsent(){
        if (sharedUtils==null){
            synchronized (SharedUtils.class){
                if (sharedUtils==null){
                    sharedUtils=new SharedUtils();
                }
            }
        }
        return sharedUtils;
    }
    public void init(Context context){
        UMShareConfig config = new UMShareConfig();
        config.isNeedAuthOnGetUserInfo(true);
        config.isOpenShareEditActivity(true);
        UMShareAPI.get(context).setShareConfig(config);
    }
    public void shareText(String shareStr){
        new ShareAction(App.context)
                .withText(shareStr)
                .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                .setCallback(shareListener)
                .open();
    }
    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(App.context,"成功了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(App.context,"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(App.context,"取消了",Toast.LENGTH_LONG).show();

        }
    };

}
