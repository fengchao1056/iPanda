package com.example.a123.pandatv.module.pandabroadcast;


import android.view.View;

import com.example.a123.pandatv.base.BaseFragment;
import com.example.a123.pandatv.model.entity.PandaHomeBean;

public class BoadCastFragment extends BaseFragment implements BoadCastContract.View{
    private BoadCastContract.Presenter presenter;
    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void loadDate() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dimissProgress() {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void setPresenter(BoadCastContract.Presenter presenter) {
       this.presenter=presenter;
    }

    @Override
    public void showResult(PandaHomeBean pandaHome) {

    }

    @Override
    public void playVideo() {

    }
}
