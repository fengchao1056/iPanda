package com.example.a123.pandatv.module.personcenter.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.a123.pandatv.R;
import com.example.a123.pandatv.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/7/31.
 */

public class SettingActivity extends BaseActivity implements View.OnClickListener,CompoundButton.OnCheckedChangeListener{
    @BindView(R.id.setting_backBtn)
    ImageView settingBackBtn;
    @BindView(R.id.login_setting_msg)
    CheckBox loginSettingMsg;
    @BindView(R.id.login_setting_videoPlay)
    CheckBox loginSettingVideoPlay;
    @BindView(R.id.clear)
    TextView clear;
    @BindView(R.id.clear_save)
    ImageView clearSave;
    @BindView(R.id.livechina_setting_clear)
    LinearLayout livechinaSettingClear;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.login_setting_help)
    LinearLayout loginSettingHelp;
    @BindView(R.id.login_setting_check)
    LinearLayout loginSettingCheck;
    @BindView(R.id.livechina_setting_likeours)
    ImageView livechinaSettingLikeours;
    @BindView(R.id.login_setting_about)
    LinearLayout loginSettingAbout;

    @Override
    protected int getLayoutId() {
        return R.layout.setting_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setListener() {
        loginSettingMsg.setOnCheckedChangeListener(this);
        loginSettingVideoPlay.setOnCheckedChangeListener(this);
        clearSave.setOnClickListener(this);
        loginSettingHelp.setOnClickListener(this);
        settingBackBtn.setOnClickListener(this);
        loginSettingCheck.setOnClickListener(this);
        loginSettingAbout.setOnClickListener(this);
    }

    @Override
    protected void setIntent() {

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.clear_save:
                break;
            case R.id.login_setting_help:
                break;
            case R.id.setting_backBtn:
                finish();
                break;
            case R.id.login_setting_check:
                break;
            case R.id.login_setting_about:
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()){
            case R.id.login_setting_msg:
                break;
            case R.id.login_setting_videoPlay:
                break;
        }
    }
}
