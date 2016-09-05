package com.example.dllo.openeyes.ui.fragment;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.dllo.openeyes.R;
import com.example.dllo.openeyes.model.bean.AuthorFragmentBean;
import com.example.dllo.openeyes.model.net.NetUrls;
import com.example.dllo.openeyes.ui.activity.AuthorVideoActivity;
import com.example.dllo.openeyes.ui.activity.BeforeSelectionActivity;
import com.example.dllo.openeyes.ui.activity.HomeActivity;
import com.example.dllo.openeyes.ui.adapter.OnRecyclerViewClickListener;
import com.example.dllo.openeyes.ui.fragment.AbsBaseFragment;
import com.example.dllo.openeyes.view.MyListView;
import com.example.dllo.openeyes.tools.PicassoInstance;
import com.example.dllo.openeyes.tools.PullDownElasticImp;
import com.example.dllo.openeyes.tools.PullDownScrollView;
import com.example.dllo.openeyes.model.bean.SelectionBean;
import com.example.dllo.openeyes.ui.adapter.SelectionLsAdapter;
import com.example.dllo.openeyes.ui.adapter.SelectionReAdapter;
import com.example.dllo.openeyes.tools.OkHttp;
import com.example.dllo.openeyes.tools.OnHttpCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/8/12.
 */
public class SelectionFragment extends AbsBaseFragment implements PullDownScrollView.RefreshListener, View.OnClickListener {
    private RecyclerView moreReView,firstReView,secondReView;
    private ArrayList<SelectionBean.SectionListBean.ItemListBean.DataBean.ChildItemListBean.ChildDataBean> reArrayList,firstReArray,secondReArray;
    private ArrayList<SelectionBean.SectionListBean.ItemListBean.DataBean> lsArrayList;
    private MyListView listView;
    private TextView moreSelectionTV,latestTV,moreAuthorTV,firstLatestTitleTV,firstLatestDescriptionTV,firstLatestVideoCountTV,secondLatestTitleTV,secondLatestDescriptionTV,secondLatestVideoCountTV;
    private ImageView moreIV,firstAuthorIcon,secondAuthorIcon,anmiInIV;
    private PullDownScrollView mPullDownScrollView;
    private RelativeLayout beforeSelectRelayout,animRe;
    private ScrollView scrollView;
    private BackTopBroadcast backTopBroadcast;
    private int textItem=0,textItemPos=0;



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
        beforeSelectRelayout=byView(R.id.look_before_selection_relayout);
        scrollView=byView(R.id.selection_scrollview);
        animRe=byView(R.id.search_anmi_re);
        anmiInIV=byView(R.id.ic_eye_black_inner);

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
        Animation loadingAnim= AnimationUtils.loadAnimation(context,R.anim.loading_anim);
        loadingAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                animRe.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        anmiInIV.startAnimation(loadingAnim);

        initdata();
        mPullDownScrollView.setRefreshListener(this);
        mPullDownScrollView.setPullDownElastic(new PullDownElasticImp(context));
        beforeSelectRelayout.setOnClickListener(this);
        backTopBroadcast=new BackTopBroadcast();
        IntentFilter intentFilter=new IntentFilter("com.example.dllo.openeyes.ui.BACK_TOP");
        context.registerReceiver(backTopBroadcast,intentFilter);
    }

    private void initdata() {
        lsArrayList=new ArrayList<>();
        OkHttp.getInstance().startRequest(NetUrls.SELECTION_URL, SelectionBean.class, new OnHttpCallBack<SelectionBean>() {
            @Override
            public void onSuccess(SelectionBean response) {
                final List<SelectionBean.SectionListBean.ItemListBean> listBean=response.getSectionList().get(0).getItemList();
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
                animRe.setVisibility(View.GONE);
                listView.setAdapter(lsAdapter);

                final AuthorFragmentBean.ItemListBean.DataBean bean = getDataBean();

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent=new Intent(context,AuthorVideoActivity.class);
                        if(position==0){
                            if (textItem==0){
                                intent.putExtra("pos",position);
                                intent.putExtra("videos",bean);
                                context.startActivity(intent);
                            }
                        }else {
                            if (position<textItemPos){
                                int pos=position-1;
                                intent.putExtra("pos",pos);
                                intent.putExtra("videos",bean);
                                context.startActivity(intent);
                            }else if (position>textItemPos){
                                int pos=position-textItem;
                                intent.putExtra("pos",pos);
                                intent.putExtra("videos",bean);
                                context.startActivity(intent);
                            }
                        }
                    }
                });



                reArrayList=new ArrayList<>();
                List<SelectionBean.SectionListBean.ItemListBean.DataBean.ChildItemListBean> reListBean=response.getSectionList().get(1).getItemList().get(0).getData().getItemList();
                for (int i = 0; i < reListBean.size(); i++) {
                    SelectionBean.SectionListBean.ItemListBean.DataBean.ChildItemListBean.ChildDataBean childDataBean=reListBean.get(i).getData();
                    reArrayList.add(childDataBean);
                }
                SelectionReAdapter reAdapter=new SelectionReAdapter(context);
                reAdapter.setArrayList(reArrayList);
                moreReView.setAdapter(reAdapter);
                moreReView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));

                final AuthorFragmentBean.ItemListBean.DataBean reBean = getBean(reArrayList);
                reAdapter.setListener(new OnRecyclerViewClickListener() {
                    @Override
                    public void OnRecyclerViewClick(int position) {
                        Intent intent=new Intent(context,AuthorVideoActivity.class);
                        intent.putExtra("pos",position);
                        intent.putExtra("videos",reBean);
                        context.startActivity(intent);
                    }
                });


                List<SelectionBean.SectionListBean.ItemListBean.DataBean.ChildItemListBean> firstReList=response.getSectionList().get(2).getItemList().get(0).getData().getItemList();
                firstReArray=new ArrayList<>();
                for (int i = 0; i < firstReList.size(); i++) {
                    SelectionBean.SectionListBean.ItemListBean.DataBean.ChildItemListBean.ChildDataBean firstBean=firstReList.get(i).getData();
                    firstReArray.add(firstBean);
                }
                SelectionReAdapter firstReAdapter=new SelectionReAdapter(context);
                firstReAdapter.setArrayList(firstReArray);
                final AuthorFragmentBean.ItemListBean.DataBean firBean = getBean(firstReArray);
                firstReAdapter.setListener(new OnRecyclerViewClickListener() {
                    @Override
                    public void OnRecyclerViewClick(int position) {
                        Intent intent=new Intent(context,AuthorVideoActivity.class);
                        intent.putExtra("pos",position);
                        intent.putExtra("videos",firBean);
                        context.startActivity(intent);
                    }
                });
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
                final AuthorFragmentBean.ItemListBean.DataBean secBean = getBean(secondReArray);
                secondReAdapter.setListener(new OnRecyclerViewClickListener() {
                    @Override
                    public void OnRecyclerViewClick(int position) {
                        Intent intent=new Intent(context,AuthorVideoActivity.class);
                        intent.putExtra("pos",position);
                        intent.putExtra("videos",secBean);
                        context.startActivity(intent);
                    }
                });
                secondReView.setAdapter(secondReAdapter);
                secondReView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));


            }

            @Override
            public void onError(Throwable ex) {

            }
        });
    }

    private AuthorFragmentBean.ItemListBean.DataBean getBean(ArrayList<SelectionBean.SectionListBean.ItemListBean.DataBean.ChildItemListBean.ChildDataBean> array) {
        final AuthorFragmentBean.ItemListBean.DataBean reBean=new AuthorFragmentBean.ItemListBean.DataBean();
        ArrayList<AuthorFragmentBean.ItemListBean.DataBean.NItemListBean> list=new ArrayList<AuthorFragmentBean.ItemListBean.DataBean.NItemListBean>();
        for (int i = 0; i < array.size(); i++) {
            AuthorFragmentBean.ItemListBean.DataBean.NItemListBean nItemListBean=new AuthorFragmentBean.ItemListBean.DataBean.NItemListBean();
            AuthorFragmentBean.ItemListBean.DataBean.NItemListBean.NDataBean nDataBean=new AuthorFragmentBean.ItemListBean.DataBean.NItemListBean.NDataBean();
            AuthorFragmentBean.ItemListBean.DataBean.NItemListBean.NDataBean.CoverBean coverBean=new AuthorFragmentBean.ItemListBean.DataBean.NItemListBean.NDataBean.CoverBean();
            AuthorFragmentBean.ItemListBean.DataBean.NItemListBean.NDataBean.ConsumptionBean consumptionBean=new AuthorFragmentBean.ItemListBean.DataBean.NItemListBean.NDataBean.ConsumptionBean();
            AuthorFragmentBean.ItemListBean.DataBean.NItemListBean.NDataBean.AuthorBean authorBean=new AuthorFragmentBean.ItemListBean.DataBean.NItemListBean.NDataBean.AuthorBean();
            SelectionBean.SectionListBean.ItemListBean.DataBean.ChildItemListBean.ChildDataBean.ChildAuthorBean mAuthorbean=array.get(i).getAuthor();
            List<SelectionBean.SectionListBean.ItemListBean.DataBean.ChildItemListBean.ChildDataBean.ChildPlayInfoBean> beanList=array.get(i).getPlayInfo();
            List<AuthorFragmentBean.ItemListBean.DataBean.NItemListBean.NDataBean.PlayInfoBean> playInfoList=new ArrayList<>();
            for (int j = 0; j < beanList.size(); j++) {
                AuthorFragmentBean.ItemListBean.DataBean.NItemListBean.NDataBean.PlayInfoBean playInfoBean=new AuthorFragmentBean.ItemListBean.DataBean.NItemListBean.NDataBean.PlayInfoBean();
                playInfoBean.setUrl(beanList.get(j).getUrl());
                playInfoBean.setType(beanList.get(j).getUrl());
                playInfoList.add(playInfoBean);
            }
            if (mAuthorbean!=null){
                authorBean.setDescription(mAuthorbean.getDescription());
                authorBean.setIcon(mAuthorbean.getIcon());
                authorBean.setName(mAuthorbean.getName());
                authorBean.setVideoNum(mAuthorbean.getVideoNum());
            }
            nDataBean.setPlayInfo(playInfoList);
            nDataBean.setDescription(array.get(i).getDescription());
            nDataBean.setTitle(array.get(i).getTitle());
            nDataBean.setCategory(array.get(i).getCategory());
            nDataBean.setDuration(array.get(i).getDuration());
            coverBean.setFeed(array.get(i).getCover().getFeed());
            coverBean.setBlurred(array.get(i).getCover().getBlurred());
            nDataBean.setPlayUrl(array.get(i).getPlayUrl());
            nDataBean.setAuthor(authorBean);
            consumptionBean.setCollectionCount(array.get(i).getConsumption().getCollectionCount());
            consumptionBean.setReplyCount(array.get(i).getConsumption().getReplyCount());
            consumptionBean.setShareCount(array.get(i).getConsumption().getShareCount());
            nDataBean.setCover(coverBean);
            nDataBean.setConsumption(consumptionBean);
            nItemListBean.setData(nDataBean);
            list.add(nItemListBean);
        }
        reBean.setItemList(list);
        return reBean;
    }

    @NonNull
    private AuthorFragmentBean.ItemListBean.DataBean getDataBean() {
        final AuthorFragmentBean.ItemListBean.DataBean bean=new AuthorFragmentBean.ItemListBean.DataBean();
        ArrayList<AuthorFragmentBean.ItemListBean.DataBean.NItemListBean> list=new ArrayList<AuthorFragmentBean.ItemListBean.DataBean.NItemListBean>();
        for (int i = 0; i < lsArrayList.size(); i++) {
            AuthorFragmentBean.ItemListBean.DataBean.NItemListBean nItemListBean=new AuthorFragmentBean.ItemListBean.DataBean.NItemListBean();
            AuthorFragmentBean.ItemListBean.DataBean.NItemListBean.NDataBean nDataBean=new AuthorFragmentBean.ItemListBean.DataBean.NItemListBean.NDataBean();
            AuthorFragmentBean.ItemListBean.DataBean.NItemListBean.NDataBean.CoverBean coverBean=new AuthorFragmentBean.ItemListBean.DataBean.NItemListBean.NDataBean.CoverBean();
            AuthorFragmentBean.ItemListBean.DataBean.NItemListBean.NDataBean.ConsumptionBean consumptionBean=new AuthorFragmentBean.ItemListBean.DataBean.NItemListBean.NDataBean.ConsumptionBean();
            AuthorFragmentBean.ItemListBean.DataBean.NItemListBean.NDataBean.AuthorBean authorBean=new AuthorFragmentBean.ItemListBean.DataBean.NItemListBean.NDataBean.AuthorBean();
            SelectionBean.SectionListBean.ItemListBean.DataBean.AuthorBean mAuthorbean=lsArrayList.get(i).getAuthor();
            List<SelectionBean.SectionListBean.ItemListBean.DataBean.PlayInfoBean> beanList=lsArrayList.get(i).getPlayInfo();
            List<AuthorFragmentBean.ItemListBean.DataBean.NItemListBean.NDataBean.PlayInfoBean> playInfoList=new ArrayList<>();
            if (beanList !=null){
                for (int j = 0; j < beanList.size(); j++) {
                    AuthorFragmentBean.ItemListBean.DataBean.NItemListBean.NDataBean.PlayInfoBean playInfoBean=new AuthorFragmentBean.ItemListBean.DataBean.NItemListBean.NDataBean.PlayInfoBean();
                    playInfoBean.setUrl(beanList.get(j).getUrl());
                    playInfoBean.setType(beanList.get(j).getUrl());
                    playInfoList.add(playInfoBean);
                }
                nDataBean.setPlayInfo(playInfoList);
            }
            if (mAuthorbean!=null){
                authorBean.setDescription(mAuthorbean.getDescription());
                authorBean.setIcon(mAuthorbean.getIcon());
                authorBean.setName(mAuthorbean.getName());
                authorBean.setVideoNum(mAuthorbean.getVideoNum());
            }
            nDataBean.setDescription(lsArrayList.get(i).getDescription());
            nDataBean.setTitle(lsArrayList.get(i).getTitle());
            nDataBean.setCategory(lsArrayList.get(i).getCategory());
            nDataBean.setDuration(lsArrayList.get(i).getDuration());
            SelectionBean.SectionListBean.ItemListBean.DataBean.CoverBean inCoverBean=lsArrayList.get(i).getCover();
            if (inCoverBean!=null){
                coverBean.setFeed(inCoverBean.getFeed());
                coverBean.setBlurred(inCoverBean.getBlurred());
                nDataBean.setCover(coverBean);
            }
            nDataBean.setPlayUrl(lsArrayList.get(i).getPlayUrl());
            nDataBean.setAuthor(authorBean);
            SelectionBean.SectionListBean.ItemListBean.DataBean.ConsumptionBean inConsumption=lsArrayList.get(i).getConsumption();
            if (inConsumption !=null){
                consumptionBean.setCollectionCount(inConsumption.getCollectionCount());
                consumptionBean.setReplyCount(inConsumption.getReplyCount());
                consumptionBean.setShareCount(inConsumption.getShareCount());
                nDataBean.setConsumption(consumptionBean);
                nItemListBean.setData(nDataBean);
                list.add(nItemListBean);
            }else {
                textItem++;
                textItemPos=i;
            }
        }
        bean.setItemList(list);
        return bean;
    }


    @Override
    public void onRefresh(PullDownScrollView view) {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                initdata();
                mPullDownScrollView.finishRefresh("");
            }
        }, 2000);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.look_before_selection_relayout:
                goTo(context, BeforeSelectionActivity.class);
                break;
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        context.unregisterReceiver(backTopBroadcast);
    }
    class BackTopBroadcast extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            scrollView.scrollTo(0,0);

        }
    }

}
