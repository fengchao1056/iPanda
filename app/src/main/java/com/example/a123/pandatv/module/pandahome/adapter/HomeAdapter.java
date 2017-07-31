package com.example.a123.pandatv.module.pandahome.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;
import com.example.a123.pandatv.R;
import com.example.a123.pandatv.model.entity.PandaHomeBean;
import com.example.a123.pandatv.widget.manager.ToastManager;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<Object> list;
    private LayoutInflater inflater;
    public static final int TYPE1 = 1, TYPE2 = 2, TYPE3 = 3, TYPE4 = 4, TYPE5 = 5;
    public HomeAdapter(Context context, List<Object> list) {
        this.context = context;
        this.list = list;
        this.inflater=LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        Object o = list.get(position);
        //熊猫播报
        if(o instanceof PandaHomeBean.DataBean.PandaeyeBean) {
              return TYPE1;
            //熊猫直播
        }else  if(o instanceof  PandaHomeBean.DataBean.PandaliveBean){
            return TYPE2;
            //精彩一刻
        }else  if(o instanceof  PandaHomeBean.DataBean.AreaBean) {
            return TYPE3;
            //滚滚视频
        }else  if(o instanceof  PandaHomeBean.DataBean.WallliveBean) {
            return TYPE4;

        }else  if(o instanceof  PandaHomeBean.DataBean.ChinaliveBean) {
            return TYPE5;
        }
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType){
            case TYPE1:
                View view1 = inflater.inflate(R.layout.boadcast_item, parent, false);
                viewHolder = new ViewHolder(context, view1);
                break;
            case TYPE2:
                View view2=inflater.inflate(R.layout.home_liveplay_main,parent,false);
                viewHolder = new ViewHolder(context, view2);
                break;
            case TYPE3:
                 View view3=inflater.inflate(R.layout.home_splendid_main,parent,false);
                viewHolder = new ViewHolder(context, view3);
                break;
            case TYPE4:
                View view4=inflater.inflate(R.layout.home_ggvideo_main,parent,false);
                viewHolder =new ViewHolder(context,view4);
                break;
            case TYPE5:
                View view5=inflater.inflate(R.layout.home_livechina_main,parent,false);
                viewHolder =new ViewHolder(context,view5);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
         switch (itemViewType){
             case TYPE1:
                BoadCastadapter adapter=new BoadCastadapter(holder.itemView);
                 PandaHomeBean.DataBean.PandaeyeBean pandaeyeBean = (PandaHomeBean.DataBean.PandaeyeBean) list.get(position);
                 adapter.setDate(pandaeyeBean);
                 break;
             case TYPE2:
                 LiveplayAdapter liveplayAdapter=new LiveplayAdapter(holder.itemView);
                 PandaHomeBean.DataBean.PandaliveBean pandalive = (PandaHomeBean.DataBean.PandaliveBean) list.get(position);
                  liveplayAdapter.setData(pandalive);
                 break;
             case  TYPE3:
                 SplendidAdapter splendAdapter=new SplendidAdapter(holder.itemView);
                 PandaHomeBean.DataBean.AreaBean arrbean = (PandaHomeBean.DataBean.AreaBean) list.get(position);
                 splendAdapter.setData(arrbean);
                 break;
             case  TYPE4:
                 GGViewHolder ggViewHolder = new GGViewHolder(holder.itemView);
                 PandaHomeBean.DataBean.WallliveBean wallliveBean = (PandaHomeBean.DataBean.WallliveBean) list.get(position);
                 ggViewHolder.setDate(wallliveBean);
                 break;
             case  TYPE5:
                 ChinaAdapter chinaAdapter = new ChinaAdapter(holder.itemView);
                 PandaHomeBean.DataBean.ChinaliveBean ChinaliveBean = (PandaHomeBean.DataBean.ChinaliveBean) list.get(position);
                 chinaAdapter.setDate(ChinaliveBean);
                 break;

         }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
    class GGViewHolder extends RecyclerView.ViewHolder implements AdapterView.OnItemClickListener {

        private List<PandaHomeBean.DataBean.WallliveBean.ListBeanX> wallliveBeanList;
        private ListView home_ggVedio_listView;

        public GGViewHolder(View itemView) {
            super(itemView);
            home_ggVedio_listView = (ListView) itemView.findViewById(R.id.home_ggVedio_listView);
        }

        public void setDate(PandaHomeBean.DataBean.WallliveBean wallliveBean) {


            wallliveBeanList = new ArrayList<>();

            for (int i = 0; i < 5; i++) {
                wallliveBeanList.add(wallliveBean.getList().get(i));
            }
            HomeGGVideoAdapter splendidAdapter = new HomeGGVideoAdapter(context, wallliveBeanList);
            home_ggVedio_listView.setAdapter(splendidAdapter);
            home_ggVedio_listView.setOnItemClickListener(this);
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            PandaHomeBean.DataBean.WallliveBean.ListBeanX listBeanX = wallliveBeanList.get(position);
            String title = listBeanX.getTitle();
            String url = listBeanX.getUrl();
            ToastManager.show(title);

        }
    }

class ChinaAdapter extends RecyclerView.ViewHolder{
    private GridView gridView;
    private PandaHomeBean.DataBean.ChinaliveBean chinaliveBean;
    private ArrayList<PandaHomeBean.DataBean.ChinaliveBean.ListBeanXX> arraylist=new ArrayList<>();
    //home_liveChina_gridView
    public ChinaAdapter(View itemView) {
        super(itemView);
        gridView= (GridView) itemView.findViewById(R.id.home_liveChina_gridView);
    }
    public  void setDate(PandaHomeBean.DataBean.ChinaliveBean chinaliveBean){
        this.chinaliveBean=chinaliveBean;
        arraylist.addAll(chinaliveBean.getList());
        HomeChinaLiveAdapter adapter=new HomeChinaLiveAdapter(context,arraylist);
        gridView.setAdapter(adapter);

    }
}
class SplendidAdapter extends RecyclerView.ViewHolder{
    private PandaHomeBean.DataBean.AreaBean arrbean;
    private GridView gridview;
    private ArrayList<PandaHomeBean.DataBean.AreaBean.ListscrollBean> arraylist=new ArrayList<>();



    public SplendidAdapter(View itemView) {
        super(itemView);
        gridview= (GridView) itemView.findViewById(R.id.home_splendid_gridView);
    }
    public void setData(PandaHomeBean.DataBean.AreaBean arrbean){
                this.arrbean=arrbean;
        List<PandaHomeBean.DataBean.AreaBean.ListscrollBean> listscroll = arrbean.getListscroll();

        for (int i = 0; i < 4; i++) {
            arraylist.add(listscroll.get(i));
        }
        HomeSplendidAdapter adapter=new HomeSplendidAdapter(context,arraylist);
        gridview.setAdapter(adapter);

    }

}

 class LiveplayAdapter extends RecyclerView.ViewHolder implements AdapterView.OnItemClickListener {
     private PandaHomeBean.DataBean.PandaliveBean pandaliveBean;
     private GridView gridView;
     private ArrayList<PandaHomeBean.DataBean.PandaliveBean.ListBean> arrayList = new ArrayList<>();


     public LiveplayAdapter(View itemView) {
         super(itemView);
         gridView = (GridView) itemView.findViewById(R.id.home_playLive);

     }

     public void setData(PandaHomeBean.DataBean.PandaliveBean pandaliveBean) {
         this.pandaliveBean = pandaliveBean;
         List<PandaHomeBean.DataBean.PandaliveBean.ListBean> list = pandaliveBean.getList();
         arrayList.addAll(list);
         HomePandaLiveAdapter adapter = new HomePandaLiveAdapter(context, arrayList);
         gridView.setAdapter(adapter);

     }

     @Override
     public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
         String vid = arrayList.get(position).getVid();
         String id1 = arrayList.get(position).getId();
         String title = arrayList.get(position).getTitle();
         ToastManager.show(title);
     }
 }

 class BoadCastadapter extends RecyclerView.ViewHolder  {
    private ImageView imageView;
    private TextView btn1, btn2, title1, title2;
    private PandaHomeBean.DataBean.PandaeyeBean pandaeye;

    public BoadCastadapter(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.home_pandaObserver_image);
        btn1 = (TextView) itemView.findViewById(R.id.home_observer_btn1);
        btn2 = (TextView) itemView.findViewById(R.id.home_observer_btn2);
        title1 = (TextView) itemView.findViewById(R.id.home_observer_title1);
        title2 = (TextView) itemView.findViewById(R.id.home_observer_title2);
    }

    public void setDate(PandaHomeBean.DataBean.PandaeyeBean pandaeye) {
        this.pandaeye = pandaeye;
        String pandaeyelogo = pandaeye.getPandaeyelogo();
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(context).load(pandaeyelogo).into(imageView);
        btn1.setText(pandaeye.getItems().get(0).getBrief());
        btn2.setText(pandaeye.getItems().get(1).getBrief());
        title1.setText(pandaeye.getItems().get(0).getTitle());
        title2.setText(pandaeye.getItems().get(1).getTitle());

    }

 }
}
