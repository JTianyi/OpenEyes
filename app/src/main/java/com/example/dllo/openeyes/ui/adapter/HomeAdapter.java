package com.example.dllo.openeyes.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/12.
 */
public class HomeAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> datas;
    private String[] tabTitles = {"精选", "发现", "作者","我的"};


    public HomeAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setDatas(ArrayList<Fragment> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return datas != null && datas.size() > 0 ? datas.get(position) : null;
    }

    @Override
    public int getCount() {
        return datas != null && datas.size() > 0 ? datas.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
