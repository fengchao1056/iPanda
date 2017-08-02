package com.example.a123.pandatv.module.pandahome;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.a123.pandatv.R;
import com.example.a123.pandatv.app.App;
import com.example.a123.pandatv.base.BaseFragment;
import com.example.a123.pandatv.model.entity.PandaHomeBean;
import com.example.a123.pandatv.model.entity.UpDateLoading;
import com.example.a123.pandatv.module.pandahome.adapter.HomeAdapter;
import com.example.a123.pandatv.module.pandahome.adapter.HomeViewPagerAdapter;
import com.example.a123.pandatv.module.pandahome.adapter.OnViewPagerItemListener;
import com.example.a123.pandatv.utils.ACache;
import com.example.a123.pandatv.widget.view.ShowDioLog;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
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
    private static int versionCode;
    private String vsinurl;
    int total = 0;

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
       show.dismiss();
    }

    @Override
    public void playVideo() {

    }

    @Override
    public void loadMore() {
        getAppVersionName(getActivity());
    }

    @Override
    public void loadWebView() {

    }


    @Override
    public void getVersion(UpDateLoading upDateLoading) {
        String versionsNum = upDateLoading.getData().getVersionsNum();
        vsinurl = upDateLoading.getData().getVersionsUrl();
        int versionsInt = Integer.parseInt(versionsNum);
        if (versionCode < versionsInt) {
            getShowDialog();
        } else {
            Toast.makeText(getActivity(), "已经是最新版本", Toast.LENGTH_LONG).show();
        }
    }
    public void getShowDialog() {
        new AlertDialog.Builder(getActivity()).setTitle("版本更新")//设置对话框标题

                .setMessage("检测到最新版本")//设置显示的内容

                .setPositiveButton("立即更新", new DialogInterface.OnClickListener() {//添加确定按钮


                    @Override

                    public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件

                        // TODO Auto-generated method stub
                        dialog.dismiss();
                        loadNewVersionProgress();
                        dialog.dismiss();

                    }

                }).setNegativeButton("以后再说", new DialogInterface.OnClickListener() {//添加返回按钮


            @Override

            public void onClick(DialogInterface dialog, int which) {//响应事件

                // TODO Auto-generated method stub

                dialog.dismiss();

            }

        }).show();//在按键响应事件中显示此对话框
    }
    public static String getAppVersionName(Context context) {
        String versionName = "";

        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = packageInfo.versionName;
            versionCode = packageInfo.versionCode;
            Log.i("aaa", versionCode + "");
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {
            Log.i("aaa", versionName);
        }
        return versionName;

    }
    /**
     * 下载新版本程序，需要子线程
     */
    private void loadNewVersionProgress() {
        final String uri = vsinurl;
        final ProgressDialog pd;    //进度条对话框
        pd = new ProgressDialog(getActivity());
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setMessage("正在下载更新");
        pd.show();
        //启动子线程下载任务
        new Thread() {
            @Override
            public void run() {
                try {
                    File file = getFileFromServer(uri, pd);
                    sleep(3000);
                    installApk(file);
                    pd.dismiss(); //结束掉进度条对话框
                } catch (Exception e) {
                    //下载apk失败
                    Log.i("abc", "下载失败");
//                    Toast.makeText(getActivity(), "下载新版本失败", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        }.start();
    }

    /**
     * 从服务器获取apk文件的代码
     * 传入网址uri，进度条对象即可获得一个File文件
     * （要在子线程中执行哦）
     */
    public File getFileFromServer(String uri, final ProgressDialog pd) throws Exception {
        //如果相等的话表示当前的sdcard挂载在手机上并且是可用的
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            URL url = new URL(uri);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            //获取到文件的大小
            pd.setMax(conn.getContentLength());
            InputStream is = conn.getInputStream();
            long time = System.currentTimeMillis();//当前时间的毫秒数
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), time + "updata.apk");
            if (!file.exists())
                file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            BufferedInputStream bis = new BufferedInputStream(is);
            byte[] buffer = new byte[1024];
            int len;

            while ((len = bis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
                total += len;
                //获取当前下载量
                pd.setProgress(total);
            }
            fos.close();
            bis.close();
            is.close();
            return file;
        } else {
            return null;
        }
    }

    /**
     * 安装apk
     */
    protected void installApk(File file) {
        Intent intent = new Intent();
        //执行动作
        intent.setAction(Intent.ACTION_VIEW);
        //执行的数据类型
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        startActivity(intent);
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
