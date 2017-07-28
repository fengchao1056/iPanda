package com.example.a123.pandatv.module.pandalivechina;


import com.example.a123.pandatv.model.biz.chinalive.ChinaliveModelImpl;
import com.example.a123.pandatv.model.biz.chinalive.Chinalivemodel;

public class ChinaLivePresenter implements ChinaLiveContract.Presenter {
    private ChinaLiveContract.View view;
    private Chinalivemodel pandahomemodel;

    public ChinaLivePresenter(ChinaLiveContract.View view) {
        this.view = view;
        view.setPresenter(this);
        pandahomemodel=new ChinaliveModelImpl();
    }

    @Override
    public void start() {
      /*  pandahomemodel.getResult(new MyCallback<PandaHomeBean>() {
            @Override
            public void onSuccess(PandaHomeBean pandaHomeBean) {
                view.showResult(pandaHomeBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });*/

    }
}
