package com.example.a123.pandatv.module.pandalivechina.chilefragment;

import com.example.a123.pandatv.model.biz.chinalive.ChinaliveModelImpl;
import com.example.a123.pandatv.model.biz.chinalive.Chinalivemodel;
import com.example.a123.pandatv.model.entity.LiveChinasBean;
import com.example.a123.pandatv.net.callback.MyCallback;

/**
 * Created by Administrator on 2017/7/28.
 */

public class LiveChinasPresenter implements LiveChiansContract.Presenter {
    private LiveChiansContract.View view;
    private Chinalivemodel chinalivemodel;
    public LiveChinasPresenter(LiveChiansContract.View view) {
        this.view=view;
        this.view.setPresenter(this);
        chinalivemodel=new ChinaliveModelImpl();
    }

    @Override
    public void start() {

    }

    @Override
    public void setResult(String url) {
        chinalivemodel.getLiveChinaResult(url, new MyCallback<LiveChinasBean>() {
            @Override
            public void onSuccess(LiveChinasBean liveChinaFragmentBean) {
                view.setLiveChinaFragment(liveChinaFragmentBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                view.showMessage(errorMsg);
            }
        });
    }
}
