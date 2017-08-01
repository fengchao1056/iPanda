package com.example.a123.pandatv.module.personcenter.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.a123.pandatv.base.BaseFragment;
import com.example.a123.pandatv.module.pandalivechina.chilefragment.LiveChinasFragment;

import java.util.List;

/**
 * Created by Administrator on 2017/7/28.
 */

public class CollectTitleAdapter extends FragmentStatePagerAdapter {
    private List<BaseFragment> liveChinasFragments;
    private List<String> titles;
    public CollectTitleAdapter(FragmentManager fm, List<BaseFragment> liveChinasFragments, List<String> titles) {
        super(fm);
        this.liveChinasFragments=liveChinasFragments;
        this.titles=titles;
    }

    @Override
    public Fragment getItem(int position) {
        return liveChinasFragments.get(position);
    }

    @Override
    public int getCount() {
        return liveChinasFragments.isEmpty()?0:liveChinasFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
