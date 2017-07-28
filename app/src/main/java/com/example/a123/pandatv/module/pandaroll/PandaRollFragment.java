package com.example.a123.pandatv.module.pandaroll;


import android.view.View;

import com.example.a123.pandatv.base.BaseFragment;
import com.example.a123.pandatv.model.entity.PandaHomeBean;

public class PandaRollFragment extends BaseFragment implements PandaRollContract.View {
    private PandaRollContract.Presenter presenter;
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
    public void setPresenter(PandaRollContract.Presenter presenter) {
        this.presenter=presenter;
    }

    @Override
    public void showResult(PandaHomeBean pandaHome) {

    }

    @Override
    public void playVideo() {

    }

    @Override
    public void showErrorMassage(String msg) {

    }
}
