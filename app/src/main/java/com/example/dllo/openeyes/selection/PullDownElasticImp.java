package com.example.dllo.openeyes.selection;

/**
 * Created by dllo on 16/8/13.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.dllo.openeyes.R;

public class PullDownElasticImp implements PullDownScrollView.IPullDownElastic {
    private View refreshView;
    private int headContentHeight;
    private ProgressBar progressBar;
    private TextView tipsTextview;
    private TextView lastUpdatedTextView;

    private Context mContext;
    public PullDownElasticImp(Context context) {
        mContext = context;
        init();
    }


    private void init() {
        refreshView = LayoutInflater.from(mContext).inflate(
                R.layout.item_selection_refresh_top, null);

        progressBar = (ProgressBar) refreshView
                .findViewById(R.id.head_progressBar);

        tipsTextview = (TextView) refreshView.findViewById(R.id.refresh_hint);

        lastUpdatedTextView = (TextView) refreshView
                .findViewById(R.id.refresh_time);

        headContentHeight = dip2px(mContext, 50);
    }


    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    @Override
    public View getElasticLayout() {
        return refreshView;
    }

    @Override
    public int getElasticHeight() {
        return headContentHeight;
    }


    @Override
    public void showProgressBar(int visibility) {
        progressBar.setVisibility(visibility);
    }

    @Override
    public void setTips(String tips) {
        tipsTextview.setText(tips);
    }


    @Override
    public void showLastUpdate(int visibility) {
        lastUpdatedTextView.setVisibility(visibility);
    }

    public void setLastUpdateText(String text) {
        lastUpdatedTextView.setText(text);
    }

    @Override
    public void changeElasticState(int state, boolean isBack) {

    }

}

