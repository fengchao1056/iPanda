package com.example.a123.pandatv.module.pandahome;

import com.example.a123.pandatv.base.BasePresenter;
import com.example.a123.pandatv.base.BaseView;
import com.example.a123.pandatv.model.entity.PandaHomeBean;
import com.example.a123.pandatv.model.entity.UpDateLoading;

import java.io.File;

/**
 * Created by xingge on 2017/7/26.
 */

public interface HomeContract {

    interface View extends BaseView<Presenter> {
        void showHomeListData(PandaHomeBean pandaHome);
        void loadMore();
        void loadWebView();
        void setupapk(File file);
        void getVersion(UpDateLoading upDateLoading);
    }

    interface Presenter extends BasePresenter{
        void loadMore(int pageSize,int pageContent);
        void uplode(String url);
    }

}
