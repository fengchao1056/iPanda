package com.example.a123.pandatv.activity;

import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.a123.pandatv.R;
import com.example.a123.pandatv.app.App;
import com.example.a123.pandatv.base.BaseActivity;
import com.example.a123.pandatv.ui.module.pandabroadcast.BoadCastFragment;
import com.example.a123.pandatv.ui.module.pandabroadcast.BoadCastPresenter;
import com.example.a123.pandatv.ui.module.pandahome.HomeFragment;
import com.example.a123.pandatv.ui.module.pandahome.HomePresenter;
import com.example.a123.pandatv.ui.module.pandalive.PandaLiveFragment;
import com.example.a123.pandatv.ui.module.pandalive.PandaLivePresenter;
import com.example.a123.pandatv.ui.module.pandalivechina.ChinaLiveFragment;
import com.example.a123.pandatv.ui.module.pandalivechina.ChinaLivePresenter;
import com.example.a123.pandatv.ui.module.pandaroll.PandaRollFragment;
import com.example.a123.pandatv.ui.module.pandaroll.PandaRollPresenter;
import com.example.a123.pandatv.widget.manager.MainFragmentBuild;
import com.example.a123.pandatv.widget.manager.ToastManager;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {


    private long lastTime;//上一次点击back键的时间毫秒数
    public static final int HOMETYPE = 1;
    private RadioGroup main_radiogroup;

    private TextView main_titlebar;
    private ImageView main_image;
    private ImageView main_imagehudong;
    private ImageView imageView;
    private int viewID= R.id.main_fragment;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        App.context = this;
        main_radiogroup= (RadioGroup) findViewById(R.id.main_radiogroup);
        main_titlebar= (TextView) findViewById(R.id.main_titlebar);
        main_image= (ImageView) findViewById(R.id.main_image);
        main_imagehudong= (ImageView) findViewById(R.id.main_imagehudong);

        imageView= (ImageView) findViewById(R.id.main_imagepersonal);
    }

    @Override
    protected void setListener() {
        main_radiogroup.setOnCheckedChangeListener(this);
        imageView.setOnClickListener(this);
        main_imagehudong.setOnClickListener(this);
    }

    @Override
    protected void setIntent() {

        //showHome();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
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
    public void showHome(){
        isShowTitle(true,"");
        HomeFragment homFragment = (HomeFragment) MainFragmentBuild.getInsenter().setFragmentView(viewID, HomeFragment.class).builder().getFragmentContext();
        new HomePresenter(homFragment);
    }
    public void showPandaLive(){
        isShowTitle(false,"熊猫直播");
        PandaLiveFragment pandaLiveFragment= (PandaLiveFragment) MainFragmentBuild.getInsenter().setFragmentView(viewID,PandaLiveFragment.class).builder().getFragmentContext();
        new PandaLivePresenter(pandaLiveFragment);
    }
    public void showGGVideo(){
        isShowTitle(false,"滚滚视频");
        PandaRollFragment ggVideoFragment= (PandaRollFragment) MainFragmentBuild.getInsenter().setFragmentView(viewID,PandaRollFragment.class).builder().getFragmentContext();
        new PandaRollPresenter(ggVideoFragment);
    }
    public void showPandaObserver(){
        isShowTitle(false,"熊猫播报");
        BoadCastFragment pandaObserverFragment= (BoadCastFragment) MainFragmentBuild.getInsenter().setFragmentView(viewID,BoadCastFragment.class).builder().getFragmentContext();
        new BoadCastPresenter(pandaObserverFragment);
    }
    public void showChinaLive() {
        isShowTitle(false, "直播中国");
        ChinaLiveFragment chinaLiveFragment = (ChinaLiveFragment) MainFragmentBuild.getInsenter().setFragmentView(viewID, ChinaLiveFragment.class).builder().getFragmentContext();
        new ChinaLivePresenter(chinaLiveFragment);
    }
    public void isShowTitle(Boolean isShow,String title){
        if (isShow){
            main_image.setVisibility(View.VISIBLE);
            main_titlebar.setVisibility(View.INVISIBLE);
            main_imagehudong.setVisibility(View.VISIBLE);
        }else {
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
                //Intent intent=new Intent(MainActivity.this,PersonalActivity.class);
                //startActivity(intent);
                break;
            case R.id.main_imagehudong:
               // Intent intent1=new Intent(MainActivity.this,CehuaActivity.class);
                //startActivity(intent1);
                break;
        }

    }
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        FragmentManager manager = getSupportFragmentManager();
        FragmentManager.BackStackEntry entry = manager.getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 1);
        String simpleName = entry.getName();
        if (simpleName.equals("BoadCastFragment") || simpleName.equals("PandaLiveFragment") || simpleName.equals("HomeFragment")
                || simpleName.equals("PandaRollFragment")|| simpleName.equals("ChinaLiveFragment")) {
            if(System.currentTimeMillis() - lastTime < 2000){
                System.exit(0);
               // lastTime=0;
            }else {
                ToastManager.show("再按一次退出应用");
                lastTime = System.currentTimeMillis();
            }
        } else {
            super.onBackPressed();
        }

    }
/*    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis() - lastTime < 2000){
            finish();
        }else {
            ToastManager.show("再按一次退出应用");
            lastTime = System.currentTimeMillis();
        }
    }*/
}
