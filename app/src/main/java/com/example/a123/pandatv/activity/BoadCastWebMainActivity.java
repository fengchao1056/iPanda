package com.example.a123.pandatv.activity;

import android.content.Intent;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a123.pandatv.R;
import com.example.a123.pandatv.base.BaseActivity;

import butterknife.BindView;

public class BoadCastWebMainActivity extends BaseActivity {

    @BindView(R.id.observer_webBack)
    ImageView observerWebBack;
    @BindView(R.id.pandaObserver_title)
    TextView pandaObserverTitle;
    @BindView(R.id.pandaObserver_webUrl)
    WebView pandaObserverWebUrl;
    @BindView(R.id.shoucang_btn)
    CheckBox shoucangBtn;
    @BindView(R.id.fenxiang_btn)
    CheckBox fenxiangBtn;
    private String url;
    private String vid;
    private boolean isSave;
    private Intent intent;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_boad_cast_web_main;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
         isSave = intent.getBooleanExtra("isSave", false);
        String vid = intent.getStringExtra("vid");
        String url = intent.getStringExtra("url");
        WebSettings webSettings = pandaObserverWebUrl.getSettings();
        //设置自适应屏幕 ， 两者适应
        webSettings.setUseWideViewPort(true);//将图片调整到适合屏幕的大小
        webSettings.setLoadWithOverviewMode(true);//  缩放至屏幕的大小
         webSettings.setBuiltInZoomControls(true);//设置内置的缩放控件。若为false，则该WebView不可缩放
          webSettings.setDisplayZoomControls(false);//隐藏原生的缩放控件
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //关闭webview中缓存
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图
        shoucangBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isSave =!isSave;
                if (isSave) {
                    Toast.makeText(BoadCastWebMainActivity.this, "已经收藏", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(BoadCastWebMainActivity.this, "已经取消收藏", Toast.LENGTH_SHORT).show();
                }

            }
        });
        fenxiangBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            }
        });



    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void setIntent() {
        if (url != null) {
            pandaObserverWebUrl.loadUrl(url);
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            intent.putExtra("vid", vid);
            intent.putExtra("isSave", isSave);
            setResult(2000, intent);
            BoadCastWebMainActivity.this.finish();
        }
        return false;
    }
}
