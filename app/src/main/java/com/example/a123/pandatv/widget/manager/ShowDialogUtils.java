package com.example.a123.pandatv.widget.manager;

import android.app.AlertDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.a123.pandatv.app.App;

/**
 * Created by Administrator on 2017/7/13.
 */

public class ShowDialogUtils {
    private static ShowDialogUtils showDialogUtils;
    private AlertDialog.Builder dialog;
    private Context context;
    private Boolean wifiConnected, mobileConnected;
    private ShowDialogUtils() {
        dialog = new AlertDialog.Builder(App.context);
    }

    public static ShowDialogUtils getInsenter() {
        if (showDialogUtils == null)
            synchronized (ShowDialogUtils.class) {
                if (showDialogUtils == null) {
                    showDialogUtils = new ShowDialogUtils();
                }
            }
        return showDialogUtils;
    }

/*    public ShowDialogUtils setViewId(final IShowDialogUtils ShowDialogUtils) {
        if (netType() == 1) {
            dialog.setTitle("当前处于移动网络是否继续播放？");
            dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ShowDialogUtils.setMaked();
                }
            });
            dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            dialog.create().show();
        }
        return this;
    }*/



    public ShowDialogUtils updateConnectedFlags(Context context) {
        this.context=context;
        ConnectivityManager connMgr =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeInfo = connMgr.getActiveNetworkInfo();
        if (activeInfo != null && activeInfo.isConnected()) {
            wifiConnected = activeInfo.getType() == ConnectivityManager.TYPE_WIFI;
            mobileConnected = activeInfo.getType() == ConnectivityManager.TYPE_MOBILE;
        } else {
            wifiConnected = false;
            mobileConnected = false;
        }
        return this;
    }
    public Boolean isNetConnected(){
        if (wifiConnected || mobileConnected){
            if (isNetworkAvailable(context)){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null) {
        } else {
            //如果仅仅是用来判断网络连接
             //则可以使用 cm.getActiveNetworkInfo().isAvailable();
            NetworkInfo[] info = cm.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static final int MOBILETYPE = 1;
    private static final int NULLNET = 0;
    private static final int WIFITYPE = 2;

    public int netType() {
        if (wifiConnected)
            return WIFITYPE;
        if (mobileConnected)
            return MOBILETYPE;
        return NULLNET;
    }

}
