package com.example.a123.pandatv.module.personcenter.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.a123.pandatv.R;
import com.example.a123.pandatv.base.BaseActivity;
import com.example.a123.pandatv.model.entity.LoginEntity;
import com.example.a123.pandatv.utils.ACache;

/**
 * Created by Administrator on 2017/7/31.
 */

public class PersenActivity extends BaseActivity implements View.OnClickListener{
    private LinearLayout loginLayout,seeHistoryLayout,collectLayout,settingLayout;
    private ImageView backImg;
    @Override
    protected int getLayoutId() {
        return R.layout.personconte_itemr;
    }

    @Override
    protected void initView() {
        ACache aCache= ACache.get(this);
        LoginEntity loginEntity= (LoginEntity) aCache.getAsObject("loginentity");
        if (loginEntity!=null){
            String usrid = loginEntity.getUsrid();
            loginEntity.getUser_seq_id();
        }
        loginLayout= (LinearLayout) findViewById(R.id.login_layout);
        backImg= (ImageView) findViewById(R.id.person_backBtn);
        seeHistoryLayout= (LinearLayout) findViewById(R.id.person_seeHistory);
        collectLayout= (LinearLayout) findViewById(R.id.collect_layout);
        settingLayout= (LinearLayout) findViewById(R.id.person_setting);
    }

    @Override
    protected void setListener() {
        loginLayout.setOnClickListener(this);
        backImg.setOnClickListener(this);
        seeHistoryLayout.setOnClickListener(this);
        collectLayout.setOnClickListener(this);
        settingLayout.setOnClickListener(this);

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
            case R.id.person_setting:
                Intent setting=new Intent(this,SettingActivity.class);
                startActivity(setting);
                break;
        }
    }
}
