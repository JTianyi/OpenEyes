package com.example.dllo.openeyes;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.dllo.openeyes.selection.MyListView;
import com.example.dllo.openeyes.selection.SelectionBean;
import com.example.dllo.openeyes.selection.SelectionLsAdapter;
import com.example.dllo.openeyes.selection.SelectionReAdapter;

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
        reArrayList=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SelectionBean.SectionListBean.ItemListBean.DataBean bean=new SelectionBean.SectionListBean.ItemListBean.DataBean();
            bean.setCategory("gg");
            bean.setDuration(50);
            bean.setTitle("但是代收款");
            reArrayList.add(bean);
        }
        SelectionReAdapter adapter=new SelectionReAdapter(context);
        adapter.setArrayList(reArrayList);
        moreReView.setAdapter(adapter);
        moreReView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));

        lsArrayList=new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            SelectionBean.SectionListBean.ItemListBean.DataBean bean=new SelectionBean.SectionListBean.ItemListBean.DataBean();
            bean.setCategory("bb");
            bean.setDuration(120);
            bean.setTitle("发射多喝水");
            lsArrayList.add(bean);
        }
        SelectionLsAdapter lsAdapter=new SelectionLsAdapter(context);
        lsAdapter.setArrayList(lsArrayList);
        listView.setAdapter(lsAdapter);
    }
}
