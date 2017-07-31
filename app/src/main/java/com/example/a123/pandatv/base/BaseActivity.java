package com.example.a123.pandatv.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
//      App.iHttp = new HttpFactory().create();
        //AppManager.getAppManager().addActivity(this);
        initView();
        setListener();
        setIntent();

    }

    protected  abstract int getLayoutId();
    protected  abstract void initView();
    protected abstract void setListener();
    protected abstract void setIntent();
}
