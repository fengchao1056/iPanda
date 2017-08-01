package com.example.a123.pandatv.module.personcenter.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.a123.pandatv.module.pandalivechina.chilefragment.LiveChinasFragment;

import java.util.List;

/**
 * Created by Administrator on 2017/7/28.
 */

public class SeeHistoryTitleAdapter extends FragmentStatePagerAdapter {
    private List<LiveChinasFragment> liveChinasFragments;
    private List<String> titles;
    public SeeHistoryTitleAdapter(FragmentManager fm, List<LiveChinasFragment> liveChinasFragments, List<String> titles) {
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
