package com.example.a123.pandatv.ui.module.pandalive;


import com.example.a123.pandatv.model.biz.pandalive.PandaLiveModelImpl;
import com.example.a123.pandatv.model.biz.pandalive.Pandalivemodel;
import com.example.a123.pandatv.model.entity.PandaHomeBean;
import com.example.a123.pandatv.net.callback.MyCallback;

public class PandaLivePresenter implements PandaLiveContract.Presenter {
    private PandaLiveContract.View view;
    private Pandalivemodel pandahomemodel;

    public PandaLivePresenter(PandaLiveContract.View view) {
        this.view = view;
        view.setPresenter(this);
        pandahomemodel=  new PandaLiveModelImpl();
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
