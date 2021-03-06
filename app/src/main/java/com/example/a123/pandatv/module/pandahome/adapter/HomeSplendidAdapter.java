package com.example.a123.pandatv.module.pandahome.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a123.pandatv.R;
import com.example.a123.pandatv.model.entity.PandaHomeBean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/14.
 */

public class HomeSplendidAdapter extends BaseAdapter {
    private List<PandaHomeBean.DataBean.AreaBean.ListscrollBean> pandaliveBeans;
    private LayoutInflater inflater;
    private Context context;
    public HomeSplendidAdapter(Context context, List<PandaHomeBean.DataBean.AreaBean.ListscrollBean> pandaliveBeans){
        inflater=LayoutInflater.from(context);
        this.pandaliveBeans=pandaliveBeans;
        this.context=context;
    }
    @Override
    public int getCount() {
        return pandaliveBeans.isEmpty()?0:pandaliveBeans.size();
    }

    @Override
    public Object getItem(int position) {
        return pandaliveBeans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HolderView holderView=null;
        if (convertView==null){
            convertView=inflater.inflate(R.layout.home_splendid_item,null);
            holderView=new HolderView(convertView);
            convertView.setTag(holderView);
        }else {
            holderView= (HolderView) convertView.getTag();
        }
        holderView.setDate(pandaliveBeans.get(position));
        return convertView;
    }
    class HolderView{
        ImageView imageView;
        TextView title,tv_splendid_item;
        public HolderView(View view){
            imageView= (ImageView) view.findViewById(R.id.homesplendid_image);
            title= (TextView) view.findViewById(R.id.homesplendid_title);
            tv_splendid_item= (TextView) view.findViewById(R.id.tv_splendid_item);

        }
        public void setDate(PandaHomeBean.DataBean.AreaBean.ListscrollBean bean){
            String image = bean.getImage();
            String title = bean.getTitle();

            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Glide.with(context).load(image).asBitmap().into(imageView);
            this.title.setText(title);
        }
    }
}
