package com.example.a123.pandatv.activity.cehua;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.example.a123.pandatv.R;
import com.example.a123.pandatv.adapter.CehuaAdapter;
import com.example.a123.pandatv.base.BaseActivity;
import com.example.a123.pandatv.model.entity.CehuaBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/7/29.
 */

public class CehuaActivity extends BaseActivity implements PullToRefreshListener,CeHuaContract.View{
    @BindView(R.id.historical_image)
    ImageView historicalImage;
    @BindView(R.id.cehua_pullto)
    PullToRefreshRecyclerView cehuaPullto;
    private CehuaAdapter adapter;
    private List<CehuaBean.InteractiveBean> list;

    private CeHuaPresenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_cehua;
    }

    @Override
    protected void initView() {
        new CeHuaPresenter(this);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        cehuaPullto.setLayoutManager(manager);

        cehuaPullto.setLoadingMoreEnabled(true);
        cehuaPullto.setPullRefreshEnabled(true);

        list = new ArrayList<>();
        presenter.start();
    }

    @Override
    protected void setListener() {
        historicalImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        cehuaPullto.setPullToRefreshListener(this);
    }

    @Override
    protected void setIntent() {

    }

    @Override
    public void onRefresh() {

        cehuaPullto.postDelayed(new Runnable() {
            @Override
            public void run() {

                presenter.start();
                adapter.notifyDataSetChanged();
                cehuaPullto.setRefreshComplete();

            }
        },1000);
    }

    @Override
    public void onLoadMore() {

        cehuaPullto.setLoadMoreComplete();
    }

    @Override
    public void getWebUrl(CehuaBean cehuaBean) {
        list.clear();
        list.addAll(cehuaBean.getInteractive());
        adapter = new CehuaAdapter(this, list);
        cehuaPullto.setAdapter(adapter);
        Log.e("TAG", list.size() + "");
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dimissProgress() {

    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(CeHuaContract.Presenter presenter) {
        this.presenter= (CeHuaPresenter) presenter;
    }
}
