package com.example.a123.pandatv.module.pandalivechina.chilefragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a123.pandatv.R;
import com.example.a123.pandatv.base.BaseFragment;
import com.example.a123.pandatv.model.entity.LiveChinasBean;
import com.example.a123.pandatv.module.pandalivechina.adapter.LiveChinaAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/7/28.
 */

public class LiveChinasFragment extends BaseFragment implements LiveChiansContract.View{

    @BindView(R.id.liveChina_fragmentRecylerView)
    RecyclerView liveChinaFragmentRecylerView;
    private List<LiveChinasBean.LiveBean> liveBeens;
    private LiveChinaAdapter adapter;
    private Bundle bundle;
    private LiveChinasPresenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.livechina_list;
    }

    @Override
    protected void initView(View view) {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        liveChinaFragmentRecylerView.setLayoutManager(manager);
        new LiveChinasPresenter(this);

    }

    @Override
    protected void loadDate() {

        String url = bundle.getString("url");
        if (!"".equals(url)){
            presenter.setResult(url);
        }

    }

    @Override
    protected void setListener() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void setLiveChinaFragment(LiveChinasBean liveChinaFragmentBean) {

        liveBeens=new ArrayList<>();
        liveBeens.addAll(liveChinaFragmentBean.getLive());
        adapter=new LiveChinaAdapter(getContext(),liveBeens);
        liveChinaFragmentRecylerView.setAdapter(adapter);
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
    public void setPresenter(LiveChiansContract.Presenter presenter) {
        this.presenter= (LiveChinasPresenter) presenter;
    }

    @Override
    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }
}
