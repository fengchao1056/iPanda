package com.example.a123.pandatv.module.personcenter.activity;

import android.view.View;
import android.widget.ImageView;

import com.example.a123.pandatv.R;
import com.example.a123.pandatv.base.BaseActivity;

/**
 * Created by Administrator on 2017/7/31.
 */

public class SeeHistoryActivity extends BaseActivity implements View.OnClickListener{
    private ImageView historyBackBtn;
    @Override
    protected int getLayoutId() {
        return R.layout.history_main;
    }

    @Override
    protected void initView() {
        historyBackBtn= (ImageView) findViewById(R.id.history_backBtn);
    }

    @Override
    protected void setListener() {
        historyBackBtn.setOnClickListener(this);
    }

    @Override
    protected void setIntent() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.history_backBtn:
                finish();
                break;
        }
    }
}
