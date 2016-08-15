package com.example.dllo.openeyes;

import android.view.View;
import android.widget.GridView;

import com.example.dllo.openeyes.tool.OkHttp;
import com.example.dllo.openeyes.tool.OnHttpCallBack;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/12.
 * 发现界面
 * @author wangweijian
 */
public class FindFragment extends AbsBaseFragment {
    private GridView gridView;
    private ArrayList<FindBean> beanArrayList;
    @Override
    protected int setLayout() {
        return R.layout.fragment_find;
    }

    @Override
    protected void initViews(View view) {
     gridView = byView(R.id.find_grid_view);
    }

    @Override
    protected void initDatas() {
        beanArrayList = new ArrayList<>();
        //加载发现界面数据
        addFindData();
    }

    private void addFindData() {
        OkHttp.getInstance().startRequest(NetUrls.FIND_URL, FindBean.class, new OnHttpCallBack<FindBean>() {
            @Override
            public void onSuccess(FindBean response) {
                FindBean findBean = response;
                beanArrayList.add(findBean);
            }

            @Override
            public void onError(Throwable ex) {

            }
        });
    }
}
