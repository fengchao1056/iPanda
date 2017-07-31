package com.example.a123.pandatv.module.personcenter.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.example.a123.pandatv.R;
import com.example.a123.pandatv.base.BaseActivity;
import com.example.a123.pandatv.base.BaseFragment;
import com.example.a123.pandatv.module.personcenter.adapter.CollectTitleAdapter;
import com.example.a123.pandatv.module.personcenter.fragment.LiveFragment;
import com.example.a123.pandatv.module.personcenter.fragment.SeeVedioFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/7/31.
 */

public class CollectActivity extends BaseActivity implements View.OnClickListener{
    @BindView(R.id.collect_backBtn)
    ImageView collectBackBtn;
    @BindView(R.id.collect_tab)
    TabLayout collectTab;
    @BindView(R.id.collect_viewPager)
    ViewPager collectViewPager;

    private List<BaseFragment> fragments=new ArrayList<>();
    private List<String> collectTitleList=new ArrayList<>();
    private CollectTitleAdapter adapter;
    @Override
    protected int getLayoutId() {
        return R.layout.collect_main;
    }

    @Override
    protected void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        collectTab.setTabMode(TabLayout.MODE_FIXED);

    }

    @Override
    protected void setListener() {
        collectBackBtn.setOnClickListener(this);
    }

    @Override
    protected void setIntent() {
        collectTitleList.clear();
        fragments.clear();
        collectTitleList.add("直播");
        collectTitleList.add("精彩看点");

        fragments.add(new LiveFragment());
        fragments.add(new SeeVedioFragment());

        adapter=new CollectTitleAdapter(getSupportFragmentManager(),fragments,collectTitleList);
        collectViewPager.setAdapter(adapter);
        collectTab.setupWithViewPager(collectViewPager);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.collect_backBtn:
                finish();
                break;
        }
    }
}
