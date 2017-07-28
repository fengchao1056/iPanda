package com.example.a123.pandatv.model.biz.pandabroadcast;


import com.example.a123.pandatv.model.biz.BaseModel;
import com.example.a123.pandatv.model.entity.PandaHomeBean;
import com.example.a123.pandatv.net.callback.MyCallback;

public interface BoadCastmodel extends BaseModel {
      void getResult(MyCallback<PandaHomeBean> callback);


}
