package com.example.a123.pandatv.activity;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.a123.pandatv.R;
import com.example.a123.pandatv.activity.cehua.CehuaActivity;
import com.example.a123.pandatv.app.App;
import com.example.a123.pandatv.base.BaseActivity;
import com.example.a123.pandatv.module.pandabroadcast.BoadCastFragment;
import com.example.a123.pandatv.module.pandabroadcast.BoadCastPresenter;
import com.example.a123.pandatv.module.pandahome.HomeFragment;
import com.example.a123.pandatv.module.pandahome.HomePresenter;
import com.example.a123.pandatv.module.pandalive.PandaLiveFragment;
import com.example.a123.pandatv.module.pandalive.PandaLivePresenter;
import com.example.a123.pandatv.module.pandalivechina.ChinaLiveFragment;
import com.example.a123.pandatv.module.pandalivechina.ChinaLivePresenter;
import com.example.a123.pandatv.module.pandaroll.PandaRollFragment;
import com.example.a123.pandatv.module.pandaroll.PandaRollPresenter;
import com.example.a123.pandatv.module.personcenter.activity.PersenActivity;
import com.example.a123.pandatv.widget.manager.MainFragmentBuild;
import com.example.a123.pandatv.widget.manager.MentBuilder;
import com.example.a123.pandatv.widget.manager.ToastManager;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {


    private long lastTime;//上一次点击back键的时间毫秒数
    public static final int HOMETYPE = 1;
    private RadioGroup main_radiogroup;

    private TextView main_titlebar;
    private ImageView main_image;
    private ImageView main_imagehudong;
    private ImageView imageView;
    private int viewID = R.id.main_fragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        App.context = this;
        main_radiogroup = (RadioGroup) findViewById(R.id.main_radiogroup);
        main_titlebar = (TextView) findViewById(R.id.main_titlebar);
        main_image = (ImageView) findViewById(R.id.main_image);
        main_imagehudong = (ImageView) findViewById(R.id.main_imagehudong);

        imageView = (ImageView) findViewById(R.id.main_imagepersonal);
    }

    @Override
    protected void setListener() {
        main_radiogroup.setOnCheckedChangeListener(this);
        imageView.setOnClickListener(this);
        main_imagehudong.setOnClickListener(this);
    }

    @Override
    protected void setIntent() {
        showHome();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.main_home:
                showHome();
                break;
            case R.id.main_pandaLive:
                showPandaLive();
                break;
            case R.id.main_ggVideo:
                showGGVideo();
                break;
            case R.id.main_pandaObserver:
                showPandaObserver();
                break;
            case R.id.mian_chinaLive:
                showChinaLive();
                break;
        }
    }

    public void showHome() {
        isShowTitle(true, "");
        MentBuilder.changeFragment(HomeFragment.class, R.id.main_fragment, true, null, true);
        //HomeFragment homFragment = (HomeFragment) MainFragmentBuild.getInsenter().setFragmentView(viewID, HomeFragment.class).builder().getFragmentContext();

    }

    public void showPandaLive() {
        isShowTitle(false, "熊猫直播");
        MentBuilder.changeFragment(PandaLiveFragment.class, R.id.main_fragment, true, null, true);

    }

    public void showGGVideo() {
        isShowTitle(false, "滚滚视频");
        MentBuilder.changeFragment(PandaRollFragment.class, R.id.main_fragment, true, null, true);

    }

    public void showPandaObserver() {
        isShowTitle(false, "熊猫播报");
        MentBuilder.changeFragment(BoadCastFragment.class, R.id.main_fragment, true, null, true);

    }

    public void showChinaLive() {
        isShowTitle(false, "直播中国");
        MentBuilder.changeFragment(ChinaLiveFragment.class, R.id.main_fragment, true, null, true);

    }

    public void isShowTitle(Boolean isShow, String title) {
        if (isShow) {
            main_image.setVisibility(View.VISIBLE);
            main_titlebar.setVisibility(View.INVISIBLE);
            main_imagehudong.setVisibility(View.VISIBLE);
        } else {
            main_image.setVisibility(View.GONE);
            main_titlebar.setVisibility(View.VISIBLE);
            main_imagehudong.setVisibility(View.GONE);
            main_titlebar.setText(title);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_imagepersonal:
                Intent intent = new Intent(MainActivity.this, PersenActivity.class);
                startActivity(intent);
                break;
            case R.id.main_imagehudong:
                Intent intent1 = new Intent(MainActivity.this, CehuaActivity.class);
                startActivity(intent1);
                break;
        }

    }

    @Override
    public void onBackPressed() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentManager.BackStackEntry entry = manager.getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 1);
        String simpleName = entry.getName();
        if (simpleName.equals("BoadCastFragment") || simpleName.equals("PandaLiveFragment") || simpleName.equals("HomeFragment")
                || simpleName.equals("PandaRollFragment") || simpleName.equals("ChinaLiveFragment")) {
            if (System.currentTimeMillis() - lastTime < 2000) {
                System.exit(0);
                // lastTime=0;
            } else {
                ToastManager.show("再按一次退出应用");
                lastTime = System.currentTimeMillis();
            }
        } else {
            super.onBackPressed();
        }

    }

}
