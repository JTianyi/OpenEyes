package com.example.dllo.openeyes;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/12.
 */
public class HomeAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> datas;


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

}
