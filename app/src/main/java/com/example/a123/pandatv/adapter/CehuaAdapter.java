package com.example.a123.pandatv.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;
import com.example.a123.pandatv.R;
import com.example.a123.pandatv.activity.WebActivity;
import com.example.a123.pandatv.model.entity.CehuaBean;

import java.util.List;


/**
 * Created by lenovo on 2017/7/15.
 */

public class CehuaAdapter extends BaseAdapter<CehuaBean.InteractiveBean> {


    public CehuaAdapter(Context context, List datas) {
        super(context, R.layout.cehua_item, datas);
    }


    @Override
    public void convert(ViewHolder holder, final CehuaBean.InteractiveBean interactiveBean) {

        holder.setText(R.id.cehua_item_tv,interactiveBean.getTitle());
        ImageView img = (ImageView) holder.itemView.findViewById(R.id.cehua_item_img);
        img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(context).load(interactiveBean.getImage()).into(img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,WebActivity.class);
                intent.putExtra("url",interactiveBean.getUrl());
                context.startActivity(intent);
            }
        });
    }
}
