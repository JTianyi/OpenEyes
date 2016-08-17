package com.example.dllo.openeyes;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.openeyes.selection.MyListView;
import com.example.dllo.openeyes.selection.PicassoInstance;
import com.example.dllo.openeyes.selection.PullDownElasticImp;
import com.example.dllo.openeyes.selection.PullDownScrollView;
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
public class SelectionFragment extends AbsBaseFragment implements PullDownScrollView.RefreshListener {
    private RecyclerView moreReView,firstReView,secondReView;
    private ArrayList<SelectionBean.SectionListBean.ItemListBean.DataBean.ChildItemListBean.ChildDataBean> reArrayList,firstReArray,secondReArray;
    private ArrayList<SelectionBean.SectionListBean.ItemListBean.DataBean> lsArrayList;
    private MyListView listView;
    private TextView moreSelectionTV,latestTV,moreAuthorTV,firstLatestTitleTV,firstLatestDescriptionTV,firstLatestVideoCountTV,secondLatestTitleTV,secondLatestDescriptionTV,secondLatestVideoCountTV;
    private ImageView moreIV,firstAuthorIcon,secondAuthorIcon;
    private PullDownScrollView mPullDownScrollView;

    @Override
    protected int setLayout() {
        return R.layout.fragment_selection;
    }

    @Override
    protected void initViews(View view) {
        moreReView=byView(R.id.selection_re);
        listView=byView(R.id.selection_ls);
        mPullDownScrollView=byView(R.id.refresh_scrollview);
        moreSelectionTV=byView(R.id.look_for_more_selection_tv);
        moreIV=byView(R.id.selection_more_iv);
        latestTV=byView(R.id.latest_tv);
        moreAuthorTV=byView(R.id.look_for_more_author_tv);

        firstAuthorIcon=byView(R.id.first_latest_logo_iv);
        firstLatestDescriptionTV=byView(R.id.first_latest_description_tv);
        firstLatestTitleTV=byView(R.id.first_latest_title_tv);
        firstLatestVideoCountTV=byView(R.id.first_latest_video_count_tv);
        firstReView=byView(R.id.first_latest_re);

        secondAuthorIcon=byView(R.id.second_latest_logo_iv);
        secondLatestDescriptionTV=byView(R.id.second_latest_description_tv);
        secondLatestTitleTV=byView(R.id.second_latest_title_tv);
        secondLatestVideoCountTV=byView(R.id.second_latest_video_count_tv);
        secondReView=byView(R.id.second_latest_re);

    }

    @Override
    protected void initDatas() {

        lsArrayList=new ArrayList<>();
        OkHttp.getInstance().startRequest(NetUrls.SELECTION_URL, SelectionBean.class, new OnHttpCallBack<SelectionBean>() {
            @Override
            public void onSuccess(SelectionBean response) {
                List<SelectionBean.SectionListBean.ItemListBean> listBean=response.getSectionList().get(0).getItemList();
                moreSelectionTV.setText(response.getSectionList().get(0).getFooter().getData().getText());
                moreAuthorTV.setText(response.getSectionList().get(2).getFooter().getData().getText());
                latestTV.setText(response.getSectionList().get(2).getHeader().getData().getText());
                PicassoInstance.getsInstance().setImage(response.getSectionList().get(1).getItemList().get(0).getData().getHeader().getCover(),moreIV);
                response.getSectionList().get(2).getItemList().get(0).getData().getHeader();
                SelectionBean.SectionListBean.ItemListBean.DataBean.HeaderBean firstHeadBean=response.getSectionList().get(2).getItemList().get(0).getData().getHeader();
                firstLatestTitleTV.setText(firstHeadBean.getTitle());
                firstLatestVideoCountTV.setText(firstHeadBean.getSubTitle());
                firstLatestDescriptionTV.setText(firstHeadBean.getDescription());
                PicassoInstance.getsInstance().setImage(firstHeadBean.getIcon(),firstAuthorIcon);
                SelectionBean.SectionListBean.ItemListBean.DataBean.HeaderBean secondHeadBean=response.getSectionList().get(2).getItemList().get(1).getData().getHeader();
                secondLatestTitleTV.setText(secondHeadBean.getTitle());
                secondLatestVideoCountTV.setText(secondHeadBean.getSubTitle());
                secondLatestDescriptionTV.setText(secondHeadBean.getDescription());
                PicassoInstance.getsInstance().setImage(secondHeadBean.getIcon(),secondAuthorIcon);
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

                List<SelectionBean.SectionListBean.ItemListBean.DataBean.ChildItemListBean> firstReList=response.getSectionList().get(2).getItemList().get(0).getData().getItemList();
                firstReArray=new ArrayList<>();
                for (int i = 0; i < firstReList.size(); i++) {
                    SelectionBean.SectionListBean.ItemListBean.DataBean.ChildItemListBean.ChildDataBean firstBean=firstReList.get(i).getData();
                    firstReArray.add(firstBean);
                }
                SelectionReAdapter firstReAdapter=new SelectionReAdapter(context);
                firstReAdapter.setArrayList(firstReArray);
                firstReView.setAdapter(firstReAdapter);
                firstReView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));

                List<SelectionBean.SectionListBean.ItemListBean.DataBean.ChildItemListBean> secondReList=response.getSectionList().get(2).getItemList().get(1).getData().getItemList();
                secondReArray=new ArrayList<>();
                for (int i = 0; i < secondReList.size(); i++) {
                    SelectionBean.SectionListBean.ItemListBean.DataBean.ChildItemListBean.ChildDataBean secondBean=secondReList.get(i).getData();
                    secondReArray.add(secondBean);
                }
                SelectionReAdapter secondReAdapter=new SelectionReAdapter(context);
                secondReAdapter.setArrayList(secondReArray);
                secondReView.setAdapter(secondReAdapter);
                secondReView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));

            }

            @Override
            public void onError(Throwable ex) {

            }
        });
        mPullDownScrollView.setRefreshListener(this);
        mPullDownScrollView.setPullDownElastic(new PullDownElasticImp(context));

    }

    @Override
    public void onRefresh(PullDownScrollView view) {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                mPullDownScrollView.finishRefresh("");
            }
        }, 2000);
    }
}
