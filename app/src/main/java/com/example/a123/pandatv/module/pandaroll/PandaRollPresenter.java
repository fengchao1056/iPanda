package com.example.a123.pandatv.module.pandaroll;


import com.example.a123.pandatv.model.biz.pandaroll.PandaRollModelImpl;
import com.example.a123.pandatv.model.biz.pandaroll.PandaRollemodel;

public class PandaRollPresenter implements PandaRollContract.Presenter {
    private PandaRollContract.View view;
    private PandaRollemodel pandahomemodel;

    public PandaRollPresenter(PandaRollContract.View view) {
        this.view = view;
        view.setPresenter(this);
        pandahomemodel=new PandaRollModelImpl();
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
