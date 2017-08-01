package com.example.a123.pandatv.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidkun.PullToRefreshRecyclerView;
import com.example.a123.pandatv.R;
import com.example.a123.pandatv.base.BaseActivity;
import com.example.a123.pandatv.model.entity.PandaObserverFirstItemBean;
import com.example.a123.pandatv.module.pandabroadcast.BoadcastItemCastPresenter;
import com.example.a123.pandatv.module.pandabroadcast.BoadcastItemContract;
import com.example.a123.pandatv.module.pandabroadcast.adapter.PandaObserverFirstItemAdapter;

import java.util.ArrayList;

import butterknife.BindView;

public class BoadCastMainActivity extends BaseActivity implements BoadcastItemContract.View {
            private BoadcastItemContract.Presenter presenter;
    @BindView(R.id.checkbox_cast)
    CheckBox checkboxCast;
    @BindView(R.id.tv_cast)
    TextView tvCast;
    @BindView(R.id.recycler_cast)
    PullToRefreshRecyclerView recyclerCast;
    @BindView(R.id.ggvideo_backBtn)
    ImageView ggvideoBackBtn;
    @BindView(R.id.title_cast)
    TextView titleCast;
    @BindView(R.id.web_shoucang_btn)
    CheckBox webShoucangBtn;
    @BindView(R.id.web_fenxiang_btn)
    CheckBox webFenxiangBtn;
    private ArrayList<PandaObserverFirstItemBean.VideoBean> videoBean=new ArrayList<>();
    private PandaObserverFirstItemAdapter adapter;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_boad_cast_main;
    }

    @Override
    protected void initView() {
        new BoadcastItemCastPresenter(this);
         presenter.start();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerCast.setLayoutManager(manager);
        adapter = new PandaObserverFirstItemAdapter(this,videoBean);
        recyclerCast.setAdapter(adapter);
        checkboxCast.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tvCast.setVisibility(View.VISIBLE);
                } else {
                    tvCast.setVisibility(View.GONE);
                }
            }
        });
        ggvideoBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void setIntent() {

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
    public void setPresenter(BoadcastItemContract.Presenter presenter) {
          this.presenter=presenter;
    }

    @Override
    public void setResulte(PandaObserverFirstItemBean pandaObserverFirstItemBean) {
        String desc = pandaObserverFirstItemBean.getVideoset().get_$0().getDesc();
        String name = pandaObserverFirstItemBean.getVideoset().get_$0().getName();
         titleCast.setText(name);
         tvCast.setText(desc);
        videoBean.addAll(pandaObserverFirstItemBean.getVideo());


    }

    @Override
    public void playVideo() {

    }
}
