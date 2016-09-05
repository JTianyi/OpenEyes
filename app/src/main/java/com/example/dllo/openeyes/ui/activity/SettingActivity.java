package com.example.dllo.openeyes.ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.example.dllo.openeyes.R;

/**
 * Created by mac on 16/8/25.
 * 设置界面
 *
 * @author wangweijian
 */
public class SettingActivity extends AbsBaseActivity implements View.OnClickListener {
    private ImageView returnIv;
    private RadioButton flowOpenBtn, flowCloseBtn, updateOpenBtn, updateCloseBtn, cacheOpenBtn, cacheCloseBtn;

    @Override
    protected int setLayout() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initViews() {
        returnIv = byView(R.id.setting_return);
        flowOpenBtn = byView(R.id.flow_open_btn);
        flowCloseBtn = byView(R.id.flow_close_btn);
        updateOpenBtn = byView(R.id.update_open_btn);
        updateCloseBtn = byView(R.id.update_close_btn);
        cacheOpenBtn = byView(R.id.cache_open_btn);
        cacheCloseBtn = byView(R.id.cache_close_btn);
    }

    @Override
    protected void initDatas() {
        returnIv.setOnClickListener(this);//返回键
        flowCloseBtn.setOnClickListener(this);//流量开关
        flowOpenBtn.setOnClickListener(this);
        updateOpenBtn.setOnClickListener(this);//更新开关
        updateCloseBtn.setOnClickListener(this);
        cacheCloseBtn.setOnClickListener(this);//缓存开关
        cacheOpenBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.setting_return:
                finish();
                break;
            case R.id.flow_open_btn:
                break;
            case R.id.flow_close_btn:
                break;
            case R.id.update_close_btn:
                break;
            case R.id.update_open_btn:
                break;
            case R.id.cache_close_btn:
                break;
            case R.id.cache_open_btn:
                break;
        }
    }
}
