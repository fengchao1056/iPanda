package com.example.a123.pandatv.module.pandabroadcast;


import com.example.a123.pandatv.model.biz.pandabroadcast.BoadCastmodel;
import com.example.a123.pandatv.model.biz.pandabroadcast.BoadCatModelImpl;
import com.example.a123.pandatv.model.entity.PandaObserverFirstItemBean;
import com.example.a123.pandatv.net.callback.MyCallback;

public class BoadcastItemCastPresenter implements BoadcastItemContract.Presenter {
    private BoadcastItemContract.View view;
    private BoadCastmodel pandahomemodel;

    public BoadcastItemCastPresenter(BoadcastItemContract.View view) {
        this.view = view;
        view.setPresenter(this);
        pandahomemodel=  new BoadCatModelImpl();
    }

    @Override
    public void start() {
        view.showProgress();
        pandahomemodel.getOneItem(new MyCallback<PandaObserverFirstItemBean>() {
            @Override
            public void onSuccess(PandaObserverFirstItemBean BoadCastBean)
            {
                view.setResulte(BoadCastBean);
                view.dimissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

    }
}
