package com.example.dllo.openeyes.ui.activity;

import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dllo.openeyes.R;
import com.example.dllo.openeyes.model.bean.BeforeSelectionBean;
import com.example.dllo.openeyes.model.net.NetUrls;
import com.example.dllo.openeyes.tools.OkHttp;
import com.example.dllo.openeyes.tools.OnHttpCallBack;
import com.example.dllo.openeyes.ui.adapter.BeforeSelectionLsAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/17.
 * 查看往期精选界面
 */
public class BeforeSelectionActivity extends AbsBaseActivity implements View.OnClickListener {
    private ArrayList<BeforeSelectionBean.IssueListBean.ItemListBean> arrayList;
    private ListView listView;
    private BeforeSelectionBean beforeSelectionBean;
    private BeforeSelectionLsAdapter adapter;
    private String date;
    private TextView dateTV;
    private boolean flag = true;
    private boolean isSuccess = false;
    private ImageView backIV;

    @Override
    protected int setLayout() {
        return R.layout.activity_before_selection;
    }

    @Override
    protected void initViews() {
        listView=byView(R.id.before_selection_ls);
        dateTV=byView(R.id.before_selection_date_tv);
        backIV=byView(R.id.back_selection_frag_iv);

    }

    @Override
    protected void initDatas() {
        backIV.setOnClickListener(this);
        arrayList=new ArrayList<>();
        OkHttp.getInstance().startRequest(NetUrls.LOOK_BEFORE_SELECTON_URL, BeforeSelectionBean.class, new OnHttpCallBack<BeforeSelectionBean>() {
            @Override
            public void onSuccess(BeforeSelectionBean response) {
                beforeSelectionBean=response;
                for (int i = 0; i < response.getIssueList().size(); i++) {
                    for (int j = 0; j < response.getIssueList().get(i).getItemList().size(); j++) {
                        arrayList.add(response.getIssueList().get(i).getItemList().get(j));
                    }
                }
                adapter = new BeforeSelectionLsAdapter(BeforeSelectionActivity.this);
                adapter.setArrayList(arrayList);
                listView.setAdapter(adapter);
                listView.setOnScrollListener(new AbsListView.OnScrollListener() {
                    @Override
                    public void onScrollStateChanged(AbsListView view, int scrollState) {
                        if (scrollState == 0 && view.getLastVisiblePosition() == arrayList.size()-1 && isSuccess ){
                            flag = true;
                        }

                    }

                    @Override
                    public void onScroll(AbsListView view, final int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                        date=arrayList.get(firstVisibleItem).getData().getText();
                        if (date != null){
                            dateTV.setText(date);
                        }
                        if (view.getLastVisiblePosition()==arrayList.size()-1 && flag){
                            flag = false;
                            isSuccess = false;
                            OkHttp.getInstance().startRequest(beforeSelectionBean.getNextPageUrl(), BeforeSelectionBean.class, new OnHttpCallBack<BeforeSelectionBean>() {
                                @Override
                                public void onSuccess(BeforeSelectionBean response) {
                                    beforeSelectionBean=response;
                                    for (int i = 0; i < response.getIssueList().size(); i++) {
                                        for (int j = 0; j < response.getIssueList().get(i).getItemList().size(); j++) {
                                            arrayList.add(response.getIssueList().get(i).getItemList().get(j));
                                        }
                                    }
                                    adapter.setArrayList(arrayList);
                                    isSuccess = true;

                                }

                                @Override
                                public void onError(Throwable ex) {

                                }
                            });

                        }

                    }
                });
            }

            @Override
            public void onError(Throwable ex) {

            }
        });


    }


    @Override
    public void onClick(View v) {
        finish();
    }
}
