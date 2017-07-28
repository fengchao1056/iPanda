package com.example.a123.pandatv.module.pandahome;


import android.view.View;

import com.example.a123.pandatv.R;
import com.example.a123.pandatv.base.BaseFragment;
import com.example.a123.pandatv.model.entity.PandaHomeBean;

import java.util.ArrayList;

public class HomeFragment extends BaseFragment implements HomeContract.View {
    private HomeContract.Presenter presenter;
    private ArrayList<Object> arrayList=new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.pandahome;
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
    public void setPresenter(HomeContract.Presenter presenter) {
        this.presenter=presenter;
    }

    @Override
    public void showHomeListData(PandaHomeBean pandaHome) {
        PandaHomeBean.DataBean.AreaBean area = pandaHome.getData().getArea();
        arrayList.add(area);

    }

    @Override
    public void playVideo() {

    }

    @Override
    public void loadWebView() {

    }
}
