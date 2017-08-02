package com.example.a123.pandatv.net;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.example.a123.pandatv.app.App;
import com.example.a123.pandatv.net.callback.MyCallback;
import com.google.gson.Gson;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
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
    public void getRegister(String url, Map<String, String> params,Map<String,String> hears, final MyCallback<String> callback) {
        FormBody.Builder builder = new FormBody.Builder();

        if (params != null && params.size() > 0) {
            Set<String> keys = params.keySet();
            for (String key : keys) {
                String value = params.get(key);
                builder.add(key,value);
            }
        }
        Request.Builder request = new Request.Builder();
        request.url(url).post(builder.build()).build();
        if (hears != null && hears.size() > 0) {
            Set<String> strings = hears.keySet();
            for (String string : strings) {
                String s = hears.get(string);
                request.addHeader(string, s);
            }
        }

        client.newCall(request.build()).enqueue(new Callback() {
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
                        callback.onSuccess(jsonData);
                    }
                });

            }
        });
    }

    @Override
    public void getUserImg(String url, final MyCallback<Drawable> callback) {
        final Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                final String s = e.toString();
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callback.onError(404,s);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final byte[] bytes = response.body().bytes();
                Headers headers = response.headers();
                String jsonid = headers.get("Set-Cookie");
                setSaveCookie(jsonid);
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callback.onSuccess(byteToDrawable(bytes));
                    }
                });
            }
        });
    }

    @Override
    public void getYZM(String url, Map<String,String> params, Map<String,String> heards, final MyCallback<String> callback) {
        FormBody.Builder builder = new FormBody.Builder();

        if (params != null && params.size() > 0) {
            Set<String> keys = params.keySet();
            for (String key : keys) {
                String value = params.get(key);
               builder.add(key,value);
            }
        }
        Request.Builder request = new Request.Builder();
        request.post(builder.build());
        if (heards != null && heards.size() > 0) {
            Set<String> strings = heards.keySet();
            for (String string : strings) {
                String s = heards.get(string);
                request.addHeader(string, s);
            }
        }
            client.newCall(request.build()).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    final String error = e.toString();
                    App.context.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            callback.onError(404,error);
                        }
                    });
                }
                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    final String string = response.body().string();
                    App.context.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            callback.onSuccess(string);
                        }
                    });
                }
            });

    }

    @Override
    public <T> void getLogin(String url, Map<String, String> params, final MyCallback<T> callback) {
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
        Request request = new Request.Builder().url(url)
                .addHeader("Referer","https://reg.cntv.cn/login/login.action")
                .addHeader("User-Agent","CNTV_APP_CLIENT_CYNTV_MOBILE").build();
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

    public void setSaveCookie(String Cookie){
        SharedPreferences sharedPreferences = App.context.getSharedPreferences("Cookie", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("Set-Cookie",Cookie);
        edit.commit();
    }
    public Drawable byteToDrawable(byte[] buteArray) {
        try {
            String string = new String(buteArray, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ByteArrayInputStream ins = new ByteArrayInputStream(buteArray);
        return Drawable.createFromStream(ins, null);
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
