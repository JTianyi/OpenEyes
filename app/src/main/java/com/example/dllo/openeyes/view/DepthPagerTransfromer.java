package com.example.dllo.openeyes.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.dllo.openeyes.R;
import com.example.dllo.openeyes.tools.RecyclableImageView;

/**
 * Created by dllo on 16/8/25.
 */
public class DepthPagerTransfromer implements ViewPager.PageTransformer {
    private static float MIN_SCALE = 0.75f;
    private Context context;

    @Override
    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();
        RecyclableImageView imageView= (RecyclableImageView) view.findViewById(R.id.author_video_detail_cover_feed);
        if (position < -1) { // [-Infinity,-1)

            // This page is way off-screen to the left.
            view.setAlpha(1);
        } else if (position <= 0) { // [-1,0]
            // Use the default slide transition when
            // moving to the left page
            imageView.setTranslationX(pageWidth * -position / 4 *3);
            Log.d("DepthPagerTransfromer", "position:" + position);
//            view.setTranslationX(pageWidth * position);
            view.setAlpha(1);
            view.setTranslationX(1);
            //获取屏幕宽度
//            int height = ScreenUtilsInstance.getsInstance().getScreenHeight(context);
//            //获取控件的布局
//            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
//            //修改布局中的属性
//            layoutParams.height = height;
//            //重新设置修改后的布局给控件
//            view.setLayoutParams(layoutParams);
            view.setScaleX(1);
            view.setScaleY(1);
        } else if (position <=1) { // (0,1]
            // Fade the page out.
//            view.setAlpha(1 - position);
            // Counteract the default slide transition
            view.setTranslationX(pageWidth * -position / 4 *3);
//             Scale the page down (between MIN_SCALE and 1)
//            float scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position));
//            view.setScaleX(scaleFactor);
//            view.setScaleY(scaleFactor);
//            view.setRotationX(100 * position);
//            view.setTranslationY(-10f * position * 100);
//            TranslateAnimation animation = new TranslateAnimation(pageWidth,0,0,0);
//            animation.setFillAfter(true);
//            view.startAnimation(animation);

        }
        else { // (1,+Infinity]
            // This page is way off-screen to the right.
//            view.setAlpha(0);

        }



    }
}
