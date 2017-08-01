package com.example.a123.pandatv.module.pandabroadcast.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;
import com.example.a123.pandatv.R;
import com.example.a123.pandatv.model.entity.PandaObserverFirstItemBean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/21.
 */

public class PandaObserverFirstItemAdapter extends BaseAdapter<PandaObserverFirstItemBean.VideoBean> {
    public PandaObserverFirstItemAdapter(Context context, List<PandaObserverFirstItemBean.VideoBean> datas) {
        super(context, R.layout.pandaobserver_firstitem, datas);
    }

    private IPandaObserverFirstItemListener firstItemListener;

    public void setObserverItemListener(IPandaObserverFirstItemListener firstItemListener) {
        this.firstItemListener = firstItemListener;
    }

    @Override
    public void convert(ViewHolder holder, final PandaObserverFirstItemBean.VideoBean videoBean) {
        LinearLayout linearLayout = holder.getView(R.id.pandaObserverFirstItem_linearLayout);
        holder.setText(R.id.observerfirstitem_content, videoBean.getT());
        holder.setText(R.id.observerfirstItem_time, videoBean.getLen());
        ImageView imageView = holder.getView(R.id.pandaObserverFirstItem_image);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(context).load(videoBean.getImg()).asBitmap().into(imageView);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstItemListener.setObserverVideoItemPid(videoBean);
            }
        });

    }
}
