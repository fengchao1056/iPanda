package com.example.a123.pandatv.model.biz.pandalive;


import com.example.a123.pandatv.model.biz.BaseModel;
import com.example.a123.pandatv.model.entity.PandaHomeBean;
import com.example.a123.pandatv.net.callback.MyCallback;

public interface Pandalivemodel extends BaseModel {
      void getResult(MyCallback<PandaHomeBean> callback);

}
