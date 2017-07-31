package com.example.a123.pandatv.module.pandabroadcast;


import com.example.a123.pandatv.model.biz.pandabroadcast.BoadCastmodel;
import com.example.a123.pandatv.model.biz.pandabroadcast.BoadCatModelImpl;
import com.example.a123.pandatv.model.entity.PandaBoadCastBean;
import com.example.a123.pandatv.net.callback.MyCallback;

public class BoadCastPresenter implements BoadCastContract.Presenter {
    private BoadCastContract.View view;
    private BoadCastmodel pandahomemodel;

    public BoadCastPresenter(BoadCastContract.View view) {
        this.view = view;
        view.setPresenter(this);
        pandahomemodel=  new BoadCatModelImpl();
    }

    @Override
    public void start() {
        view.showProgress();
        pandahomemodel.getResult(new MyCallback<PandaBoadCastBean>() {
            @Override
            public void onSuccess(PandaBoadCastBean BoadCastBean)
            {
                view.showResult(BoadCastBean);
                view.dimissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

    }
}
