package com.example.a123.pandatv.module.pandabroadcast;


import com.example.a123.pandatv.model.biz.pandabroadcast.BoadCastmodel;
import com.example.a123.pandatv.model.biz.pandabroadcast.BoadCatModelImpl;
import com.example.a123.pandatv.model.entity.PandaHomeBean;
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
        pandahomemodel.getResult(new MyCallback<PandaHomeBean>() {
            @Override
            public void onSuccess(PandaHomeBean pandaHomeBean)
            {
                view.showResult(pandaHomeBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

    }
}
