package com.example.dllo.openeyes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dllo on 16/8/12.
 * 抽象的Fragment基类
 */
public abstract class AbsBaseFragment extends Fragment {
    protected Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(setLayout(), container, false);
    }

    //抽象方法:设置布局
    protected abstract int setLayout();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    //初始化组件
    protected abstract void initViews(View view);


    protected <T extends View> T byView(int resId) {
        return (T) getView().findViewById(resId);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDatas();
    }

    //初始化数据
    protected abstract void initDatas();

    protected void goTo(Context from, Class<? extends AbsBaseActivity> to) {
        Intent intent = new Intent(from, to);
        context.startActivity(intent);
    }


}