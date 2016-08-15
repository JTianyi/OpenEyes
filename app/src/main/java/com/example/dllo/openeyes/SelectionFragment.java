package com.example.dllo.openeyes;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.dllo.openeyes.selection.MyListView;
import com.example.dllo.openeyes.selection.SelectionBean;
import com.example.dllo.openeyes.selection.SelectionLsAdapter;
import com.example.dllo.openeyes.selection.SelectionReAdapter;
import com.example.dllo.openeyes.tool.OkHttp;
import com.example.dllo.openeyes.tool.OnHttpCallBack;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/12.
 */
public class SelectionFragment extends AbsBaseFragment{
    private RecyclerView moreReView;
    private ArrayList<SelectionBean.SectionListBean.ItemListBean.DataBean> reArrayList;
    private ArrayList<SelectionBean.SectionListBean.ItemListBean.DataBean> lsArrayList;
    private MyListView listView;
    @Override
    protected int setLayout() {
        return R.layout.fragment_selection;
    }

    @Override
    protected void initViews(View view) {
        moreReView=byView(R.id.selection_re);
        listView=byView(R.id.selection_ls);
    }

    @Override
    protected void initDatas() {
        OkHttp.getInstance().startRequest(NetUrls.SELECTION_URL, SelectionBean.class, new OnHttpCallBack<SelectionBean>() {
            @Override
            public void onSuccess(SelectionBean response) {
               // lsArrayList=response.getSectionList().get(0).getItemList();
            }

            @Override
            public void onError(Throwable ex) {

            }
        });
    }
}
