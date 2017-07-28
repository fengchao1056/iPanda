package com.example.a123.pandatv.model.biz.pandaroll;


import com.example.a123.pandatv.model.entity.PandaHomeBean;
import com.example.a123.pandatv.net.callback.MyCallback;

public class PandaRollModelImpl implements PandaRollemodel {


    @Override
    public void getResult(MyCallback<PandaHomeBean> callback) {
        iHttp.get("",null,callback);
    }
}
