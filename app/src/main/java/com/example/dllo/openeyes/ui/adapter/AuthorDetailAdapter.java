package com.example.dllo.openeyes.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.dllo.openeyes.ui.fragment.AuthorDetailDateFragment;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by mac on 16/8/17.
 * 全景适配器
 * @author wangweijian
 */
public class AuthorDetailAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> data;
    private Context context;
    private String [] urls = new String[2];
    private String[] titles = {"按时间排序","按分享排序"};

    public AuthorDetailAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    public void setUrls(String[] urls) {
        this.urls = urls;
        notifyDataSetChanged();
    }


    public AuthorDetailAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return AuthorDetailDateFragment.newInstance(urls[position]);
    }

    @Override
    public int getCount() {
        return urls.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
