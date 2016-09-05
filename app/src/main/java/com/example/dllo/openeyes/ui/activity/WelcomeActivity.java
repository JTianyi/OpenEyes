package com.example.dllo.openeyes.ui.activity;

import android.os.CountDownTimer;
import android.widget.ImageView;

import com.example.dllo.openeyes.R;
import com.example.dllo.openeyes.model.bean.WelcomeBean;
import com.example.dllo.openeyes.model.net.NetUrls;
import com.example.dllo.openeyes.tools.OkHttp;
import com.example.dllo.openeyes.tools.OnHttpCallBack;
import com.example.dllo.openeyes.tools.PicassoInstance;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

/**
 * Created by mac on 16/8/24.
 * 欢迎页
 *
 * @author wangweijian
 */
public class WelcomeActivity extends AbsBaseActivity {
    private ImageView welcomeIv;
    private WelcomeBean bean;
    private CountDownTimer timer;
    private RequestCreator creator;

    @Override
    protected int setLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initViews() {
        welcomeIv = byView(R.id.welcome_iv);
    }

    @Override
    protected void initDatas() {
        //加载欢迎页数据
        addWelcomeData();
    }


    private void addWelcomeData() {
        bean = new WelcomeBean();
        OkHttp.getInstance().startRequest(NetUrls.WELCOME_URL, WelcomeBean.class, new OnHttpCallBack<WelcomeBean>() {
            @Override
            public void onSuccess(WelcomeBean response) {
                bean = response;
                //计时加载图片
                loadData();
            }
            @Override
            public void onError(Throwable ex) {

            }
        });
    }

    private void loadData() {
        //RequestCreator 要求使用Picasso
        creator = Picasso.with(this).load(bean.getStartPage().getImageUrl());
        //计时切换页面和跳转主页
        timer = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (millisUntilFinished / 1000 == 2) {
                    creator.into(welcomeIv);
                }
            }

            @Override
            public void onFinish() {
                //跳到主页
                goTo(WelcomeActivity.this, HomeActivity.class);
            }
        }.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        timer.cancel();
    }

}
