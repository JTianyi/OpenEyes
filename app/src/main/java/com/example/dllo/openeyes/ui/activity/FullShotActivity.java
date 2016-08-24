package com.example.dllo.openeyes.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.example.dllo.openeyes.R;
import com.example.dllo.openeyes.ui.adapter.FullShotAdapter;
import com.example.dllo.openeyes.ui.fragment.AccordShareFragment;
import com.example.dllo.openeyes.ui.fragment.AccordTimeFragment;

import java.util.ArrayList;

/**
 * Created by mac on 16/8/17.
 * 360全景主界面
 * @author wangweijian
 *
 */
public class FullShotActivity extends AbsBaseActivity implements View.OnClickListener {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<Fragment> data;
    private FullShotAdapter adapter;
    private ImageView returnIv;
    @Override
    protected int setLayout() {
        return R.layout.activity_shot_full;
    }

    @Override
    protected void initViews() {
        tabLayout = byView(R.id.full_shot_tab_layout);
        viewPager = byView(R.id.full_shot_view_pager);
        returnIv = byView(R.id.full_shot_return);
    }

    @Override
    protected void initDatas() {
       //加载Fragment数据
        addFragment();
        returnIv.setOnClickListener(this);
    }

    private void addFragment() {
        data = new ArrayList<>();
        adapter = new FullShotAdapter(getSupportFragmentManager());
        data.add(new AccordTimeFragment());
        data.add(new AccordShareFragment());
        adapter.setData(data);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.full_shot_return:
                finish();
        }
    }
}
