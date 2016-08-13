package com.example.dllo.openeyes.selection;

/**
 * Created by dllo on 16/8/13.
 */
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

/**
 * Created by dllo on 16/8/12.
 */
public class PullDownScrollView extends LinearLayout {
    private int refreshTargetTop = -60;
    private int headContentHeight;

    private RefreshListener refreshListener;

    private RotateAnimation animation;
    private RotateAnimation reverseAnimation;

    private final static int RATIO = 2;
    private int preY = 0;
    private boolean isElastic = false;
    private int startY;
    private int state;

    private String note_release_to_refresh = "松开更新";
    private String note_pull_to_refresh = "下拉刷新";
    private String note_refreshing = "正在更新...";

    private IPullDownElastic mElastic;
    public PullDownScrollView(Context context) {
        super(context);
        init();
    }

    public PullDownScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void init() {
        animation = new RotateAnimation(0, -180,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        animation.setInterpolator(new LinearInterpolator());
        animation.setDuration(250);
        animation.setFillAfter(true);

        reverseAnimation = new RotateAnimation(-180, 0,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        reverseAnimation.setInterpolator(new LinearInterpolator());
        reverseAnimation.setDuration(200);
        reverseAnimation.setFillAfter(true);
    }
    public void setRefreshListener(RefreshListener listener) {
        this.refreshListener = listener;
    }
    public void setPullDownElastic(IPullDownElastic elastic) {
        mElastic = elastic;

        headContentHeight = mElastic.getElasticHeight();
        refreshTargetTop = - headContentHeight;
        LayoutParams lp = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, headContentHeight);
        lp.topMargin = refreshTargetTop;
        addView(mElastic.getElasticLayout(), 0, lp);
    }
    public void setRefreshTips(String pullToRefresh, String releaseToRefresh, String refreshing) {
        note_pull_to_refresh = pullToRefresh;
        note_release_to_refresh = releaseToRefresh;
        note_refreshing = refreshing;
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        printMotionEvent(ev);
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            preY = (int) ev.getY();
        }
        if (ev.getAction() == MotionEvent.ACTION_MOVE) {


            if (!isElastic && canScroll()
                    && (int) ev.getY() - preY >= headContentHeight / (3*RATIO)
                    && refreshListener != null && mElastic != null) {

                isElastic = true;
                startY = (int) ev.getY();

                return true;
            }

        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        printMotionEvent(event);
        handleHeadElastic(event);
        return super.onTouchEvent(event);
    }

    private void handleHeadElastic(MotionEvent event) {
        if (refreshListener != null && mElastic != null) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:

                    break;
                case MotionEvent.ACTION_UP:


                    if (state != IPullDownElastic.REFRESHING && isElastic) {

                        if (state == IPullDownElastic.DONE) {
                            // 什么都不做
                            setMargin(refreshTargetTop);
                        }
                        if (state == IPullDownElastic.PULL_To_REFRESH) {
                            state = IPullDownElastic.DONE;
                            setMargin(refreshTargetTop);
                            changeHeaderViewByState(state, false);

                        }
                        if (state == IPullDownElastic.RELEASE_To_REFRESH) {
                            state = IPullDownElastic.REFRESHING;
                            setMargin(0);
                            changeHeaderViewByState(state, false);
                            onRefresh();

                        }

                    }
                    isElastic = false;
                    break;
                case MotionEvent.ACTION_MOVE:

                    int tempY = (int) event.getY();

                    if (state != IPullDownElastic.REFRESHING && isElastic) {
                        // 可以松手去刷新了
                        if (state == IPullDownElastic.RELEASE_To_REFRESH) {
                            if (((tempY - startY) / RATIO < headContentHeight)
                                    && (tempY - startY) > 0) {
                                state = IPullDownElastic.PULL_To_REFRESH;
                                changeHeaderViewByState(state, true);

                            } else if (tempY - startY <= 0) {
                                state = IPullDownElastic.DONE;
                                changeHeaderViewByState(state, false);

                            }
                        }
                        if (state == IPullDownElastic.DONE) {
                            if (tempY - startY > 0) {
                                state = IPullDownElastic.PULL_To_REFRESH;
                                changeHeaderViewByState(state, false);
                            }
                        }
                        if (state == IPullDownElastic.PULL_To_REFRESH) {
                            // 下拉到可以进入RELEASE_TO_REFRESH的状态
                            if ((tempY - startY) / RATIO >= headContentHeight) {
                                state = IPullDownElastic.RELEASE_To_REFRESH;
                                changeHeaderViewByState(state, false);

                            } else if (tempY - startY <= 0) {
                                state = IPullDownElastic.DONE;
                                changeHeaderViewByState(state, false);

                            }
                        }
                        if (tempY - startY > 0) {
                            setMargin((tempY - startY)/2 + refreshTargetTop);
                        }
                    }
                    break;
            }
        }
    }

    /**
     *
     */
    private void setMargin(int top) {
        LinearLayout.LayoutParams lp = (LayoutParams) mElastic.getElasticLayout()
                .getLayoutParams();
        lp.topMargin = top;
        // 修改后刷新
        mElastic.getElasticLayout().setLayoutParams(lp);
        mElastic.getElasticLayout().invalidate();
    }

    private void changeHeaderViewByState(int state, boolean isBack) {

        mElastic.changeElasticState(state, isBack);
        switch (state) {
            case IPullDownElastic.RELEASE_To_REFRESH:
                mElastic.showProgressBar(View.GONE);
                mElastic.showLastUpdate(View.VISIBLE);
                mElastic.setTips(note_release_to_refresh);

                break;
            case IPullDownElastic.PULL_To_REFRESH:
                mElastic.showProgressBar(View.GONE);
                mElastic.showLastUpdate(View.VISIBLE);
                mElastic.setTips(note_pull_to_refresh);

                // 是由RELEASE_To_REFRESH状态转变来的
                if (isBack) {

                }

                break;
            case IPullDownElastic.REFRESHING:
                mElastic.showProgressBar(View.VISIBLE);
                mElastic.showLastUpdate(View.GONE);
                mElastic.setTips(note_refreshing);



                break;
            case IPullDownElastic.DONE:
                mElastic.showProgressBar(View.GONE);

//            arrowImageView.setImageResource(R.drawable.goicon);
                // tipsTextview.setText("下拉刷新");
                // lastUpdatedTextView.setVisibility(View.VISIBLE);

                break;
        }
    }

    private void onRefresh() {
        if (refreshListener != null) {
            refreshListener.onRefresh(this);
        }
    }

    /**
     *
     */
    @Override
    public void computeScroll() {

    }

    /**
     * 结束刷新事件，UI刷新完成后必须回调此方法
     * @param text 一般传入：“上次更新时间:12:23”
     */
    public void finishRefresh(String text) {
        if (mElastic == null) {

            return;
        }
        if (state == IPullDownElastic.DONE) {

        }
        state = IPullDownElastic.DONE;
        if (text != null) {
            mElastic.setLastUpdateText(text);
        }
        changeHeaderViewByState(state,false);


        mElastic.showLastUpdate(View.VISIBLE);
        setMargin(refreshTargetTop);
    }

    private boolean canScroll() {
        View childView;
        if (getChildCount() > 1) {
            childView = this.getChildAt(1);
            if (childView instanceof AbsListView) {
                int top = ((AbsListView) childView).getChildAt(0).getTop();
                int pad = ((AbsListView) childView).getListPaddingTop();
                if ((Math.abs(top - pad)) < 3
                        && ((AbsListView) childView).getFirstVisiblePosition() == 0) {
                    return true;
                } else {
                    return false;
                }
            } else if (childView instanceof ScrollView) {
                if (((ScrollView) childView).getScrollY() == 0) {
                    return true;
                } else {
                    return false;
                }
            }

        }
        return canScroll(this);
    }

    /**
     * 子类重写此方法可以兼容其它的子控件，目前只兼容AbsListView和ScrollView
     * @param view
     * @return
     */
    public boolean canScroll(PullDownScrollView view) {
        return false;
    }

    private void printMotionEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:

            default:
                break;
        }
    }
    public interface RefreshListener {
        void onRefresh(PullDownScrollView view);
    }
    public interface IPullDownElastic {
        public final static int RELEASE_To_REFRESH = 0;
        public final static int PULL_To_REFRESH = 1;
        public final static int REFRESHING = 2;
        public final static int DONE = 3;

        public View getElasticLayout();

        public int getElasticHeight();

        public void showProgressBar(int visibility);

        public void setTips(String tips);

        public void showLastUpdate(int visibility);

        public void setLastUpdateText(String text);

        public void changeElasticState(int state, boolean isBack);

    }
}
