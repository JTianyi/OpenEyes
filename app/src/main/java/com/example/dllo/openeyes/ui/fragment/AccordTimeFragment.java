package com.example.dllo.openeyes.ui.fragment;

import android.view.View;
import android.widget.ListView;

import com.example.dllo.openeyes.R;
import com.example.dllo.openeyes.model.bean.AccordBean;
import com.example.dllo.openeyes.model.net.NetUrls;
import com.example.dllo.openeyes.tools.OkHttp;
import com.example.dllo.openeyes.tools.OnHttpCallBack;
import com.example.dllo.openeyes.ui.adapter.AccordTimeAdapter;

/**
 * Created by mac on 16/8/17.
 * 按时间排序的界面
 * @author wangweijian
 */
public class AccordTimeFragment extends AbsBaseFragment{
    private AccordBean accordTimeBean;
    private AccordTimeAdapter timeAdapter;
    private ListView listView;
    @Override
    protected int setLayout() {
        return R.layout.fragment_time_accord;
    }

    @Override
    protected void initViews(View view) {
        listView = byView(R.id.accord_time_list_view);
    }

    @Override
    protected void initDatas() {
        //加载按时间排序的界面的数据
        addTimeData();
    }

    private void addTimeData() {
        accordTimeBean = new AccordBean();
        timeAdapter = new AccordTimeAdapter(context);
        OkHttp.getInstance().startRequest(NetUrls.ACCORD_TIME_URL, AccordBean.class, new OnHttpCallBack<AccordBean>() {
            @Override
            public void onSuccess(AccordBean response) {
                accordTimeBean = response;
                timeAdapter.setAccordTimeBean(accordTimeBean);
                listView.setAdapter(timeAdapter);
            }

            @Override
            public void onError(Throwable ex) {

            }
        });
    }
}
