package com.example.dllo.openeyes.ui.activity;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.dllo.openeyes.R;
import com.example.dllo.openeyes.model.bean.ExploreBannerBean;
import com.example.dllo.openeyes.model.net.NetUrls;
import com.example.dllo.openeyes.tools.HorizontalStackTransformer;
import com.example.dllo.openeyes.tools.OkHttp;
import com.example.dllo.openeyes.tools.OnHttpCallBack;
import com.example.dllo.openeyes.tools.PicassoInstance;
import com.example.dllo.openeyes.ui.adapter.ExploreBannerAdapter;

/**
 * Created by mac on 16/8/22.
 * 轮播图探索界面
 * @author wangweijian
 */
public class ExploreBannerActivity extends AbsBaseActivity implements View.OnClickListener {
    private ViewPager viewPager;
    private ExploreBannerAdapter adapter;
    private TextView positionTv;
    private ImageView exploreBackgroundIv;
    private ExploreBannerBean bean;
    private ImageView returnIv;
    @Override
    protected int setLayout() {
        return R.layout.activity_banner_explore;
    }

    @Override
    protected void initViews() {
        viewPager = byView(R.id.explore_view_pager);
        positionTv = byView(R.id.explore_position_tv);
        exploreBackgroundIv = byView(R.id.explore_background_iv);
        returnIv = byView(R.id.explore_return);
    }

    @Override
    protected void initDatas() {
        adapter = new ExploreBannerAdapter(this);
        //加载探索界面数据
        addExploreData();
        //设置形式
        viewPager.setPageTransformer(true, new HorizontalStackTransformer(this));
        //设置限制张数
        viewPager.setOffscreenPageLimit(3);
        //给viewPager设置点击事件
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                positionTv.setText(position+1+"-10");
                PicassoInstance.getsInstance().setImage(bean.getItemList().get(position).getData().getCover().getBlurred(),exploreBackgroundIv);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        returnIv.setOnClickListener(this);
    }

    private void addExploreData() {
        OkHttp.getInstance().startRequest(NetUrls.EXPLORE_BANNER_URL, ExploreBannerBean.class, new OnHttpCallBack<ExploreBannerBean>() {
            @Override
            public void onSuccess(ExploreBannerBean response) {
                bean = response;
                adapter.setExploreBannerBean(bean);
                viewPager.setAdapter(adapter);
                PicassoInstance.getsInstance().setImage(bean.getItemList().get(0).getData().getCover().getBlurred(),exploreBackgroundIv);

            }

            @Override
            public void onError(Throwable ex) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.explore_return:
                finish();
                break;
        }
    }
}
