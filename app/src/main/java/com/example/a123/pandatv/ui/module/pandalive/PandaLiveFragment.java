package com.example.a123.pandatv.ui.module.pandalive;


import android.view.View;

import com.example.a123.pandatv.R;
import com.example.a123.pandatv.base.BaseFragment;
import com.example.a123.pandatv.model.entity.PandaHomeBean;

public class PandaLiveFragment extends BaseFragment implements PandaLiveContract.View {
    private PandaLiveContract.Presenter presenter;
    @Override
    protected int getLayoutId() {
        return R.layout.pandalive;
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
    public void setPresenter(PandaLiveContract.Presenter presenter) {
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
