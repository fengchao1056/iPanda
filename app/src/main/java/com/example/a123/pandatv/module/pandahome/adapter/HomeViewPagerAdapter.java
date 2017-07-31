package com.example.a123.pandatv.module.pandahome.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2017/7/13.
 */

public class HomeViewPagerAdapter extends PagerAdapter {
    private List<View> list;
    public HomeViewPagerAdapter(List<View> list){
        this.list=list;
    }
    @Override
    public int getCount() {
        return list.size()>0?Integer.MAX_VALUE:0;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }

    private OnViewPagerItemListener onViewPagerItemListener;
    public void setOnViewPagerItemListener(OnViewPagerItemListener onViewPagerItemListener){
        this.onViewPagerItemListener=onViewPagerItemListener;
    }
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        final View view = list.get(position % list.size());
        if (view.getParent()!=null){
            ((ViewGroup) view.getParent()).removeView(view);
        }
        if (list.size()>0)
            container.addView(list.get(position%list.size()));
     /*   view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onViewPagerItemListener.onItemListener(view,position % list.size());
            }
        });*/
        return list.get(position%list.size());
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
