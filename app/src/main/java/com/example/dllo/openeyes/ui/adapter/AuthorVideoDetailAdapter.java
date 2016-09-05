package com.example.dllo.openeyes.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.dllo.openeyes.R;
import com.example.dllo.openeyes.model.bean.AuthorFragmentBean;
import com.example.dllo.openeyes.tools.DensityUtils;
import com.example.dllo.openeyes.tools.PicassoInstance;
import com.example.dllo.openeyes.tools.ScreenUtilsInstance;
import com.example.dllo.openeyes.ui.activity.PlayVideoActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/8/16.
 * 视频待播放页面的ViewPager的adapter
 */
public class AuthorVideoDetailAdapter extends PagerAdapter {
    private ArrayList<AuthorFragmentBean.ItemListBean.DataBean.NItemListBean> datas;
    private Context context;
    private ImageView coverIv;


    public AuthorVideoDetailAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(ArrayList<AuthorFragmentBean.ItemListBean.DataBean.NItemListBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();

    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_author_video_detail,container,false);
        coverIv = (ImageView) view.findViewById(R.id.author_video_detail_cover_feed);

        Animation mAnimation = null ;
        /**
         * 显示动画的ImageView
         */

        mAnimation = AnimationUtils.loadAnimation(context,R.anim.video_detail_enlarge_scale);
        coverIv.setAnimation(mAnimation );
        mAnimation.start();

        String coverUrl=datas.get(position).getData().getCover().getFeed();

        PicassoInstance.getsInstance().setImage(coverUrl,coverIv);

        //获取屏幕宽度
        int height = ScreenUtilsInstance.getsInstance().getScreenHeight(context);
        //获取控件的布局
        ViewGroup.LayoutParams layoutParams = coverIv.getLayoutParams();
        //修改布局中的属性
        layoutParams.height = height*26 /51;
        //重新设置修改后的布局给控件
        final AuthorFragmentBean.ItemListBean.DataBean.NItemListBean.NDataBean playInfoBean=datas.get(position).getData();
        coverIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, PlayVideoActivity.class);
                intent.putExtra("playUrl",datas.get(position).getData().getPlayUrl());
                intent.putExtra("playInfo",playInfoBean);
                context.startActivity(intent);


            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
