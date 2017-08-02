package com.example.a123.pandatv.net;


import android.app.ProgressDialog;
import android.os.Environment;
import android.util.Log;

import com.example.a123.pandatv.app.App;
import com.example.a123.pandatv.net.callback.MyCallback;
import com.example.a123.pandatv.utils.ACache;
import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

//     OKhttp发送网络请求
public class OkhttpUtils implements IHttp {
    private static OkhttpUtils utils;
    private static OkHttpClient client;
    private int total=0;
    private OkhttpUtils(){
      client=new OkHttpClient.Builder().build();
    }
    public static OkhttpUtils getInstance(){
        if(utils==null) {
            synchronized (OkhttpUtils.class){
                if(utils==null) {
                    utils=new OkhttpUtils();
                }
            }
        }
        return  utils;
    }


    @Override
    public <T> void get(String url, final MyCallback<T> callback) {
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callback.onError(404,e.getMessage().toString());
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String jsonData = response.body().string();
                //执行在子线程中
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callback.onSuccess(getGeneric(jsonData,callback));
                    }
                });

            }
        });
    }

    @Override
    public <T> void get(String url, Map<String, String> params, final MyCallback<T> callback) {
        StringBuffer sb = new StringBuffer(url);
        if(params != null && params.size() > 0){
            sb.append("?");
            Set<String> keys = params.keySet();
            for (String key : keys) {
                String value = params.get(key);
                sb.append(key).append("=").append(value).append("&");
            }
            url = sb.deleteCharAt(sb.length()-1).toString();
        }
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                       // callback.onError(404,e.getMessage().toString());
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String jsonData = response.body().string();
                //执行在子线程中
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callback.onSuccess(getGeneric(jsonData,callback));
                    }
                });

            }
        });
    }

    @Override
    public void upload() {

    }

    @Override
    public void downLoad(String vsinurl, final MyCallback<File> myCallback) {
        final String uri = vsinurl;
        final ProgressDialog pd;    //进度条对话框
        pd = new ProgressDialog(App.context);
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
                    myCallback.onSuccess(file);
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
                int total = len;
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

    @Override
    public void loadImage() {

    }
    /**
     * 自动解析json至回调中的JavaBean
     * @param jsonData
     * @param callBack
     * @param <T>
     * @return
     */
    private <T> T getGeneric(String jsonData,MyCallback<T> callBack){
        Gson gson = new Gson();
        //通过反射获取泛型的实例
        Type[] types = callBack.getClass().getGenericInterfaces();
        Type[] actualTypeArguments = ((ParameterizedType) types[0]).getActualTypeArguments();
        Type type = actualTypeArguments[0];
        T t = gson.fromJson(jsonData,type);
        String simpleName = t.getClass().getSimpleName();
        ACache aCache=ACache.get(App.context,"interfaceCache");
        aCache.put(simpleName, (Serializable) t);
        return t;
    }
}
