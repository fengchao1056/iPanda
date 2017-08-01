package com.example.a123.pandatv.module.pandalivechina.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a123.pandatv.R;
import com.example.a123.pandatv.model.entity.LiveChinasBean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/28.
 */

public class LiveChinaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<LiveChinasBean.LiveBean> list;
    private Context context;
    public LiveChinaAdapter(Context context, List<LiveChinasBean.LiveBean> list) {
        this.list=list;
        this.context=context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.livechina_item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.setData(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.isEmpty()?0:list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView playVideoimg,playBtn;
        private CheckBox isShowImg;
        private TextView content,title;

        public ViewHolder(View itemView) {
            super(itemView);
            playVideoimg= (ImageView) itemView.findViewById(R.id.liveChina_itemImg);
            isShowImg= (CheckBox) itemView.findViewById(R.id.isShow_content);
            playBtn= (ImageView) itemView.findViewById(R.id.liveChina_playBtn);
            content= (TextView) itemView.findViewById(R.id.liveChina_itemContent);
            title= (TextView) itemView.findViewById(R.id.livechina_itemTitle);

        }
        public void setData(LiveChinasBean.LiveBean liveBean){
            String title = liveBean.getTitle();
            String brief = liveBean.getBrief();
            this.title.setText("[正在直播]"+title);
            this.content.setText(brief);
            playVideoimg.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Glide.with(context).load(liveBean.getImage()).asBitmap().into(playVideoimg);
            isShowImg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked){
                        content.setVisibility(View.VISIBLE);
                    }else {
                        content.setVisibility(View.GONE);
                    }

                }
            });
        }
    }
}
