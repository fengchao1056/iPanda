package com.example.a123.pandatv.module.pandahome.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Administrator on 2017/7/13.
 */

public class StartViewPagerAdapter extends PagerAdapter {
    private List<ImageView> imageViews;
    public StartViewPagerAdapter(List<ImageView> imageViews){
        this.imageViews=imageViews;
    }
    @Override
    public int getCount() {
        return imageViews.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        if (imageViews!=null)
            container.addView(imageViews.get(position));
        return imageViews.get(position);
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        if (imageViews!=null){
            container.removeView(imageViews.get(position));
        }
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
