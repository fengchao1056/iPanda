package com.example.a123.pandatv.module.pandahome;


import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.example.a123.pandatv.R;
import com.example.a123.pandatv.base.BaseFragment;
import com.example.a123.pandatv.model.entity.PandaHomeBean;
import com.example.a123.pandatv.module.pandahome.adapter.HomeAdapter;
import com.example.a123.pandatv.widget.view.ShowDioLog;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

public class HomeFragment extends BaseFragment implements HomeContract.View {
   /* @BindView(R.id.banner)
    Banner banner;*/
    @BindView(R.id.homeRecyclerView)
    XRecyclerView homeRecyclerView;
    Unbinder unbinder;



    private HomeContract.Presenter presenter;
    private ArrayList<Object> arrayList = new ArrayList<>();
    private ShowDioLog show;


    @Override
    protected int getLayoutId() {
        return R.layout.pandahome;
    }

    @Override
    protected void initView(View view) {

        show = ShowDioLog.getInstance().show(getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
       /* View inflate = LayoutInflater.from(getContext()).inflate(R.layout.banner, null);
        banner= (Banner) inflate.findViewById(R.id.banner);
        homeRecyclerView.addView(inflate);*/
        homeRecyclerView.setLayoutManager(manager);

    }

    @Override
    protected void loadDate() {
        new HomePresenter(this);
        presenter.start();

    }

    @Override
    protected void setListener() {

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
       /* banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        banner.setImageLoader(new MyLoad());
        banner.setImages(image);
        banner.setBannerAnimation(Transformer.Default);
        banner.setBannerTitles(text);
        banner.setDelayTime(2000);
        banner.isAutoPlay(true);
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.start();*/

        arrayList.add(data.getPandaeye());
        arrayList.add(data.getPandalive());
        arrayList.add(data.getArea());
        HomeAdapter adapter = new HomeAdapter(getContext(), arrayList);
        homeRecyclerView.setAdapter(adapter);
        show.dismiss();
    }

    @Override
    public void playVideo() {

    }

    @Override
    public void loadWebView() {

    }

}
