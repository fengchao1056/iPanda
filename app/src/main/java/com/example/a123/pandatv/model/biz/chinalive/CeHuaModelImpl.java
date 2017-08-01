package com.example.a123.pandatv.model.biz.chinalive;

import com.example.a123.pandatv.config.Urls;
import com.example.a123.pandatv.model.entity.CehuaBean;
import com.example.a123.pandatv.net.callback.MyCallback;

/**
 * Created by Administrator on 2017/7/29.
 */

public class CeHuaModelImpl implements CeHuaModel {
    @Override
    public void webUrl( MyCallback<CehuaBean> callback) {
        iHttp.get(Urls.CEHUA,callback);
    }
}
