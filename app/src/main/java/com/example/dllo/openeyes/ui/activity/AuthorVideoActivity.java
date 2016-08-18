package com.example.dllo.openeyes.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dllo.openeyes.R;
import com.example.dllo.openeyes.model.bean.AuthorFragmentBean;
import com.example.dllo.openeyes.tools.DensityUtils;
import com.example.dllo.openeyes.tools.PicassoInstance;
import com.example.dllo.openeyes.tools.ScreenUtilsInstance;
import com.example.dllo.openeyes.ui.adapter.AuthorVideoDetailAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/16.
 */
public class AuthorVideoActivity extends AbsBaseActivity{
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private AuthorVideoDetailAdapter adapter;
    private ArrayList<AuthorFragmentBean.ItemListBean.DataBean.NItemListBean> datas;
    private int position;
    private ImageView blurredIv;//下方模糊图片
    private ImageView videoBackIv,videoPlayIv;//返回键,播放键
    @Override
    protected int setLayout() {
        return R.layout.activity_author_video;
    }

    @Override
    protected void initViews() {
        viewPager=byView(R.id.author_video_viewpager);
        tabLayout=byView(R.id.author_video_tablayout);
        blurredIv=byView(R.id.author_video_blurred);
        videoBackIv=byView(R.id.author_video_back);
        videoPlayIv=byView(R.id.author_video_play);

    }

    @Override
    protected void initDatas() {
        //AuthorAdapter 图片点击事件跳转传值NItemList集合过来
        Intent intent=getIntent();
        datas=intent.getParcelableArrayListExtra("videos");
        position=intent.getIntExtra("pos",0);
        adapter=new AuthorVideoDetailAdapter(this);
        String blurredUrl=datas.get(position).getData().getCover().getBlurred();
        PicassoInstance.getsInstance().setImage(blurredUrl,blurredIv);
        //获取屏幕宽度
        int height = ScreenUtilsInstance.getsInstance().getScreenHeight(this);
        //获取控件的布局
        ViewGroup.LayoutParams layoutParams = blurredIv.getLayoutParams();
        //修改布局中的属性
        layoutParams.height = height*9/20;
        //重新设置修改后的布局给控件
        blurredIv.setLayoutParams(layoutParams);
        adapter.setDatas(datas);
        viewPager.setAdapter(adapter);
        //设置tablayout的懒加载页数
        viewPager.setOffscreenPageLimit(5);
        viewPager.setCurrentItem(position);
        //设置tablayout滑动条颜色
        tabLayout.setSelectedTabIndicatorColor(Color.WHITE);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d("AuthorVideoActivity", "position:" + position);
                Log.d("AuthorVideoActivity", "positionOffset:" + positionOffset);
                Log.d("AuthorVideoActivity", "positionOffsetPixels:" + positionOffsetPixels);
               if (positionOffset<=0.5){
                   videoBackIv.setAlpha(1-(positionOffset*2));
                   videoPlayIv.setAlpha(1-(positionOffset*2));
               }else{
                   videoBackIv.setAlpha((float) ((positionOffset-0.5)*2));
                   videoPlayIv.setAlpha((float) ((positionOffset-0.5)*2));
               }


            }

            @Override
            public void onPageSelected(int position) {
                String blurredUrl=datas.get(position).getData().getCover().getBlurred();
                PicassoInstance.getsInstance().setImage(blurredUrl,blurredIv);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });












    }
}
