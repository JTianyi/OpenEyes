package com.example.dllo.openeyes;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class HomeActivity extends AbsBaseActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private HomeAdapter adapter;
    private ArrayList<Fragment>datas;
    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        tabLayout=byView(R.id.main_tablayout);
        viewPager=byView(R.id.main_viewpager);

    }



    @Override
    protected void initDatas() {
        creatFragment();
        adapter=new HomeAdapter(getSupportFragmentManager());
        adapter.setDatas(datas);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        setTabBackgroud();

    }

    private void setTabBackgroud() {
       
    }


    private void creatFragment() {
        datas=new ArrayList<>();
        datas.add(new SelectionFragment());
        datas.add(new FindFragment());
        datas.add(new AuthorFragment());
        datas.add(new MineFragment());
    }
}
