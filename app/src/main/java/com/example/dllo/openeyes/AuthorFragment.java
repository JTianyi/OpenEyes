package com.example.dllo.openeyes;

import android.view.View;
import android.widget.ListView;

/**
 * Created by dllo on 16/8/12.
 */
public class AuthorFragment extends AbsBaseFragment {
    private AuthorBean bean;
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
        


    }
}
