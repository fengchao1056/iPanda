package com.example.a123.pandatv.module.pandabroadcast;


import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidkun.PullToRefreshRecyclerView;
import com.bumptech.glide.Glide;
import com.example.a123.pandatv.R;
import com.example.a123.pandatv.activity.BoadCastMainActivity;
import com.example.a123.pandatv.base.BaseFragment;
import com.example.a123.pandatv.model.entity.PandaBoadCastBean;
import com.example.a123.pandatv.module.pandabroadcast.adapter.OnRecyclerItemClickListener;
import com.example.a123.pandatv.module.pandabroadcast.adapter.PandaObserverAdapter;
import com.example.a123.pandatv.module.pandahome.adapter.HomeViewPagerAdapter;
import com.example.a123.pandatv.module.pandahome.adapter.OnViewPagerItemListener;
import com.example.a123.pandatv.utils.ACache;
import com.example.a123.pandatv.widget.manager.Dbmanager;
import com.example.a123.pandatv.widget.manager.ToastManager;
import com.example.a123.pandatv.widget.manager.green.Collect;
import com.example.a123.pandatv.widget.view.ShowDioLog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

public class BoadCastFragment extends BaseFragment implements BoadCastContract.View {
    @BindView(R.id.MCostRecycer)
    PullToRefreshRecyclerView MCostRecycer;
    Unbinder unbinder;
    private List<PandaBoadCastBean.ListBean> beanList = new ArrayList<>();
    private List<CheckBox> checkBoxes = new ArrayList<>();
    private BoadCastContract.Presenter presenter;
    private ViewPager viewpager;
    private int num = 10000;
    private List<View> viewPagerFragments = new ArrayList<>();
    private LinearLayout layout;
    private PandaObserverAdapter pandaObserverAdapter;
    private View inflate,inflate1;
    private ShowDioLog show;

    @Override
    protected int getLayoutId() {
        return R.layout.boadcast;
    }

    @Override
    protected void initView(View view) {

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayout.VERTICAL, false);
        MCostRecycer.setLayoutManager(layoutManager);
        inflate = LayoutInflater.from(getContext()).inflate(R.layout.home_viewpager_main, null);
        layout = (LinearLayout) inflate.findViewById(R.id.home_viewpager_linearLayout);
        viewpager = (ViewPager) inflate.findViewById(R.id.home_viewpager);
        MCostRecycer.addHeaderView(inflate);
        MCostRecycer.setLoadingMoreEnabled(false);
        MCostRecycer.setPullRefreshEnabled(false);
        MCostRecycer.displayLastRefreshTime(false);
        pandaObserverAdapter = new PandaObserverAdapter(getContext(), beanList);
        MCostRecycer.setAdapter(pandaObserverAdapter);


    }

    @Override
    protected void loadDate() {
        new BoadCastPresenter(this);
        presenter.start();



    }

    @Override
    protected void setListener() {
        pandaObserverAdapter.setOnRecyclerItemClickListener(new OnRecyclerItemClickListener() {
            @Override
            public void getViewContent(View view, PandaBoadCastBean.ListBean listBean) {
                String type = listBean.getType();
                Intent intent;
                if (type.endsWith("1")) {
                    ToastManager.show("播放");
                    String title = listBean.getTitle();
                    String url = listBean.getUrl();
                    String image = listBean.getImage();
                    Dbmanager.getInstance().insert(title,"",null, url,image,false);
                    List<Collect> list = Dbmanager.getInstance().list();
                    String s = list.toString();
                    ArrayList<Collect> a=new ArrayList();
                    a.addAll(list);
                    Log.e("TAG","图片地址"+a.get(4).getImage()+"title"+a.get(4).getTitle()+a.get(4).getPlaytime());
                    Log.e("TAG",a.size()+"ss"+list.size());
                } else if (type.endsWith("2")) {
                    String title = listBean.getTitle();
                    String url = listBean.getUrl();
                    String image = listBean.getImage();
                    Dbmanager.getInstance().insert(title,"",null, url,image,false);
                    List<Collect> list = Dbmanager.getInstance().list();
                    String s = list.toString();
                    ArrayList<Collect> a=new ArrayList();
                    a.addAll(list);
                    //Log.e("TAG","图片地址"+a.get(2).getImage()+"title"+a.get(2).getTitle()+a.get(2).getPlaytime());
                    Log.e("TAG",a.size()+"ss"+list.size());
                    intent = new Intent(getContext(), BoadCastMainActivity.class);
                   getContext().startActivity(intent);
                }

//                getContext().startActivity(intent);
            }
        });
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                num = position;
                for (int i = 0; i < checkBoxes.size(); i++) {
                    if (i == num % checkBoxes.size()) {
                        checkBoxes.get(i).setChecked(true);
                    } else {
                        checkBoxes.get(i).setChecked(false);
                    }
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    public void SetViewpager(final List<PandaBoadCastBean.BigImgBean> biglist) {
        CheckBox checkBox;
        View view=null;
        View view1=null;
        for (PandaBoadCastBean.BigImgBean big  : biglist){
            view1 = LayoutInflater.from(getContext()).inflate(R.layout.checkbox_item, null);
            checkBox = (CheckBox) view1.findViewById(R.id.viewpager_checkbox_btn);
            layout.addView(view1);
            checkBoxes.add(checkBox);
            view = LayoutInflater.from(getContext()).inflate(R.layout.home_viewpager_fragment, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.home_viewpager_image);
            TextView title = (TextView) view.findViewById(R.id.home_viewpager_title);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            String image = big.getImage();
            String title1 = big.getTitle();
            Glide.with(getContext()).load(image).into(imageView);
              title.setText(title1);
            viewPagerFragments.add(view);

        }
        final HomeViewPagerAdapter homeViewPagerAdapter=new HomeViewPagerAdapter(viewPagerFragments);
         viewpager.setAdapter(homeViewPagerAdapter);
         checkBoxes.get(num%checkBoxes.size()).setChecked(true);
        viewpager.setCurrentItem(checkBoxes.size());
        handler.sendEmptyMessageDelayed(222, 2000);
        homeViewPagerAdapter.setOnViewPagerItemListener(new OnViewPagerItemListener() {
            @Override
            public void onItemListener(View view, int posetion) {
                String type = biglist.get(posetion).getType();
                String pid = biglist.get(posetion).getPid();
                String image = biglist.get(posetion).getImage();
                String title = biglist.get(posetion).getTitle();
                String vid = biglist.get(posetion).getVid();
                String id = biglist.get(posetion).getId();
                String url = biglist.get(posetion).getUrl();
                Boolean isSave=false;
                if (type.endsWith("5")) {
                    Intent intent = new Intent(getContext(), BoadCastMainActivity
                            .class);
                    intent.putExtra("isSave",isSave);
                    intent.putExtra("vid",vid);
                    intent.putExtra("url", url);
                    startActivityForResult(intent,2000);
                }

            }
        });


    }

    @Override
    public void showProgress() {
        show = ShowDioLog.getInstance().show(getContext());
    }

    @Override
    public void dimissProgress() {
        show.dismiss();
    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void setPresenter(BoadCastContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showResult(PandaBoadCastBean pandaHome) {
        Log.e("TAG",pandaHome.getBigImg().size()+"");
        SetViewpager(pandaHome.getBigImg());
        beanList.addAll(pandaHome.getList());

    }
    public void setListView(List<PandaBoadCastBean.ListBean> listBeanList) {
        beanList.addAll(listBeanList);
        pandaObserverAdapter.notifyDataSetChanged();
    }
    @Override
    public void Net() {
        ACache aCache = ACache.get(getContext(),"interfaceCache");
        if (aCache.getAsObject("PandaBoadCastBean") != null) {
            PandaBoadCastBean homeBean1 = (PandaBoadCastBean) aCache.getAsObject("PandaBoadCastBean");

            setListView(homeBean1.getList());
            SetViewpager(homeBean1.getBigImg());

        }
        show.dismiss();

    }

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 222:
                    num++;
                    viewpager.setCurrentItem(num);
                    for (int i = 0; i < checkBoxes.size(); i++) {
                        if (i == num % checkBoxes.size()) {
                            checkBoxes.get(i).setChecked(true);
                        } else {
                            checkBoxes.get(i).setChecked(false);
                        }
                    }
                    handler.sendEmptyMessageDelayed(222, 2000);
                    break;
            }
        }
    };
    @Override
    public void playVideo() {

    }

}
