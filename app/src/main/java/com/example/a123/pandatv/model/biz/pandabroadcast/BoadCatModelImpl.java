package com.example.a123.pandatv.model.biz.pandabroadcast;


import com.example.a123.pandatv.config.Urls;
import com.example.a123.pandatv.model.entity.PandaBoadCastBean;
import com.example.a123.pandatv.model.entity.PandaObserverFirstItemBean;
import com.example.a123.pandatv.net.callback.MyCallback;

public class BoadCatModelImpl implements BoadCastmodel {


    @Override
    public void getResult(MyCallback<PandaBoadCastBean> callback) {
        iHttp.get(Urls.BOBAO,null,callback);
    }

    @Override
    public void getOneItem(MyCallback<PandaObserverFirstItemBean> callback) {
        iHttp.get(Urls.BOADCASTITEM,null,callback);
    }
}
