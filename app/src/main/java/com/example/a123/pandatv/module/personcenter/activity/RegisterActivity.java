package com.example.a123.pandatv.module.personcenter.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.example.a123.pandatv.R;
import com.example.a123.pandatv.base.BaseActivity;
import com.example.a123.pandatv.base.BaseFragment;
import com.example.a123.pandatv.module.personcenter.adapter.CollectTitleAdapter;
import com.example.a123.pandatv.module.personcenter.fragment.EmailRegisterFragment;
import com.example.a123.pandatv.module.personcenter.fragment.PhoneRegisterFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/1.
 */

public class RegisterActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.person_backBtn)
    ImageView personBackBtn;
    @BindView(R.id.register_tab)
    TabLayout registerTab;
    @BindView(R.id.register_viewPager)
    ViewPager registerViewPager;

    private List<BaseFragment> fragments = new ArrayList<>();
    private List<String> collectTitleList = new ArrayList<>();
    private CollectTitleAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.register_main;
    }

    @Override
    protected void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        registerTab.setTabMode(TabLayout.MODE_FIXED);

    }

    @Override
    protected void setListener() {
        personBackBtn.setOnClickListener(this);
    }

    @Override
    protected void setIntent() {
        collectTitleList.clear();
        fragments.clear();
        collectTitleList.add("手机注册");
        collectTitleList.add("邮箱注册");

        fragments.add(new PhoneRegisterFragment());
        fragments.add(new EmailRegisterFragment());

        adapter=new CollectTitleAdapter(getSupportFragmentManager(),fragments,collectTitleList);
        registerViewPager.setAdapter(adapter);
        registerTab.setupWithViewPager(registerViewPager);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.person_backBtn:
                finish();
                break;
        }
    }
}
