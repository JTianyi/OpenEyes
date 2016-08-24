package com.example.dllo.openeyes.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import java.util.ArrayList;

/**
 * Created by mac on 16/8/17.
 * 全景适配器
 * @author wangweijian
 */
public class FullShotAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> data;
    private Context context;
    private String[] titles = {"按时间排序","按分享排序"};

    public FullShotAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    public void setData(ArrayList<Fragment> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public FullShotAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
