package com.example.a123.pandatv.model.biz.pandahome;


import com.example.a123.pandatv.model.biz.BaseModel;
import com.example.a123.pandatv.model.entity.PandaHomeBean;
import com.example.a123.pandatv.net.callback.MyCallback;

public interface Pandahomemodel extends BaseModel {
      void getHomeResult(MyCallback<PandaHomeBean> callback);


}
