package com.example.a123.pandatv.model.biz.chinalive;


import com.example.a123.pandatv.model.biz.BaseModel;
import com.example.a123.pandatv.model.entity.LiveChinaTitleBean;
import com.example.a123.pandatv.model.entity.LiveChinasBean;
import com.example.a123.pandatv.model.entity.PandaHomeBean;
import com.example.a123.pandatv.net.callback.MyCallback;

public interface Chinalivemodel extends BaseModel {
      void getLiveChinasResult(MyCallback<LiveChinaTitleBean> callback);
      void getLiveChinaResult(String viewUrl, MyCallback<LiveChinasBean> callback);


}
