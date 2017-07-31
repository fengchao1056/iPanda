package com.example.a123.pandatv.module.pandalivechina;


import com.example.a123.pandatv.model.biz.chinalive.ChinaliveModelImpl;
import com.example.a123.pandatv.model.biz.chinalive.Chinalivemodel;
import com.example.a123.pandatv.model.entity.LiveChinaTitleBean;
import com.example.a123.pandatv.net.callback.MyCallback;

public class ChinaLivePresenter implements ChinaLiveContract.Presenter {
    private ChinaLiveContract.View view;
    private Chinalivemodel chinalivemodel;

    public ChinaLivePresenter(ChinaLiveContract.View view) {
        this.view = view;
        view.setPresenter(this);
        chinalivemodel = new ChinaliveModelImpl();
    }

    @Override
    public void start() {
        chinalivemodel.getLiveChinasResult(new MyCallback<LiveChinaTitleBean>() {
            @Override
            public void onSuccess(LiveChinaTitleBean liveChinaBean) {
                view.showResult(liveChinaBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                view.showMessage(errorMsg);
            }
        });
    }

    @Override
    public void showPopup() {
        view.showPopup();
    }
}
