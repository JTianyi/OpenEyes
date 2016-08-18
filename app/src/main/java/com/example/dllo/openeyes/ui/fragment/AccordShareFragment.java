package com.example.dllo.openeyes.ui.fragment;

import android.view.View;
import android.widget.ListView;

import com.example.dllo.openeyes.R;
import com.example.dllo.openeyes.model.bean.AccordBean;
import com.example.dllo.openeyes.model.bean.AccordShareBean;
import com.example.dllo.openeyes.model.net.NetUrls;
import com.example.dllo.openeyes.tools.OkHttp;
import com.example.dllo.openeyes.tools.OnHttpCallBack;
import com.example.dllo.openeyes.ui.adapter.AccordShareAdapter;

/**
 * Created by mac on 16/8/17.
 * 根据分享书序排序界面
 * @author wangweijian
 */
public class AccordShareFragment extends AbsBaseFragment {
    private AccordBean accordBean;
    private ListView listView;
    private AccordShareAdapter adapter;
    @Override
    protected int setLayout() {
        return R.layout.fragment_share_accord;
    }

    @Override
    protected void initViews(View view) {
        listView = byView(R.id.accord_share_list_view);
    }

    @Override
    protected void initDatas() {
        //加载根据分享顺序的数据
        addShareData();
    }

    private void addShareData() {
                accordBean = new AccordBean();
        OkHttp.getInstance().startRequest(NetUrls.ACCORD_SHARE_URL, AccordBean.class, new OnHttpCallBack<AccordBean>() {
            @Override
            public void onSuccess(AccordBean response) {
                 accordBean = response;
                 adapter = new AccordShareAdapter(context);
                 adapter.setAccordBean(accordBean);
                 listView.setAdapter(adapter);
            }

            @Override
            public void onError(Throwable ex) {

            }
        });
    }
}
