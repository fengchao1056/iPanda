package com.example.a123.pandatv.model.biz.chinalive;

import com.example.a123.pandatv.model.biz.BaseModel;
import com.example.a123.pandatv.model.entity.CehuaBean;
import com.example.a123.pandatv.net.callback.MyCallback;

/**
 * Created by Administrator on 2017/7/29.
 */

public interface CeHuaModel extends BaseModel {
    void webUrl(MyCallback<CehuaBean> callback);
}
