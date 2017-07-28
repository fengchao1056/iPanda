package com.example.a123.pandatv.module.pandahome;

import com.example.a123.pandatv.base.BasePresenter;
import com.example.a123.pandatv.base.BaseView;
import com.example.a123.pandatv.model.entity.PandaHomeBean;

/**
 * Created by xingge on 2017/7/26.
 */

public interface HomeContract {

    interface View extends BaseView<Presenter> {
        void showHomeListData(PandaHomeBean pandaHome);
        void playVideo();
        void loadWebView();
    }

    interface Presenter extends BasePresenter{
    }

}
