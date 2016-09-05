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
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.telecom.TelecomManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dllo.openeyes.R;
import com.example.dllo.openeyes.model.net.NetUrls;
import com.example.dllo.openeyes.tools.DensityUtils;
import com.example.dllo.openeyes.tools.ModuleUtilsInstance;
import com.example.dllo.openeyes.tools.PicassoInstance;
import com.example.dllo.openeyes.tools.ScreenUtilsInstance;
import com.example.dllo.openeyes.ui.adapter.AuthorDetailAdapter;
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
//    private ArrayList<Fragment> data;
    private AuthorDetailAdapter adapter;
    private ImageView backIv,shareIv;
    private TextView textView;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private AppBarLayout appBarLayout;
    private TextView dongbei, haha;
    private Toolbar toolbar;
    private LinearLayout dateLinearLayout, shareLinearLayout;
    private CircleImageView iconCirIv;//协调布局的图片
    private CenterTextView descriptionCenTv;
    private TextView nameTv, nameBarTv;
    private String [] urls = new String[2];
    private int id;
    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;

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

        backIv = byView(R.id.author_detail_back);
        shareIv=byView(R.id.author_detail_share);
        dateLinearLayout = byView(R.id.author_detail_date_view);
        shareLinearLayout = byView(R.id.author_detail_share_view);

        iconCirIv = byView(R.id.author_detail_icon);
        descriptionCenTv = byView(R.id.author_detail_description);
        nameBarTv = byView(R.id.author_detail_name_bar);
        nameTv = byView(R.id.author_detail_name);

    }


    @Override
    protected void initDatas() {
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        String descriptionStr = intent.getStringExtra("des");
        String nameStr = intent.getStringExtra("name");
        String nameBarStr=intent.getStringExtra("namebar");
        String iconUrl=intent.getStringExtra("icon");


        nameTv.setText(nameStr);
        nameBarTv.setText(nameBarStr);
        descriptionCenTv.setText(descriptionStr);
        PicassoInstance.getsInstance().setImage(iconUrl, iconCirIv);


        final int px = DensityUtils.dp2px(this, 118.5f);
        final int width = ScreenUtilsInstance.getsInstance().getScreenWidth(this);
        //加载Fragment数据
        addFragment();

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset <= -px && verticalOffset >= -800) {
                    nameBarTv.setVisibility(View.VISIBLE);
                    nameTv.setVisibility(View.GONE);
                } else {
                    nameTv.setVisibility(View.VISIBLE);
                    nameBarTv.setVisibility(View.GONE);
                }
            }
        });
        backIv.setOnClickListener(this);
        shareIv.setOnClickListener(this);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                RelativeLayout.LayoutParams layoutParamsDate = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);//定义一个LayoutParams
                layoutParamsDate.setMargins((int) ((positionOffset * width / 2) + (width / 7)), 0, 0, 0);//4个参数按顺序分别是左上右下
                RelativeLayout.LayoutParams layoutParamsShare = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);//定义一个LayoutParams
                layoutParamsShare.setMargins((width / 2) + (width / 7), 0, (width / 7), 0);//4个参数按顺序分别是左上右下
                if (position == 1) {
                    shareLinearLayout.setVisibility(View.VISIBLE);
                    dateLinearLayout.setVisibility(View.GONE);
                    shareLinearLayout.setLayoutParams(layoutParamsShare); //mView是控件
                } else {
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
//        data = new ArrayList<>();
        adapter = new AuthorDetailAdapter(getSupportFragmentManager());
        urls[0]= NetUrls.AUTHOR_DETAIL_HEAD_URL + id + NetUrls.AUTHOR_DETAIL_DATE_URL + NetUrls.AUTHOR_DETAIL_FOOT_URL;
        urls[1]= NetUrls.AUTHOR_DETAIL_HEAD_URL + id + NetUrls.AUTHOR_DETAIL_SHARE_URL + NetUrls.AUTHOR_DETAIL_FOOT_URL;
        adapter.setUrls(urls);
//        data.add(new );
//        data.add(AuthorDetailDateFragment.newInstance());
//        adapter.setData(data);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.author_detail_back:
                finish();
                break;
            case R.id.author_detail_share:
                builder = new AlertDialog.Builder(this,R.style.dialog);
                View view = LayoutInflater.from(this).inflate(R.layout.item_author_detail_share, null);
               TextView dismissIv = (TextView) view.findViewById(R.id.author_detail_share_dismiss);
                dismissIv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                builder.setView(view);

                alertDialog=builder.show();
                alertDialog.setCanceledOnTouchOutside(false);
                break;
        }
    }


}
