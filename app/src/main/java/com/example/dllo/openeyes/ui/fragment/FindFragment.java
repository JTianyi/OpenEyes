package com.example.dllo.openeyes.ui.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.example.dllo.openeyes.HeaderGridView;
import com.example.dllo.openeyes.model.bean.FindBean;
import com.example.dllo.openeyes.model.net.NetUrls;
import com.example.dllo.openeyes.tools.DensityUtils;

import com.example.dllo.openeyes.tools.ScreenUtilsInstance;
import com.example.dllo.openeyes.tools.OkHttp;
import com.example.dllo.openeyes.tools.OnHttpCallBack;
import com.example.dllo.openeyes.tools.PicassoInstance;
import com.example.dllo.openeyes.ui.adapter.FindAdapter;
import com.youth.banner.Banner;

import com.example.dllo.openeyes.R;

/**
 * Created by dllo on 16/8/12.
 * 发现界面
 *
 * @author wangweijian
 */
public class FindFragment extends AbsBaseFragment {
    private HeaderGridView headerGridView;
    private FindBean findBean;
    private FindAdapter findAdapter;
    private String[] bannerUrls = {"","","",""};
    private Banner banner;

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
        View view = LayoutInflater.from(context).inflate(R.layout.item_find_one,null);
        ImageView topIv = (ImageView) view.findViewById(R.id.find_top_iv);
        ImageView topicIv = (ImageView) view.findViewById(R.id.find_topic_iv);
        ImageView rectangleIv = (ImageView) view.findViewById(R.id.find_rectangle_iv);
        PicassoInstance.getsInstance().setImage(findBean.getItemList().get(1).getData().getImage(),topIv);
        PicassoInstance.getsInstance().setImage(findBean.getItemList().get(2).getData().getImage(),topicIv);
        PicassoInstance.getsInstance().setImage(findBean.getItemList().get(3).getData().getImage(),rectangleIv);
        headerGridView.addHeaderView(view);
        //获取屏幕宽度
        int width = ScreenUtilsInstance.getsInstance().getScreenWidth(context);
        //将dp转换成px
        int px = DensityUtils.dp2px(context,1.5f);
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
        layoutParams.height = screenHeight*2/5;
        //重新设置给控件
        banner.setLayoutParams(layoutParams);

    }

    private void addFindData() {
        OkHttp.getInstance().startRequest(NetUrls.FIND_URL, FindBean.class, new OnHttpCallBack<FindBean>() {
            @Override
            public void onSuccess(FindBean response) {
                findBean = new FindBean();
                findBean = response;
                findAdapter = new FindAdapter(context);
                findAdapter.setFindBean(findBean);
                headerGridView.setAdapter(findAdapter);
                for (int i = 0; i < findBean.getItemList().get(0).getData().getItemList().size(); i++) {
                    bannerUrls[i] = findBean.getItemList().get(0).getData().getItemList().get(i).getData().getImage();
                    banner.setImages(bannerUrls);
                }
                //加载position=1的数据
                addOneData();
            }

            @Override
            public void onError(Throwable ex) {

            }
        });
    }

}
