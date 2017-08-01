package com.example.a123.pandatv.module.personcenter.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.a123.pandatv.R;
import com.example.a123.pandatv.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/7/31.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.login_radiobutton_wenxin)
    RadioButton loginRadiobuttonWenxin;
    @BindView(R.id.login_radiobutton_qq)
    RadioButton loginRadiobuttonQq;
    @BindView(R.id.login_radiobutton_sina)
    RadioButton loginRadiobuttonSina;
    @BindView(R.id.login_radiogroup)
    RadioGroup loginRadiogroup;
    @BindView(R.id.login_edit_number)
    EditText loginEditNumber;
    @BindView(R.id.login_edit_password)
    EditText loginEditPassword;
    @BindView(R.id.livechina_wangjimimaa)
    TextView livechinaWangjimimaa;
    @BindView(R.id.login_button)
    Button loginButton;
    @BindView(R.id.login_backImg)
    ImageView loginBackImg;

    @Override
    protected int getLayoutId() {
        return R.layout.login_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setListener() {
        loginBackImg.setOnClickListener(this);
    }

    @Override
    protected void setIntent() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_backImg:
                finish();
                break;
        }
    }

}
