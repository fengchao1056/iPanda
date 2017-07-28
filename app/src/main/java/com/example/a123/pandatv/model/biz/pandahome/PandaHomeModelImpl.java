package com.example.a123.pandatv.model.biz.pandahome;


import com.example.a123.pandatv.config.Urls;
import com.example.a123.pandatv.model.entity.PandaHomeBean;
import com.example.a123.pandatv.net.callback.MyCallback;

public class PandaHomeModelImpl implements Pandahomemodel {


    @Override
    public void getHomeResult(MyCallback<PandaHomeBean> callback) {
        iHttp.get(Urls.HOMELIVE,null,callback);
    }
}
