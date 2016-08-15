package com.example.dllo.openeyes;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.openeyes.selection.MyListView;
import com.example.dllo.openeyes.selection.PicassoInstance;
import com.example.dllo.openeyes.selection.SelectionBean;
import com.example.dllo.openeyes.selection.SelectionLsAdapter;
import com.example.dllo.openeyes.selection.SelectionReAdapter;
import com.example.dllo.openeyes.tool.OkHttp;
import com.example.dllo.openeyes.tool.OnHttpCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/8/12.
 */
public class SelectionFragment extends AbsBaseFragment{
    private RecyclerView moreReView;
    private ArrayList<SelectionBean.SectionListBean.ItemListBean.DataBean.ChildItemListBean.ChildDataBean> reArrayList;
    private ArrayList<SelectionBean.SectionListBean.ItemListBean.DataBean> lsArrayList;
    private MyListView listView;
    private TextView moreSelectionTV;
    private ImageView moreIV;

    @Override
    protected int setLayout() {
        return R.layout.fragment_selection;
    }

    @Override
    protected void initViews(View view) {
        moreReView=byView(R.id.selection_re);
        listView=byView(R.id.selection_ls);
        moreSelectionTV=byView(R.id.look_for_more_selection_tv);
        moreIV=byView(R.id.selection_more_iv);
    }

    @Override
    protected void initDatas() {
        lsArrayList=new ArrayList<>();
        OkHttp.getInstance().startRequest(NetUrls.SELECTION_URL, SelectionBean.class, new OnHttpCallBack<SelectionBean>() {
            @Override
            public void onSuccess(SelectionBean response) {
                List<SelectionBean.SectionListBean.ItemListBean> listBean=response.getSectionList().get(0).getItemList();
                moreSelectionTV.setText(response.getSectionList().get(0).getFooter().getData().getText());
                PicassoInstance.getsInstance().setImage(response.getSectionList().get(1).getItemList().get(0).getData().getHeader().getCover(),moreIV);
                for (int i = 0; i < listBean.size(); i++) {
                    SelectionBean.SectionListBean.ItemListBean.DataBean bean=listBean.get(i).getData();
                    lsArrayList.add(bean);
                }
                SelectionLsAdapter lsAdapter=new SelectionLsAdapter(context);
                lsAdapter.setArrayList(lsArrayList);
                listView.setAdapter(lsAdapter);

                reArrayList=new ArrayList<>();
                List<SelectionBean.SectionListBean.ItemListBean.DataBean.ChildItemListBean> reListBean=response.getSectionList().get(1).getItemList().get(0).getData().getItemList();
                for (int i = 0; i < reListBean.size(); i++) {
                    SelectionBean.SectionListBean.ItemListBean.DataBean.ChildItemListBean.ChildDataBean bean=reListBean.get(i).getData();
                    reArrayList.add(bean);
                }
                SelectionReAdapter reAdapter=new SelectionReAdapter(context);
                reAdapter.setArrayList(reArrayList);
                moreReView.setAdapter(reAdapter);
                moreReView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
            }

            @Override
            public void onError(Throwable ex) {

            }
        });


    }
}
