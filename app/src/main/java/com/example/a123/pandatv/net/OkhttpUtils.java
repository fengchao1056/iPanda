package com.example.a123.pandatv.net;


import com.example.a123.pandatv.app.App;
import com.example.a123.pandatv.net.callback.MyCallback;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
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
    public <T> void get(String url, MyCallback<T> callback) {

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
    public void upload() {

    }

    @Override
    public void downLoad() {

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
        return t;
    }
}
