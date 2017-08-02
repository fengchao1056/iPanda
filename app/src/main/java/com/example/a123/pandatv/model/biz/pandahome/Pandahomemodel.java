package com.example.a123.pandatv.model.biz.pandahome;


import com.example.a123.pandatv.model.biz.BaseModel;
import com.example.a123.pandatv.model.entity.PandaHomeBean;
import com.example.a123.pandatv.model.entity.UpDateLoading;
import com.example.a123.pandatv.net.callback.MyCallback;

import java.io.File;

public interface Pandahomemodel extends BaseModel {
      void getHomeResult(MyCallback<PandaHomeBean> callback);
      void loadMore(int pageSize,int pageContent);
      //版本更新
      void getVerSion(MyCallback<UpDateLoading> myNetCallBack);
        void getup(String url,MyCallback<File> myCallback);

}
