package com.example.dllo.openeyes.ui.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.dllo.openeyes.model.bean.SearchBean;
import com.example.dllo.openeyes.model.net.NetUrls;
import com.example.dllo.openeyes.tools.DensityUtils;
import com.example.dllo.openeyes.tools.OkHttp;
import com.example.dllo.openeyes.tools.OnHttpCallBack;
import com.example.dllo.openeyes.ui.adapter.HomeAdapter;
import com.example.dllo.openeyes.ui.adapter.OnRecyclerViewClickListener;
import com.example.dllo.openeyes.ui.adapter.PopReAdapter;
import com.example.dllo.openeyes.ui.adapter.SearchLsAdapter;
import com.example.dllo.openeyes.ui.fragment.MineFragment;
import com.example.dllo.openeyes.R;
import com.example.dllo.openeyes.ui.fragment.SelectionFragment;
import com.example.dllo.openeyes.ui.fragment.AuthorFragment;
import com.example.dllo.openeyes.ui.fragment.FindFragment;
import com.example.dllo.openeyes.view.TitleTextView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import io.vov.vitamio.BuildConfig;

public class HomeActivity extends AbsBaseActivity implements View.OnClickListener {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private HomeAdapter adapter;
    private ArrayList<Fragment>datas;
    private ImageView searchIv,menuIv;
    private TitleTextView titleTV;
    private PopupWindow popupWindow;
    private TextView cancleTV,searchResultTV;
    private RecyclerView popReView;
    private JSONArray arrayList;
    private LinearLayout beforeSearchLin,searchLin;
    private ArrayList<SearchBean.ItemListBean> listBeen;
    private ListView popLs;
    private SearchBean searchBean;
    private boolean flag=true;
    private boolean isSuccess=false;
    private SearchView searchView;
    private String chEntry;

    @Override
    protected int setLayout() {
        return R.layout.activity_home;

    }
    @Override
    protected void initViews() {
        tabLayout=byView(R.id.main_tablayout);
        viewPager=byView(R.id.main_viewpager);
        searchIv=byView(R.id.title_bar_search);
        menuIv=byView(R.id.title_bar_menu);
        titleTV=byView(R.id.title_tv);

    }

    @Override
    protected void initDatas() {
        creatFragment();
        adapter=new HomeAdapter(getSupportFragmentManager());
        adapter.setDatas(datas);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        setTabIcon();
        changeTitleBarIcon();
        titleTV.setOnClickListener(this);
        searchIv.setOnClickListener(this);
        menuIv.setOnClickListener(this);

    }

    private void changeTitleBarIcon() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                 if (position==3){
                     menuIv.setVisibility(View.VISIBLE);
                     searchIv.setVisibility(View.GONE);
                 }else {
                     searchIv.setVisibility(View.VISIBLE);
                     menuIv.setVisibility(View.GONE);
                 }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setTabIcon() {

        View selectionView=getLayoutInflater().inflate(R.layout.tab_selection,null);
        tabLayout.getTabAt(0).setCustomView(selectionView);
        View findView=getLayoutInflater().inflate(R.layout.tab_find,null);
        tabLayout.getTabAt(1).setCustomView(findView);
        View authorView=getLayoutInflater().inflate(R.layout.tab_author,null);
        tabLayout.getTabAt(2).setCustomView(authorView);
        View mineView=getLayoutInflater().inflate(R.layout.tab_mine,null);
        tabLayout.getTabAt(3).setCustomView(mineView);
        tabLayout.setSelectedTabIndicatorHeight(0);

    }


    private void creatFragment() {
        datas=new ArrayList<>();
        datas.add(new SelectionFragment());
        datas.add(new FindFragment());
        datas.add(new AuthorFragment());
        datas.add(new MineFragment());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_tv:
                Intent intent=new Intent("com.example.dllo.openeyes.ui.BACK_TOP");
                sendBroadcast(intent);
                break;
            case R.id.title_bar_search:
                initPop();
                popupWindow.showAsDropDown(searchIv,0,-DensityUtils.dp2px(this,45));
                break;
            case R.id.pop_cancel_tv:
                beforeSearchLin.setVisibility(View.VISIBLE);
                searchLin.setVisibility(View.GONE);
                flag=true;
                popupWindow.dismiss();
                break;
            case R.id.title_bar_menu:
                goTo(this,SettingActivity.class);
                break;
        }

    }
    public void initPop(){

        View view=getLayoutInflater().inflate(R.layout.item_pop,null);
        popupWindow=new PopupWindow(view,-1,-1,true);

        // 给popwindow设置一个背景,如果不设置,当popwindow出现时,按返回键就没响应
        popupWindow.setBackgroundDrawable(new BitmapDrawable());

        cancleTV = (TextView) view.findViewById(R.id.pop_cancel_tv);
        popReView= (RecyclerView) view.findViewById(R.id.search_pop_re);
        beforeSearchLin= (LinearLayout) view.findViewById(R.id.pop_before_search_lin);
        searchLin= (LinearLayout) view.findViewById(R.id.pop_search_lin);
        searchResultTV= (TextView) view.findViewById(R.id.pop_search_result_tv);
        popLs= (ListView) view.findViewById(R.id.pop_search_ls);
        searchView= (SearchView) view.findViewById(R.id.search_view);
        SpannableString spannableString=new SpannableString("帮你找到感兴趣的视频");
        spannableString.setSpan(new AbsoluteSizeSpan(13,true),0,spannableString.length(),0);
        searchView.setQueryHint(spannableString);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                chEntry=query;
                beforeSearchLin.setVisibility(View.GONE);
                searchLin.setVisibility(View.VISIBLE);
                paraseUrl();
                flag=true;
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        arrayList = new JSONArray();
        OkHttp.getInstance().startRequest(NetUrls.SEARCH_URL, new OnHttpCallBack<String>() {
            @Override
            public void onSuccess(String response) {
                arrayList = JSON.parseArray(response);
                PopReAdapter popReAdapter=new PopReAdapter(HomeActivity.this);
                popReAdapter.setArrayList(arrayList);
                popReView.setAdapter(popReAdapter);
                popReView.setLayoutManager(new GridLayoutManager(HomeActivity.this,4,LinearLayoutManager.VERTICAL,false));
                popReAdapter.setListener(new OnRecyclerViewClickListener() {
                    @Override
                    public void OnRecyclerViewClick(int position) {
                        beforeSearchLin.setVisibility(View.GONE);
                        searchLin.setVisibility(View.VISIBLE);
                        chEntry = (String) arrayList.get(position);
                        paraseUrl();
                    }
                });
            }

            @Override
            public void onError(Throwable ex) {

            }
        });
        cancleTV.setOnClickListener(this);
        popupWindow.setAnimationStyle(R.style.pop);

    }

    private void paraseUrl() {
        String entry= null;
        try {
            entry = URLEncoder.encode(chEntry,"utf-8");
            listBeen = new ArrayList<>();
            OkHttp.getInstance().startRequest(NetUrls.SEARCH_HEAD_URL + entry + NetUrls.SEARCH_END_URL, SearchBean.class, new OnHttpCallBack<SearchBean>() {
                @Override
                public void onSuccess(SearchBean response) {
                    searchBean=response;
                    listBeen = (ArrayList<SearchBean.ItemListBean>) response.getItemList();
                    final SearchLsAdapter searchLsAdapter=new SearchLsAdapter(HomeActivity.this);
                    searchLsAdapter.setArrayList(listBeen);
                    popLs.setAdapter(searchLsAdapter);
                    searchResultTV.setText("- "+ chEntry +"搜索结果共"+listBeen.size()+"个 —");
                    popLs.setOnScrollListener(new AbsListView.OnScrollListener() {
                        @Override
                        public void onScrollStateChanged(AbsListView view, int scrollState) {
                            if ( isSuccess==true ){
                                flag=true;
                            }
                        }

                        @Override
                        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                           if (flag){
                               flag=false;
                               isSuccess=false;
                                if (searchBean.getNextPageUrl()!=null){
                                    OkHttp.getInstance().startRequest((String)searchBean.getNextPageUrl(), SearchBean.class, new OnHttpCallBack<SearchBean>() {
                                        @Override
                                        public void onSuccess(SearchBean response) {
                                            for (int i = 0; i < response.getItemList().size(); i++) {
                                                searchBean=response;
                                                listBeen.add(response.getItemList().get(i));
                                                popLs.setVisibility(View.GONE);
                                                searchLsAdapter.setArrayList(listBeen);
                                                popLs.setVisibility(View.VISIBLE);
                                                searchResultTV.setText("- "+ chEntry +"搜索结果共"+listBeen.size()+"个 —");
                                                isSuccess=true;
                                            }
                                        }

                                        @Override
                                        public void onError(Throwable ex) {

                                        }
                                    });
                                }
                            }

                        }
                    });


                }

                @Override
                public void onError(Throwable ex) {

                }
            });



        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
