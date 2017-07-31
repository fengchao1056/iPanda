package com.example.a123.pandatv.module.pandabroadcast.adapter;

import android.view.View;

import com.example.a123.pandatv.model.entity.PandaBoadCastBean;

/**
 * Created by Administrator on 2017/7/17.
 */

public interface OnRecyclerItemClickListener {
    void getViewContent(View view, PandaBoadCastBean.ListBean listBean);
}
