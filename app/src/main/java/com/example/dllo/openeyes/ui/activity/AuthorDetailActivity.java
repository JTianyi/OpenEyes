package com.example.dllo.openeyes.ui.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.telecom.TelecomManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dllo.openeyes.R;
import com.example.dllo.openeyes.tools.DensityUtils;
import com.example.dllo.openeyes.tools.ModuleUtilsInstance;
import com.example.dllo.openeyes.tools.PicassoInstance;
import com.example.dllo.openeyes.tools.ScreenUtilsInstance;
import com.example.dllo.openeyes.ui.adapter.FullShotAdapter;
import com.example.dllo.openeyes.ui.fragment.AccordShareFragment;
import com.example.dllo.openeyes.ui.fragment.AccordTimeFragment;
import com.example.dllo.openeyes.ui.fragment.AuthorDetailDateFragment;
import com.example.dllo.openeyes.ui.fragment.AuthorDetailShareFragment;
import com.example.dllo.openeyes.view.CenterTextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by mac on 16/8/20.
 * 作者详情页面
 *
 * @author jiangtianyi
 */
public class AuthorDetailActivity extends AbsBaseActivity implements View.OnClickListener {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<Fragment> data;
    private FullShotAdapter adapter;
    private ImageView backIv;
    private TextView textView;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private AppBarLayout appBarLayout;
    private TextView dongbei, haha;
    private Toolbar toolbar;
    private LinearLayout dateLinearLayout, shareLinearLayout;

    @Override
    protected int setLayout() {
        return R.layout.activity_author_detail;
    }

    @Override
    protected void initViews() {
        tabLayout = byView(R.id.toolbar_tab);
        viewPager = byView(R.id.full_shot_view_pager);
        collapsingToolbarLayout = byView(R.id.collapsing_toolbar_layout);
        appBarLayout = byView(R.id.app_bar_layout);
        toolbar = byView(R.id.toolbar);
        haha = byView(R.id.author_detail_name_bar);
        dongbei = byView(R.id.author_detail_name);

        backIv = byView(R.id.author_detail_back);
        dateLinearLayout = byView(R.id.author_detail_date_view);
        shareLinearLayout = byView(R.id.author_detail_share_view);
    }


    @Override
    protected void initDatas() {
        final int px = DensityUtils.dp2px(this, 118.5f);
        final int width = ScreenUtilsInstance.getsInstance().getScreenWidth(this);
        //加载Fragment数据
        addFragment();

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset <= -px && verticalOffset >= -400) {
                    haha.setVisibility(View.VISIBLE);
                    dongbei.setVisibility(View.GONE);
                } else {
                    dongbei.setVisibility(View.VISIBLE);
                    haha.setVisibility(View.GONE);
                }
            }
        });
        backIv.setOnClickListener(this);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                RelativeLayout.LayoutParams layoutParamsDate = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);//定义一个LayoutParams
                layoutParamsDate.setMargins((int) ((positionOffset*width/2)+(width/7)),0,0,0);//4个参数按顺序分别是左上右下
                RelativeLayout.LayoutParams layoutParamsShare = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);//定义一个LayoutParams
                layoutParamsShare.setMargins((width/2)+(width/7),0,(width/7),0);//4个参数按顺序分别是左上右下
                if (position==1){
                    shareLinearLayout.setVisibility(View.VISIBLE);
                    dateLinearLayout.setVisibility(View.GONE);
                    shareLinearLayout.setLayoutParams(layoutParamsShare); //mView是控件
                }else{
                    dateLinearLayout.setVisibility(View.VISIBLE);
                    shareLinearLayout.setVisibility(View.GONE);
                    dateLinearLayout.setLayoutParams(layoutParamsDate); //mView是控件
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private void addFragment() {
        data = new ArrayList<>();
        adapter = new FullShotAdapter(getSupportFragmentManager());
        data.add(new AuthorDetailDateFragment());
        data.add(new AuthorDetailShareFragment());
        adapter.setData(data);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.author_detail_back:
                finish();
        }
    }


}
