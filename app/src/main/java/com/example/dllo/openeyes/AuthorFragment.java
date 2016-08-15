package com.example.dllo.openeyes;

import android.view.View;
import android.widget.ListView;

import com.example.dllo.openeyes.tool.OkHttp;
import com.example.dllo.openeyes.tool.OnHttpCallBack;

/**
 * Created by dllo on 16/8/12.
 * @author jiangtianyi
 */
public class AuthorFragment extends AbsBaseFragment {
    private AuthorFragmentBean bean;
    private AuthorAdapter adapter;
    private ListView listView;

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

    }
}
