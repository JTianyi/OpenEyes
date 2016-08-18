package com.example.dllo.openeyes.ui.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.dllo.openeyes.model.bean.AuthorFragmentBean;
import com.example.dllo.openeyes.model.net.NetUrls;
import com.example.dllo.openeyes.R;
import com.example.dllo.openeyes.tools.OkHttp;
import com.example.dllo.openeyes.tools.OnHttpCallBack;
import com.example.dllo.openeyes.ui.adapter.AuthorAdapter;

/**
 * Created by dllo on 16/8/12.
 * @author jiangtianyi
 */
public class AuthorFragment extends AbsBaseFragment {
    private AuthorFragmentBean bean;
    private AuthorAdapter adapter;
    private ListView listView;
    private BackTopBroadcast backTopBroadcast;

    @Override
    protected int setLayout() {
        return R.layout.fragment_author;
    }

    @Override
    protected void initViews(View view) {
        listView=byView(R.id.author_listview);
    }

    @Override
    protected void initDatas() {
        bean=new AuthorFragmentBean();
        OkHttp.getInstance().startRequest(NetUrls.AUTHOR_URL, AuthorFragmentBean.class, new OnHttpCallBack<AuthorFragmentBean>() {
            @Override
            public void onSuccess(AuthorFragmentBean response) {
                bean=response;
                adapter=new AuthorAdapter(context);
                adapter.setBean(bean);
                listView.setAdapter(adapter);
            }

            @Override
            public void onError(Throwable ex) {

            }
        });
        backTopBroadcast=new BackTopBroadcast();
        IntentFilter intentFilter=new IntentFilter("com.example.dllo.openeyes.ui.BACK_TOP");
        context.registerReceiver(backTopBroadcast,intentFilter);

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        context.unregisterReceiver(backTopBroadcast);
    }
    class BackTopBroadcast extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            listView.smoothScrollToPosition(0);

        }
    }
}
