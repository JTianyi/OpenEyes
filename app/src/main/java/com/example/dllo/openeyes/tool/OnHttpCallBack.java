package com.example.dllo.openeyes.tool;

/**
 * Created by mac on 16/8/13.
 */
public interface OnHttpCallBack<T> {
    void onSuccess(T response);
    void onError(Throwable ex);
}
