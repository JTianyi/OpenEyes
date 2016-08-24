package com.example.dllo.openeyes.ui.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dllo.openeyes.model.bean.ExploreBannerBean;
import com.example.dllo.openeyes.model.bean.FindBean;
import com.example.dllo.openeyes.model.net.NetUrls;
import com.example.dllo.openeyes.tools.DensityUtils;

import com.example.dllo.openeyes.tools.ScreenUtilsInstance;


import com.example.dllo.openeyes.tools.OkHttp;
import com.example.dllo.openeyes.tools.OnHttpCallBack;
import com.example.dllo.openeyes.tools.PicassoInstance;
import com.example.dllo.openeyes.ui.activity.ExploreBannerActivity;
import com.example.dllo.openeyes.ui.adapter.FindAdapter;
import com.youth.banner.Banner;

import com.example.dllo.openeyes.R;
import com.example.dllo.openeyes.model.bean.FindBean;
import com.example.dllo.openeyes.model.bean.FindNeedBean;
import com.example.dllo.openeyes.model.net.NetUrls;
import com.example.dllo.openeyes.tools.DensityUtils;
import com.example.dllo.openeyes.tools.ScreenUtilsInstance;
import com.example.dllo.openeyes.tools.OkHttp;
import com.example.dllo.openeyes.tools.OnHttpCallBack;
import com.example.dllo.openeyes.tools.PicassoInstance;
import com.example.dllo.openeyes.ui.activity.FullShotActivity;
import com.example.dllo.openeyes.ui.adapter.FindAdapter;
import com.example.dllo.openeyes.view.HeaderGridView;
import com.youth.banner.Banner;

import com.example.dllo.openeyes.R;

import java.util.ArrayList;
/**
 * Created by dllo on 16/8/12.
 * 发现界面
 *
 * @author wangweijian
 */
public class FindFragment extends AbsBaseFragment implements View.OnClickListener {
    private HeaderGridView headerGridView;
    private FindBean findBean;
    private ArrayList<FindNeedBean> beanArrayList;
    private FindAdapter findAdapter;
    private Banner banner;
    private BackTopBroadcast backTopBroadcast;
    private String[] bannerUrls;

    @Override
    protected int setLayout() {
        return R.layout.fragment_find;
    }

    @Override
    protected void initViews(View view) {
        headerGridView = byView(R.id.find_grid_view);
    }

    @Override
    protected void initDatas() {
        //加载发现界面数据
        addFindData();
        //加载轮播图数据
        addBannerData();
    }

    private void addOneData() {
        View view = LayoutInflater.from(context).inflate(R.layout.item_find_one, null);
        ImageView topIv = (ImageView) view.findViewById(R.id.find_top_iv);
        ImageView topicIv = (ImageView) view.findViewById(R.id.find_topic_iv);
        ImageView rectangleIv = (ImageView) view.findViewById(R.id.find_rectangle_iv);
        PicassoInstance.getsInstance().setImage(findBean.getItemList().get(1).getData().getImage(), topIv);
        PicassoInstance.getsInstance().setImage(findBean.getItemList().get(2).getData().getImage(), topicIv);
        PicassoInstance.getsInstance().setImage(findBean.getItemList().get(3).getData().getImage(), rectangleIv);
        headerGridView.addHeaderView(view);
        //获取屏幕宽度
        int width = ScreenUtilsInstance.getsInstance().getScreenWidth(context);
        //将dp转换成px
        int px = DensityUtils.dp2px(context, 1.5f);
        //获取控件的布局
        ViewGroup.LayoutParams layoutParamsTop = topIv.getLayoutParams();
        ViewGroup.LayoutParams layoutParamsTopic = topicIv.getLayoutParams();
        ViewGroup.LayoutParams layoutParamsRectangleIv = rectangleIv.getLayoutParams();
        //修改布局中的属性
        layoutParamsTop.height = (width - px) / 2;
        //重新设置修改后的布局给控件
        topIv.setLayoutParams(layoutParamsTop);
        //修改布局中的属性
        layoutParamsTopic.height = (width - px) / 2;
        //重新设置修改后的布局给控件
        topicIv.setLayoutParams(layoutParamsTopic);
        //修改布局中的属性
        layoutParamsRectangleIv.height = (width - px) / 2;
        //重新设置修改后的布局给控件
        rectangleIv.setLayoutParams(layoutParamsRectangleIv);
        rectangleIv.setOnClickListener(this);
    }


    private void addBannerData() {
        View view = LayoutInflater.from(context).inflate(R.layout.item_find_banner, null);
        banner = (Banner) view.findViewById(R.id.find_banner);
        //设置指示器(小圆点)
        banner.setBannerStyle(Banner.CIRCLE_INDICATOR);
        //设置位置
        banner.setIndicatorGravity(Banner.CENTER);
        banner.isAutoPlay(true);
        //加到头布局
        headerGridView.addHeaderView(view);
        //获取屏幕高度
        int screenHeight = ScreenUtilsInstance.getsInstance().getScreenHeight(context);
        //获取控件的布局
        ViewGroup.LayoutParams layoutParams = banner.getLayoutParams();
        //修改控件
        layoutParams.height = screenHeight * 2 / 5;
        //重新设置给控件
        banner.setLayoutParams(layoutParams);
        //给banner设置点击事件
        banner.setOnBannerClickListener(new Banner.OnBannerClickListener() {
            @Override
            public void OnBannerClick(View view, int position) {
                if (position==bannerUrls.length){
                goTo(context, ExploreBannerActivity.class);
                }
            }
        });
    }


    private void addFindData() {
        OkHttp.getInstance().startRequest(NetUrls.FIND_URL, FindBean.class, new OnHttpCallBack<FindBean>() {
            @Override
            public void onSuccess(FindBean response) {
                findBean = new FindBean();
                findBean = response;
                FindNeedBean needBean;
                beanArrayList = new ArrayList<>();
                findAdapter = new FindAdapter(context);
                for (int i = 0; i < findBean.getItemList().size(); i++) {
                    if (i > 3) {
                        String needImage = findBean.getItemList().get(i).getData().getImage();
                        String needTitle = findBean.getItemList().get(i).getData().getTitle();
                        needBean = new FindNeedBean();
                        needBean.setNeedImage(needImage);
                        needBean.setNeedTitle(needTitle);
                        beanArrayList.add(needBean);
                    }
                }
                findAdapter.setBeanArrayList(beanArrayList);
                headerGridView.setAdapter(findAdapter);
                bannerUrls = new String[findBean.getItemList().get(0).getData().getItemList().size()];
                for (int i = 0; i < findBean.getItemList().get(0).getData().getItemList().size(); i++) {
                    bannerUrls[i] = findBean.getItemList().get(0).getData().getItemList().get(i).getData().getImage();
                    banner.setImages(bannerUrls);
                }
                //加载1 ,2位置的数据
                addOneData();
            }

            @Override
            public void onError(Throwable ex) {

            }
        });
        backTopBroadcast=new BackTopBroadcast();
        IntentFilter intentFilter=new IntentFilter("com.example.dllo.openeyes.ui.BACK_TOP");
        context.registerReceiver(backTopBroadcast,intentFilter);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        context.unregisterReceiver(backTopBroadcast);
    }
    class BackTopBroadcast extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            headerGridView.smoothScrollToPosition(0);

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.find_rectangle_iv:
                goTo(context, FullShotActivity.class);

        }
    }
}
