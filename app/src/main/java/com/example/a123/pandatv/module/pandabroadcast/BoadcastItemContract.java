package com.example.a123.pandatv.module.pandabroadcast;


import com.example.a123.pandatv.base.BasePresenter;
import com.example.a123.pandatv.base.BaseView;
import com.example.a123.pandatv.model.entity.PandaObserverFirstItemBean;

public interface BoadcastItemContract {
      interface  View extends BaseView<Presenter>{
          void setResulte(PandaObserverFirstItemBean pandaObserverFirstItemBean);
          void playVideo();

      }
      interface  Presenter extends BasePresenter{

      }
}
