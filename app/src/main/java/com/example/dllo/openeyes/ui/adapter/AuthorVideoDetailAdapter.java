package com.example.dllo.openeyes.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
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

import java.util.ArrayList;
/**
 * Created by dllo on 16/8/16.
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
    public Object instantiateItem(ViewGroup container, int position) {
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
        layoutParams.height = height*11 / 20;
        //重新设置修改后的布局给控件
        coverIv.setLayoutParams(layoutParams);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
