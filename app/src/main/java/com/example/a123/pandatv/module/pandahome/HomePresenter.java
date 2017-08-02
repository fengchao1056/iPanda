package com.example.a123.pandatv.module.pandahome;


import com.example.a123.pandatv.model.biz.pandahome.PandaHomeModelImpl;
import com.example.a123.pandatv.model.biz.pandahome.Pandahomemodel;
import com.example.a123.pandatv.model.entity.PandaHomeBean;
import com.example.a123.pandatv.model.entity.UpDateLoading;
import com.example.a123.pandatv.net.callback.MyCallback;

import java.io.File;

public class HomePresenter implements HomeContract.Presenter {
    private HomeContract.View view;
    private Pandahomemodel pandahomemodel;

    public HomePresenter(HomeContract.View view) {
        this.view = view;
        view.setPresenter(this);
        pandahomemodel=new PandaHomeModelImpl();
    }

    @Override
    public void start() {

        view.loadMore();
        view.loadWebView();
        pandahomemodel.getHomeResult(new MyCallback<PandaHomeBean>() {
            @Override
            public void onSuccess(PandaHomeBean pandaHomeBean) {
                view.showHomeListData(pandaHomeBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                   view.showMessage(errorMsg);
            }
        });
        pandahomemodel.getVerSion(new MyCallback<UpDateLoading>() {
            @Override
            public void onSuccess(UpDateLoading upDateLoading) {
                view.getVersion(upDateLoading);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

    }

    @Override
    public void loadMore(int pageSize, int pageContent) {
        new PandaHomeModelImpl().loadMore(pageSize, pageContent);
    }

    @Override
    public void uplode(String url) {
         pandahomemodel.getup(url, new MyCallback<File>() {
             @Override
             public void onSuccess(File file) {
                    view.setupapk(file);
             }

             @Override
             public void onError(int errorCode, String errorMsg) {

             }
         });
    }
}
