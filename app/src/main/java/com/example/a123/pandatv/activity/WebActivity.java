package com.example.a123.pandatv.activity;

import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.a123.pandatv.R;
import com.example.a123.pandatv.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/7/29.
 */

public class WebActivity extends BaseActivity {
    private WebSettings settings;
    private String stringurl;
    @BindView(R.id.webview)
    WebView webview;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_web;
    }

    @Override
    protected void initView() {

        settings =webview.getSettings();
        stringurl = getIntent().getStringExtra("url");

        //      可以与什么交互
        settings.setJavaScriptEnabled(true);
//        将图片控制到适合webview的大小
        settings.setUseWideViewPort(true);

//        缩放至屏幕大小
        settings.setLoadWithOverviewMode(true);
        webview.loadUrl(stringurl);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void setIntent() {

    }
}
