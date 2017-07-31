package com.example.a123.pandatv.model.biz.pandabroadcast;


import com.example.a123.pandatv.model.biz.BaseModel;
import com.example.a123.pandatv.model.entity.PandaBoadCastBean;
import com.example.a123.pandatv.net.callback.MyCallback;

public interface BoadCastmodel extends BaseModel {
      void getResult(MyCallback<PandaBoadCastBean> callback);


}
