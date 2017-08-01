package com.example.a123.pandatv.model.biz.chinalive;


import com.example.a123.pandatv.config.Urls;
import com.example.a123.pandatv.model.entity.LiveChinaTitleBean;
import com.example.a123.pandatv.model.entity.LiveChinasBean;
import com.example.a123.pandatv.model.entity.PandaHomeBean;
import com.example.a123.pandatv.net.callback.MyCallback;

public class ChinaliveModelImpl implements Chinalivemodel {
    @Override
    public void getLiveChinasResult(MyCallback<LiveChinaTitleBean> callback) {
        iHttp.get(Urls.LIVECHINAS,null,callback);
    }

    @Override
    public void getLiveChinaResult(String viewUrl, MyCallback<LiveChinasBean> callback) {
        iHttp.get(viewUrl,null,callback);
    }
}
