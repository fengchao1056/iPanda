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

public class HomeGGVideoAdapter extends BaseAdapter {
    private List<PandaHomeBean.DataBean.WallliveBean.ListBeanX> pandaliveBeans;
    private LayoutInflater inflater;
    private Context context;
    public HomeGGVideoAdapter(Context context, List<PandaHomeBean.DataBean.WallliveBean.ListBeanX> pandaliveBeans){
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
            convertView=inflater.inflate(R.layout.observer_adapter_item,null);
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
        TextView title;
        public HolderView(View view){
            imageView= (ImageView) view.findViewById(R.id.observer_list_image);
            title= (TextView) view.findViewById(R.id.observer_list_title);
        }
        public void setDate(PandaHomeBean.DataBean.WallliveBean.ListBeanX bean){
            String image = bean.getImage();
            String title = bean.getTitle();

            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Glide.with(context).load(image).asBitmap().into(imageView);
            this.title.setText(title);
        }
    }
}
