package com.example.dllo.openeyes.ui.activity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dllo.openeyes.R;
import com.example.dllo.openeyes.model.bean.AuthorFragmentBean;
import com.example.dllo.openeyes.tools.DensityUtils;
import com.example.dllo.openeyes.tools.PicassoInstance;
import com.example.dllo.openeyes.tools.RecyclableImageView;
import com.example.dllo.openeyes.tools.ScreenUtilsInstance;
import com.example.dllo.openeyes.ui.adapter.AuthorVideoDetailAdapter;
import com.example.dllo.openeyes.view.TypeTextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by dllo on 16/8/16.
 */
public class AuthorVideoActivity extends AbsBaseActivity implements View.OnClickListener {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private AuthorVideoDetailAdapter adapter;
    private AuthorFragmentBean.ItemListBean.DataBean dataBean;
    private int position;
    private RecyclableImageView blurredIv, blurredNexIv;//下方模糊图片,下一张加载图片
    private ImageView videoBackIv, videoPlayIv, openDetailTv;//返回键,播放键
    private TypeTextView descriptionTpTv, titleTpTv, cateAndDuraTpTv;
    private CircleImageView iconCiIv;
    private TextView headerTitleTv, headerDescriptionTv, headerSubtitleTv;//header的相关文字
    private TextView favoritesTv, shareTv, replyTv, downloadTv;
    private RelativeLayout videoTexts;

    @Override
    protected int setLayout() {
        return R.layout.activity_author_video;
    }

    @Override
    protected void initViews() {
        viewPager = byView(R.id.author_video_viewpager);
        tabLayout = byView(R.id.author_video_tablayout);
        blurredIv = byView(R.id.author_video_blurred);
        blurredNexIv = byView(R.id.author_video_blurred_next);
        videoBackIv = byView(R.id.author_video_back);
        videoPlayIv = byView(R.id.author_video_play);
        descriptionTpTv = byView(R.id.author_video_description);
        titleTpTv = byView(R.id.author_video_title);
        cateAndDuraTpTv = byView(R.id.author_video_category_and_duration);
        iconCiIv = byView(R.id.author_video_header_icon);
        headerTitleTv = byView(R.id.author_video_header_title);
        headerSubtitleTv = byView(R.id.author_video_header_subTitle);
        headerDescriptionTv = byView(R.id.author_video_header_description);
        favoritesTv = byView(R.id.author_video_favorites);
        shareTv = byView(R.id.author_video_share);
        replyTv = byView(R.id.author_video_reply);
        downloadTv = byView(R.id.author_video_download);
        openDetailTv = byView(R.id.author_video_open_detail);
        videoTexts = byView(R.id.author_video_texts);

    }

    @Override
    protected void initDatas() {
        //AuthorAdapter 图片点击事件跳转传值NItemList集合过来
        Intent intent = getIntent();
        dataBean = intent.getParcelableExtra("videos");
        position = intent.getIntExtra("pos", 0);
        setText();
        videoBackIv.setOnClickListener(this);
        adapter = new AuthorVideoDetailAdapter(this);
        final String blurredUrl = dataBean.getItemList().get(position).getData().getCover().getBlurred();
        PicassoInstance.getsInstance().setImage(blurredUrl, blurredIv);
        //获取屏幕宽度
        int height = ScreenUtilsInstance.getsInstance().getScreenHeight(this);
        //获取控件的布局
        ViewGroup.LayoutParams layoutParams = blurredIv.getLayoutParams();
        //修改布局中的属性
        layoutParams.height = height * 9 / 20;
        //重新设置修改后的布局给控件
        blurredIv.setLayoutParams(layoutParams);
        blurredNexIv.setLayoutParams(layoutParams);

        adapter.setDatas(dataBean.getItemList());
        viewPager.setAdapter(adapter);
        //设置tablayout的懒加载页数
        viewPager.setOffscreenPageLimit(5);
        viewPager.setCurrentItem(position);
        //设置tablayout滑动条颜色
        tabLayout.setSelectedTabIndicatorColor(Color.WHITE);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            float offset;
            int pos;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (positionOffset <= 0.5) {
                    videoBackIv.setAlpha(1 - (positionOffset * 2));
                    videoPlayIv.setAlpha(1 - (positionOffset * 2));
                } else {
                    videoBackIv.setAlpha((float) ((positionOffset - 0.5) * 2));
                    videoPlayIv.setAlpha((float) ((positionOffset - 0.5) * 2));
                }

//                Log.d("AuthorVideoActivity", "positionOffset - offset:" + (positionOffset - offset));
//                    float ori = positionOffset - offset;
//                    if (ori > 0) {
//                        moveAnim(positionOffset);
////                        videoTexts.setAlpha(positionOffset);
//                    } else {
////                        videoTexts.setAlpha(1-positionOffset);
//                        moveAnim(1 - positionOffset);
//
//                    }
//                    offset = positionOffset;


                if (position < pos) {
                    //往右划
                    videoTexts.setAlpha(positionOffset);
                    blurredIv.setAlpha(positionOffset);
//                    String blurredUrl = dataBean.getItemList().get(position).getData().getCover().getBlurred();
//                    String blurredNexUrl = dataBean.getItemList().get(position-1).getData().getCover().getBlurred();
//                    PicassoInstance.getsInstance().setImage(blurredUrl, blurredIv);
//                    PicassoInstance.getsInstance().setImage(blurredUrl, blurredIv);

//                    PicassoInstance.getsInstance().setImage(blurredNexUrl, blurredNexIv);

                } else {
                    //往左滑(正常)
                    videoTexts.setAlpha(1 - positionOffset);
//                    String blurredNexUrl = dataBean.getItemList().get(position+1).getData().getCover().getBlurred();
//                    PicassoInstance.getsInstance().setImage(blurredNexUrl, blurredNexIv);
//                    blurredNexIv.setAlpha(positionOffset);
                    blurredIv.setAlpha(1 - positionOffset);

                }


            }

            @Override
            public void onPageSelected(int position) {

                AuthorFragmentBean.ItemListBean.DataBean.NItemListBean.NDataBean nDataBean = dataBean.getItemList().get(position).getData();
                String blurredUrl = nDataBean.getCover().getBlurred();
                PicassoInstance.getsInstance().setImage(blurredUrl, blurredIv);
                String descriptionStr = nDataBean.getDescription();
                String titleStr = nDataBean.getTitle();
                String cateStr = "#" + nDataBean.getCategory();
                DecimalFormat df = new DecimalFormat("00");
                String m = df.format(nDataBean.getDuration() / 60);
                String s = df.format(nDataBean.getDuration() % 60);
                int favoritesStr = nDataBean.getConsumption().getCollectionCount();
                int shareStr = nDataBean.getConsumption().getShareCount();
                int replyStr = nDataBean.getConsumption().getReplyCount();
                PicassoInstance.getsInstance().setImage(dataBean.getHeader().getIcon(), iconCiIv);
                headerTitleTv.setText(dataBean.getHeader().getTitle());
                headerSubtitleTv.setText(dataBean.getHeader().getSubTitle());
                headerDescriptionTv.setText(dataBean.getHeader().getDescription());
                titleTpTv.start(titleStr);
                descriptionTpTv.start(descriptionStr);
                cateAndDuraTpTv.start(cateStr + "  /  " + m + "′ " + s + "″");
                favoritesTv.setText(favoritesStr + "");
                shareTv.setText(shareStr + "");
                replyTv.setText(replyStr + "");
                pos = position;

//                BitmapDrawable bmp1 = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(),R.mipmap.three_mins));
//                BitmapDrawable bmp2 = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(),R.mipmap.recommend_bg_unlike));
//                Drawable layers [] = {bmp1,bmp2};
//                LayerDrawable drawable = new LayerDrawable(layers);
//                blurredIv.setImageDrawable(drawable);

                if (position == dataBean.getItemList().size() - 1) {
                    String blurredNexUrl = dataBean.getItemList().get(position).getData().getCover().getBlurred();
                    PicassoInstance.getsInstance().setImage(blurredNexUrl, blurredNexIv);
                } else {
                    String blurredNexUrl = dataBean.getItemList().get(position + 1).getData().getCover().getBlurred();
                    PicassoInstance.getsInstance().setImage(blurredNexUrl, blurredNexIv);
                }


            }

            @Override
            public void onPageScrollStateChanged(int state) {


            }
        });


    }


    private void setText() {
        String blurredUrl = dataBean.getItemList().get(position).getData().getCover().getBlurred();
        PicassoInstance.getsInstance().setImage(blurredUrl, blurredIv);
        String descriptionStr = dataBean.getItemList().get(position).getData().getDescription();
        String titleStr = dataBean.getItemList().get(position).getData().getTitle();
        String cateStr = "#" + dataBean.getItemList().get(position).getData().getCategory();
        DecimalFormat df = new DecimalFormat("00");
        String m = df.format(dataBean.getItemList().get(position).getData().getDuration() / 60);
        String s = df.format(dataBean.getItemList().get(position).getData().getDuration() % 60);
        int favoritesStr = dataBean.getItemList().get(position).getData().getConsumption().getCollectionCount();
        int shareStr = dataBean.getItemList().get(position).getData().getConsumption().getShareCount();
        int replyStr = dataBean.getItemList().get(position).getData().getConsumption().getReplyCount();
        PicassoInstance.getsInstance().setImage(dataBean.getHeader().getIcon(), iconCiIv);
        headerTitleTv.setText(dataBean.getHeader().getTitle());
        headerSubtitleTv.setText(dataBean.getHeader().getSubTitle());
        headerDescriptionTv.setText(dataBean.getHeader().getDescription());
        titleTpTv.start(titleStr);
        descriptionTpTv.start(descriptionStr);
        cateAndDuraTpTv.start(cateStr + "  /  " + m + "′ " + s + "″");
        favoritesTv.setText(favoritesStr + "");
        shareTv.setText(shareStr + "");
        replyTv.setText(replyStr + "");

        if (position == dataBean.getItemList().size() - 1) {
            String blurredNexUrl = dataBean.getItemList().get(position).getData().getCover().getBlurred();
            PicassoInstance.getsInstance().setImage(blurredNexUrl, blurredNexIv);
        } else {
            String blurredNexUrl = dataBean.getItemList().get(position + 1).getData().getCover().getBlurred();
            PicassoInstance.getsInstance().setImage(blurredNexUrl, blurredNexIv);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.author_video_back:
                finish();
                break;
        }
    }
}
