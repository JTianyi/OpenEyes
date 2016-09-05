package com.example.dllo.openeyes.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.dllo.openeyes.R;
import com.example.dllo.openeyes.model.bean.AccordBean;
import com.example.dllo.openeyes.model.bean.AuthorDetailBean;
import com.example.dllo.openeyes.model.net.NetUrls;
import com.example.dllo.openeyes.tools.OkHttp;
import com.example.dllo.openeyes.tools.OnHttpCallBack;
import com.example.dllo.openeyes.tools.PicassoInstance;
import com.example.dllo.openeyes.ui.adapter.AccordTimeAdapter;
import com.example.dllo.openeyes.ui.adapter.AuthorDetailDateAdapter;
import com.example.dllo.openeyes.view.CenterTextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by mac on 16/8/17.
 * 作者详情界面按时间排序的界面
 *
 * @author jiangtianyi
 */
public class AuthorDetailDateFragment extends AbsBaseFragment {
    private AuthorDetailBean bean;
    private AuthorDetailDateAdapter adapter;
    private RecyclerView recyclerView;
    private int id;

    public static AuthorDetailDateFragment newInstance(String url) {

        Bundle args = new Bundle();
        args.putString("URL", url);
        AuthorDetailDateFragment fragment = new AuthorDetailDateFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_author_date_detail;
    }

    @Override
    protected void initViews(View view) {
        recyclerView = byView(R.id.author_detail_recyclerView);

    }

    @Override
    protected void initDatas() {

        //加载按时间排序的界面的数据
        addDateData();
    }

    private void addDateData() {

        bean = new AuthorDetailBean();

        Bundle args = getArguments();
        String url = args.getString("URL");

        OkHttp.getInstance().startRequest(url
                , AuthorDetailBean.class, new OnHttpCallBack<AuthorDetailBean>() {

                    @Override
                    public void onSuccess(AuthorDetailBean response) {
                        bean = response;
                        adapter = new AuthorDetailDateAdapter(context);
                        adapter.setDatas((ArrayList<AuthorDetailBean.ItemListBean>) bean.getItemList());
                        recyclerView.setLayoutManager(new LinearLayoutManager(context));
                        recyclerView.setAdapter(adapter);


                    }

                    @Override
                    public void onError(Throwable ex) {

                    }
                });
    }
}
