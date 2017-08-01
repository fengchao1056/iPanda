package com.example.a123.pandatv.model.biz.chinalive;


import com.example.a123.pandatv.model.entity.PandaHomeBean;
import com.example.a123.pandatv.net.callback.MyCallback;

public class ChinaliveModelImpl implements Chinalivemodel {


    @Override
    public void getResult(MyCallback<PandaHomeBean> callback) {
        iHttp.get("",null,callback);
    }
}
