package com.example.a123.pandatv.model.biz.pandabroadcast;


import com.example.a123.pandatv.model.entity.PandaHomeBean;
import com.example.a123.pandatv.net.callback.MyCallback;

public class BoadCatModelImpl implements BoadCastmodel {


    @Override
    public void getResult(MyCallback<PandaHomeBean> callback) {
        iHttp.get("",null,callback);
    }
}
