package com.example.dllo.openeyes.tools;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by mac on 16/8/18.
 */
public class HorizontalStackTransformer implements ViewPager.PageTransformer {
    private Context context;

    public HorizontalStackTransformer(Context context) {
        this.context = context;
    }

    @Override
    public void transformPage(View page, float position) {

//        if (position <= 0.0f) {
//            page.setAlpha(1.0f);
//            //出现卡片抽动效果的关键代码
//            page.setTranslationY(0f);
//        } else {
//            float scale = (float) (page.getWidth() - DensityUtils.dp2px(context, 20 * position)) / (float) (page.getWidth());
//            page.setAlpha(1.0f);
//            page.setPivotX(page.getWidth() / 2f);
//            page.setPivotY(page.getHeight() / 2f);
//            page.setScaleX(scale);
//            page.setScaleY(scale);
//            //修改过的代码
//            page.setTranslationY(-page.getHeight() * position + (page.getHeight() * 0.5f) * (1 - scale) + DensityUtils.dp2px(context, 10) * position);
        //设置每个卡片x方向偏移量，这样可以使卡片都完全叠加起来
        if (position<=0.0f){
            page.setAlpha(1.0f);
            //最上面的卡片可以点击
            page.setClickable(true);
            //出现卡片抽动效果的关键代码
            page.setTranslationX(0f);
        }else {
            //下面的图片不可以点击
            page.setClickable(false);
            float scale = (float) (page.getWidth() - DensityUtils.dp2px(context, 60 * position)) / (float) (page.getWidth());
            //设置卡片透明度
            page.setAlpha(1f);
            //设置缩放中点
            page.setPivotX(page.getWidth() / 2f);
            page.setPivotY(page.getHeight() / 2f);
            //设置缩放的比例 此处设置两个相邻的卡片的缩放比率为0.9f
//        page.setScaleX((float) Math.pow(0.9f,position));
//        page.setScaleY((float) Math.pow(0.9f,position));
            page.setScaleX(scale);
            page.setScaleY(scale);
            page.setTranslationX(-page.getWidth() * position);
//        page.setTranslationY(-page.getHeight() * position + (page.getHeight() * 0.5f) * (1 - scale) + DensityUtils.dp2px(context, 10) * position);
//        page.setTranslationY( (page.getHeight() * 0.5f) * (1 - (float) Math.pow(0.9f, position)) + DensityUtils.dp2px(context, 10));
            page.setTranslationY((page.getHeight() * 0.5f) * (1 - scale) + DensityUtils.dp2px(context, 10));
//        page.setTranslationY(-page.getHeight()*position);
        }
    }



}
