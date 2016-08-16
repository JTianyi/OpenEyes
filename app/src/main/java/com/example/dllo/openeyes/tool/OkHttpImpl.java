package com.example.dllo.openeyes.tool;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;

import com.alibaba.fastjson.JSON;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by mac on 16/8/13.
 */
public class OkHttpImpl implements NetWork {
    private OkHttpClient mClient;
    //这样初始化的Handler不论在哪个线程new的,它都属于主线程
    private Handler mHandler = new Handler(Looper.getMainLooper());

    public OkHttpImpl(){
        File cacheDir = Environment.getExternalStorageDirectory();
        mClient = new OkHttpClient.Builder()
                //设置网络请求的缓存目录
                  .cache(new Cache(cacheDir,10*1024*1024))
                //连接超时时间
                  .connectTimeout(5, TimeUnit.SECONDS).build();
    }

    @Override
    public void startRequest(String url, final OnHttpCallBack<String> callBack) {
        Request request = new Request.Builder().url(url).build();
        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callBack.onError(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String resultStr = response.body().string();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(resultStr);
                    }
                });
            }
        });
    }

    @Override
    public <T> void startRequest(String url, final Class<T> tClass, final OnHttpCallBack<T> callBack) {
            Request request = new Request.Builder().url(url).build();
        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onError(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                    String resultStr = response.body().string();
                    final T resultBean =  JSON.parseObject(resultStr,tClass);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.onSuccess(resultBean);
                        }
                    });
            }
        });
    }
}
