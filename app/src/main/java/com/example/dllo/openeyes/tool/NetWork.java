package com.example.dllo.openeyes.tool;

/**
 * Created by mac on 16/8/13.
 */
public interface NetWork {
    void startRequest(String url, OnHttpCallBack<String> callBack);
    <T> void startRequest(String url, Class<T> tClass, OnHttpCallBack<T> callBack);
}
