package com.example.dllo.openeyes.tools;

/**
 * Created by mac on 16/8/13.
 */
public class OkHttp implements NetWork{
    //静态内部类形式的单例模式
    private static final class SingletonHolder{
        private static final OkHttp INSTANCE = new OkHttp();
    }
    public static OkHttp getInstance(){
        return SingletonHolder.INSTANCE;
    }
    private NetWork tool;

    private OkHttp(){
        tool = new OkHttpImpl();
    }



    @Override
    public void startRequest(String url, OnHttpCallBack<String> callBack) {
        tool.startRequest(url,callBack);
    }

    @Override
    public <T> void startRequest(String url, Class<T> tClass, OnHttpCallBack<T> callBack) {
       tool.startRequest(url,tClass,callBack);
    }
}
