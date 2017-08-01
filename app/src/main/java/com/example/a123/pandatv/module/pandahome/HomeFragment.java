package com.example.a123.pandatv.module.pandahome;


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

import com.bumptech.glide.Glide;
import com.example.a123.pandatv.R;
import com.example.a123.pandatv.app.App;
import com.example.a123.pandatv.base.BaseFragment;
import com.example.a123.pandatv.model.entity.PandaHomeBean;
import com.example.a123.pandatv.module.pandahome.adapter.HomeAdapter;
import com.example.a123.pandatv.module.pandahome.adapter.HomeViewPagerAdapter;
import com.example.a123.pandatv.module.pandahome.adapter.OnViewPagerItemListener;
import com.example.a123.pandatv.utils.ACache;
import com.example.a123.pandatv.widget.view.ShowDioLog;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

public class HomeFragment extends BaseFragment implements HomeContract.View {
   /* @BindView(R.id.banner)
    Banner banner;*/
    @BindView(R.id.homeRecyclerView)
    XRecyclerView homeRecyclerView;
    Unbinder unbinder;


    private LinearLayout homeViewpagerLinearLayout;
    private HomeContract.Presenter presenter;
    private ArrayList<Object> arrayList = new ArrayList<>();
    private ShowDioLog show;
    private Banner banner;
    private int currmentNum = 100000;
    private List<CheckBox> checkBoxes = new ArrayList<>();
    private ViewPager homeViewpager;
    private List<View> viewPagerFragments = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.pandahome;
    }

    @Override
    protected void initView(View view) {

        show = ShowDioLog.getInstance().show(getContext());

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.home_viewpager_main, null);
        homeViewpagerLinearLayout = (LinearLayout) inflate.findViewById(R.id.home_viewpager_linearLayout);
        homeViewpager = (ViewPager) inflate.findViewById(R.id.home_viewpager);
        homeRecyclerView.addHeaderView(inflate);
        homeRecyclerView.setLayoutManager(manager);
        homeRecyclerView.setPullRefreshEnabled(false);
        homeRecyclerView.setLoadingMoreEnabled(false);



    }

    @Override
    protected void loadDate() {
        new HomePresenter(this);
        presenter.start();

    }

    @Override
    protected void setListener() {
        homeViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currmentNum = position;
                for (int i = 0; i < checkBoxes.size(); i++) {
                    if (i == currmentNum % checkBoxes.size()) {
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

    @Override
    public void showProgress() {

    }

    @Override
    public void dimissProgress() {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showHomeListData(PandaHomeBean pandaHome) {
        PandaHomeBean.DataBean data = pandaHome.getData();
        Log.e("TAG", "+++++" + data.toString());
        ArrayList<String> text = new ArrayList<>();
        ArrayList<String> image = new ArrayList<>();
        for (int i = 0; i < data.getBigImg().size(); i++) {
            text.add(data.getBigImg().get(i).getTitle());
            image.add(data.getBigImg().get(i).getImage());
        }

        arrayList.add(data.getPandaeye());
        arrayList.add(data.getPandalive());
        arrayList.add(data.getArea());
        arrayList.add(data.getWalllive());
        arrayList.add(data.getChinalive());
        HomeAdapter adapter = new HomeAdapter(getContext(), arrayList);
        homeRecyclerView.setAdapter(adapter);
        List<PandaHomeBean.DataBean.BigImgBean> bigImg = pandaHome.getData().getBigImg();
        showViewPager(bigImg);
       /* homeRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                homeRecyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        arrayList.clear();
                        loadDate();
                    }
                },2000);
            }

            @Override
            public void onLoadMore() {

            }
        });*/
       show.dismiss();
    }

    @Override
    public void playVideo() {

    }

    @Override
    public void loadWebView() {

    }
    //轮播图
    public void showViewPager(final List<PandaHomeBean.DataBean.BigImgBean> bigImgBeanList) {
        View view = null;
        CheckBox checkBox;
        View view1 = null;
        for (PandaHomeBean.DataBean.BigImgBean bigImgBean : bigImgBeanList) {
            view1 = LayoutInflater.from(getContext()).inflate(R.layout.checkbox_item, null);
            checkBox = (CheckBox) view1.findViewById(R.id.viewpager_checkbox_btn);

            homeViewpagerLinearLayout.addView(view1);
            checkBoxes.add(checkBox);
            view = LayoutInflater.from(getContext()).inflate(R.layout.home_viewpager_fragment, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.home_viewpager_image);
            TextView title = (TextView) view.findViewById(R.id.home_viewpager_title);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            String image = bigImgBean.getImage();
            String titlestr = bigImgBean.getTitle();
            Glide.with(getContext()).load(image).into(imageView);
            title.setText(titlestr);
            viewPagerFragments.add(view);
        }
        HomeViewPagerAdapter adapter = new HomeViewPagerAdapter(viewPagerFragments);
        homeViewpager.setAdapter(adapter);
        checkBoxes.get(currmentNum % checkBoxes.size()).setChecked(true);
        homeViewpager.setCurrentItem(currmentNum);

        handler.sendEmptyMessageDelayed(222, 2000);
        adapter.setOnViewPagerItemListener(new OnViewPagerItemListener() {
            @Override
            public void onItemListener(View view, int posetion) {
                String url = bigImgBeanList.get(posetion).getUrl();
                String pid = bigImgBeanList.get(posetion).getPid();
                String stype = bigImgBeanList.get(posetion).getStype();
                String type = bigImgBeanList.get(posetion).getType();
                String title = bigImgBeanList.get(posetion).getTitle();
                String image = bigImgBeanList.get(posetion).getImage();
                String id = bigImgBeanList.get(posetion).getId();

            }
        });
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 222:
                    currmentNum++;
                    homeViewpager.setCurrentItem(currmentNum);
                    for (int i = 0; i < checkBoxes.size(); i++) {
                        if (i == currmentNum % checkBoxes.size()) {
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
    public void Net() {

        ACache aCache = ACache.get(App.context,"interfaceCache");
        if (aCache.getAsObject("PandaHomeBean")!=null){
            PandaHomeBean homeBean = (PandaHomeBean) aCache.getAsObject("PandaHomeBean");
            PandaHomeBean.DataBean data = homeBean.getData();
            List<Object> list = new ArrayList<>();
            list.add(data.getPandaeye());
            list.add(data.getPandalive());
            list.add(data.getArea());
            list.add(data.getWalllive());
            list.add(data.getChinalive());
            HomeAdapter adapter = new HomeAdapter(getContext(), list);
            homeRecyclerView.setAdapter(adapter);
            List<PandaHomeBean.DataBean.BigImgBean> bigImgBeanList = homeBean.getData().getBigImg();
            showViewPager(bigImgBeanList);
            show.dismiss();
        }
    }
}
