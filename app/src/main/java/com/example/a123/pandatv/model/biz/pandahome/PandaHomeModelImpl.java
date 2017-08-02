package com.example.a123.pandatv.model.biz.pandahome;


import com.example.a123.pandatv.config.Urls;
import com.example.a123.pandatv.model.entity.PandaHomeBean;
import com.example.a123.pandatv.model.entity.UpDateLoading;
import com.example.a123.pandatv.net.callback.MyCallback;

import java.io.File;

public class PandaHomeModelImpl implements Pandahomemodel {


    @Override
    public void getHomeResult(MyCallback<PandaHomeBean> callback) {
        iHttp.get(Urls.HOMELIVE,null,callback);
    }

    @Override
    public void loadMore(int pageSize, int pageContent) {

    }

    @Override
    public void getVerSion(MyCallback<UpDateLoading> myNetCallBack) {
        iHttp.get(Urls.UPDATE,null,myNetCallBack);
    }

    @Override
    public void getup(String url, MyCallback<File> myCallback) {
        iHttp.downLoad(url,myCallback);
    }
}
