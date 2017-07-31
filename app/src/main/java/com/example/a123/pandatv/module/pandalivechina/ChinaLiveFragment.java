package com.example.a123.pandatv.module.pandalivechina;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.a123.pandatv.R;
import com.example.a123.pandatv.base.BaseFragment;
import com.example.a123.pandatv.model.entity.LiveChinaTitleBean;
import com.example.a123.pandatv.model.entity.LiveChinasBean;
import com.example.a123.pandatv.module.pandalivechina.adapter.ChinaLiveTitleAdapter;
import com.example.a123.pandatv.module.pandalivechina.chilefragment.LiveChinasFragment;
import com.example.a123.pandatv.utils.ACache;
import com.example.a123.pandatv.view.DragAdapter;
import com.example.a123.pandatv.view.DragGridView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class ChinaLiveFragment extends BaseFragment implements ChinaLiveContract.View, CompoundButton.OnCheckedChangeListener {
    @BindView(R.id.liveChina_tabLayout)
    TabLayout liveChinaTabLayout;
    @BindView(R.id.liveChina_addFragment)
    ImageView liveChinaAddFragment;
    @BindView(R.id.liveChina_viewPager)
    ViewPager liveChinaViewPager;

    private ChinaLiveContract.Presenter presenter;
    private List<String> tablistBeens = new ArrayList<>();
    private List<String> allTitleName = new ArrayList<>();
    private Map<String, String> tagUrlMap;
    private List<LiveChinasFragment> liveChinasFragments = new ArrayList<>();
    private ChinaLiveTitleAdapter chinaLiveAdapter;

    private PopupWindow popupWindow;
    private DragGridView gridView;
    private DragGridView gridView_other;
    private CheckBox checkBox;
    private DragAdapter dragAdapter;
    private DragAdapter other_adapter;
    private List<String> channels = new ArrayList<>();
    private List<String> channels_other = new ArrayList<>();
    private ACache aCache;

    @Override
    protected int getLayoutId() {
        return R.layout.livechina_main;
    }

    @Override
    protected void initView(View view) {
        aCache = ACache.get(getContext());
        liveChinasFragments = new ArrayList<>();
        tablistBeens = new ArrayList<>();
        new ChinaLivePresenter(this);
    }

    @Override
    protected void loadDate() {
        presenter.start();
    }


    @Override
    protected void setListener() {
        liveChinaAddFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.showPopup();
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
    public void setPresenter(ChinaLiveContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showResult(LiveChinaTitleBean liveChinaBean) {

        LiveChinaTitleBean livechinaTabBean1 = (LiveChinaTitleBean) aCache.getAsObject("livechinaTabBean");
        if (livechinaTabBean1 == null) {
            livechinaTabBean1 = liveChinaBean;
        }
        add_Fragment(livechinaTabBean1);
        List<LiveChinaTitleBean.TablistBean> tablist = livechinaTabBean1.getTablist();
        List<LiveChinaTitleBean.AlllistBean> alllist = livechinaTabBean1.getAlllist();
        initDatatitle(tablist);
        initDataOther(alllist);

    }

    public void add_Fragment(LiveChinaTitleBean popupBean) {
        tablistBeens = new ArrayList<>();
        liveChinasFragments = new ArrayList<>();
        tagUrlMap = new HashMap<>();
        List<LiveChinaTitleBean.TablistBean> tablist = popupBean.getTablist();
        List<LiveChinaTitleBean.AlllistBean> alllist = popupBean.getAlllist();
        LiveChinasFragment liveChinasFragment = null;
        Bundle bundle = null;
        for (LiveChinaTitleBean.TablistBean tablistBean : tablist) {
            tablistBeens.add(tablistBean.getTitle());
            liveChinasFragment = new LiveChinasFragment();
            bundle = new Bundle();
            bundle.putString("url", tablistBean.getUrl());
            liveChinasFragment.setBundle(bundle);
            tagUrlMap.put(tablistBean.getTitle(), tablistBean.getUrl());
            liveChinasFragments.add(liveChinasFragment);
        }
        for (LiveChinaTitleBean.AlllistBean alllistBean : alllist) {

            tagUrlMap.put(alllistBean.getTitle(), alllistBean.getUrl());
        }
        liveChinaTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        chinaLiveAdapter = new ChinaLiveTitleAdapter(getChildFragmentManager(), liveChinasFragments, tablistBeens);
        liveChinaViewPager.setAdapter(chinaLiveAdapter);
        liveChinaTabLayout.setupWithViewPager(liveChinaViewPager);

    }

    @Override
    public void initDataOther(List<LiveChinaTitleBean.AlllistBean> alllistBeanList) {
        for (LiveChinaTitleBean.AlllistBean alllistBean : alllistBeanList) {
            channels_other.add(alllistBean.getTitle());
        }
    }

    @Override
    public void initDatatitle(List<LiveChinaTitleBean.TablistBean> tablistBeanList) {
        for (LiveChinaTitleBean.TablistBean alllistBean : tablistBeanList) {
            channels.add(alllistBean.getTitle());
        }
    }

    @Override
    public void showPopup() {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.activity_popup_columns, null);

        popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(null);
        popupWindow.setOutsideTouchable(true);
        ImageView imageView = (ImageView) view.findViewById(R.id.fanhui);
        gridView = (DragGridView) view.findViewById(R.id.gridView_channel);
        gridView_other = (DragGridView) view.findViewById(R.id.gridView_channel_other);
        checkBox = (CheckBox) view.findViewById(R.id.licechina_add_button);
        checkBox.setOnCheckedChangeListener(this);

        gridView.setNumColumns(3);
        dragAdapter = new DragAdapter(getActivity(), channels);
        gridView.setAdapter(dragAdapter);

        other_adapter = new DragAdapter(getActivity(), channels_other);
        gridView_other.setAdapter(other_adapter);
        gridView_other.setNumColumns(3);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.activity_main, null);
        View linearLayout = inflate.findViewById(R.id.main_linearLayout);
        popupWindow.showAsDropDown(linearLayout);
    }

    @Override
    public void setRefresh() {

        tablistBeens.clear();
        liveChinasFragments.clear();

        LiveChinasFragment liveChinasFragment = null;
        Bundle bundle = null;
        for (int i = 0; i < channels.size(); i++) {
            tablistBeens.add(channels.get(i));
            liveChinasFragment = new LiveChinasFragment();
            bundle = new Bundle();
            bundle.putString("url", tagUrlMap.get(channels.get(i)));
            liveChinasFragment.setBundle(bundle);
            liveChinasFragments.add(liveChinasFragment);
        }
        liveChinaTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        chinaLiveAdapter = new ChinaLiveTitleAdapter(getChildFragmentManager(), liveChinasFragments, tablistBeens);
        liveChinaViewPager.setAdapter(chinaLiveAdapter);
        liveChinaTabLayout.setupWithViewPager(liveChinaViewPager);
        setSave();
    }

    @Override
    public void showErrorMassage(String msg) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {

        if (isChecked) {
            checkBox.setText("完成");
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (isChecked && tablistBeens != null && tablistBeens.size() > 4) {
                        String channel = channels.get(position);
                        channels.remove(position);
                        channels_other.add(channel);
                        dragAdapter.notifyDataSetChanged();
                        other_adapter.notifyDataSetChanged();

                    } else {
                        Toast.makeText(getContext(), "总数不能小于4", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            gridView_other.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (isChecked) {
                        String channel = channels_other.get(position);
                        channels_other.remove(position);
                        channels.add(channel);
                        dragAdapter.notifyDataSetChanged();
                        other_adapter.notifyDataSetChanged();
                    }

                }
            });
        } else {
            setRefresh();
            checkBox.setText("编辑");
        }
    }

    public void setSave() {
        LiveChinaTitleBean.TablistBean tablistBean;
        List<LiveChinaTitleBean.TablistBean> tablistBeanList = new ArrayList<>();
        List<LiveChinaTitleBean.AlllistBean> alllistBeanList = new ArrayList<>();
        LiveChinaTitleBean.AlllistBean alllistBean;

        LiveChinaTitleBean livechinaTabbean = new LiveChinaTitleBean();
        for (String title : channels) {
            tablistBean = new LiveChinaTitleBean.TablistBean();
            tablistBean.setTitle(title);
            tablistBean.setUrl(tagUrlMap.get(title));
            tablistBeanList.add(tablistBean);
        }
        for (String title : channels_other) {
            alllistBean = new LiveChinaTitleBean.AlllistBean();
            alllistBean.setUrl(tagUrlMap.get(title));
            alllistBean.setTitle(title);
            alllistBeanList.add(alllistBean);
        }
        livechinaTabbean.setAlllist(alllistBeanList);
        livechinaTabbean.setTablist(tablistBeanList);
        aCache.put("livechinaTabBean", livechinaTabbean);

    }
}
