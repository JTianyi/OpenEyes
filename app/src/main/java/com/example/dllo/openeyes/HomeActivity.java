package com.example.dllo.openeyes;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class HomeActivity extends AbsBaseActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private HomeAdapter adapter;
    private ArrayList<Fragment>datas;
    private ImageView searchIv,menuIv;
    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        tabLayout=byView(R.id.main_tablayout);
        viewPager=byView(R.id.main_viewpager);
        searchIv=byView(R.id.title_bar_search);
        menuIv=byView(R.id.title_bar_menu);

    }



    @Override
    protected void initDatas() {
        creatFragment();
        adapter=new HomeAdapter(getSupportFragmentManager());
        adapter.setDatas(datas);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        setTabIcon();
        changeTitleBarIcon();

    }

    private void changeTitleBarIcon() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                 if (position==3){
                     menuIv.setVisibility(View.VISIBLE);
                     searchIv.setVisibility(View.GONE);
                 }else {
                     searchIv.setVisibility(View.VISIBLE);
                     menuIv.setVisibility(View.GONE);
                 }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setTabIcon() {

        View selectionView=getLayoutInflater().inflate(R.layout.tab_selection,null);
        tabLayout.getTabAt(0).setCustomView(selectionView);
        View findView=getLayoutInflater().inflate(R.layout.tab_find,null);
        tabLayout.getTabAt(1).setCustomView(findView);
        View authorView=getLayoutInflater().inflate(R.layout.tab_author,null);
        tabLayout.getTabAt(2).setCustomView(authorView);
        View mineView=getLayoutInflater().inflate(R.layout.tab_mine,null);
        tabLayout.getTabAt(3).setCustomView(mineView);
        tabLayout.setSelectedTabIndicatorHeight(0);

    }


    private void creatFragment() {
        datas=new ArrayList<>();
        datas.add(new SelectionFragment());
        datas.add(new FindFragment());
        datas.add(new AuthorFragment());
        datas.add(new MineFragment());
    }

}
