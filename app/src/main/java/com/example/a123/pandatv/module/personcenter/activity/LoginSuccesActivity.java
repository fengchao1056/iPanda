package com.example.a123.pandatv.module.personcenter.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.a123.pandatv.R;
import com.example.a123.pandatv.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/1.
 */

public class LoginSuccesActivity extends BaseActivity implements View.OnClickListener{
    @BindView(R.id.loginsuc_return_imageView)
    ImageView loginsucReturnImageView;
    @BindView(R.id.imge)
    ImageView imge;
    @BindView(R.id.touxiang)
    LinearLayout touxiang;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.nicheng)
    LinearLayout nicheng;
    @BindView(R.id.outLogin_btn)
    Button outLoginBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.loginsucces_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setListener() {
        loginsucReturnImageView.setOnClickListener(this);
    }

    @Override
    protected void setIntent() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginsuc_return_imageView:
                finish();
                break;
        }
    }
}
