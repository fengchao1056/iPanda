package com.example.a123.pandatv.module.personcenter.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.a123.pandatv.R;
import com.example.a123.pandatv.base.BaseActivity;

/**
 * Created by Administrator on 2017/7/31.
 */

public class PersonActivity extends BaseActivity implements View.OnClickListener{
    private LinearLayout loginLayout,seeHistoryLayout,collectLayout;
    private ImageView backImg;
    @Override
    protected int getLayoutId() {
        return R.layout.personconte_itemr;
    }

    @Override
    protected void initView() {
        loginLayout= (LinearLayout) findViewById(R.id.login_layout);
        backImg= (ImageView) findViewById(R.id.person_backBtn);
        seeHistoryLayout= (LinearLayout) findViewById(R.id.person_seeHistory);
        collectLayout= (LinearLayout) findViewById(R.id.collect_layout);
    }

    @Override
    protected void setListener() {
        loginLayout.setOnClickListener(this);
        backImg.setOnClickListener(this);
        seeHistoryLayout.setOnClickListener(this);
        collectLayout.setOnClickListener(this);

    }

    @Override
    protected void setIntent() {

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.login_layout:
                Intent intent=new Intent(this,LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.person_backBtn:
                finish();
                break;
            case R.id.person_seeHistory:
                Intent intentSeeHistory=new Intent(this,SeeHistoryActivity.class);
                startActivity(intentSeeHistory);
                break;
            case R.id.collect_layout:
                Intent collectHistory=new Intent(this,CollectActivity.class);
                startActivity(collectHistory);
                break;
        }
    }
}
